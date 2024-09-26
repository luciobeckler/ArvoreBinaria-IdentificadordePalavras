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
  int altura = 0;

  public avlNo(String palavraInicial, int valorInicial) {
    this.linha = valorInicial;
    this.palavra = palavraInicial;
    this.linhas.add(valorInicial + 1);
    this.altura = 1;
  }

  public void adicionarLinha(int linha) {
    this.linhas.add(linha + 1);
  }

  public int getAltura(avlNo no) {
    return no == null ? 0 : no.altura;
  }

  public void atualizarAltura() {
    if (getAltura(esquerda) > getAltura(direita))
      this.altura = 1 + getAltura(esquerda);
    else
      this.altura = 1 + getAltura(direita);
  }

  public int getFatorDeBalanceamento() {
    return getAltura(esquerda) - getAltura(direita);
  }
}
