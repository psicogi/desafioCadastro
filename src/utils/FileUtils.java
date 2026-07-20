package utils;

import enums.TipoPet;
import enums.TipoSexo;
import model.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void salvar(Pet pet) {
        LocalDateTime  now = LocalDateTime.now(); // pega a hora de agora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"); // formata no padrao dado pelo dev

        String dataFormatada =  now.format(formatter); // aplica a formatação na data

        String nomeSemEspaco = pet.getName().replace(" ", "").toUpperCase();
        String nomeArquivo = "petsCadastrados/" + dataFormatada + "-" + nomeSemEspaco + ".TXT";

        File file = new File(nomeArquivo);

        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)){

            bw.write("1 - " + pet.getName()); // escreve a linha nova
            bw.newLine(); // cria uma nova linha
            bw.write("2 - " + pet.getPet());
            bw.newLine();
            bw.write("3 - " + pet.getSexo());
            bw.newLine();
            bw.write("4 - " + pet.getRua() + ", " + pet.getNumero() + ", " + pet.getCidade());
            bw.newLine();
            bw.write("5 - " + pet.getIdade());
            bw.newLine();
            bw.write("6 - " + pet.getPeso());
            bw.newLine();
            bw.write("7 - " + pet.getRaca());

        } catch (IOException e) { // captura se der algum erro
            e.printStackTrace(); // mostra o erro no terminal
        }
    }

    public static List<Pet> lerPets() {
        List<Pet> pets = new ArrayList<>(); // cria uma lista
        File pasta = new File("petsCadastrados"); // cria um objeto que aponta para a pasta
        File[] arquivos = pasta.listFiles(); // cria um array que lista os arquivos da pasta

        for (File file : arquivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String nome = br.readLine().split(" - ")[1]; // cria uma var para cada linha lida e remove o -
                String tipo = br.readLine().split(" - ")[1];
                String sexo = br.readLine().split(" - ")[1];
                String endereco = br.readLine().split(" - ")[1];
                String idade = br.readLine().split(" - ")[1];
                String peso = br.readLine().split(" - ")[1];
                String raca = br.readLine().split(" - ")[1];

                String[] partesEndereco = endereco.split(", "); // cria um array para dividir as partes de endereco
                String rua = partesEndereco[0];
                String numeroCasa = partesEndereco[1];
                String cidade = partesEndereco[2];

                TipoPet tipoPet = TipoPet.valueOf(tipo); // converte o tipo para enum
                TipoSexo tipoSexo = TipoSexo.valueOf(sexo);

                Pet pet = new Pet(nome, tipoPet, tipoSexo, numeroCasa, cidade, rua, idade, peso, raca); // cria um objeto e aponta para o resultado
                pets.add(pet); // adiciona o objeto
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pets;
    }
}
