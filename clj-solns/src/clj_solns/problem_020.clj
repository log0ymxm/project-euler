(ns clj-solns.problem-020
  (:require [clj-solns.utils :refer [digits !]]))

(defn problem-twenty []
  (->> (! 100)
       digits
       (apply +)))
