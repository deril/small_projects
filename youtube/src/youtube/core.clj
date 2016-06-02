(ns youtube.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json])
  (:gen-class
    :name youtube.core
    :methods [#^{:static true} [search [String] String]]))

(def link "https://www.googleapis.com/youtube/v3/search")

(defn build-video-link
  [video_name]
  (client/get link
              {:query-params {"part" "snippet"
                              "maxResults" 1
                              "type" "video"
                              "q" (str video_name)
                              "key" "AIzaSyCbi43o8yrQSqyzob2rOIQ87-X-sevQoFM"}}))

(defn fetch-video-link
  [video_name]
  (str "https://youtube.com/watch?v="
       (get-in (json/read-str (:body (build-video-link video_name))) ["items" 0 "id" "videoId"])))

(defn -search
  "A Java-callable wrapper around the 'fetch-video-link' function."
  [query]
  (fetch-video-link query))

(defn -main
  []
  (println (fetch-video-link "hello adele")))
