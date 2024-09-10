# Árvore binária identificadora de palavras - Java
Este projeto consiste em implementar um programa que lê um arquivo de texto no formato .txt, processa suas palavras e as organiza em uma estrutura de Árvore de Pesquisa Binária (BST - Binary Search Tree). O objetivo é identificar todas as palavras com 3 ou mais caracteres, removendo pontuações, convertendo todas as letras para minúsculas e associando-as às linhas em que aparecem no arquivo.

Cada nó da árvore armazena uma palavra, e uma lista das linhas em que essa palavra foi encontrada no texto. No final, o programa imprime as palavras em ordem alfabética, utilizando a busca em árvores do tipo "em ordem", juntamente com os números das linhas em que cada palavra aparece.

## Para implementar a estrutura de árvore foram criadas duas classes:
### Classe No
Representa um nó da árvore de pesquisa binária. Os principais atributos e métodos são:

### Classe árvore
Representa a estrutura da árvore e suas ações e possui os seguintes atributos e classes:

Agora para implemetar a solução foram implementadas as seguintes classes:
### Palavra
É a classe que irá carregar a palavra, permitindo que a árvore encontre a ordem alfabética e a quantidade de vezes que esta palavra aparece
### Leitor
Classe responsável por realizar a leitura de arquivos e retornar uma fila de Palavras
### App
É a classe onde a aplicação roda e é onde está a lógica das operações nas outras classes.

## Diagrama das classes:
![image](https://github.com/user-attachments/assets/ad90a00f-4dfe-48af-8b3b-a329b292c412)

## Resultados:
![Imagem do WhatsApp de 2024-09-08 à(s) 22 53 05_498e9d82](https://github.com/user-attachments/assets/82616694-81c0-42ed-8034-245637aaabef)

