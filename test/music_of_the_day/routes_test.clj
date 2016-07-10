(ns music-of-the-day.routes-test
  (:require [clojure.test :refer :all]
            [music-of-the-day.routes :refer :all]))

(deftest test-landing-page
  (let [resp (routes {:request-method :get
                      :uri "/"})]
    (is (= 200 (:status resp)))))
