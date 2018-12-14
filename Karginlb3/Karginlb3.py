import matplotlib.pyplot as plt
import numpy as np

s = ['Петя','Ванечка','Григорий Иванович ','Иринка' ,'Заир']
dat = np.random.random(200).reshape(20,10) # создаём матрицу значений
x1 = [1,2,3,4,5]
x = [3, 5, 83, 34, 27]
z = np.random.random(100)
z1 = [10, 17, 24, 16, 22]
z2 = [12, 14, 21, 13, 17]

# bar()
fig1 = plt.figure()
plt.bar(x1, z1)
plt.title('Bar chart')
plt.grid(True)   # линии вспомогательной сетки

# hist()
fig2 = plt.figure()
plt.hist(z)
plt.title('Простая гистограмма')
plt.grid(True)

# pie()
fig3 = plt.figure()
plt.pie(x, labels=s)
plt.title('Кто старше?')

# boxplot()
fig4 = plt.figure()
plt.boxplot([z1, z2])
plt.title('Boxplot')
plt.grid(True)

# errorbar()
fig5 = plt.figure()
plt.errorbar(x1, z1, xerr=1, yerr=0.5)
plt.title('Errorbar')
plt.grid(True)

fig6 = plt.figure()
pc = plt.pcolor(dat) # метод псевдографики pcolor
plt.colorbar(pc)
plt.title('Pcolor plot')

fig7 = plt.figure()
me = plt.imshow(dat)
plt.colorbar(me)
plt.title('Построение изолиний')

plt.show()