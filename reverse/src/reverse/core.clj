(ns reverse.core
  (:require [clojure.string :as str :only [split]])
  (:gen-class))

(defn s_reverse [s i j]
  (if (< i j)
    (s_reverse (assoc s i (get s j) j (get s i)) (inc i) (dec j))
    s))

(defn -main
  [string]
  (let [s (str/split string #"")]
    (println (str/join "" (s_reverse s 0 (dec (count s)))))))
