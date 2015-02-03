(ns clj-solns.problem-010)

(def certainty 6)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n)
                    certainty))

(def all-ints (range 1 Integer/MAX_VALUE))
(def primes (filter prime? all-ints))

(defn problem-ten []
  (->> primes
       (filter #(<= % 2000000))
       (apply +)))
