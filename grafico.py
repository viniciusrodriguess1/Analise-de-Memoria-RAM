import matplotlib.pyplot as plt
import numpy as np

def plot_graphs(data_dict, title, xlabel, ylabel, graph_type='line', median=False):
    plt.figure(figsize=(10, 6))
    for label, values in data_dict.items():
        x = np.arange(len(values))  # Índices para os valores
        
        if median:
            # Exibe a mediana
            plt.plot(x, [np.median(values)]*len(values), marker='o', label=f"{label} (Mediana: {np.median(values):.2f})")
        else:
            # Exibe a média
            plt.plot(x, values, marker='o', label=f"{label} (Média: {np.mean(values):.2f})")
    
    plt.title(title)
    plt.xlabel(xlabel)
    plt.ylabel(ylabel)
    plt.legend()
    plt.grid(True)
    plt.show()

# Dados fornecidos para memória
dataM1 = [1560, 1796, 1868, 1696, 1876, 1448, 1516, 1764, 1716, 1718]  
dataM2 = [2956, 2680, 2752, 2468, 2828, 3036, 2856, 2824, 2992, 2866]
dataM3 = [983, 984, 985, 986, 987, 988, 989, 990, 991, 992]
dataM4 = [983, 983, 983, 983, 983, 983, 983, 983, 983, 983]

# Dicionário para memória
data_dict1 = {
    "Bubble Python": dataM1,
    "Quick Python": dataM2,
    "Quick Java": dataM3,
    "Bubble Java": dataM4
}

# Dados fornecidos para tempo
dataT1 = [15.34, 23.94, 19.50, 20.51, 23.52, 21.82, 20.01, 21.29, 18.35, 21.12]
dataT2 = [644.01, 661.10, 704.01, 1060.90, 615.99, 636.66, 655.40, 678.00, 1291.00, 678.24]
dataT3 = [22.01, 23.94, 21.33, 18.79, 22.01, 15.14, 20.52, 19.15, 21.03, 19.53]
dataT4 = [86993.79, 108735.96, 89433.15, 66832.01, 63167.02, 60010.37, 74078.88, 90601.93, 97007.23, 78103.06]

# Dicionário para tempo
data_dict2 = {
    "Quick Java": dataT1,
    "Quick Python": dataT2,
    "Bubble Java": dataT3,
    "Bubble Python": dataT4
}

# Plotar gráfico de média para Memória
plot_graphs(data_dict1, title="Gráfico de Média - Memória", xlabel="Índice", ylabel="Memória em KB", graph_type='line', median=False)

# Plotar gráfico de média para Tempo
plot_graphs(data_dict2, title="Gráfico de Média - Tempo", xlabel="Índice", ylabel="Tempo em ms", graph_type='line', median=False)

# Plotar gráfico de mediana para Memória
plot_graphs(data_dict1, title="Gráfico de Mediana - Memória", xlabel="Índice", ylabel="Memória em KB", graph_type='line', median=True)

# Plotar gráfico de mediana para Tempo
plot_graphs(data_dict2, title="Gráfico de Mediana - Tempo", xlabel="Índice", ylabel="Tempo em ms", graph_type='line', median=True)
