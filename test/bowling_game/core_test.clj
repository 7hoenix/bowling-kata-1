(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :as game]))

(deftest gutter-game
  (testing "should be 0 if you never knock over a pin"
    (let [score (reduce game/roll 0 (take 20 (repeat 0)))]
      (is (= score 0)))))
