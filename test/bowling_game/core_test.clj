(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(defn- roll-many[number-of-rolls score-of-each-roll]
  (reduce game/roll 0 (take number-of-rolls (repeat score-of-each-roll))))

(deftest bowling-game
  (testing "test gutter game"
    (let [game (game/new-game)
          score (roll-many 20 0)]
      (is (= 0 score))))

  (testing "test all ones"
    (let [game (game/new-game)
          score (roll-many 20 1)]
      (is (= 20 score)))))
 
; (testing "test roll one spare"
;  (let [score (roll-many 3 5)]
;    (is (= score 20)))))

; Hmmmmm... I'm thinking i want a game now.
