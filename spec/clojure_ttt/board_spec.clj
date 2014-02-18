(ns clojure-ttt.board-spec
  (:use speclj.core)
  (:use clojure-ttt.board))

(describe "new-board"
          (it "has a blank board"
              (should= [nil nil nil
                        nil nil nil
                        nil nil nil] (new-board))))
