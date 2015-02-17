(ns clj-solns.problem-022
  (:require [clojure.java.io :refer [resource]]))

(defn alphabetic-score [w]
  (->> w
       (map int)
       (map #(- % 64))
       (apply +)))

(defn problem-twentytwo []
  (->> (resource "names.txt")
       slurp
       (re-seq #"\w+")
       sort
       (map-indexed #(* (inc %1) (alphabetic-score %2)))
       (apply +)))
