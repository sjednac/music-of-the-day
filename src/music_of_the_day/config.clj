(ns music-of-the-day.config)

(defonce app-configs (atom {:profile :dev
                            :ip "0.0.0.0"
                            :port 8080
                            :recommendation-update-interval (* 1000 60 60)
                            :spotify-client-id (System/getenv "SPOTIFY_CLIENT_ID")
                            :spotify-client-secret (System/getenv "SPOTIFY_CLIENT_SECRET")
                            }))

(defn config
  "Provides application settings."
  [key]
  (@ app-configs key))
