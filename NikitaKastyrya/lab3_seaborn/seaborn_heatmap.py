# Визуализация тепловой карты

import seaborn as sns
import matplotlib.pyplot as plt


plt.subplot(221)
# Загружаем набор данных
flights = sns.load_dataset("flights")
#Реорганизуем данные в виде кластеризованной таблицы:
flights = flights.pivot("month", "year", "passengers")
# Создаём тепловую карту
ax = sns.heatmap(flights)

plt.subplot(222)
# Численное значение для каждой ячейки
ax = sns.heatmap(flights, annot=True, fmt="d")

plt.subplot(223)
# Строки между ячейками
ax = sns.heatmap(flights, linewidths=.5)

plt.subplot(224)
# Другая цветовая гамма
ax = sns.heatmap(flights, cmap="YlGnBu")

plt.show()

