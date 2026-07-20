package service;

import enums.TipoPet;
import enums.TipoSexo;
import model.Pet;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

        FileUtils.salvar(pet);
    }

    public static void buscar(Scanner sc) throws Exception {
        List<Pet> pets = FileUtils.lerPets();


        // pergunta qual o tipo do pet
        System.out.println("Qual o tipo do animal quer buscar? ");
        System.out.println("1. Cachorro");
        System.out.println("2. Gato");
        String opc = sc.nextLine();

        TipoPet tipoBuscado = opc.equals("1") ? TipoPet.CACHORRO : TipoPet.GATO; // se a opc for 1 é cachorro, senao, gato

        List<Pet> petsFiltrados = new ArrayList<>();
        for (Pet pet: pets) {
            if (pet.getPet() == tipoBuscado) { // se o pet for igual ao tipo buscado, adicione ele
                petsFiltrados.add(pet);
            }
        }

        System.out.println("Por qual critério quer buscar? ");
        System.out.println("1. Nome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");
        String criterio = sc.nextLine();

        boolean encontrou = false;

        switch (criterio) {
            case "1":
                System.out.println("Digite o nome do animal: ");
                String nomeBuscado = sc.nextLine();

                for (Pet pet: petsFiltrados) {
                    if (pet.getName().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                        System.out.println("Nome: " + pet.getName() + "\nPet: " + pet.getPet() + "\nSexo: " + pet.getSexo() + "\nIdade: " + pet.getIdade());
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pet não encontrado!");
                }
                break;
            case "2":
                encontrou = false;
                System.out.println("Digite o sexo do animal: ");
                String sexoBuscado = sc.nextLine();

                for (Pet pet: petsFiltrados) {
                    if (pet.getSexo().toString().equalsIgnoreCase(sexoBuscado)) {
                        System.out.println("Nome: " + pet.getName() + "\nPet: " + pet.getPet() + "\nSexo: " + pet.getSexo() + "\nIdade: " + pet.getIdade());
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pet não encontrado!");
                }

                break;
            case "3":
                encontrou = false;
                System.out.println("Digite a idade: ");
                String idadeBuscada = sc.nextLine();

                for (Pet pet: petsFiltrados) {
                    if (pet.getIdade().contains(idadeBuscada)) {
                        System.out.println("Nome: " + pet.getName() + "\nPet: " + pet.getPet() + "\nSexo: " + pet.getSexo() + "\nIdade: " + pet.getIdade());
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pet não encontrado!");
                }
                break;
            case "4":
                encontrou = false;
                System.out.println("Digite o peso: ");
                String pesoBuscado = sc.nextLine();

                for (Pet pet: petsFiltrados) {
                    if (pet.getPeso() == pesoBuscado) {
                        System.out.println("Nome: " + pet.getName() + "\nPet: " + pet.getPet() + "\nSexo: " + pet.getSexo() + "\nIdade: " + pet.getIdade());
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pet não encontrado!");
                }
                break;
            case "5":
                encontrou = false;
                System.out.println("Digite a raça: ");
                String racaBuscada = sc.nextLine();

                for (Pet pet: petsFiltrados) {
                    if (pet.getRaca().equalsIgnoreCase(racaBuscada)) {
                        System.out.println("Nome: " + pet.getName() + "\nPet: " + pet.getPet() + "\nSexo: " + pet.getSexo() + "\nIdade: " + pet.getIdade());
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pet não encontrado!");
                }
                break;
            case "6":
                encontrou = false;
                System.out.println("Digite o endereço: ");
                String enderecoBuscado = sc.nextLine();

                for (Pet pet: petsFiltrados) {
                    String endereco = pet.getRua() + " " + pet.getNumero() + " " + pet.getCidade();
                    if (endereco.toLowerCase().contains(enderecoBuscado.toLowerCase())) {
                        System.out.println("Nome: " + pet.getName() + "\nPet: " + pet.getPet() + "\nSexo: " + pet.getSexo() + "\nIdade: " + pet.getIdade());
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pet não encontrado!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }
}
