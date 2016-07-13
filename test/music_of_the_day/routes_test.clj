(ns music-of-the-day.routes-test
  (:require [clojure.test :refer :all]
            [music-of-the-day.data :refer :all]
            [music-of-the-day.routes :refer :all]))

(deftest test-show-landing-page
  (let [resp (all-routes {:request-method :get
                          :uri "/"})]
    (is (= 200 (:status resp)))))

(deftest test-list-recommendations
  (let [resp (all-routes {:request-method :get
                          :uri "/recommendations"})]
    (is (= 200 (:status resp)))))

(deftest test-get-recommendation-by-id
  (reset! recommendations [{:id "598173f8-f215-4cda-82c9-03ffa081706e"}])
  (let [resp (all-routes {:request-method :get
                          :uri "/recommendation/598173f8-f215-4cda-82c9-03ffa081706e"})]
    (is (= 200 (:status resp)))))

(deftest test-get-recommendation-by-missing-id
  (let [resp (all-routes {:request-method :get
                          :uri "/recommendation/ffffffff-ffff-ffff-ffff-ffffffffffff"})]
    (is (= 404 (:status resp)))))
