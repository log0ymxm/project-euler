(ns clj-solns.problem-009
  (:require [clj-solns.utils :refer [pythagorean-triplet? thousand-sums]]))

(defn problem-nine []
  (->> thousand-sums
       (filter pythagorean-triplet?)
       first
       (apply *)))
