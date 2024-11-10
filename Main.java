import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o modo:");
        System.out.println("1 - Console");
        System.out.println("2 - Interface Grafica");
        int escolha = scanner.nextInt();

        if (escolha == 1) {
            AgendaConsole agendaConsole = new AgendaConsole();
            agendaConsole.iniciar();
        } else if (escolha == 2) {
            SwingUtilities.invokeLater(() -> {
                AgendaSwing agendaSwing = new AgendaSwing();
                agendaSwing.setVisible(true);
            });
        } else {
            System.out.println("Opcao invalida.");
        }
    }
}
