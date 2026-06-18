package view;
import util.Navegador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TelaCadastroAlunos extends JPanel {

    public TelaCadastroAlunos() {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }

        configurarPainel();
    }


    // CONFIGURAÇÃO DA JANELA
    private void configurarPainel() {



        setLayout(new BorderLayout());

        add(criarMenuLateral(), BorderLayout.WEST);

        add(criarPainelCadastro(), BorderLayout.CENTER);
    }


    // MENU LATERAL
    private JPanel criarMenuLateral() {

        JPanel menu = new JPanel();

        menu.setPreferredSize(new Dimension(220, 0));

        menu.setLayout(new BoxLayout(
                menu,
                BoxLayout.Y_AXIS));

        menu.setBackground(new Color(243, 243, 248));

        menu.add(Box.createVerticalStrut(20));

        //menu.add(criarBotaoMenu("🏠 Início", true));
        JButton btnInicio =
                criarBotaoMenu(
                        "\uD83C\uDFE0 Início",
                        false);
        Box.createVerticalStrut(15);

        btnInicio.addActionListener(e ->
                Navegador.mostrar("INICIO"));
        menu.add(btnInicio);

        //menu.add(criarBotaoMenu("🔎 Pesquisar", false));
        JButton btnPesquisar =
                criarBotaoMenu(
                        "\uD83D\uDD0D Pesquisar",
                        false);
        Box.createVerticalStrut(15);

        btnPesquisar.addActionListener(e ->
                Navegador.mostrar("PESQUISAR"));

        menu.add(btnPesquisar);

        //menu.add(criarBotaoMenu("📖 Catálogo", false));
        JButton btnCatalogos =
                criarBotaoMenu("\uD83D\uDCDA Catálogo", false);
        Box.createVerticalStrut(15);

        btnCatalogos.addActionListener(e ->
                Navegador.mostrar("CATALOGOS"));

        menu.add(btnCatalogos);

        menu.add(Box.createVerticalStrut(20));

        //menu.add(criarBotaoMenu("📚 Livros", false));
        JButton btnLivros =
                criarBotaoMenu("\uD83D\uDD6E Livros", false);
        Box.createVerticalStrut(15);

        btnLivros.addActionListener(e ->
                Navegador.mostrar("LIVROS"));

        menu.add(btnLivros);

        //menu.add(criarBotaoMenu("🎓 Usuários", false));
        JButton btnUsuarios =
                criarBotaoMenu("\uD83C\uDF93 Usuários", false);
        Box.createVerticalStrut(15);

        btnUsuarios.addActionListener(e ->
                Navegador.mostrar("ALUNOS"));

        menu.add(btnUsuarios);


        menu.add(criarBotaoMenu("\uD83D\uDCCA Relatórios", false));

        menu.add(Box.createVerticalGlue());

        menu.add(new JSeparator());

        menu.add(Box.createVerticalStrut(10));

        menu.add(criarBotaoMenu("Ajuda", false));

        menu.add(Box.createVerticalStrut(20));

        return menu;
    }


    // BOTÕES DO MENU
    private JButton criarBotaoMenu(String texto,
                                   boolean selecionado) {

        JButton botao = new JButton(texto);

        botao.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50));

        botao.setHorizontalAlignment(
                SwingConstants.LEFT);

        botao.setFocusPainted(false);

        botao.setBorderPainted(false);

        botao.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        24));

        if (selecionado) {

            botao.setBackground(
                    new Color(
                            220,
                            240,
                            255));

        } else {

            botao.setBackground(new Color(243, 243, 248));

        }

        botao.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt) {

                        botao.setBackground(
                                new Color(
                                        220,
                                        240,
                                        255));
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt) {

                        if (!selecionado) {

                            botao.setBackground(
                                    new Color(243, 243, 248));
                        }
                    }
                });

        return botao;
    }


    // PAINEL PRINCIPAL
    private JPanel criarPainelCadastro() {

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        painelPrincipal.setBackground(
                new Color(245, 247, 250));


        // TÍTULO
        JLabel titulo = new JLabel(
                "Cadastro de Usuários",
                SwingConstants.CENTER);

        titulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30));

        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        0,
                        25,
                        0));

        painelPrincipal.add(
                titulo,
                BorderLayout.NORTH);


        // CONTEÚDO CENTRAL
        JPanel conteudo = new JPanel();

        conteudo.setOpaque(false);

        conteudo.setLayout(
                new BoxLayout(
                        conteudo,
                        BoxLayout.Y_AXIS));

        conteudo.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        40,
                        20,
                        40));

        conteudo.add(criarPainelInformacoes());
        conteudo.add(Box.createVerticalStrut(30));
        conteudo.add(criarPainelEndereco());
        conteudo.add(Box.createVerticalStrut(40));
        conteudo.add(criarPainelBotoes());

        painelPrincipal.add(
                conteudo,
                BorderLayout.CENTER);

        return painelPrincipal;
    }


    // INFORMAÇÕES DO USUÁRIO
    private JPanel criarPainelInformacoes() {

        JPanel painel = new JPanel(
                new GridLayout(
                        2,
                        5,
                        20,
                        10));

        painel.setBackground(new Color(243, 243, 248));

        painel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                Color.BLACK,
                                1),
                        "Informações do Usuário",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                16)));

        painel.add(criarCampo("ID"));
        painel.add(criarCampo("Nome"));
        painel.add(criarCampo("Telefone"));
        painel.add(criarCampo("E-mail"));
        painel.add(criarCampo("CPF"));

        return painel;
    }


    // ENDEREÇO
    private JPanel criarPainelEndereco() {

        JPanel painel = new JPanel(
                new GridLayout(
                        2,
                        4,
                        20,
                        10));

        painel.setBackground(new Color(243, 243, 248));

        painel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                Color.BLACK,
                                1),
                        "Endereço do Usuário",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                16)));

        painel.add(criarCampo("Rua"));
        painel.add(criarCampo("Complemento"));
        painel.add(criarCampo("CEP"));
        painel.add(criarCampo("Estado"));
        painel.add(criarCampo("Cidade"));
        painel.add(criarCampo("Número"));
        painel.add(criarCampo("Bairro"));

        painel.add(new JLabel());

        return painel;
    }


    // CAMPO DE TEXTO
    private JPanel criarCampo(String titulo) {

        JPanel painel = new JPanel();

        painel.setOpaque(false);

        painel.setLayout(
                new BoxLayout(
                        painel,
                        BoxLayout.Y_AXIS));

        JLabel label = new JLabel(titulo);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14));


        // ALINHA À ESQUERDA
        label.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        JTextField campo =
                new JTextField();

        campo.setPreferredSize(
                new Dimension(
                        200,
                        24));

        campo.setMinimumSize(
                new Dimension(
                        100,
                        24));

        campo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        24));

        campo.setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK,
                        1));


        // ALINHA À ESQUERDA
        campo.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        painel.add(label);
        painel.add(Box.createVerticalStrut(3));
        painel.add(campo);

        return painel;
    }


    // BOTÕES
    private JPanel criarPainelBotoes() {

        JPanel painel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        40,
                        10));

        painel.setOpaque(false);

        JButton btnCadastrar =
                criarBotaoPrincipal(
                        "Cadastrar");

        JButton btnLimpar =
                criarBotaoPrincipal(
                        "Limpar");

        painel.add(btnCadastrar);
        painel.add(btnLimpar);

        return painel;
    }


    // BOTÃO PRINCIPAL
    private JButton criarBotaoPrincipal(
            String texto) {

        JButton botao =
                new JButton(texto);

        botao.setPreferredSize(
                new Dimension(
                        220,
                        55));

        botao.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        botao.setBackground(new Color(243, 243, 248));

        botao.setForeground(Color.BLACK);

        botao.setFocusPainted(false);

        botao.setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK,
                        2));

        botao.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent evt) {

                        botao.setBackground(
                                new Color(
                                        220,
                                        240,
                                        255));
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent evt) {

                        botao.setBackground(
                                new Color(243, 243, 248));
                    }
                });

        return botao;
    }

}