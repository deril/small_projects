(ns pig-latin.core-test
  (:require [clojure.test :refer :all]
            [pig-latin.core :refer :all]))

(deftest a-test
  (testing "correct translate with punctuation"
    (is (= (-main "Hello, it is me!") "Ellohay, itway isway emay!"))))
