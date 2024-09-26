import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Arvore.Arvore;
import Arvore.avlNo;
import Data.Leitor;
import Data.Palavra;

public class App {
    static Queue<Palavra> fila = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        GeraResultado();
    }

    private static void GeraResultado() {
        fila = Leitor.LeArquivosECriaObjetos("src/Data/faroeste.txt");

        Arvore arvore = esvaziarFilasEPopularArvore();

        TesteFuncionalidadesArvore(arvore);
    }

    // #region Métodos kickoff
    private static Arvore esvaziarFilasEPopularArvore() {
        Arvore arvore = new Arvore();

        while (fila.isEmpty() != true) {

            // esvazia a fila
            Palavra word = fila.poll();
            arvore.Inserir(new avlNo(word.getPalavra(), word.getLinha()));

        }
        return arvore;
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
        arvore.Inserir(new avlNo("teste", 15));

        System.out.println("Exibindo a árvore em Pos ordem \n\n");
        arvore.PosOrdem();

        System.out.println("Exibindo a árvore em pré ordem \n\n");
        arvore.PreOrdem();

        System.out.println("Exibindo a árvore em ordem \n\n");
        arvore.EmOrdem();
    }
    // #endregion
}
