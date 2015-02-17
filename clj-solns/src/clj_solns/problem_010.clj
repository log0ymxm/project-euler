(ns clj-solns.problem-010
  (:require [clj-solns.utils :refer [primes]]))

(defn problem-ten []
  (->> primes
       (filter #(<= % 2000000))
       (apply +)))
