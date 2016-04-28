(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(defn- roll-many[game number-of-rolls score-of-each-roll]
  (reduce (fn [game _] (game/roll game score-of-each-roll)) game (range number-of-rolls)))

(defn- roll-spare [g]
   (roll-many g 2 5))

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
               (game/score)))))
 
  (testing "test roll one spare"
    (is (= 16
           (-> g
               (roll-spare)
               (game/roll 3)
               (roll-many 17 0)
               (game/score)))))

  (testing "test one strike"
    (is (= 24
           (-> g
               (game/roll 10)
               (game/roll 3)
               (game/roll 4)
               (roll-many 16 0)
               (game/score)))))))
