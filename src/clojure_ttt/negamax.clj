(ns clojure-ttt.negamax
  (:use [clojure-ttt.board :only [winner? update-board available-spaces]])
  (:use [clojure-ttt.utilities :only [switch-player tied?]]))

(declare rank-board)
(def winning-score  1)
(def losing-score -1)
(def tied-score 0)

(defn find-opponent [player]
  (switch-player player))

(defn find-scores [board player moves]
  (zipmap moves (map #(rank-board (update-board board % player) player winning-score) moves)))

(defn find-best-score [scores]
  (reduce max (vals scores)))

(defn find-best-moves [scores best-score moves]
  (filter #(= (scores %) best-score) moves))

(defn random-best-move [best-moves]
  (rand-nth best-moves))

(defn best-move [board player]
  (let [moves (available-spaces board)
        scores (find-scores board player moves)
        best-score (find-best-score scores)
        best-moves (find-best-moves scores best-score moves)]
    (random-best-move best-moves)))

(defn rank-board [board player win-score]
  (cond
    (winner? player board) win-score
    (winner? (find-opponent player) board) (* losing-score win-score)
    (tied? board) tied-score
    :else (let [opponent (find-opponent player)
                next-board (update-board board (best-move board opponent) opponent)]
            (recur next-board opponent (* losing-score win-score)))))

(def rank-board (memoize rank-board))

