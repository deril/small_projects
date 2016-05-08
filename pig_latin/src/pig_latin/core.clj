(ns pig-latin.core
  (:require [clojure.string :as string :only [join split]])
  (:use [pig-latin.translator])
  (:gen-class))

(defn -main [text]
  (println (string/join " " (map transform (string/split text #"\s")))))
