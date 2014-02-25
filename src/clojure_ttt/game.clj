(ns clojure-ttt.game
  (:use [clojure-ttt.board :only [available-spaces new-board update-board]])
  (:use [clojure-ttt.cli :only [print-tied-game print-winner print-game print-setup print-end]])
  (:use [clojure-ttt.negamax :only [best-move]])
  (:use [clojure-ttt.utilities :only [switch-player over? tied?]]))

(defn prompt []
  (print "=> "))

(defn get-input [limit]
  (prompt)
  (flush)
  (let [input (try (read-string (read-line)) (catch Exception e))]
    (if (.contains limit input)
      input
      (do
        (recur limit)))))

(defn move [player board current-player]
  (if (and (= player :ai) (= current-player "O"))
    (best-move board "O")
    (get-input (available-spaces board))))

(defn print-outcome [current-player board]
  (if (tied? board)
    (print-tied-game board)
    (print-winner current-player board)))

(defn play [player new-board]
  (loop [board new-board current-player "X"]
    (print-game (current-player board))
    (if (over? board)
      (do (print-end current-player board) (print-end))
      (recur
        (update-board board (move player board current-player) current-player)
        (switch-player current-player)))))

(defn start-game []
  (print-setup)
  (case (get-input (range 3))
    1 (play :ai (new-board))
    2 (play :human (new-board))
    0 (print-end)))


