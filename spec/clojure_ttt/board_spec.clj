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

