(ns music-of-the-day.data)

(def recommendations (atom []))

(defn random-recommendations
  "Provides a list of random recommendations"
  []
  '(
      {
       :id "f1fa6be3-06c8-450b-894d-f36629e10ee3"
       :artist "Talking Heads"
       :track "The Lady Don't Mind"
       :spotify "https://open.spotify.com/track/6xaYStR8hIimvEmKLwv4Gh"
      }
      {
       :id "598173f8-f215-4cda-82c9-03ffa081706e"
       :artist "Fad Gadget"
       :track  "Back To Nature"
       :spotify "https://open.spotify.com/track/4y8EasTsrOzb7FEPgyaKON"
      }
  ))

(defn update-recommendations
  "Updates recommendations"
  []
  (reset! recommendations (random-recommendations)))
