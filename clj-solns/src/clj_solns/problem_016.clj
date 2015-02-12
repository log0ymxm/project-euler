(ns clj-solns.problem-016
  (:require [clj-solns.utils :refer [digits int-pow]]))

(defn problem-sixteen []
  (->> (int-pow 2N 1000N)
       digits
       (apply +)))
