(ns clj-solns.sequences
  (:use clojure.core.logic)
  (:require [clojure.core.logic.fd :as fd]
            [clj-solns.utils :refer [prime? triangle-number
                                     collatz-num]]))

(defn fibs []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(def three-digit-nums (reverse (range 100 1000)))

(def all-ints (range 1 Integer/MAX_VALUE))
(def primes (filter prime? all-ints))

;; core.logic makes this feel like cheating
;; but really, it's a perfect use.
(def thousand-sums
  (run* [q]
    (fresh [a b c]
      (fd/in a b c (fd/interval 1 1000))
      (fd/eq (= (+ a b c) 1000))
      (fd/distinct [a b c])
      (== q [a b c]))))

(def triangle-numbers
  (->> (range)
       (map inc)
       (map triangle-number)))

(defn collatz-seq [n]
  (concat
   (take-while #(not= % 1)
               (iterate collatz-num n))
   [1]))
