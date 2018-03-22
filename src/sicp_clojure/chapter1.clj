(ns sicp-clojure.chapter1)

; 1.1.1

(+ 137 349)
(+ (* 3 5) (- 10 6))
(+ (* 3
      (+ (* 2 4)
         (+ 3 5)))
   (+ (- 10 7)
      6))

(def size 2)

; 1.1.3
(defn square [x] (* x x))
(square 5)
(square (square 3))

(defn abs [x]
  (if (>= x 0) x
      (- x)))

(abs -10)

;exercise 1.2
(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
   (* 3 (- 6 2) (- 2 7)))

; exercise 1.3

(defn sum-of-square [x y]
  (+ (square x) (square y)))

(defn biggest-square [x y z]
  (cond (and (> x z) (> y z)) (sum-of-square x y)
        (and (> x y) (> z y)) (sum-of-square x z)
        (and (> y x) (> z x)) (sum-of-square y z)))

; (println (sum-of-square 2 3))
; (println (biggest-square 3 2 1))
; (println (biggest-square 3 1 2))
; (println (biggest-square 1 3 2))

; exercise 1.4
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

; 1.1.7
(defn average [x y] (/ (+ x y) 2))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter 
  [guess x]
  (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(sqrt 9)
(sqrt (+ (sqrt 2) (sqrt 3)))
(square (sqrt 1000))

; exercise 1.7

(defn good-enough2? [before-guess guess]
  (< (abs (- before-guess guess)) 0.001))

(defn sqrt-iter2 
  [before-guess guess x]
  (if (good-enough2? before-guess guess)
      guess
      (sqrt-iter2 guess (improve guess x) x)))

(defn sqrt2 [x]
  (sqrt-iter2 0 1.0 x))

(sqrt2 9)
(println
  (sqrt2 9)
  (sqrt2 9))
(println
  (sqrt (+ (sqrt 2) (sqrt 3)))
  (sqrt2 (+ (sqrt 2) (sqrt 3))))
(println
  (square (sqrt 1000))
  (square (sqrt2 1000)))

; exercise 1.8
(defn good-enough-cube? [before-guess guess]
  (< (abs (- before-guess guess)) 0.001))

(defn improve-cube [guess x]
  (/ (+ (/ x guess guess) (* 2 guess)) 3))

(defn cube-iter 
  [before-guess guess x]
  (if (good-enough-cube? before-guess guess)
      guess
      (cube-iter guess (improve-cube guess x) x)))

(defn cube [x]
  (cube-iter 0 1.0 x))

(cube 8)

(defn good-enough-root? [before now]
  (< (abs (- before now)) 0.001))

(defn improve-root [guess x n]
  (/ (+ (* (- n 1) guess)
        (/ x (Math/pow guess (- n 1))))
     n))

(defn root-of-iter [before-guess guess x n]
  (if (good-enough-root? before-guess guess)
      guess
      (root-of-iter guess (improve-root guess x n) x n)))

(defn root-of [x n]
  (root-of-iter 0 1 x n))

(root-of 16 4)


; exercise 1.9
(defn plus1 [a b]
  (if (= a 0)
      b
      (inc (plus1 (dec a) b))))

(plus1 4 5)
(inc (plus1 3 5))
(inc (inc (plus1 2 5)))
(inc (inc (inc (plus1 1 5))))
(inc (inc (inc (inc (plus 0 5)))))
(inc (inc (inc (inc 5))))
(inc (inc (inc 6)))
(inc (inc 7))
(inc 9)
(9)

(defn plus2 [a b]
  (if (= a 0)
      b
      (plus2 (dec a) (inc b))))

(plus2 4 5)
(plus2 (dec 4) (inc 5))
(plus2 3 6)
(plus2 (dec 3) (inc 6))
(plus2 2 7)
(plus2 (dec 2) (inc 7))
(plus2 1 8)
(plus2 (dec 1) (inc 8))
(plus2 0 9)
(9)

(defn A [x y]
  (cond
    (= y 0) 0
    (= x 0) (* 2 y)
    (= y 1) 2
    :else (A (- x 1) (A x (- y 1)))
  ))

(A 1 10)
(A 2 4)
(A 3 3)
