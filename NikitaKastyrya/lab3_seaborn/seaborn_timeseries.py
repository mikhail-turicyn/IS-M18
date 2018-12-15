# Визуализация временного ряда

import matplotlib.pyplot as plt
import seaborn as sns



# загрузка тестовых данных
fmri = sns.load_dataset("fmri")

# Отображение сигнала в разных регионах и по типу события
sns.lineplot(x="timepoint", y="signal",
             hue="region", style="event",
             data=fmri)

plt.show()