(ns clj-solns.problem-012
  (:require [clj-solns.utils :refer [factors triangle-numbers]]))

(defn problem-twelve []
  (-> (for [n triangle-numbers
            :let [factors (factors n)
                  l (count factors)]
            :when (>= l 500)]
        n)
      first))
