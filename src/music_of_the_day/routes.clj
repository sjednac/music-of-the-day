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

(defn list-recommendations [req]
  (util/response (deref data/recommendations)))

(defn get-recommendation-by-id [req]
  (let [id (-> req :params :id)]
    (let [result (first (filter #(= (:id %) id) (deref data/recommendations)))]
      (if (nil? result)
        (util/not-found "Recomendation not found")
        (util/response result)))))


(defroutes all-routes
  (GET "/" [] show-landing-page)
  (GET "/recommendations" [] (json/wrap-json-response list-recommendations))
  (context "/recommendation/:id" []
         (GET "/" [] (json/wrap-json-response get-recommendation-by-id)))
  (route/not-found "Page not found."))
