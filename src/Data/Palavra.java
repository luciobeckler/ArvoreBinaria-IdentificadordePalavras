package Data;

public class Palavra {
    String palavra;
    int linha;

    public Palavra(String palavra, int linha) {
        this.palavra = palavra;
        this.linha = linha;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }


    public int getLinha() {
        return linha;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
}
