(ns bowling-game.core)

(defn new-game []
  {:rolls []})

(defn roll [game pins] 
  (update game :rolls conj pins))

(defn- spare? [rolls]
  (= 10 (apply + (take 2 rolls))))

(defn- score-frame-size [rolls]
  (if (spare? rolls)
    3
    2))

; => This function is an owl...
(defn- frames [rolls]
  (lazy-seq
    (if (seq rolls)
      (cons (vec (take (score-frame-size rolls) rolls))
            (frames (drop 2 rolls)))
      (seq ()))))

(defn score [game] 
  (reduce (fn [total frame] (apply + total frame)) 0 (take 10 (frames (:rolls game)))))
