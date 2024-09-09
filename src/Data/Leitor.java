package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Leitor {
  public static Queue<Palavra> LeArquivosECriaObjetos(String caminhoArquivo) {
    Queue<Palavra> pilha = new LinkedList<>();
    final String CARACTERES_SPECIAIS = "[^A-Za-z0-9]";

    try {
      BufferedReader buffer = new BufferedReader(new FileReader(caminhoArquivo));
      String linhaTextoAtual = buffer.readLine();
      int contadorLinha = 2;

      while ((linhaTextoAtual = buffer.readLine()) != null) {
        linhaTextoAtual = linhaTextoAtual.toLowerCase();
        String[] palavras = linhaTextoAtual.split(" ");

        for (int i = 0; i < palavras.length; i++) {
          String palavra = palavras[i];
          // remove os caracteres especiais
          palavra = palavra.replaceAll(CARACTERES_SPECIAIS, "");
          Palavra word = new Palavra(palavra, contadorLinha);

          pilha.add(word);
        }

        contadorLinha++;
      }
      buffer.close();
    } catch (Exception e) {
      System.err.println(e);
    }
    return pilha;
  }
}
