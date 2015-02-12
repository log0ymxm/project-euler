(ns clj-solns.problem-009
  (:require [clj-solns.sequences :refer [thousand-sums]]
            [clj-solns.utils :refer [pythagorean-triplet?]]))

(defn problem-nine []
  (->> thousand-sums
       (filter pythagorean-triplet?)
       first
       (apply *)))
