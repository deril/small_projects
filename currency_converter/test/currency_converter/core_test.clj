(ns currency-converter.core-test
  (:require [clojure.test :refer :all]
            [currency-converter.core :refer :all]))

(deftest test-main
  (testing "returns hello"
    (is (= "Hello, World!\n" (with-out-str (-main 1))))))
