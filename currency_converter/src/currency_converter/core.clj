(ns currency-converter.core
  (:require [clojure.string :as string :only [split]])
  (:use [currency-converter.fetcher])
  (:gen-class))

(defn get-data
  [currency]
  (map
    #(last (string/split % #","))
    (take-last 15 (string/split (fetch-currency currency) #"\n"))))

(defn to_usd
  [currency amount]
  (if (= currency "USD")
    [amount]
    (map #(* (read-string amount) (Float/parseFloat %)) (get-data currency))))

(defn -main
  [& args]
  (println (apply to_usd (string/split (first args) #":"))))
