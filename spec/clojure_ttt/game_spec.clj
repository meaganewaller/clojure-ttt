(ns clojure-ttt.game-spec
  (:use speclj.core)
  (:use clojure-ttt.game)
  (:use [clojure-ttt.board :only [new-board]])
  (:use clojure-ttt.cli))

(defn test-input [coll]
  (apply str (interleave coll (repeat "\n"))))

(describe "prompt"
  (around [it]
    (with-out-str (it)))

  (it "displays prompt for user"
    (should= "=> "
      (with-out-str (with-in-str "prompt"
                      (prompt))))))

(describe "get-input"
  (around [it]
    (with-out-str (it)))
  (it "returns input if valid"
    (should= 1
      (with-in-str "1"
        (get-input (range 3)))))
  (it "rejects bad input and gets good input"
    (with-in-str (test-input '(5, "ok", 3))
     (should= 3 (get-input (range 4))))))

(describe "move"
  (around [it]
    (with-out-str (it)))
  (it "gets input from the player if its the players turn"
    (should= 4 (with-in-str "4" (move "X" (new-board) :human))))
  (it "gets the ai's move if its the ai's turn"
    (should= 4 (move :ai ["X" "X" "X"
                          "X" nil "X"
                          "X" "X" "X"] "O"))))
(describe "print-outcome"
  (it "prints message for tie"
    (should= "Tied Game\nX|O|X\nO|X|O\nO|X|O\n"
      (with-out-str(with-in-str "end of game"
                     (print-outcome '"X" ["X" "O" "X" "O" "X" "O" "O" "X" "O"])))))
  (it "prints message for winner"
    (should= "O is the Winner\nO|O|O\n_|_|_\n_|_|_\n"
      (with-out-str(with-in-str "x winner"
                     (print-outcome '"X" ["O" "O" "O" nil nil nil nil nil nil]))))
    (should= "X is the Winner\nX|X|X\n_|_|_\n_|_|_\n"
      (with-out-str(with-in-str "o winner"
                     (print-outcome '"O" ["X" "X" "X" nil nil nil nil nil nil]))))))

(run-specs)






