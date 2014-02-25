(ns clojure-ttt.negamax-spec
  (:use speclj.core)
  (:use clojure-ttt.negamax))

(describe "find-opponent"
  (it "finds the opponent"
    (should= "X" (find-opponent "O"))))

(describe "find-scores"
  (it "finds the scores for a board"
    (should= {6 1} (find-scores ["X" "X" "O"
                                 "X" "O" "X"
                                 nil "O" "X"], "O" [6]))))
(describe "find-best-score"
  (it "finds the best score"
    (should= 1 (find-best-score {6 1 4 1 3 -1}))))

(describe "find-best-moves"
  (it "finds the best moves"
    (should= '(6) (find-best-moves {6 1 4 0 3 -1} 1 [3 4 6])))
  (it "can return multiple best moves"
    (should= '(1 2) (find-best-moves {1 1 2 1 3 0} 1 [1 2 3]))))

(describe "random-best-move"
  (it "doesn't return a move not listed"
    (should-not= 1 (random-best-move '(0 2 3 4 5 6 7 8)))))

(describe "rank-board"
  (it "returns 1 for ai win"
    (should= 1 (rank-board '("X" "X" "X"
                             nil nil nil
                             nil nil nil), "X", 1)))
  (it "returns -1 for human win"
    (should= -1 (rank-board '("X" "X" "X"
                              nil nil nil
                              nil nil nil), "O", 1)))
  (it "returns 0 for a tied board"
    (should= 0 (rank-board '("X" "O" "X"
                             "O" "X" "O"
                             "O" "X" "O"), "X", 1))))
(describe "best-move"
  (it "takes the available space"
    (should= 0 (best-move '(nil "X" "O"
                            "X" "O" "X"
                            "X" "O" "X") "O")))

  (it "picks the winning move"
    (should= 6 (best-move '(nil "X" "O"
                            "X" "O" "X"
                            nil "O" "X") "O")))
  (it "picks the blocking move"
    (should= 3 (best-move '("X" "X" "O"
                            nil "O" "X"
                            "X" nil "O") "O")))
  (it "avoids a fork"
    (should-not= 1 (best-move '(nil nil "X"
                                nil "X" nil
                               "O" nil nil) "O"))

    (should-not= 3 (best-move '(nil nil "X"
                                nil "X" nil
                                "O" nil nil) "O"))

    (should-not= 5 (best-move '(nil nil "X"
                                nil "X" nil
                                "O" nil nil) "O"))

    (should-not= 7 (best-move '(nil nil "X"
                                nil "X" nil
                                "O" nil nil) "O"))))

(run-specs)
