(ns clj-solns.problem-012)

(defn triangle-number [n]
  (apply + (range n)))

(def triangle-numbers
  (->> (range)
       (map inc)
       (map triangle-number)))

(defn factors [n]
  (into (sorted-set)
    (mapcat (fn [x] [x (/ n x)])
            (filter #(zero? (rem n %))
                    (range 1 (inc (Math/sqrt n)))))))

(defn problem-twelve []
  (-> (for [n triangle-numbers
            :let [factors (factors n)
                  l (count factors)]
            :when (>= l 500)]
        n)
      first))
