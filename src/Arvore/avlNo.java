package Arvore;

import java.util.ArrayList;
import java.util.List;

import Data.Palavra;

public class avlNo {
  int linha;
  String palavra;
  List<Integer> linhas = new ArrayList<>();
  Palavra word;
  avlNo direita;
  avlNo esquerda;
  int fatorDeBalanceamento;

  public avlNo(String palavraInicial, int valorInicial) {
    this.linha = valorInicial;
    this.palavra = palavraInicial;
    this.linhas.add(valorInicial);
    fatorDeBalanceamento = 0;
  }

  public void adicionarLinha(int linha) {
    this.linhas.add(linha);
  }

}
