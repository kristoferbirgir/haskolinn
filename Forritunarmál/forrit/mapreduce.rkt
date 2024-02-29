;; Notkun: (mapreduce op f x u)
;; Fyrir: op er tvíundarfall af tagi a->b->b.
;;        f er einundarfall af tagi c-> a.
;;        x er listi (x1..xN) af tagi c og
;;        u er gildi af tagi b.
;; Gildi: (f x1 (f x2) (.. (f xN u)..))).  

(define (mapreduce op f x u)
  (if (null? x)
      u
      (op (f (car x)) (mapreduce op f (cdr x) u))))

