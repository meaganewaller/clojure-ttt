(ns clojure-ttt.cli-spec
  (:use speclj.core)
  (:use clojure-ttt.board)
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


(describe "print-board"
  (it "prints the board when empty"
    (should= "A Message\n_|_|_\n_|_|_\n_|_|_\n"
      (with-out-str (with-in-str "printed board")
                    (print-board "A Message" '(nil nil nil nil nil nil nil nil nil)))))
  (it "prints the board with moves"
    (should= "A Message\nX|X|_\n_|X|_\nO|_|_\n"
      (with-out-str (with-in-str "printed board")
                    (print-board "A Message" '("X" "X" nil nil "X" nil "O" nil nil))))))

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

(describe "print-game"
  (it "prints the game"
    (should= "\nCurrent Player: X\n_|_|_\n_|_|_\n_|_|_\n\n"
      (with-out-str(with-in-str "current player")
                                (print-game "A Message" '"X" '(nil nil nil nil nil nil nil nil nil))))))

(describe "print-tied-game"
  (it "displays tied game message"
    (should= "Tied Game\nX|O|X\nO|X|O\nO|X|O\n"
      (with-out-str (with-in-str "tied game")
                    (print-tied-game '("X" "O" "X" "O" "X" "O" "O" "X" "O"))))))

(describe "print-winner"
  (it "displays winner of the game"
    (should= "X is the Winner\nX|X|X\n_|_|_\n_|_|_\n"
      (with-out-str (with-in-str "x win")
                    (print-winner '"X" '("X" "X" "X" nil nil nil nil nil nil))))
    (should= "O is the Winner\nO|O|O\n_|_|_\n_|_|_\n"
      (with-out-str (with-in-str "o win")
                    (print-winner '"O", '("O" "O" "O" nil nil nil nil nil nil))))))

(describe "print-end"
  (it "prints the ending game message"
    (should= "Game Over!\n"
      (with-out-str (with-in-str "game over")
                    (print-end)))))

(describe "print-setup"
  (it "prints the setup"
    (should= "\n\nWelcome to Tic Tac Toe!\n[0]\n[1]\n[2]\n"
      (with-out-str (with-in-str "config")
                    (print-setup)))))


(run-specs)
