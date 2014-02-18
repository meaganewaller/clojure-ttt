(ns clojure-ttt.board
  (:use clojure.set))

(defn find-spaces [marker board]
  (into #{} (keep-indexed #(if (= marker %2) %1) board)))

(defn available-spaces [board]
  (find-spaces nil board))

(defn new-board []
  [nil nil nil
   nil nil nil
   nil nil nil])

(defn update-board [board space marker]
  (concat
    (take space board)
    (list marker)
    (nthnext board (inc space))))

