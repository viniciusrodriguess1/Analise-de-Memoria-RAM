import time
from memory_profiler import memory_usage

def process_data():
    data = [64, 34, 25, 12, 22, 11, 90]
    sorted_data = sorted(data)  # Ordena os dados
    return sorted_data

if __name__ == '__main__':
    # Medindo memória e tempo
    start_time = time.time()  # Início da medição de tempo
    mem_usage = memory_usage(process_data, interval=0.01, timeout=1)  # Medição de memória
    end_time = time.time()  # Fim da medição de tempo

    # Executa a função novamente para exibir o resultado final (fora da medição)
    sorted_array = process_data()
    print(f"Array ordenado: {sorted_array}")

    # Resultados
    duration = end_time - start_time  # Tempo total em segundos
    print(f"Tempo de execução: {duration:.6f} segundos")
    print(f"Memória usada: {max(mem_usage) - min(mem_usage):.2f} MiB")
