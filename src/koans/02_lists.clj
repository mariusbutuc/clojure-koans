(ns koans.02-lists
  (:require [koan-engine.core :refer :all]))

(meditations
  "Lists can be expressed by function or a quoted form"
  (= '(1 2 3 4 5) (list 1 2 3 4 5))

  "They are Clojure seqs (sequences), so they allow access to the first"
  (= 1 (first '(1 2 3 4 5)))

  "As well as the rest"
  (= '(2 3 4 5) (rest '(1 2 3 4 5)))

  "Count your blessings"
  (= 3 (count '(dracula dooku chocula)))

  "Before they are gone"
  (= 0 (count '()))

  "The rest, when nothing is left, is empty"
  (= '() (rest '(100)))

  ; cons = construction, built on top of linked lists
  ; '(:a :b) ~ [:a|»] [:b| nil ]


  ; (= '(:b :c :d :e :a) (cons '(:b :c :d :e) (cons :a nil)))
  ; false


  ; (cons '(:b :c :d :e) (cons :a nil))
  ; ((:b :c :d :e) :a)


  ; (cons :a :b)
  ; java.lang.IllegalArgumentException: Don't know how to create ISeq from: clojure.lang.Keyword
  ;             RT.java:505 clojure.lang.RT.seqFrom
  ;             RT.java:486 clojure.lang.RT.seq
  ;             RT.java:572 clojure.lang.RT.cons
  ;             core.clj:29 clojure.core/cons


  ; (cons :a (cons :b nil))
  ; (:a :b)

  ; In computer programming, car and cdr are primitive operations on cons cells
  ; (or "non-atomic S-expressions") introduced in the Lisp programming language.
  ; A cons cell is composed of two pointers; the car operation extracts the
  ; first pointer, and the cdr operation extracts the second.
  ; http://en.wikipedia.org/wiki/CAR_and_CDR

  "Construction by adding an element to the front is easy"
  (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e)))

  ; yes, it's prepended
  ; for optimization reasons, it's cheaper to prepend

  "Conjoining an element to a list isn't hard either"
  (= '(:e :a :b :c :d) (conj '(:a :b :c :d) :e))

  ; just like `first`
  "You can use a list like a stack to get the first element"
  (= :a (peek '(:a :b :c :d :e)))

  ; just like `rest`
  "Or the others"
  (= '(:b :c :d :e) (pop '(:a :b :c :d :e)))

  "But watch out if you try to pop nothing"
  (= "No dice!" (try
          (pop '())
          (catch IllegalStateException e
            "No dice!")))

  "The rest of nothing isn't so strict"
  (= '() (try
          (rest '())
          (catch IllegalStateException e
            "No dice!"))))

