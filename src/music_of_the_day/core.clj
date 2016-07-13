(ns music-of-the-day.core
  (:gen-class)
  (:use [org.httpkit.server :only [run-server]]
        [compojure.handler :only [site]]
        [overtone.at-at :only [every mk-pool]]
        [music-of-the-day.routes :only [all-routes]]
        [music-of-the-day.data :only [update-recommendations]]
        [music-of-the-day.config :only [config]]))

(defn -main
  "Server entry point."
  [& args]
  (let [ip (config :ip) port (config :port) update-interval (config :recommendation-update-interval)]
    (println "Scheduling recommendation updates every" update-interval "ms")
    (every update-interval update-recommendations (mk-pool) :desc "Recommendation Updater")
    (println "Binding server to" ip ":" port)
    (run-server (site #'all-routes) {:ip ip :port port})))
