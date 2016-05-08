(ns pig-latin.translator
  (:require [clojure.string :as string :only [lower-case capitalize]])
  (:gen-class))

(defn transform [w]
  (def vowel (set "aeiou"))

  (defn vowel-transform [w]
    (str w "way"))

  (defn cons-transform [w]
    (let [first-letter (first w)]
      (if (vowel first-letter)
        (str w "ay")
        (cons-transform (str (subs w 1) first-letter)))))

  (defn transformate [w]
    (if (vowel (first w))
      (vowel-transform w)
      (cons-transform w)))

  (if (Character/isUpperCase (first w))
    (string/capitalize (transformate (string/lower-case w)))
    (transformate w)))
