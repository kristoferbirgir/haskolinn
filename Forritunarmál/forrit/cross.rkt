;; Notkun: (cross a b)
;; Fyrir: a og b eru óendanlegir straumar,
;; a=[a1 a2 a3 ...]
;; b=[b1 b2 b3 ...]
;; Gildi: Óendanlegi straumurinn af
;; óendanlegum straumum af tveggja
;; staka listum
;; [[(a1 b1) (a1 b2) (a1 b3) ...]
;; [(a2 b1) (a2 b2) (a2 b3) ...]
;; [(a3 b1) (a3 b2) (a3 b3) ...]
;; .
;; .
;; .
;; ]
;; sem inniheldur nokkurs konar
;; krossmargfeldi a og b.

(define (cross a b)
  (cons-stream
   (stream-map
    (lambda (x) (list (stream-car a) x))
    b
    )
   (cross (stream-cdr a) b)
   )
)
