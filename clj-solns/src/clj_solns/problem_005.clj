(ns clj-solns.problem-005)

(defn remainders [n rng]
  (map #(mod n %) rng))

(defn divisible-by-range? [n rng]
  (->> (remainders n rng)
       (every? zero?)))

;; brute force, not the fastest. Better to
;; find all prime factors of [1,20] and multiply
;; them
(defn problem-five []
  (let [one-to-twenty (range 1 21)]
    (->> (range)
         (filter #(and (not (zero? %))
                       (divisible-by-range? % one-to-twenty)))
         first)))
