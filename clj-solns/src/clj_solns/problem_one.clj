(ns clj-solns.problem-one)

(defn multiple? [n]
  (or (zero? (mod n 3))
      (zero? (mod n 5))))

(defn sum-multiples [n]
  (->> (range n)
       (filter multiple?)
       (apply +)))

;; (sum-multiples 10)
;; => 23

(defn problem-one []
  (sum-multiples 1000))
