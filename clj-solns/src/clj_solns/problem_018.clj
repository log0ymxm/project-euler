(ns clj-solns.problem-018
  (:require [loom.graph :refer [weighted-digraph weight]]
            [loom.alg :refer [dijkstra-path]]
            [clojure.core.matrix :refer [emap]]))

(def triangle [[75]
               [95 64]
               [17 47 82]
               [18 35 87 10]
               [20  4 82 47 65]
               [19  1 23 75  3 34]
               [88  2 77 73  7 63 67]
               [99 65  4 28  6 16 70 92]
               [41 41 26 56 83 40 80 70 33]
               [41 48 72 33 47 32 37 16 94 29]
               [53 71 44 65 25 43 91 52 97 51 14]
               [70 11 33 28 77 73 17 78 39 68 17 57]
               [91 71 52 38 17 14 91 43 58 50 27 29 48]
               [63 66  4 68 89 53 67 30 73 16 69 87 40 31]
               [ 4 62 98 27 23  9 70 98 73 93 38 53 60  4 23]])


(def largest (apply max (flatten aug-triangle)))

(def inv-triangle (emap #(- largest %) triangle))

(def s->k (comp keyword str))

(def triangle-nodes
  (->> inv-triangle flatten count inc range (map s->k)))

(defn triangle->map [t]
  (->> t
       (map-indexed (fn [i row]
                      (println "--- map-ind i" i row)
                      (map-indexed (fn [j distance]
                                     (let [offset (apply + (range (inc i)))
                                           left-idx (inc i)
                                           right-idx (inc left-idx)
                                           children (hash-map (s->k (+ offset j left-idx)) distance
                                                              (s->k (+ offset j right-idx)) distance)
                                           ]
                                       (if (= i (dec (count t)))
                                         (assoc children (last triangle-nodes) distance)
                                         children
                                         )))
                                   row)))
       (apply concat)
       (zipmap triangle-nodes)))

(defn triangle->graph [t]
  (->> t
       triangle->map
       (weighted-digraph)))

(def wdg (triangle->graph triangle))
(def inv-wdg (triangle->graph inv-triangle))

(def path (dijkstra-path inv-wdg :0 :120))

(defn problem-eighteen []
  (->> path
       (partition 2 1)
       (map #(apply (partial weight wdg) %))
       (apply +)))
