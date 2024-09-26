package Arvore;

public class Arvore {
  avlNo raiz;

  public void Inserir(avlNo novo) {
    raiz = InserirNovo(novo, raiz);
  }

  // #region Inserção
  private avlNo InserirNovo(avlNo novo, avlNo atual) {
    if (atual == null)
      return novo;

    if (novo.palavra.compareTo(atual.palavra) < 0)
      atual.esquerda = InserirNovo(novo, atual.esquerda);
    else if (novo.palavra.compareTo(atual.palavra) > 0)
      atual.direita = InserirNovo(novo, atual.direita);
    else if (novo.palavra.compareTo(atual.palavra) == 0) {
      atual.adicionarLinha(novo.linha);
    }

    atual.atualizarAltura();
    return AjustarBalanceamento(atual);
  }

  // Continuar a partir daqui
  private avlNo AjustarBalanceamento(avlNo atual) {
    int balanceamento = atual.getFatorDeBalanceamento();

    if (balanceamento == 2) {
      if (atual.esquerda.getFatorDeBalanceamento() < 0) {
        atual.esquerda = rotacaoEsquerda(atual.esquerda);
      }
      return rotacaoDireita(atual);
    }

    if (balanceamento == -2) {
      if (atual.direita.getFatorDeBalanceamento() > 0) {
        atual.direita = rotacaoDireita(atual.direita);
      }
      return rotacaoEsquerda(atual);
    }

    return atual;
  }

  private avlNo rotacaoDireita(avlNo y) {
    avlNo x = y.esquerda;
    avlNo T2 = x.direita;

    x.direita = y;
    y.esquerda = T2;

    y.atualizarAltura();
    x.atualizarAltura();

    return x;
  }

  private avlNo rotacaoEsquerda(avlNo x) {
    avlNo y = x.direita;
    avlNo T2 = y.esquerda;

    y.esquerda = x;
    x.direita = T2;

    x.atualizarAltura();
    y.atualizarAltura();

    return y;
  }

  // #region Exibição
  public void PreOrdem() {
    PreOrdem(raiz);
    System.out.println();
  }

  private void PreOrdem(avlNo elemento) {
    if (elemento != null) {
      System.out.print(elemento.palavra + " ");
      PreOrdem(elemento.esquerda);
      PreOrdem(elemento.direita);
    }
  }

  public void PosOrdem() {
    PosOrdem(raiz);
    System.out.println();
  }

  private void PosOrdem(avlNo elemento) {
    if (elemento != null) {
      PosOrdem(elemento.esquerda);
      PosOrdem(elemento.direita);
      System.out.print(elemento.palavra + " ");
    }
  }

  public void EmOrdem() {
    EmOrdem(raiz);
    System.out.println();
  }

  private void EmOrdem(avlNo elemento) {
    if (elemento != null) {

      EmOrdem(elemento.esquerda);
      System.out.print(elemento.palavra + " ");
      for (int i = 0; i < elemento.linhas.size(); i++) {
        System.out.print(elemento.linhas.get(i) + " ");
      }
      System.out.println("");
      EmOrdem(elemento.direita);
    }
  }
}
