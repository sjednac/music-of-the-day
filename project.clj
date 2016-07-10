(defproject music-of-the-day "0.1.0-SNAPSHOT"
  :description "A simple web service written in Clojure."
  :url "http://github.com/sbilinski/music-of-the-day"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.1.18"]
                 [compojure "1.5.1"]]
  :main ^:skip-aot music-of-the-day.core
  :target-path "target/%s"
  :plugins [[lein-auto "0.1.2"]]
  :profiles {:uberjar {:aot :all}})