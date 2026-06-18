package view;
import util.Navegador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaLogin extends JPanel {

    private JTextField txtId;
    private JPasswordField txtSenha;

    private JButton btnEntrar;
    private JButton btnLimpar;

    public TelaLogin() {

        criarTela();

    }


    private void criarTela() {

        JPanel painelPrincipal = new JPanel();

        painelPrincipal.setLayout(
                new BoxLayout(
                        painelPrincipal,
                        BoxLayout.Y_AXIS));

        painelPrincipal.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20));

        painelPrincipal.setBackground(new Color(243, 243, 248));


        // LOGO

        JLabel lblLogo;

        try {

            ImageIcon icon =
                    new ImageIcon(
                            "imagens/logo.png");

            Image img =
                    icon.getImage()
                            .getScaledInstance(
                                    360,
                                    120,
                                    Image.SCALE_SMOOTH);

            lblLogo =
                    new JLabel(
                            new ImageIcon(img));

        }
        catch (Exception e) {

            lblLogo =
                    new JLabel("LOGO");

        }

        lblLogo.setAlignmentX(
                Component.CENTER_ALIGNMENT);


        // TÍTULO

        JLabel lblTitulo =
                new JLabel("BiblioTech");

        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24));

        lblTitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT);


        // FORMULÁRIO

        JPanel painelFormulario =
                new JPanel(
                        new GridBagLayout());

        painelFormulario.setBackground(
                new Color(243, 243, 248));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        10,
                        5,
                        10,
                        5);

        gbc.anchor =
                GridBagConstraints.WEST;


        // ID

        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblId =
                new JLabel("ID:");

        lblId.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        painelFormulario.add(
                lblId,
                gbc);

        gbc.gridx = 1;

        txtId =
                new JTextField();

        txtId.setPreferredSize(
                new Dimension(
                        220,
                        30));

        painelFormulario.add(
                txtId,
                gbc);


        // SENHA


        gbc.gridx = 0;
        gbc.gridy = 1;

        JLabel lblSenha =
                new JLabel("Senha:");

        lblSenha.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        painelFormulario.add(
                lblSenha,
                gbc);

        gbc.gridx = 1;

        txtSenha =
                new JPasswordField();

        txtSenha.setPreferredSize(
                new Dimension(
                        220,
                        30));

        painelFormulario.add(
                txtSenha,
                gbc);


        // BOTÕES


        JPanel painelBotoes =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                15,
                                0));

        painelBotoes.setBackground(
                new Color(243, 243, 248));

        btnEntrar =
                new JButton("Entrar");

        btnEntrar.setPreferredSize(
                new Dimension(
                        120,
                        35));

        btnEntrar.setBackground(
                new Color(
                        25,
                        90,
                        255));

        btnEntrar.setForeground(
                new Color(243, 243, 248));

        btnEntrar.setFocusPainted(
                false);


        // EVENTO ENTRAR

        btnEntrar.addActionListener(
                e -> realizarLogin());


        // BOTÃO LIMPAR
        btnLimpar =
                new JButton("Limpar");

        btnLimpar.setPreferredSize(
                new Dimension(
                        120,
                        35));

        btnLimpar.setFocusPainted(
                false);

        btnLimpar.addActionListener(
                e -> {

                    txtId.setText("");

                    txtSenha.setText("");

                    txtId.requestFocus();

                });


        // ENTER NA SENHA


        txtSenha.addActionListener(
                e -> realizarLogin());

        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnLimpar);


        // MONTA TELA

        painelPrincipal.add(lblLogo);

        painelPrincipal.add(
                Box.createVerticalStrut(10));

        painelPrincipal.add(lblTitulo);

        painelPrincipal.add(
                Box.createVerticalStrut(25));

        painelPrincipal.add(
                painelFormulario);

        painelPrincipal.add(
                Box.createVerticalStrut(25));

        painelPrincipal.add(
                painelBotoes);

// CENTRALIZA NA TELA

        setBackground(
                new Color(
                        243,
                        243,
                        248));

        setLayout(
                new GridBagLayout());

        GridBagConstraints gbcCentral =
                new GridBagConstraints();

        gbcCentral.gridx = 0;
        gbcCentral.gridy = 0;

        add(
                painelPrincipal,
                gbcCentral);

    }

    // LOGIN

    private void realizarLogin() {

        String id =
                txtId.getText().trim();

        String senha =
                String.valueOf(
                        txtSenha.getPassword());

        if (id.equals("admin")
                && senha.equals("123")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login realizado com sucesso!");

            Navegador.mostrar("INICIO");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "ID ou senha inválidos!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

            txtSenha.setText("");

            txtSenha.requestFocus();

        }
    }

}