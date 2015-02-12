(ns clj-solns.problem-002
  (:require [clj-solns :refer [fibs]]))

(defn problem-two []
  (->> (fibs)
       (take-while #(<= % 4000000))
       (filter even?)
       (apply +)))
