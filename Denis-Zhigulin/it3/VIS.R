# Функция plot
data(Indometh)
attach(Indometh)
plot(time, conc)
means <- tapply(conc, time , mean)
names(means)
indo.times <- as.numeric(names(means))
plot(indo.times, means, xlab = "Время", ylab = "Концентрация", 
     main = "Скорость выведения индометацина", type = "o", pch = 21, cex = 1.2, 
     bg = "red", lwd=2, col.main = "blue")


# Гистограмма, совмещенная с кривой плотности
X <- rnorm(n = 100, mean = 15, sd = 5)
hist(X, breaks = 20, freq = FALSE, col = "lightblue",
     xlab = "Переменная X",
     ylab = "Плотность вероятности",
     main = "Гистограмма, совмещенная с кривой плотности")
lines(density(X), col = "red", lwd = 2)
lines(density(X, bw = 0.8), col = "blue", lwd = 2)



# кривые ядерной плотности
data(InsectSprays)
attach(InsectSprays)
# Сравнение всех препаратов по кривым ядерной плотности
library(sm)
sm.density.compare(count, spray, lwd = 2,
                   xlab="Число насекомых")
title(main="Кривые ядерной плотности")
# Составляем список кодов использованных цветов
colfill<-c(2:(2+length(levels(spray))))
# добавляем легенду туда, куда мы кликнем мышью
legend(locator(1), levels(spray), fill=colfill)



# график поверхности ядерной плотности распределения 
# двухмерной случайной величины z = f(x ,y). 
data(Indometh) 
attach(Indometh)
library(MASS)
f <- kde2d(time, conc)
image(f,xlab="Время выведения",ylab="Концентрация индометацина")
contour(f, add=TRUE)




# Функция cdplot
library(HSAUR2)
data(plasma)
layout(matrix(1:2, ncol = 2))
cdplot(ESR ~ fibrinogen, col = c("coral", "skyblue"),
       yaxlabels = c("< 20 mm/h", "> 20 mm/h"), bw = 0.9, data = plasma)
cdplot(ESR ~ globulin, col = c("coral", "skyblue"),
       yaxlabels = c("< 20 mm/h", "> 20 mm/h"), bw = 0.9, data = plasma)


# Круговые диаграммы
# Данные по явке избирателей:
percent.voted <- c(60, 40)
# Распределение голосов:
votes <- c(49.3, 19.2, 13.2, 11.7, 3.4, 1.0, 0.6)
names(percent.voted) <- c("Проголосовали", "Не явились")
names(votes) <- c("Единая Россия", "КПРФ", "Справедливая Россия",
                  "ЛДПР", "Яблоко", "Патриоты России", "Правое дело")
pie(percent.voted, radius = 0.9, cex = 0.6, main = "Явка",
    col = c("black", "gray80"))
pie(votes, cex = 0.6, radius = 0.9, init.angle = -10,
    main = "Распределение голосов", col = c(2:8))

# Столбиковые диаграммы (barplot)
data(InsectSprays)
attach(InsectSprays)
Means <- tapply(count, spray, mean)

barplot(Means, col = "steelblue",
        xlab = "Инсектицид",
        ylab = "Количество выживших насекомых",
        border = "red", width = sqrt(Means))

barplot(Means, density = 20, col = "red", horiz = T, las = 1,
        ylab = "Инсектицид",
        xlab = "Количество выживших инсекомых")


# Построение диаграммы, где несколько столбцов содержат группировку в
# соответствии с уровнями какого-либо фактора
library(MASS)
data(genotype)
means = with(genotype, tapply(Wt, list(Litter, Mother), mean))
# Функция with() позволяет указать таблицу, из которой
# функция tapply() должна брать данные для вычислений
barplot(means, beside = TRUE,
        col = topo.colors(4),
        legend.text = rownames(means),
        xlab = "Выводок", ylab = "Вес, г",
        ylim = c(0, 100))

