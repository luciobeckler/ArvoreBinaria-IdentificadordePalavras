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
    public static void main(String[] args) throws Exception {
        Queue<Palavra> fila = Leitor.LeArquivosECriaObjetos("src/Data/brasil.txt");

        Queue<Palavra> amostras = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            amostras.add(fila.poll());
        }

        Palavra palavraMeio = encontraPalavraMeioAlfabeto(amostras);

        No raizInicial = new No(palavraMeio.getPalavra(), palavraMeio.getLinha());
        Arvore arvore = new Arvore(raizInicial);

        while (amostras.isEmpty() != true) {
            Palavra word = amostras.poll();
            System.out.println(word.getPalavra());

            arvore.Inserir(new No(word.getPalavra(), word.getLinha()));
        }

        arvore.EmOrdem();

        System.out.println();

        // ler arquivo e coloca em uma stack
        // obtem amostras e inicializa uma raiz
        // comeca a desempilhar e adicionar na arvore

        // System.out.println("Hello, World!");

        // No raizInicial = new No(50);

        // Arvore arvore = new Arvore(raizInicial);
        // arvore.Inserir(new No(10));
        // ;
        // arvore.Inserir(new No(20));
        // ;
        // arvore.Inserir(new No(30));
        // ;
        // arvore.Inserir(new No(40));
        // ;
        // arvore.Inserir(new No(50));
        // ;
        // arvore.Inserir(new No(60));
        // ;
        // arvore.Inserir(new No(70));
        // ;
        // arvore.Inserir(new No(80));
        // ;
        // arvore.Inserir(new No(90));
        // ;
        // arvore.Inserir(new No(100));
        // ;

        // arvore.EmOrdem();

        // arvore.remover(100);

        // arvore.EmOrdem();

        // arvore.Inserir(new No(100));

        // arvore.EmOrdem();
    }

    public static Palavra encontraPalavraMeioAlfabeto(Queue<Palavra> amostras) {
        List<Palavra> listaPalavras = new ArrayList<>(amostras);

        listaPalavras.sort(Comparator.comparing(Palavra::getPalavra));

        int meio = listaPalavras.size() / 2;
        return listaPalavras.get(meio);
    }
}
