(ns music-of-the-day.data)

(defn current-time [] (.toString (java.time.LocalDateTime/now)) )

(def recommendations
  "Recommendations."
  [
    {
     :id "f1fa6be3-06c8-450b-894d-f36629e10ee3"
     :time (current-time)
     :artist "Talking Heads"
     :track "The Lady Don't Mind"
     :spotify "https://open.spotify.com/track/6xaYStR8hIimvEmKLwv4Gh"
    }
    {
     :id "598173f8-f215-4cda-82c9-03ffa081706e"
     :time (current-time)
     :artist "Fad Gadget"
     :track  "Back To Nature"
     :spotify "https://open.spotify.com/track/4y8EasTsrOzb7FEPgyaKON"
    }
  ])


(defn update-recommendations
  "Updates recommendations"
  []
  (println "TODO: Recommendations update"))
