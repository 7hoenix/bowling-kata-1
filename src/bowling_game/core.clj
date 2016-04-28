(ns bowling-game.core)

(defn new-game []
  {:rolls []})

(defn roll [game pins] 
  (update game :rolls conj pins))

(defn score [game] 
  (reduce + 0 (:rolls game)))
