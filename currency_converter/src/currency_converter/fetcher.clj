(ns currency-converter.fetcher
  (:require [clj-http.client :as client]
            [net.cgrand.enlive-html :as html])
  (:gen-class))

(def link "https://www.google.com/finance/getprices")

(defn fetch-currency
  ([from] (fetch-currency from "USD"))
  ([from to]
   (:body
         (client/get link
                     {:query-params {"x" "CURRENCY"
                                     "i" 86400
                                     "p" "16d"
                                     "f" "d,c"
                                     "q" (str from to)}}))))
