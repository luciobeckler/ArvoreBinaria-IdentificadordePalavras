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
  // #endregion

  // Continuar a partir daqui
  // #region Balanceamento
  private avlNo AjustarBalanceamento(avlNo atual) {
    int balanceamento = atual.getFatorDeBalanceamento();

    if (balanceamento > 1) {
      if (atual.direita != null && atual.direita.getFatorDeBalanceamento() < 0) {
        atual.direita = rotacaoDireita(atual.direita);
      }
      return rotacaoEsquerda(atual);
    }

    if (balanceamento < -1) {
      if (atual.esquerda != null && atual.esquerda.getFatorDeBalanceamento() > 0) {
        atual.esquerda = rotacaoEsquerda(atual.esquerda);
      }
      return rotacaoDireita(atual);
    }

    return atual;
  }

  private avlNo rotacaoDireita(avlNo c) {
    avlNo b = c.esquerda;
    avlNo a = b.direita;

    b.direita = c;
    c.esquerda = a;

    c.atualizarAltura();
    b.atualizarAltura();

    return b;
  }

  private avlNo rotacaoEsquerda(avlNo c) {
    avlNo b = c.direita;
    avlNo a = b.esquerda;

    b.esquerda = c;
    c.direita = a;

    c.atualizarAltura();
    b.atualizarAltura();

    return b;
  }
  // #endregion

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
  // #endregion

  // #region Busca
  public avlNo buscarPalavra(String palavra) {
    return buscarPalavra(raiz, palavra);
  }

  private avlNo buscarPalavra(avlNo atual, String palavra) {
    if (atual == null)
      return null;

    if (palavra.compareTo(atual.palavra) < 0)
      return buscarPalavra(atual.esquerda, palavra);
    else if (palavra.compareTo(atual.palavra) > 0)
      return buscarPalavra(atual.direita, palavra);
    else
      return atual;
  }
  // #endregion

  // #region Remoção
  public void removerPalavra(String palavra) {
    raiz = removerPalavra(raiz, palavra);
  }

  private avlNo removerPalavra(avlNo atual, String palavra) {
    if (atual == null)
      return null;

    if (palavra.compareTo(atual.palavra) < 0)
      atual.esquerda = removerPalavra(atual.esquerda, palavra);
    else if (palavra.compareTo(atual.palavra) > 0)
      atual.direita = removerPalavra(atual.direita, palavra);
    else {
      // Nó folha
      if (atual.esquerda == null && atual.direita == null)
        return null;
      // Nó com um filho
      else if (atual.esquerda == null)
        return atual.direita;
      else if (atual.direita == null)
        return atual.esquerda;

      // Nó com dois filhos
      else {
        avlNo sucessor = encontrarMenor(atual.direita);
        atual.palavra = sucessor.palavra;
        atual.linhas = sucessor.linhas;
        atual.direita = removerPalavra(atual.direita, sucessor.palavra);
      }
    }

    // Atualizar altura e balancear
    atual.atualizarAltura();
    return AjustarBalanceamento(atual);
  }

  // Método auxiliar para encontrar o menor nó na subárvore
  private avlNo encontrarMenor(avlNo atual) {
    while (atual.esquerda != null) {
      atual = atual.esquerda;
    }
    return atual;
  }
  // #endregion
}
