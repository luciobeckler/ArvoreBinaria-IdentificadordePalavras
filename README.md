# Árvore Binária Identificadora de Palavras - Java

Este projeto consiste em implementar um programa que lê um arquivo de texto no formato `.txt`, processa suas palavras e as organiza em uma estrutura de Árvore de Pesquisa Binária Balanceada (AVL). Esta estrutura proporciona um tempo de execução mais eficiente em comparação a uma simples árvore binária. O objetivo é identificar todas as palavras com 3 ou mais caracteres, remover pontuações, converter todas as letras para minúsculas e associar as palavras às linhas em que aparecem no arquivo. Cada nó da árvore armazena uma palavra e uma lista das linhas em que essa palavra foi encontrada no texto. No final, o programa imprime as palavras em ordem alfabética utilizando a busca "em ordem", juntamente com os números das linhas em que cada palavra aparece.

## Estrutura do Projeto

### Classes de Estrutura da Árvore
- **AvlNo**: Representa um nó da árvore de pesquisa binária balanceada.
- **Arvore**: Representa a estrutura da árvore binária balanceada e suas ações.

### Classes para a Implementação da Solução
- **Palavra**: Carrega a palavra, permitindo que a árvore encontre a ordem alfabética e a quantidade de vezes que essa palavra aparece.
- **Leitor**: Responsável por realizar a leitura de arquivos e retornar uma fila de objetos do tipo `Palavra`.
- **App**: Classe principal onde a aplicação é executada e onde está a lógica das operações nas outras classes.

## Diagrama das Classes
![Diagrama das Classes](https://github.com/user-attachments/assets/aa62975a-f68a-49b3-b58e-c9d25d48bc98)

## Testes e Resultados

Os testes foram realizados para verificar a contagem de palavras, a ordem alfabética ao imprimir a árvore "em ordem" e a comparação de desempenho entre uma árvore binária simples e uma árvore balanceada.

### Teste de Alocação de Palavra na Árvore
![Teste de Alocação de Palavra na Árvore 1](https://github.com/user-attachments/assets/7bfa0334-b00f-43c4-ad40-d22cb37b0d23)
![Teste de Alocação de Palavra na Árvore 2](https://github.com/user-attachments/assets/40f2d584-a5db-46eb-85a3-d1ba58926391)
![Teste de Alocação de Palavra na Árvore 3](https://github.com/user-attachments/assets/d5c15bca-a42c-440d-ada4-23624e4e7022)

### Teste de Verificação da Ordem Alfabética
![Teste de Verificação da Ordem Alfabética](https://github.com/user-attachments/assets/a8289085-32ed-4172-ad7e-047ad87078d4)

### Teste de Performance: Árvore Binária vs Árvore Binária Balanceada

Para realizar o comparativo de performance entre as duas implementações de árvores, foi desenvolvida uma função para buscar repetidamente a palavra “Sofrer”, chamada dentro do método `GeraResultado`, que teve o tempo de execução cronometrado. Os resultados são demonstrados a seguir:

![Gráfico de Performance 1](https://github.com/user-attachments/assets/aedac583-cbaa-4fe7-9bbd-3a22a121ed2c)
![Gráfico de Performance 2](https://github.com/user-attachments/assets/38e864f1-3b47-478e-bc43-a5af6e986640)
![Gráfico de Performance 3](https://github.com/user-attachments/assets/33b9fec6-499c-419c-965b-c6d079462e59)

## Como Executar

1. Clone o repositório para sua máquina:
   - git clone https://github.com/seu-usuario/seu-repositorio.git
2. Navegue até o diretório do projeto:
   - cd seu-repositorio
3. Compile as classes Java:
  - java src/*.java
4. Execute a aplicação:
  - java src.App arquivo_de_texto.txt


Certifique-se de que o arquivo de texto de entrada esteja no formato .txt e siga as regras mencionadas para uma análise precisa das palavras.




  
