;; Notkun: (sumsq x).
;; Fyrir: X er listi talna (x1..xN).
;; Gidli: (x1^2 + x2^2..xN^2).
(define (sumsq x)
;;  Notkun: (help u z).
;;  Fyrir:  u er tala,
;;          z er listi (z1..z2..zM).
;;  Gildi:  (z1^2 + z2^2..zM^2).
(define (helo u z)
  (if (null? z)
      u
      (help (+ u(* (car x) (car x))) (cdr z))
  )
)
  (help 0 x)
)