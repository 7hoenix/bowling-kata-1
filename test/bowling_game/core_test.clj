(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(deftest bowling-game
  (testing "test gutter game"
    (let [score (reduce game/roll 0 (take 20 (repeat 0)))]
      (is (= score 0))))
  (testing "test all ones"
    (let [score (reduce game/roll 0 (take 20 (repeat 1)))]
      (is (= score 20)))))
