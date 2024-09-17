import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Arvore.Arvore;
import Arvore.No;
import Data.Leitor;
import Data.Palavra;

public class App {
    static Queue<Palavra> fila = new LinkedList<>();
    static Queue<Palavra> amostras = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        fila = Leitor.LeArquivosECriaObjetos("src/Data/faroeste.txt");
        popularAmostras();

        Palavra palavraMeio = encontraPalavraMeioAlfabeto(amostras);
        amostras.remove(palavraMeio);
        Arvore arvore = esvaziarFilasEPopularArvore(palavraMeio);

        TesteFuncionalidadesArvore(arvore);
        printEmOrdemAlfabetica(arvore);

    }

    // #region Métodos kickoff
    private static Arvore esvaziarFilasEPopularArvore(Palavra noInicial) {
        No raizInicial = new No(noInicial.getPalavra(), noInicial.getLinha());
        Arvore arvore = new Arvore(raizInicial);

        while (amostras.isEmpty() != true && fila.isEmpty() != true) {

            // esvazia fila das amostras
            if (amostras.isEmpty() != false) {
                Palavra word = amostras.poll();
                arvore.Inserir(new No(word.getPalavra(), word.getLinha()));
            } else {
                // esvazia a fila
                Palavra word = fila.poll();
                arvore.Inserir(new No(word.getPalavra(), word.getLinha()));
            }

        }
        return arvore;
    }

    private static void printEmOrdemAlfabetica(Arvore arvore) {
        arvore.EmOrdem();
    }

    private static void popularAmostras() {
        for (int i = 0; i < 10; i++) {
            amostras.add(fila.poll());
        }
    }

    public static Palavra encontraPalavraMeioAlfabeto(Queue<Palavra> amostras) {
        List<Palavra> listaPalavras = new ArrayList<>(amostras);

        listaPalavras.sort(Comparator.comparing(Palavra::getPalavra));

        int meio = listaPalavras.size() / 2;
        return listaPalavras.get(meio);
    }
    // #endregion

    // #region Método teste funcionalidades
    private static void TesteFuncionalidadesArvore(Arvore arvore) {
        System.out.println("Inserindo a palavra teste \n\n");
        arvore.Inserir(new No("teste", 15));

        System.out.println("Exibindo a árvore em Pos ordem \n\n");
        arvore.PosOrdem();

        System.out.println("Exibindo a árvore em pré ordem \n\n");
        arvore.PreOrdem();

        System.out.println("Exibindo a árvore em ordem \n\n");
        arvore.EmOrdem();

        System.out.println("Removendo a palavra teste \n\n");
        arvore.remover("teste");

        System.out.println("Exibindo a árvore em ordem \n\n");
        arvore.EmOrdem();
    }
    // #endregion
}
