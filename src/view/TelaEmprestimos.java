package view;
import util.Navegador;

import javax.swing.*;
import java.awt.*;

public class TelaEmprestimos extends JPanel {

    public TelaEmprestimos() {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (Exception e) {

            e.printStackTrace();
        }

        configurarJanela();
    }


    // CONFIGURAÇÃO DA JANELA
    private void configurarJanela() {



        setLayout(new BorderLayout());

        add(criarMenuLateral(), BorderLayout.WEST);
        add(criarPainelLivros(), BorderLayout.CENTER);
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


    // PAINEL CENTRAL
    private JPanel criarPainelLivros() {

        JPanel painel = new JPanel(
                new BorderLayout());

        painel.setBackground(
                new Color(
                        245,
                        247,
                        250));


        // PAINEL SUPERIOR DOS BOTÕES
        JPanel painelBotoes = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        40,
                        30));

        painelBotoes.setOpaque(false);

        JButton btnNovosEmprestimos =
                criarBotaoPrincipal(
                        "Novos Emprestimos");


        JButton btnListarEmprestimos =
                criarBotaoPrincipal(
                        "Listar Empréstimos");


        painelBotoes.add(btnNovosEmprestimos);
        painelBotoes.add(btnListarEmprestimos);

        painel.add(
                painelBotoes,
                BorderLayout.NORTH);

        return painel;
    }


    // BOTÕES PRINCIPAIS
    private JButton criarBotaoPrincipal(
            String texto) {

        JButton botao =
                new JButton(texto);

        botao.setPreferredSize(
                new Dimension(
                        220,
                        60));

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
                        3));

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