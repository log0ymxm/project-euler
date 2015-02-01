(ns clj-solns.problem-two)

(defn fibs []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(defn problem-two []
  (->> (fibs)
       (take-while #(<= % 4000000))
       (filter even?)
       (apply +)))
