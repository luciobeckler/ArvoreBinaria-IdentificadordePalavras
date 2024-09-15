package Arvore;

public class Arvore {
  No raiz;

  public Arvore(No raiz) {
    this.raiz = raiz;
  }

  private No InserirNovo(No novo, No atual) {
    if (atual == null)
      return novo;

    if (novo.palavra.compareTo(atual.palavra) < 0)
      atual.esquerda = InserirNovo(novo, atual.esquerda);
    else if (novo.palavra.compareTo(atual.palavra) > 0)
      atual.direita = InserirNovo(novo, atual.direita);
    else if (novo.palavra.compareTo(atual.palavra) == 0) {
      atual.adicionarLinha(novo.linha);
    }

    return atual;
  }

  public void Inserir(No novo) {
    raiz = InserirNovo(novo, raiz);
  }

  private void PreOrdem(No elemento) {
    if (elemento != null) {
      // System.out.print(elemento.valor + " ");
      PreOrdem(elemento.esquerda);
      PreOrdem(elemento.direita);
    }
  }
  
  private void EmOrdem(No elemento) {
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

  public void EmOrdem() {
    EmOrdem(raiz);
    System.out.println();
  }

}
