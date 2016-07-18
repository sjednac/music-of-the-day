(ns music-of-the-day.core
  (:gen-class)
  (:use [taoensso.timbre :as timbre :refer [log info]]
        [environ.core :refer [env]]
        [org.httpkit.server :only [run-server]]
        [compojure.handler :only [site]]
        [overtone.at-at :only [every mk-pool]]
        [music-of-the-day.routes :only [all-routes]]
        [music-of-the-day.data :only [update-recommendations]]))

(timbre/set-level! :info)

(defn -main
  "Server entry point."
  [& args]
  (let [ip (env :bind-ip)
        port (Integer/parseInt (env :bind-port))
        update-interval (Integer/parseInt (env :recommendation-update-interval))]
    (info "Fetching recommendations...")
    (update-recommendations)
    (info "Scheduling recommendation updates every" update-interval "ms")
    (every update-interval update-recommendations (mk-pool) :initial-delay update-interval :desc "Recommendation Updater")
    (info "Binding server to" ip ":" port)
    (run-server (site #'all-routes) {:ip ip :port port})))
