(*
** Notkun: fromTo i j
** Fyrir:  i og j eru heilttölur, i<=j
** Gildi:  Listinn [i;i+1;...;j-1].

** Use:    fromTo i j
** Pre:    i and j are integers, i<=j
** Value:  The list [i;i+1;...;j-1].
*)
let rec fromTo i j =
    ...
;;

(*
** Notkun: insertAt x i z
** Fyrir:  x=[x1;x2;...;xN] er listi gilda
**         af einhverju tagi 'a. z er gildi
**         af sama tagi 'a. i er heiltala,
**         0 <= i <= N, þar sem N er lengd
**         listans x.
** Gildi:  Listinn
**           [x1;x2;...;x_i;z;x_i+1;...;xN],
**         þ.e. listinn sem út kemur þegar
**         gildinu z er skeytt inn í listann
**         x rétt fyrir aftan i fremstu
**         gildin.

** Use:    insertAt x i z
** Pre:    x=[x1;x2;...;xN] is a list of
**         values of some type 'a. z is a
**         value of type 'a. i is an integer,
**         0 <= i <= N, where N is the length
**         of the list x.
** Value:  The list
**           [x1;x2;...;x_i;z;x_i+1;...;xN],
**         i.e. the list that results from
**         inserting the value z into the
**         list x right after the first i
**         values.
*)
let rec insertAt x i z =
    ...
;;

(*
** Notkun: ...
** Fyrir:  ...
** Gildi:  ...

** Use:    ...
** Pre:    ...
** Value:  ...
*)
let rec mapreduce f op u x =
    ...
;;

(*
** Notkun: extendPermutation n z
** Fyrir:  n >= 0 er heiltala.
**         z er einhver umröðun listans [1;2;...;n-1].
** Gildi:  Listi allra þeirra lista sem út koma þegar
**         tölunni n er skeytt inn í listann z á
**         einhverjum stað, allt frá byrjun til enda.
** Aths.:  Þetta er "one-liner" ef við áttum okkur á
**         hvernig nota megi map og fromTo til að leysa
**         verkefnið.

** Use:    extendPermutation n z
** Pre:    n >= 0 is an integer.
**         z is some permutation of [1;2;...;n-1].
** Value:  The list of all the lists that result from
**         inserting the number n into the list z at
**         some position, from start to end.
** Note:   This is a "one-liner" if we realize how to
**         use map and fromTo so solve the problem.
*)
let extendPermutation n z =
    ...
;;

(*
** Notkun: append x y
** Fyrir:  x=[x1;x2;...;xN] er listi gilda af einhverju
**         tagi 'a. y=[y1;y2;...;yM] er listi gilda af
**         sama tagi.
** Gildi:  Listinn [x1;x2;...;xN,y1;y2;...;yM].

** Use:    append x y
** Pre:    x=[x1;x2;...;xN] is a list of values of some
**         type 'a. y=[y1;y2;...;yM] is a list of values
**         of the same type.
** Value:  Listinn [x1;x2;...;xN,y1;y2;...;yM].
*)
let append x y = x@y;;

(*
** Notkun: length x
** Fyrir:  x=[x1;x2;...;xN] er listi.
** Gildi:  N.
** Aths.:  Þetta má útfæra sem "one-liner" með hjálp
**         fallsins it_list.

** Use:    length x
** Pre:    x=[x1;x2;...;xN] is a list.
** Value:  N.
** Note:   This can be a "one-liner" with the help of
**         the function it_list.
*)
let length x =
    ...
;;

(*
** Notkun: permutations n
** Fyrir:  n>=0 er heiltala.
** Gildi:  Listi allra umraðana listans [1;2;...;n].

** Use:    permutations n
** Pre:    n>=0 is an integer.
** Value:  The list of all permutations of the list
**         [1;2;...;n].
*)
let rec permutations n =
    if n==0 then
        [[]]
    else
        mapreduce
            (extendPermutation n)
            append
            []
            (permutations (n-1))
;;

length (permutations 6);;