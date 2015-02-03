(ns clj-solns.problem-004)

(defn palindrome-number? [num]
  (let [s (str num)
        n (count s)
        sides (split-at (/ n 2) s)]
    (and (even? n)
         (= (-> sides first reverse)
            (-> sides last)))))

(def three-digit-nums (reverse (range 100 1000)))

(defn palindrome-products [lst]
  (for [x three-digit-nums
        y three-digit-nums
        :let [prod (* x y)]
        :when (palindrome-number? prod)]
     [x y]))

(defn problem-four []
  (->> three-digit-nums
       palindrome-products
       (map #(apply * %))
       (apply max)))
