(ns clj-solns.problem-014
  (:require [clj-solns.sequences :refer [collatz-seq]]
            [clj-solns.utils :refer [max-index]]))

(defn problem-fourteen []
  (->> (range 1 1000001)
       (map #(->> % collatz-seq
                  count))
       max-index
       inc))
