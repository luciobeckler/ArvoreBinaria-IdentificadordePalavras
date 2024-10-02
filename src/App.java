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
        long startTime = System.nanoTime();

        GeraResultado();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInMillis = duration / 1_000_000.0;

        System.out.println("Tempo de execução de GeraResultado(): " + durationInMillis + " ms");
    }

    private static void GeraResultado() {
        fila = Leitor.LeArquivosECriaObjetos("src/Data/faroeste.txt");

        Arvore arvore = esvaziarFilasEPopularArvore();

        RealizaVariasBuscas(arvore, 100000000);
    }

    private static void RealizaVariasBuscas(Arvore arvore, int quant) {
        while (quant != 0) {
            arvore.buscarPalavra("sofrer");
            quant--;
        }
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

}
