(ns clj-solns.problem-014
  (:require [clj-solns.utils :refer [max-index collatz-seq]]))

(defn problem-fourteen []
  (->> (range 1 1000001)
       (map #(->> % collatz-seq
                  count))
       max-index
       inc))
