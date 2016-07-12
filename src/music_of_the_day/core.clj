(ns music-of-the-day.core
  (:gen-class)
  (:use [org.httpkit.server :only [run-server]]
        [compojure.handler :only [site]]
        [music-of-the-day.routes :only [all-routes]]
        [music-of-the-day.config :only [config]]))

(defn -main
  "Server entry point."
  [& args]
  (let [ip (config :ip) port (config :port)]
    (println "Binding server to" ip ":" port)
    (run-server (site #'all-routes) {:ip ip :port port})))
