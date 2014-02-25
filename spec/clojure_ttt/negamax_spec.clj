(ns clojure-ttt.negamax-spec
  (:use speclj.core)
  (:use clojure-ttt.negamax))

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
