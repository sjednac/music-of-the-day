(ns music-of-the-day.data-test
  (:require [clojure.test :refer :all]
            [music-of-the-day.data :refer :all]))

(deftest test-recommendations-has-sample-data
  (let [list recommendations]
    (is (< 0 (count list)))))
