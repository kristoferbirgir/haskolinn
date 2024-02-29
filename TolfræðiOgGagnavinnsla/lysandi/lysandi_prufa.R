#Kristófer Birgir


##############
library(tidyverse)

#Smá fikt

####
(x <- c(1,2,3))

y <- c(4,5,6,7)

z <- seq(1:10)

r <- rep(1:3,2, each=2)
length(r)
####

####
x <- c(2,4,3,9,5,7)
x[4]
x[1:2]
x[-3]
x[-c(1,5)]

which(x==9)
####

# Byrjum ad vinna med gogn
####
puls <- read_delim("http://hi.is/~ahj/pulsAll.csv", delim = ";")
###

