(ns music-of-the-day.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as util]
            [ring.middleware.json :as json]
            [music-of-the-day.data :as data]))

(defn show-landing-page [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Music of the day!"})

(defn show-recommendations [req]
  (util/response data/recommendations))

(defroutes all-routes
  (GET "/" [] show-landing-page)
  (GET "/recommendations" [] (json/wrap-json-response show-recommendations))
  (route/not-found "Page not found."))
