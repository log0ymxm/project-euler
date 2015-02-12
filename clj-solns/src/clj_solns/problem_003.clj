(ns clj-solns.problem-003
  (:require [clj-solns :refer [prime-factors]]))

(defn problem-three []
  (-> 600851475143
      prime-factors
      first))
