import time
from memory_profiler import memory_usage
from algorithms.sort import bubble_sort

def process_data():
    array = [64, 34, 25, 12, 22, 11, 90]
    bubble_sort(array)  # Ordena o array
    return array

if __name__ == '__main__':
    # Medição de memória e tempo
    start_time = time.time()  # Início da medição de tempo
    mem_usage = memory_usage(process_data, interval=0.01, timeout=1)  # Medição de memória
    end_time = time.time()  # Fim da medição de tempo

    # Executa novamente para exibir o array ordenado
    array = [64, 34, 25, 12, 22, 11, 90]
    bubble_sort(array)  # Ordena o array
    print("Array ordenado:", array)

    # Resultados
    duration = end_time - start_time  # Tempo total em segundos
    print(f"Tempo de execução: {duration:.6f} segundos")
    print(f"Memória usada: {max(mem_usage) - min(mem_usage):.2f} MiB")
