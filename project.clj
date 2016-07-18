(defproject music-of-the-day "0.1.0-SNAPSHOT"
  :description "A simple web service written in Clojure."
  :url "http://github.com/sbilinski/music-of-the-day"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [environ "1.0.3"]
                 [com.taoensso/timbre "4.6.0"]
                 [http-kit "2.1.18"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [compojure "1.5.1"]
                 [overtone/at-at "1.2.0"]
                 [se.michaelthelin.spotify/spotify-web-api-java "1.5.0"]]
  :main ^:skip-aot music-of-the-day.core
  :min-lein-version "2.4.3"
  :target-path "target/%s"
  :plugins [[lein-auto "0.1.2"]
            [lein-environ "1.0.3"]
            [com.palletops/uberimage "0.4.1"]]
  :uberimage {:base-image "java:8-alpine"
              :instructions ["ENV BIND_IP 0.0.0.0"
                             "ENV BIND_PORT 8080"
                             "ENV RECOMMENDATION_UPDATE_INTERVAL 3600000"]
              :tag "sbilinski/music-of-the-day:latest"}
  :profiles {:dev     {:env {:bind-ip "0.0.0.0"
                             :bind-port "8080"
                             :recommendation-update-interval "3600000"}}
             :uberjar {:aot :all}})
