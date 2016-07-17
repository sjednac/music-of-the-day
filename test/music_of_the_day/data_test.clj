(ns music-of-the-day.data-test
  (:import  [com.wrapper.spotify.models SimpleAlbum])
  (:require [clojure.test :refer :all]
            [music-of-the-day.spotify :as spotify]
            [music-of-the-day.data :refer :all]))

(def new-releases-fixture [(doto (new SimpleAlbum) (.setId "123") (.setName "test1") (.setUri "http://test1"))
                           (doto (new SimpleAlbum) (.setId "456") (.setName "test2") (.setUri "http://test2"))
                           (doto (new SimpleAlbum) (.setId "789") (.setName "test3") (.setUri "http://test3"))])

(def recommendations-fixture [{:id "123" :name "test1" :uri "http://test1"}
                              {:id "456" :name "test2" :uri "http://test2"}
                              {:id "789" :name "test3" :uri "http://test3"}])

(deftest test-update-recommendations
  (with-redefs [spotify/get-new-releases (fn [country] new-releases-fixture)]
    (is (= recommendations-fixture (update-recommendations) ))))
