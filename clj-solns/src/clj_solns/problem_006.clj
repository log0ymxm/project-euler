(ns clj-solns.problem-006)

(defn problem-six []
  (let [rng (range 1 101)
        squares (map #(Math/pow % 2) rng)
        sum (apply + rng)
        sum-of-squares (apply + squares)
        square-of-sum (Math/pow sum 2)]
    (int (- square-of-sum sum-of-squares))))
