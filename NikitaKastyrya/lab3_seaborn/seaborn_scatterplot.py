# Точечные графики
import seaborn as sns
import matplotlib.pyplot as plt
sns.set(style="whitegrid")

plt.subplot(221)
tips = sns.load_dataset("tips")
ax = sns.scatterplot(x="day", y="total_bill", data=tips)

plt.subplot(222)
tips = sns.load_dataset("tips")
ax = sns.scatterplot(x="tip", y="total_bill", data=tips)

plt.subplot(223)
ax = sns.scatterplot(x="total_bill", y="tip", hue="time",data=tips)

plt.subplot(224)
ax = sns.scatterplot(x="total_bill", y="tip", hue="day", style="time", data=tips)

plt.show()