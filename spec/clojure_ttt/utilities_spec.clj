(ns clojure-ttt.utilities-spec
  (:use speclj.core)
  (:use clojure-ttt.utilities)
  (:use [clojure-ttt.board :only [new-board]]))

(describe "switch-player"
  (it "switches the players"
    (should= "X" (switch-player "O"))
    (should= "O" (switch-player "X"))))

(describe "no-winner"
  (it "returns true when no winner"
    (should (no-winner [new-board])))
  (it "returns false when winner"
    (should-not (no-winner '("X" "X" "X"
                                 nil nil nil
                                 nil nil nil)))))

(describe "tied?"
  (it "returns true if full board"
    (should (tied?     '("X" "O" "X"
                         "O" "X" "O"
                         "O" "X" "O"))))
  (it "returns false if board isnt full"
    (should-not (tied? (new-board)))))

(describe "over?"
  (it "returns true if winner"
    (should (over? '("X" "X" "X"
                         nil nil nil
                         nil nil nil))))

  (it "returns false if not winner"
    (should-not (over? (new-board)))))

(run-specs)
