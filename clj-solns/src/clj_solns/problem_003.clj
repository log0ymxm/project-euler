(ns clj-solns.problem-003)

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

(defn problem-three []
  (-> 600851475143
      prime-factors
      first))
