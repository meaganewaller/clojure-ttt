(ns clojure-ttt.negamax
  (:use [clojure-ttt.board :only [winner? update-board available-spaces]])
  (:use [clojure-ttt.utilities :only [switch-player]]))

(declare rank-board)

(defn best-move [board player]
  (let [moves (available-spaces board)
        scores (zipmap moves (map #(rank-board (update-board board % player) player 1) moves))
        best-score (reduce max (vals scores))
        best-moves (filter #(= (scores %) best-score) moves)]
    (rand-nth best-moves)))

(defn rank-board
  [board player win-score]
  (cond
    (winner? player board) win-score
    (winner? (switch-player player) board) (* -1 win-score)
    (empty? (available-spaces board)) 0
    :else (let [opponent (switch-player player)
                next-board (update-board board (best-move board opponent) opponent)]
            (recur next-board opponent (* -1 win-score)))))

(def rank-board (memoize rank-board))

