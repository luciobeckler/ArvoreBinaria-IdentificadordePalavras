package Arvore;

import Data.Palavra;

public class No {
  int linha;
  String palavra;
  Palavra word;
  int contador;
  No direita;
  No esquerda;

  public No(String palavraInicial, int valorInicial) {
    this.linha = valorInicial;
    this.palavra = palavraInicial;
    this.contador = 1;
  }

  public void adicionar() {
    this.contador++;
  }

}
