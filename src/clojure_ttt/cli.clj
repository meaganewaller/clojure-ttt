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

(defn print-blank []
  (println))

(defn print-board [board]
  (println (get-row board 0))
  (println (get-row board 3))
  (println (get-row board 6)))

(defn print-message [message]
  (println message))

(defn print-game [message current-player board]
  (print-message message)
  (print-blank)
  (println (format "Current Player: %s" current-player))
  (print-blank)
  (print-board board))



