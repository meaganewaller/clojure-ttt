(ns clojure-ttt.board-spec
  (:use speclj.core)
  (:use clojure-ttt.board))

(describe "new-board"
          (it "has a blank board"
              (should= [nil nil nil
                        nil nil nil
                        nil nil nil] (new-board))))

(describe "available-spaces"
          (it "returns all the empty spaces"
              (should= 9 (count (available-spaces (new-board))))
              (should= #{0 1 2 3 4 5} (available-spaces '(nil nil nil nil nil nil "O" "X" "X")))))


(describe "update-board"
          (it "returns a new board with the updated move"
              (should= ["X" nil nil nil nil nil nil nil nil] (update-board (new-board) 0 "X"))))

(describe "winner?"
          (it "returns nil if there is no winner"
              (should= nil (winner? "X" (new-board))))
          (it "returns true if theres a winner"
              (should (winner? "X" '(nil nil nil "X" "X" "X" nil nil nil))))
          (it "returns false if the marker given isnt the winner"
              (should-not (winner? "O" '("X" nil nil nil "X" nil nil nil nil "X")))))

(describe "full-board?"
  (it "returns true if full"
    (should (full-board? '("X" "X" "X" "X" "X" "X" "X" "X" "X"))))
  (it "returns false if not"
    (should-not (full-board? '("X" nil nil nil nil nil nil nil nil)))))
(run-specs)
