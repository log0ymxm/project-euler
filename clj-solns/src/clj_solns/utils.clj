(ns clj-solns.utils)

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

(def certainty 6)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n)
                    certainty))

(defn pythagorean-triplet? [triplet]
  (let [[a b c] triplet]
    (= (+ (Math/pow a 2)
          (Math/pow b 2))
       (Math/pow c 2))))

(defn triangle-number [n]
  (apply + (range n)))

(defn factors [n]
  (into (sorted-set)
    (mapcat (fn [x] [x (/ n x)])
            (filter #(zero? (rem n %))
                    (range 1 (inc (Math/sqrt n)))))))

(def collatz-num
  (memoize
   (fn [n]
     (if (even? n)
       (/ n 2)
       (inc (* 3 n))))))

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
