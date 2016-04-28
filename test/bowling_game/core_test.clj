(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(defn- roll-many[game number-of-rolls score-of-each-roll]
  (reduce (fn [game _] (game/roll game score-of-each-roll)) game (range number-of-rolls)))

(deftest bowling-game
  (let [g (game/new-game)]
  (testing "test gutter game"
    (is (= 0
           (-> g
               (roll-many 20 0)
               (game/score)))))

  (testing "test all ones"
    (is (= 20
           (-> g
               (roll-many 20 1)
               (game/score)))))))
 
  ; (testing "test roll one spare"
  ;  (let [game (game/new-game)
  ;        score (roll-many 3 5)]
  ;    (is (= score 20))))))
