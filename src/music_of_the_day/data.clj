(ns music-of-the-day.data
  (:use [music-of-the-day.spotify :only [get-new-releases]]
        [taoensso.timbre :as timbre :refer [log info debug]]))

(def recommendations (atom []))

(defn spotify-album-to-recommendation
  "Converts a Spotify album to a recommendation"
  [album]
  {
   :id (.getId album)
   :name (.getName album)
   :uri (.getUri album)
  })

(defn spotify-recommendations
  "Provides a list of recommendations from Spotify."
  []
  (let [albums (get-new-releases "pl")]
    (debug "Got" (count albums) "albums from Spotify")
    (map spotify-album-to-recommendation albums)))

(defn update-recommendations
  "Updates recommendations"
  []
  (info "Updating recommendations...")
  (reset! recommendations (spotify-recommendations)))
