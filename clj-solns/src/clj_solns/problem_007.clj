(ns clj-solns.problem-007
  (:require [clj-solns.sequences :refer [primes]]))

(defn problem-seven []
  (nth primes 10000))
