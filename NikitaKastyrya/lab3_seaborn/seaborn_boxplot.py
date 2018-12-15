# Диаграмма размаха
import seaborn as sns
import matplotlib.pyplot as plt
sns.set(style="whitegrid")

plt.subplot(221)
tips = sns.load_dataset("tips")
ax = sns.boxplot(x=tips["total_bill"])

plt.subplot(222)
ax = sns.boxplot(x="day", y="total_bill", data=tips)

plt.subplot(223)
ax = sns.boxplot(x="day", y="total_bill", hue="smoker",data=tips, palette="Set3")

plt.show()