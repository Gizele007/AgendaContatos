import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendaSwing extends JFrame {
    private ArrayList<Contato> contatos = new ArrayList<>();
    private JTable tabelaContatos;
    private DefaultTableModel tabelaModelo;

    public AgendaSwing() {
        setTitle("Agenda de Contatos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        
        getContentPane().setBackground(new Color(135, 206, 235));

        
        tabelaModelo = new DefaultTableModel(new String[]{"Nome", "Telefone", "Email"}, 0);
        tabelaContatos = new JTable(tabelaModelo);
        add(new JScrollPane(tabelaContatos), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(135, 206, 235));

        JButton addButton = criarBotao("Adicionar Contato");
        JButton removeButton = criarBotao("Remover Contato");
        JButton searchButton = criarBotao("Buscar Contato");
        JButton listButton = criarBotao("Listar Contatos");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(listButton);
        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerContato();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarContato();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarContatos();
            }
        });
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setBackground(new Color(240, 248, 255));
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        return botao;
    }

    private void adicionarContato() {
        String nome = JOptionPane.showInputDialog("Nome:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        String email = JOptionPane.showInputDialog("Email:");
        if (nome != null && telefone != null && email != null) {
            contatos.add(new Contato(nome, telefone, email));
            JOptionPane.showMessageDialog(this, "Contato adicionado!");
        }
    }

    private void listarContatos() {
        tabelaModelo.setRowCount(0);
        for (Contato contato : contatos) {
            tabelaModelo.addRow(new Object[]{contato.getNome(), contato.getTelefone(), contato.getEmail()});
        }
    }

    private void removerContato() {
        String nome = JOptionPane.showInputDialog("Nome do contato a remover:");
        if (nome != null) {
            boolean encontrado = contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
            if (encontrado) {
                JOptionPane.showMessageDialog(this, "Contato removido!");
                listarContatos(); 
            } else {
                JOptionPane.showMessageDialog(this, "Contato não encontrado.");
            }
        }
    }

    private void buscarContato() {
        String nome = JOptionPane.showInputDialog("Nome do contato a buscar:");
        if (nome != null) {
            tabelaModelo.setRowCount(0);
            for (Contato contato : contatos) {
                if (contato.getNome().equalsIgnoreCase(nome)) {
                    tabelaModelo.addRow(new Object[]{contato.getNome(), contato.getTelefone(), contato.getEmail()});
                }
            }
            if (tabelaModelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Contato não encontrado.");
            }
        }
    }
}
