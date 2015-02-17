(ns clj-solns.problem-019
  (:require [clj-time.core :refer [date-time]]
            [clj-time.predicate :refer [sunday?]]))

(defn problem-nineteen []
  (->> (map (fn [i]
              (map (fn [j]
                     (when (sunday? (date-time i j 1))
                       1))
                   (range 1 13)))
            (range 1901 2001))
       (filter identity)
       (apply +)))
