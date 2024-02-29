;;; Notkun: x = atoi(n);
;;; Fyrir: n er heiltala, n>=0.
;;; Gildi: x er listinn [n,...,2,1]
(define (atoi n)
  (define (hjalp i x)
    (if (= i n)
        x
        (hjalp (+ i 1) (cons (+ i 1) x))))
  (hjalp 0 '()))

;;;Prófun
(atoi 5)