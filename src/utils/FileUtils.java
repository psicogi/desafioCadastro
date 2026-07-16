package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void main(String[] args) {
        File form = new File("formulario.txt"); // cria um objeto que aponta para o arquivo txt
        // FileReader abre o arquivo para a leitura caractere por caractere
        // BufferedReader embrulha o FileReader e adiciona o metodo readLine() que permite ler a linha inteira de uma so vez
        // o try () faz com que os arquivos sejam fechados automaticamente
        try (FileReader fr = new FileReader(form); BufferedReader br = new BufferedReader(fr)){

            String line = br.readLine(); // le a primeira linha e guarda na var line, se a linha for vazia a var armazena o "null"
            while (line != null) { // enquanto a var for diferente de null o arquivo é lido
                System.out.println(line); // printa o arquivo
                line = br.readLine(); // le o arquivo
            }

        } catch (IOException e) { // captura se der algum erro
            e.printStackTrace(); // mostra o erro no terminal
        }
    }

    public static List<String> lerPerguntas() {
        List<String> perguntas = new ArrayList<>();
        File form = new File("formulario.txt");

        try (FileReader fr = new FileReader(form); BufferedReader br = new BufferedReader(fr)){

            String line = br.readLine(); // le a primeira linha e guarda na var line, se a linha for vazia a var armazena o "null"
            while (line != null) { // enquanto a var for diferente de null o arquivo é lido
                perguntas.add(line); // adiciona a linha na lista
                line = br.readLine(); // le a linha
            }

        } catch (IOException e) { // captura se der algum erro
            e.printStackTrace(); // mostra o erro no terminal
        }

        return perguntas;
    }
}
