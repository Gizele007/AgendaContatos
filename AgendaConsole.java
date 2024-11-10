import java.util.ArrayList;
import java.util.Scanner;

public class AgendaConsole {
    private ArrayList<Contato> contatos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Remover contato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    listarContatos();
                    break;
                case 3:
                    removerContato();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }

    private void adicionarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        contatos.add(new Contato(nome, telefone, email));
        System.out.println("Contato adicionado!");
    }

    private void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato na agenda.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    private void removerContato() {
        System.out.print("Digite o nome do contato a remover: ");
        String nome = scanner.nextLine();
        contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
        System.out.println("Contato removido!");
    }
}

