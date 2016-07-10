(ns music-of-the-day.routes)

(defn routes [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Music of the day!"})
