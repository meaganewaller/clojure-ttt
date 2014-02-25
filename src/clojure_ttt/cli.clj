(ns clojure-ttt.cli)

(defn get-space [board index]
  (if (= nil (nth board index))
    (str "_")
    (if (= "X" (nth board index))
      (str "X")
      (str "O"))))

(defn get-row [board index]
  (str
  (get-space board index)
  (str "|"
  (get-space board (+ index 1)))
  (str "|"
  (get-space board (+ index 2)))))

(defn print-message [message]
  (println message))

(defn print-board [message board]
  (print-message message)
  (println (get-row board 0))
  (println (get-row board 3))
  (println (get-row board 6)))

(defn print-blank []
  (println))

(defn print-game [current-player board]
  (print-blank)
  (print-board (format "Current Player: %s" current-player) board)
  (print-blank))

(defn print-tied-game [board]
  (print-board "Tied Game" board))

(defn print-winner [player board]
  (print-board (format "%s is the Winner", player) board))

(defn print-end []
  (println "Game Over!"))

(defn print-setup []
  (print-blank)
  (print-message "Welcome to Tic Tac Toe!")
  (print-message "[1] 1 Player")
  (print-message "[2] 2 Players")
  (print-message "[0] Quit Game"))
