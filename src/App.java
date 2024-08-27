import Arvore.Arvore;
import Arvore.No;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        No raizInicial = new No(50);

        Arvore arvore = new Arvore(raizInicial);
        arvore.Inserir(new No(10));
        ;
        arvore.Inserir(new No(20));
        ;
        arvore.Inserir(new No(30));
        ;
        arvore.Inserir(new No(40));
        ;
        arvore.Inserir(new No(50));
        ;
        arvore.Inserir(new No(60));
        ;
        arvore.Inserir(new No(70));
        ;
        arvore.Inserir(new No(80));
        ;
        arvore.Inserir(new No(90));
        ;
        arvore.Inserir(new No(100));
        ;

        arvore.EmOrdem();

        arvore.remover(100);

        arvore.EmOrdem();

        arvore.Inserir(new No(100));

        arvore.EmOrdem();
    }
}
