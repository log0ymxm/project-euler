(ns clj-solns.problem-021
  (:require [clj-solns.utils :refer [factors]]))

(defn d [n]
  (->> (factors n)
       (#(disj % n))
       (apply +)))

(defn amicable? [n]
  (and (= (d (d n)) n)
       (not (= (d n) n))))

(defn problem-twentyone []
  (->> (range 10000)
       (filter amicable?)
       (apply +)))
