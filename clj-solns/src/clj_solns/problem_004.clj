(ns clj-solns.problem-004
  (:require [clj-solns.utils :refer [palindrome-number? three-digit-nums]]))

(defn palindrome-products [lst]
  (for [x three-digit-nums
        y three-digit-nums
        :let [prod (* x y)]
        :when (palindrome-number? prod)]
     [x y]))

(defn problem-four []
  (->> three-digit-nums
       palindrome-products
       (map #(apply * %))
       (apply max)))
