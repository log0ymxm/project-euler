(ns clj-solns.problem-017
  (:require [clj-solns.utils :refer [not-zero? remove-space]]))

(defn int->written
  "Naive and only works for n < 10000"
  [n]
  (let [ones ["one" "two" "three" "four" "five"
              "six" "seven" "eight" "nine" "ten"
              "eleven" "twelve" "thirteen" "fourteen"
              "fifteen" "sixteen" "seventeen" "eighteen"
              "nineteen"]
        tens ["twenty" "thirty" "forty" "fifty" "sixty"
              "seventy" "eighty" "ninety"]
        kn (Math/floor (/ n 1000.0))
        n (mod n 1000)
        hn (Math/floor (/ n 100.0))
        n (mod n 100)
        dn (Math/floor (/ n 10.0))
        n (mod n 10)]
    (->> [(when (not-zero? kn)
            [(nth ones (dec kn)) "thousand"])
          (when (not-zero? hn)
            [(nth ones (dec hn)) "hundred"])
          (when (and (or (not-zero? kn) (not-zero? hn))
                     (or (not-zero? dn) (not-zero? n)))
            "and")
          (when (or (not-zero? dn) (not-zero? n))
            (if (< dn 2)
              (nth ones (dec (+ (* dn 10) n)))
              [(nth tens (- dn 2))
               (when (not-zero? n)
                 (nth ones (dec n)))]))]
         flatten
         (filter identity)
         (clojure.string/join " "))))

(def count-written-number
  (comp count remove-space int->written))

(defn problem-seventeen []
  (->> (range 1 1001)
       (map count-written-number)
       (apply +)))
