(ns music-of-the-day.core
  (:gen-class)
  (:use [org.httpkit.server :only [run-server]]
        [music-of-the-day.routes :only [routes]]
        [music-of-the-day.config :only [config]]))

(defn -main
  "Server entry point."
  [& args]
  (let [ip (config :ip) port (config :port)]
    (println "Starting server at port" ip ":" port)
    (run-server routes {:ip ip :port port})))
