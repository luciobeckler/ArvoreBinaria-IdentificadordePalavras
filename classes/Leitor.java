package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Leitor {
  public static Queue<Palavra> LeArquivosECriaObjetos(String caminhoArquivo) {
    Queue<Palavra> fila = new LinkedList<>();
    final String CARACTERES_SPECIAIS = "[^A-Za-z0-9]";

    try {
      BufferedReader buffer = new BufferedReader(new FileReader(caminhoArquivo));
      String linhaTextoAtual = buffer.readLine();
      int contadorLinha = 0;

      while (linhaTextoAtual != null) {
        linhaTextoAtual = linhaTextoAtual.toLowerCase();
        String[] palavras = linhaTextoAtual.split(" ");

        for (int i = 0; i < palavras.length; i++) {
          String palavra = palavras[i];

          if (palavra.length() < 3) {
            continue;
          }

          // remove os caracteres especiais
          palavra = palavra.replaceAll(CARACTERES_SPECIAIS, "");
          Palavra word = new Palavra(palavra, contadorLinha);

          fila.add(word);
        }

        contadorLinha++;
        linhaTextoAtual = buffer.readLine();
      }
      buffer.close();
    } catch (Exception e) {
      System.err.println(e);
    }
    return fila;
  }
}
