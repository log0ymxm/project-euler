(ns clj-solns.utils
  (:use clojure.core.logic)
  (:require [clojure.core.logic.fd :as fd]))

(defn fibs []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(def three-digit-nums (reverse (range 100 1000)))

(def certainty 6)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n)
                    certainty))

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

(defn triangle-number [n]
  (apply + (range n)))

(def triangle-numbers
  (->> (range)
       (map inc)
       (map triangle-number)))

(def collatz-num
  (memoize
   (fn [n]
     (if (even? n)
       (/ n 2)
       (inc (* 3 n))))))

(defn collatz-seq [n]
  (concat
   (take-while #(not= % 1)
               (iterate collatz-num n))
   [1]))

(defn prime-factors
  "Return a list of factors of N."
  ([n]
    (prime-factors n 2 ()))
  ([n k acc]
    (if (= 1 n)
      acc
      (if (= 0 (rem n k))
        (recur (quot n k) k (cons k acc))
        (recur n (inc k) acc)))))

(defn palindrome-number? [num]
  (let [s (str num)
        n (count s)
        sides (split-at (/ n 2) s)]
    (and (even? n)
         (= (-> sides first reverse)
            (-> sides last)))))

(defn remainders [n rng]
  (map #(mod n %) rng))

(defn divisible-by-range? [n rng]
  (->> (remainders n rng)
       (every? zero?)))

(defn pythagorean-triplet? [triplet]
  (let [[a b c] triplet]
    (= (+ (Math/pow a 2)
          (Math/pow b 2))
       (Math/pow c 2))))

(defn factors [n]
  (into (sorted-set)
    (mapcat (fn [x] [x (/ n x)])
            (filter #(zero? (rem n %))
                    (range 1 (inc (Math/sqrt n)))))))

(defn perfect-factors [n]
  (-> n factors (disj n)))

(defn max-index [seq]
  (->> seq
       (map-indexed vector)
       (apply max-key second)
       first))

(defn binomial-coefficient [n k]
  (let [rprod (fn [a b] (reduce * (range a (inc b))))]
    (/ (rprod (- n k -1) n) (rprod 1N k))))

(defn int-pow [b ^long ex]
  (loop [acc 1, ex ex]
    (case ex
      0 acc
      (recur (* acc b) (dec ex)))))

(def not-zero? (comp not zero?))

(defn remove-space [s]
  (-> s (clojure.string/replace " " "")))

(defn digits [number]
  (map #(Character/getNumericValue %) (str number)))

(defn power [x n]
  (cond (= 0 n) 1
        (= 1 n) x
        (even? n) (power (*' x x) (/ n 2))
        (odd? n) (*' x (power (*' x x) (/ (dec n) 2)))))

(defn- find-power [n k]
  (loop [total n sum 0]
    (let [i (int (/ total k))]
      (if (zero? i) sum
          (recur i (+ sum i))))))

(defn ! [n]
  (loop [[h & t]
         (map #(power % (find-power n %))
              (take-while #(<= % n) primes))
         acc 1]
    (if h (recur t (*' h acc)) acc)))

(defn perfect? [n]
  (= (apply + (perfect-factors n))
     n))

(defn deficient? [n]
  (< (apply + (perfect-factors n))
     n))

(defn abundant? [n]
  (> (apply + (perfect-factors n))
     n))
