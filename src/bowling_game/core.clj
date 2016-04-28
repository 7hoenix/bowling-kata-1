(ns bowling-game.core)

(defn new-game []
  {:rolls []})

(defn roll [game pins] 
  (update game :rolls conj pins))

(defn- strike? [rolls]
  (= 10 (first rolls)))

(defn- spare? [rolls]
  (= 10 (apply + (take 2 rolls))))

(defn- score-frame-size [rolls]
  (if (or (spare? rolls) (strike? rolls))
    3
    2))

(defn- drop-frame-size [rolls]
  (if (strike? rolls)
    1
    2))

; => This function is an owl...
(defn- frames [rolls]
  (lazy-seq
    (if (seq rolls)
      (cons (vec (take (score-frame-size rolls) rolls))
            (frames (drop (drop-frame-size rolls) rolls)))
      (seq ()))))

(defn score [game] 
  (reduce (fn [total frame] (apply + total frame)) 0 (take 10 (frames (:rolls game)))))
