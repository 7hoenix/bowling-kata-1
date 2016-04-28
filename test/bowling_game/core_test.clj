(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(defn- bowl-many [score-of-each-roll]
  (reduce game/roll 0 (take 20 (repeat score-of-each-roll))))

(deftest bowling-game
  (testing "test gutter game"
    (let [score (bowl-many 0)]
      (is (= score 0))))

  (testing "test all ones"
    (let [score (bowl-many 1)]
      (is (= score 20)))))
