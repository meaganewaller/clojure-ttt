(ns clojure-ttt.board
  (:use clojure.set))

(def winning-combos [#{0 1 2} #{3 4 5} #{6 7 8}
                     #{0 3 6} #{1 4 7} #{2 5 8}
                     #{0 4 8} #{6 4 2}] )

(defn find-spaces [marker board]
  (into #{} (keep-indexed #(if (= marker %2) %1) board)))

(defn available-spaces [board]
  (find-spaces nil board))

(defn winner? [marker board]
  (some (fn [space] (subset? space (find-spaces marker board))) winning-combos))

(defn new-board []
  [nil nil nil
   nil nil nil
   nil nil nil])

(defn update-board [board space marker]
  (concat
    (take space board)
    (list marker)
    (nthnext board (inc space))))

(defn full-board? [board]
  (= 0 (count (available-spaces board))))
