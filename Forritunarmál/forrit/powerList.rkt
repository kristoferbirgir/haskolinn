;; Notkun: (powerList n)
;; Fyrir: n er heiltala, n>=0.
;; Gildi: Listi allra undirlista listans
;; (n ... 2 1).
;; Þetta er listi sem inniheldur 2^n
;; undirlista.

(define (powerList n)
  (if (= n 0)
      '(())
      (append
       (powerList (- n 1))
       (map
        (lambda (z) (cons n z))
        (powerList (- n 1))
       )
      )
  )
)
;;; Prófun
(powerList 3)

  