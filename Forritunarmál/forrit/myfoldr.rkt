;; Notkun: (myfoldr f x u)
;; Fyrir:  f er tvíundarfall, þ.e. fall
;;         sem tekur inn tvö viðföng af
;;         ehv tagi, x er listi (x1..xN)
;;         gilda af því tagi, u er gildi
;;         af því tagi.
;; Gildi:  (f x1 (f x2 (..(f xN u)..))).
;;         Reiknað hægri til vinstri.
(define (myfoldr f x u)
  (if (null? x)
      u
      (f (car x) (myfoldr f (cdr x) u))
  )
)
(myfoldr - '(1 2) 3) ;; Returns 2
(myfoldr (lambda (a b) (cons a b))
    '(1 2 3)
    '()) ;; Returns (1 2 3)