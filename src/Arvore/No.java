package Arvore;

import Data.Palavra;

public class No {
  int linha;
  String palavra;
  Palavra word;
  No direita;
  No esquerda;

  public No(String palavraInicial, int valorInicial) {
    this.linha = valorInicial;
    this.palavra = palavraInicial;
  }

}
