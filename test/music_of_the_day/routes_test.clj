(ns music-of-the-day.routes-test
  (:require [clojure.test :refer :all]
            [music-of-the-day.routes :refer :all]))

(deftest test-show-landing-page
  (let [resp (all-routes {:request-method :get
                          :uri "/"})]
    (is (= 200 (:status resp)))))

(deftest test-show-recommendations
  (let [resp (all-routes {:request-method :get
                          :uri "/recommendations"})]
    (is (= 200 (:status resp)))))
