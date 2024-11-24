import time
from memory_profiler import memory_usage
from algorithms.sort import bubble_sort

def read_numbers_from_file(filename):
    """Lê números de um arquivo .txt e retorna uma lista."""
    with open(filename, 'r') as file:
        return [int(line.strip()) for line in file]

def process_data(filename):
    """Lê números do arquivo e ordena usando bubble_sort."""
    array = read_numbers_from_file(filename)
    bubble_sort(array)
    return array

if __name__ == '__main__':
    input_file = r'C:\Users\vinic\Área de Trabalho\projetos\Analise-de-Memoria-RAM\arq.txt'

    # Medição de memória e tempo
    start_time = time.time()  # Início da medição de tempo
    mem_usage = memory_usage((process_data, (input_file,)), interval=0.01, timeout=10)  # Medição de memória
    end_time = time.time()  # Fim da medição de tempo

    # Executa novamente para exibir o array ordenado
    array = read_numbers_from_file(input_file)
    bubble_sort(array)  # Ordena o array
    print("Array ordenado:", array)

    # Resultados
    duration = end_time - start_time  # Tempo total em segundos

    # Convertendo o uso de memória de MiB para bytes
    mem_used_bytes = (max(mem_usage) - min(mem_usage)) * 1024 * 1024

    print(f"Tempo de execução: {duration:.6f} segundos")
    print(f"Memória usada: {int(mem_used_bytes)} bytes")
