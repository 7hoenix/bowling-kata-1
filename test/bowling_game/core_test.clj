(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(defn- roll-many[number-of-rolls score-of-each-roll]
  (reduce game/roll 0 (take number-of-rolls (repeat score-of-each-roll))))

(deftest bowling-game
  (testing "test gutter game"
    (let [score (roll-many 20 0)]
      (is (= score 0))))

  (testing "test all ones"
    (let [score (roll-many 20 1)]
      (is (= score 20)))))
