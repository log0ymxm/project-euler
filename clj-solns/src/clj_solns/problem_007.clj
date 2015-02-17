(ns clj-solns.problem-007
  (:require [clj-solns.utils :refer [primes]]))

(defn problem-seven []
  (nth primes 10000))
