(ns clj-solns.problem-007)

(def certainty 5)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n)
                    certainty))

(def all-ints (range 1 Integer/MAX_VALUE))
(def primes (filter prime? all-ints))

(defn problem-seven []
  (nth primes 10000))
