package Arvore;

public class Arvore {
  No raiz;

  public Arvore(No raiz) {
    this.raiz = raiz;
  }

  private No InserirNovo(No novo, No atual) {
    if (atual == null)
      return novo;

    if (novo.valor < atual.valor)
      atual.esquerda = InserirNovo(novo, atual.esquerda);
    else if (novo.valor > atual.valor)
      atual.direita = InserirNovo(novo, atual.direita);

    return atual;
  }

  public void Inserir(No novo) {
    raiz = InserirNovo(novo, raiz);
  }

  private void PreOrdem(No elemento) {
    if (elemento != null) {
      System.out.print(elemento.valor + " ");
      PreOrdem(elemento.esquerda);
      PreOrdem(elemento.direita);
    }
  }

  private void PosOrdem(No elemento) {
    if (elemento != null) {
      PosOrdem(elemento.esquerda);
      PosOrdem(elemento.direita);
      System.out.print(elemento.valor + " ");
    }
  }

  private void EmOrdem(No elemento) {
    if (elemento != null) {
      EmOrdem(elemento.esquerda);
      System.out.print(elemento.valor + " ");
      EmOrdem(elemento.direita);
    }
  }

  public void PreOrdem() {
    PreOrdem(raiz);
    System.out.println();
  }

  public void PosOrdem() {
    PosOrdem(raiz);
    System.out.println();
  }

  public void EmOrdem() {
    EmOrdem(raiz);
    System.out.println();
  }

  No encontrarElemento(No atual, int valor) {
    if (atual == null)
      return null;

    if (valor == atual.valor)
      return atual;

    if (valor > atual.valor) {

      if (atual.direita != null && atual.direita.valor == valor)
        return atual;
      return encontrarElemento(atual.direita, valor);
    } else {
      if (atual.esquerda != null && atual.esquerda.valor == valor)
        return atual;
      return encontrarElemento(atual.esquerda, valor);
    }
  }

  public boolean remover(int valor) {
    if (raiz == null)
      return false;
    else {
      No pai;
      No noX;
      if (raiz.valor == valor) {
        pai = raiz;
        noX = raiz;
      } else {

        pai = encontrarElemento(raiz, valor);
        if (pai.valor < valor)
          noX = pai.direita;
        else
          noX = pai.esquerda;

      }

      if (noX.direita == null && noX.esquerda == null) {
        if (pai.valor < valor)
          pai.direita = null;
        else
          pai.esquerda = null;

      } else {
        if (noX.direita != null && noX.esquerda != null) {
          No noPaiDireitaEsquerda = maisEsquerdaPossivel(noX, noX.direita);
          No substituto = noPaiDireitaEsquerda.esquerda;
          noPaiDireitaEsquerda.esquerda = null;
          substituto.direita = noX.direita;
          substituto.esquerda = noX.esquerda;
          noX.esquerda = null;
          noX.direita = null;

        } else {
          if (noX.direita == null) {
            if (pai.valor > valor)
              pai.direita = noX.esquerda;
            else
              pai.esquerda = noX.esquerda;
          }
          if (noX.esquerda == null) {
            if (pai.valor > valor)
              pai.direita = noX.direita;
            else
              pai.esquerda = noX.direita;
          }

        }
      }
      return true;
    }
  }

  private No maisEsquerdaPossivel(No pai, No filhoAtual) {
    if (filhoAtual.esquerda == null)
      return pai;
    return maisEsquerdaPossivel(filhoAtual, filhoAtual.esquerda);
  }

  private No obterSucessor(No NoRemovido) {
    No sucessorPai = NoRemovido;
    No sucessor = NoRemovido;
    No atual = NoRemovido.direita;

    while (atual != null) {
      sucessorPai = sucessor;
      sucessor = atual;
      atual = atual.esquerda;
    }

    if (sucessor != NoRemovido.direita) {
      sucessorPai.esquerda = sucessor.direita;
      sucessor.direita = NoRemovido.direita;
    }

    return sucessor;
  }
}
