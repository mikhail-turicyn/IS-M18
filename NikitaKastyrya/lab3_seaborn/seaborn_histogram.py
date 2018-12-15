# Визуализация гистограммы

import matplotlib.pyplot as plt
import seaborn as sns, numpy as np
import pandas as pd

plt.subplot(221)

sns.set(); np.random.seed(0)
x = np.random.randn(100)
ax = sns.distplot(x)

plt.subplot(222)
x = pd.Series(x, name="x variable")
ax = sns.distplot(x)

plt.show()