package Arvore;

import java.util.ArrayList;
import java.util.List;

import Data.Palavra;

public class No {
  int linha;
  String palavra;
  List<Integer> linhas = new ArrayList<>();
  Palavra word;
  No direita;
  No esquerda;

  public No(String palavraInicial, int valorInicial) {
    this.linha = valorInicial;
    this.palavra = palavraInicial;
    this.linhas.add(valorInicial);
  }

  public void adicionarLinha(int linha) {
    this.linhas.add(linha);
  }

}
