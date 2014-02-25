(ns clojure-ttt.negamax-spec
  (:use speclj.core)
  (:use clojure-ttt.negamax))

(describe 'best-move'
  (it "returns best move for ai"
    (should= 0 (best-move '(nil "X" "X"
                            "O" "O" "X"
                            "X" "O" "O") "X"))
    (should= 1 (best-move '("X" nil "O"
                            "O" "O" "X"
                            "X" "O" nil) "O"))
    (should= 2 (best-move '(nil nil nil
                            "O" "O" "X"
                            nil "O" "X") "X"))
    (should= 2 (best-move '("X" "X" nil
                            nil "O" "O"
                            nil nil "O") "X"))
    (should= 4 (best-move '("X" "O" nil
                            nil nil "O"
                            nil "O" "X") "X"))
    (should= 6 (best-move '("X" "O" "X"
                            "O" "X" "O"
                            nil "X" "O") "X"))))
(run-specs)
