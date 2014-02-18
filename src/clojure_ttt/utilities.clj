(ns clojure-ttt.utilities
  (:use [clojure-ttt.board :only [available-spaces winner?]]))

(defn switch-player [current]
  (if (= "X" current) "O" "X"))

(defn tied? [board]
  (if (= 0 (count (available-spaces board))) true false))


(defn over? [board]
  (some true?
        [(or (winner? "X" board) (winner? "O" board))
         (tied? board)]))

(defn end [] (println "Game over! Goodbye") (shutdown-agents))
