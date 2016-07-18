(ns music-of-the-day.spotify
  (:use [environ.core :refer [env]])
  (:import (com.wrapper.spotify Api)))

(defn api []
  "Creates a base API object."
  (let [client-id (env :spotify-client-id) client-secret (env :spotify-client-secret)]
    (if (nil? client-id) (throw (IllegalStateException. "spotify client id was not specified")))
    (if (nil? client-secret) (throw (IllegalStateException. "spotify client secret was not specified")))
    (-> (Api/builder )
        (.clientId client-id)
        (.clientSecret client-secret)
        (.build))))

(defn api-token [token]
  "Creates an API object with token-based authentication."
  (-> (Api/builder)
      (.accessToken token)
      (.build)))

(defn client-credentials-grant-request
  "Creates a ClientCredentialsGrantRequest"
  []
  (-> (api)
      (.clientCredentialsGrant)
      (.build)))

(defn new-releases-request
  "Creates a NewReleasesRequest"
  [token country]
  (-> (api-token token)
      (.getNewReleases)
      (.country country)
      (.build)))

(defn get-access-token
  "Provides a new access token"
  []
  (.getAccessToken (.get (client-credentials-grant-request))))

(defn get-new-releases [country]
  "Provides newly released albums for a given country."
  (let [releases (new-releases-request (get-access-token) country)]
    (-> (.get releases) (.getAlbums) (.getItems))))
