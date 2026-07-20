import service.PetService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opc;
        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("|                     MENU                          |");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.println("-----------------------------------------------------");

            opc = sc.nextLine();

            switch (opc) {
                case "1":
                    PetService.cadastrar(sc);
                    break;
                case "2":
                    PetService.buscar(sc);
                    break;
            }

        } while (!opc.matches("[1-6]"));

        sc.close();
    }
}
