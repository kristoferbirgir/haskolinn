---
title:"Fasteignaverkefni1"
author:"Kristófer Birgir Hjörleifsson (kbh15@hi.is)"
date:"2023-02-01"
output:rmdformats::downcute:
---
  
  ## Lesum inn pakka:
```{
    r, warning = FALSE, message = FALSE
  }
knitr::opts_chunk$set(echo = TRUE,
                      message = FALSE,
                      warning = FALSE)
options(scipen = 9999)
library(tidyverse)
library(dplyr)
library(knitr)
```


## Hluti 1 - Gagnamöndl

# Lesum inn gögnin:
```{
  r
}
housing_data <-
  read.table(
    "https://ahj.hi.is/husnaedisverd_2017_21.csv",
    sep = ";",
    header = TRUE,
    stringsAsFactors = TRUE,
  )
```
# Næst er að velja 3 hverfi:
-Fossvogur
- Breiðholt
- Austur Kópavog
```{
  r
}
hverfi <- c(280, 25, 320)
housing_data <- dplyr::filter(housing_data, matssvaedi %in% hverfi)
```

## Skoðum gerð breyta
```{
  r
}
print(str(housing_data))
```
breytur líta út fyrir að vera réttar

## Fermetraverð er:
Gerum nýja breytu í töflu þar sem við deilum kaupverði með stærð til að fá fermetraverð
```{
  r
}
housing_data <-
  housing_data %>% mutate(fermetraverd = kaupverd / birtm2)
```
´
## Tegundir eigna:
```{
  r
}
housing_data <- housing_data %>% mutate(teg_ein_s_i = case_when(
  teg_eign %in% c("Einbýlishús", "Parhús", "Raðhús") ~ "Sérbýli",
  teg_eign %in% c("Íbúðareign") ~ "Íbúð"
))
```

## Hverfi
Skiptum á hverfakóða og nöfnum svo það sé lesanlegt
```{
  r
}
housing_data <- housing_data %>% transmute(
  housing_data,
  matssvaedi = case_when(
    matssvaedi == 280 ~ "Fossvogur",
    matssvaedi == 25 ~ "Bakkar",
    matssvaedi == 320 ~ "Kópavogur Au."
  )
)
```

# Hluti 2 - Myndræn framsetning

## Myndir af verði og stærð

```{
  r
}
ggplot(housing_data, aes(kaupverd)) +
  geom_histogram(bins = 50,
                 col = "green",) +
  ggtitle("Dreifing á kaupverði eigna") +
  xlab("Kaupverð") +
  ylab("Fjöldi eigna á verðbili")

ggplot(housing_data, aes(birtm2)) +
  geom_histogram(bins = 50,
                 col = "red",) +
  ggtitle("Dreifing á stærð eigna") +
  xlab("Stærð eigna í fermetrum") +
  ylab("Fjöldi eigna á stærðarbili")
```

## mynd af skiptingu innan hverfa

```{
  r
}

ggplot(housing_data, aes(matssvaedi, fill = teg_ein_s_i)) +
  geom_bar(position = "dodge") +
  ggtitle("Fjöldi og týpa eigna eftir hverfum") +
  xlab("Hverfi") +
  ylab("Fjöldi")
```

## Mynd af fermetraverði eftir tegund eigna

```{
  r
}
ggplot(housing_data, aes(fermetraverd, fill = teg_ein_s_i)) +
  geom_histogram(bins = 50,
                 col = "black",) +
  ggtitle("Fermetraverð eftir tegund eigna") +
  xlab("Verð") +
  ylab("Fjöldi")
```

##

```{
  r
}
ggplot(housing_data, aes(x = kaupverd, y = birtm2, color = teg_ein_s_i)) +
  geom_point() +
  facet_grid( ~ matssvaedi) +
  xlab("kaupverð") +
  ylab("stærð")
```

# Hluti 3. - Töflur

## fjöldi sérbýla og íbúða í hverfum
```{
  r
}
knitr::kable(table(housing_data$matssvaedi, housing_data$teg_ein_s_i))
```

## hlutfall sérbýla og íbúða í hverfum
```{
  r
}
knitr::kable(round(prop.table(
  table(housing_data$matssvaedi,
        housing_data$teg_ein_s_i),
  1
),
3))
```

```{
  r
}
knitr::kable(
  housing_data %>%
    group_by(hverfi = matssvaedi, "tegund eigna" = teg_ein_s_i) %>% # our group
    
    summarise(
      # summarise operation by group
      meðaltal = mean(fermetraverd),
      staðalfrávik = sd(fermetraverd),
      miðgildi = median(fermetraverd),
      fjöldi = n()
    )
)
```

## Hluti 4 - Líkindafræði

líkur á að tvær eignir af þremur eignum séu einbýlishús, þar sem 20% eigna eru einbýlishús, $`r dbinom(2, 3, 0.2)`$ 
en líkur á að færri en tvær eignir af þremur völdum séu einbýlishús eru $`r round(pbinom(1,3,0.2),3)`$
  
  
Gerum nú ráð fyrir að stærð einbýlishúsa í hverfinu fylgi normaldreifingu með meðaltal 170 fm og staðalfrávik 20 fm. 
þá eru $`r round(1-pnorm(190,170,20),3)`$ líkur á að eign valin af handahófi sé stærri en $190m^2$
  
  
Jonni ætlar að byggja einbýlishús í hverfinu og vill endilega að það verði í hópi 10% stærstu einbýlishúsanna í hverfinu. 
húsið verður þá að vera $`r round(qnorm(0.9,170,20),3)` m^2$
  