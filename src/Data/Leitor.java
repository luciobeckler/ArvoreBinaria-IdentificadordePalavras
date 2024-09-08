package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.channels.Pipe.SourceChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leitor {
  public static Queue<Palavra> LeArquivosECriaObjetos(String caminhoArquivo) {
    Queue<Palavra> pilha = new LinkedList<>();

    try {
      BufferedReader buffer = new BufferedReader(new FileReader(caminhoArquivo));
      String linha = buffer.readLine();
      int line = 1;

      while ((linha = buffer.readLine()) != null) {
        linha = linha.toLowerCase();
        String[] palavras = linha.split(" ");

        for (int i = 0; i < palavras.length; i++) {
          String palavra = palavras[i];

          Palavra word = new Palavra(palavra, line);

          pilha.add(word);
        }

        line++;
      }
      buffer.close();
    } catch (Exception e) {
      System.err.println(e);
    }
    return pilha;
  }
}
