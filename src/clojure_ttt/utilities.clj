(ns clojure-ttt.utilities
  (:use [clojure-ttt.board :only [available-spaces winner? full-board?]]))

(defn switch-player [current]
  (if (= "X" current) "O" "X"))

(defn no-winner [board]
  (not (or (winner? "X" board) (winner? "O" board))))

(defn tied? [board]
  (and (full-board? board) (no-winner board)))

(defn over? [board]
  (some true?
        [(or (winner? "X" board) (winner? "O" board))
         (tied? board)]))

