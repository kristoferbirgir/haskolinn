;;; Notkun: x = iota(n);
;;; Fyrir: n er heiltala, n>=0.
;;; Gildi: x er listinn [1,2,...,n]

(define (iota n)

  ;;; Notkun: (help i z)
  ;;; Fyrir: 0 <= i <= n, z er listinn i+1 1+2.. n)
  ;;; Gildi: listinn (1 2.. n)
  (define (help i z)
    (if (= i 0)
        z
        (help (- i 1) (cons i z))
        )
    )
  (help n '())
  )
(iota 10)
    