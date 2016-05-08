(ns horoscope.core
  (:require [clj-http.client :as client]
            [net.cgrand.enlive-html :as html])
  (:gen-class))

(defn fetch-resource [sign]
  (html/html-resource (java.io.StringReader. (:body (client/get (str "http://new.theastrologer.com/" sign))))))

(defn -main
  [sign]
  (println (str "Here is " sign "'s horoscope for " (java.util.Date.)))
  (-> (fetch-resource sign)
      (html/select [:div#today :p])
      first
      :content
      first
      println))
