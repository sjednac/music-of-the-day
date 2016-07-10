(ns music-of-the-day.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(defn show-landing-page [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Music of the day!"})

(defn show-recommendations [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Some recommendations might be shown here someday"})

(defroutes all-routes
  (GET "/" [] show-landing-page)
  (GET "/recommendations" [] show-recommendations)
  (route/not-found "Page not found."))
