(ns bowling-game.core)

(defn new-game []
  {:rolls []})

(defn roll [score pins] 
  (+ score pins))
