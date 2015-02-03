(ns clj-solns.problem-009
  (use clojure.core.logic)
  (require [clojure.core.logic.fd :as fd]))

;; core.logic makes this feel like cheating
;; but really, it's a perfect use.
(def thousand-sums
  (run* [q]
    (fresh [a b c]
      (fd/in a b c (fd/interval 1 1000))
      (fd/eq (= (+ a b c) 1000))
      (fd/distinct [a b c])
      (== q [a b c]))))

(defn pythagorean-triplet? [triplet]
  (let [[a b c] triplet]
    (= (+ (Math/pow a 2)
          (Math/pow b 2))
       (Math/pow c 2))))

(defn problem-nine []
  (->> thousand-sums
       (filter pythagorean-triplet?)
       first
       (apply *)))
