import time
import platform
import psutil
from memory_profiler import memory_usage

def quicksort(array):
    """Implementação do QuickSort."""
    if len(array) <= 1:
        return array
    else:
        pivot = array[0]
        less = [x for x in array[1:] if x <= pivot]
        greater = [x for x in array[1:] if x > pivot]
        return quicksort(less) + [pivot] + quicksort(greater)

def read_numbers_from_file(filename):
    """Lê números de um arquivo .txt e retorna uma lista."""
    with open(filename, 'r') as file:
        return [int(line.strip()) for line in file]

def write_numbers_to_file(filename, numbers):
    """Escreve os números ordenados em um arquivo .txt."""
    with open(filename, 'w') as file:
        for num in numbers:
            file.write(f"{num}\n")

def process_data(filename):
    """Lê números do arquivo, ordena usando QuickSort e retorna o array ordenado."""
    array = read_numbers_from_file(filename)
    return quicksort(array)

if __name__ == '__main__':
    input_file = r'C:\Users\vinic\Área de Trabalho\projetos\Analise-de-Memoria-RAM\arq-desafio.txt'
    output_file = r'C:\Users\vinic\Área de Trabalho\projetos\Analise-de-Memoria-RAM\Quick\Python\arq-saida.txt'

    # Informações da linguagem
    print(f"Linguagem: Python")
    print(f"Versão: {platform.python_version()}")

    # Informações do sistema
    print(f"Sistema Operacional: {platform.system()} {platform.release()}")
    print(f"Processador: {platform.processor()}")
    print(f"Memória RAM Total: {psutil.virtual_memory().total // 1024} KB")

    # Medição de memória e tempo
    start_time = time.time()  # Início da medição de tempo
    mem_usage = memory_usage((process_data, (input_file,)), interval=0.01, timeout=10)  # Medição de memória
    end_time = time.time()  # Fim da medição de tempo

    # Processa os dados e gera o array ordenado
    sorted_array = process_data(input_file)

    # Escreve o array ordenado no arquivo de saída
    write_numbers_to_file(output_file, sorted_array)

    # Resultados
    duration_ms = (end_time - start_time) * 1000  # Tempo total em milissegundos
    mem_used_kb = (max(mem_usage) - min(mem_usage)) * 1024  # Memória usada em kilobytes
    print(f"Tempo de execução: {duration_ms:.2f} ms")
    print(f"Memória usada: {int(mem_used_kb)} KB")
    print(f"Array ordenado salvo em: {output_file}")
