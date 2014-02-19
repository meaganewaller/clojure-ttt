(ns clojure-ttt.cli-spec
  (:use speclj.core)
  (:use clojure-ttt.cli))

(describe "get-space"
          (it "gets space from board"
              (should= "_" (get-space '("X" "O" nil) 2))
              (should= "X" (get-space '("X" "O" nil) 0))
              (should= "O" (get-space '("X" "O" nil) 1))))

(describe "get-row"
          (it "gets row"
              (should= "_|_|_" (get-row '(nil nil nil) 0))
              (should= "X|O|X" (get-row '("X" "O" "X") 0))))

(describe "print-blank"
          (it "prints a blank line"
              (should= "\n"
                       (with-out-str (with-in-str "line break")
                                     (print-blank)))))

(describe "print-message"
          (it "prints a message"
              (should= "Welcome to Tic Tac Toe\n"
                       (with-out-str (with-in-str "message")
                                     (print-message '"Welcome to Tic Tac Toe")))))


(describe "print-board"
          (it "prints the board when empty"
              (should= "_|_|_\n_|_|_\n_|_|_\n"
                       (with-out-str (with-in-str "printed board")
                                     (print-board '(nil nil nil nil nil nil nil nil nil)))))
          (it "prints the board with moves"
              (should= "X|X|_\n_|X|_\nO|_|_\n"
                       (with-out-str (with-in-str "printed board")
                                     (print-board '("X" "X" nil nil "X" nil "O" nil nil))))))

(describe "print-game"
          (it "prints the game info"
              (should= "Good Luck!\n\nCurrent Player: X\n\n_|_|_\n_|_|_\n_|_|_\n"
                       (with-out-str(with-in-str "current player")
                                                 (print-game '"Good Luck!" '"X" '(nil nil nil nil nil nil nil nil nil))))))

(run-specs)
