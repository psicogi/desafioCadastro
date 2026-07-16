package service;

import enums.TipoPet;
import enums.TipoSexo;
import model.Pet;
import utils.FileUtils;

import java.util.List;
import java.util.Scanner;

public class PetService {
    static final String NAO_INFORMADO = "NÃO INFORMADO";

    public static void cadastrar(Scanner sc) throws Exception {
        List<String> perguntas = FileUtils.lerPerguntas();

        // 1- nome do animal
        System.out.println(perguntas.get(0));
        String name = sc.nextLine();

        if (name.isBlank()) {
            throw new Exception("Nome é obrigatório!");
        }

        if (!name.contains(" ")) {
            throw new Exception("É obrigatório ter nome e sobrenome!");
        }

        if (!name.matches("[a-zA-ZÀ-ú ]+")) {
            throw new Exception("Nome não pode conter caracteres especiais!");
        }

        // 2- tipo do animal
        System.out.println(perguntas.get(1));
        TipoPet tipoPet = TipoPet.valueOf(sc.nextLine().toUpperCase());

        // 3- sexo do animal
        System.out.println(perguntas.get(2));
        TipoSexo tipoSexo = TipoSexo.valueOf(sc.nextLine().toUpperCase());

        // 4- endereco que foi encontrado
        System.out.println(perguntas.get(3));
        System.out.print("Numero da casa: ");
        String numeroCasa = sc.nextLine();

        if (numeroCasa.isBlank()) {
            numeroCasa = NAO_INFORMADO;
        }

        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Rua: ");
        String rua = sc.nextLine();

        // 5- idade do pet
        System.out.println(perguntas.get(4));
        String idade = sc.nextLine();

        if (idade.isBlank()) {
            idade = NAO_INFORMADO;
        } else {
            int idade2 = Integer.parseInt(idade);
            if (idade2 > 20) {
                throw new Exception("Idade máxima é 20");
            } else if (idade2 < 1) {
                idade = "0." + idade2;
            }
        }

        // 6- peso do pet
        System.out.println(perguntas.get(5));
        String peso = sc.nextLine();

        if (peso.isBlank()) {
            peso = NAO_INFORMADO;
        } else {
            double peso2 = Double.parseDouble(peso);

            if (peso2 < 0.5 || peso2 > 60) {
                throw new Exception("Peso fora do range");
            }
        }

        // 7- raça do pet
        System.out.println(perguntas.get(6));
        String raca  = sc.nextLine();

        if (raca.isBlank()) {
            raca = NAO_INFORMADO;
        } else if (!raca.matches("[a-zA-ZÀ-ú ]+")) {
            throw new Exception("Raça não pode  conter caracteres especiais!");
        }

        Pet pet = new Pet(name, tipoPet, tipoSexo, numeroCasa, cidade, rua, idade, peso, raca);
    }
}
