(ns clj-solns.problem-010
  (:require [clj-solns.sequences :refer [primes]]))

(defn problem-ten []
  (->> primes
       (filter #(<= % 2000000))
       (apply +)))
