;; Notkun: (foldl f u x)
;; Fyrir: f er tvíundarfall,
;; u er eitthvert gildi,
;; x=(x1 ... xN) er listi einhverra gilda
;; Gildi: (f (f ... (f (f u x1) x2) ...) xN)
;; Ath.: (foldl f u '()) skal skila u

(define (foldl f u x)
  (if (null? x)
      u
      (foldl f (f u (car x)) (cdr x))
  )
)
;;; Prófun
(foldl 1 4 '()) ;;; Skilar 4 því x er null