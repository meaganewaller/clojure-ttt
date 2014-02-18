(ns clojure-ttt.utilities-spec
  (:use speclj.core)
  (:use clojure-ttt.utilities)
  (:use [clojure-ttt.board :only [new-board]]))

(describe "switch-player"
          (it "switches the players"
              (should= "X" (switch-player "O"))
              (should= "O" (switch-player "X"))))

(describe "tied?"
          (it "returns true if full board"
              (should (tied? '("X" "O" "X"
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

(describe "end"
          (it "prints goodbye message"
              (should= "Game over! Goodbye\n" (with-out-str (end)))))

