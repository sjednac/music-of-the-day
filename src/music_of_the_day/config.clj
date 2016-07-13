(ns music-of-the-day.config)

(defonce app-configs (atom {:profile :dev
                            :ip "0.0.0.0"
                            :port 8080
                            :recommendation-update-interval 1000}))

(defn config
  "Provides application settings."
  [key]
  (@ app-configs key))
