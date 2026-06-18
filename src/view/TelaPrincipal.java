package view;
import util.Navegador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaPrincipal extends JPanel {

    public TelaPrincipal() {

        configurarPainel();

    }

    private void configurarPainel() {

        setLayout(new BorderLayout());

        add(criarMenuLateral(), BorderLayout.WEST);
        add(criarPainelCentral(), BorderLayout.CENTER);

    }

    //Menu Lateral
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

        btnLivros.addActionListener(e ->
                Navegador.mostrar("LIVROS"));
        Box.createVerticalStrut(15);

        menu.add(btnLivros);

        //menu.add(criarBotaoMenu("🎓 Usuários", false));
        JButton btnUsuarios =
                criarBotaoMenu("\uD83C\uDF93 Usuários", false);

        btnUsuarios.addActionListener(e ->
                Navegador.mostrar("ALUNOS"));
        Box.createVerticalStrut(15);

        menu.add(btnUsuarios);


        menu.add(criarBotaoMenu("\uD83D\uDCCA Relatórios", false));

        menu.add(Box.createVerticalGlue());

        menu.add(new JSeparator());

        menu.add(Box.createVerticalStrut(10));

        menu.add(criarBotaoMenu("❓ Ajuda", false));

        menu.add(Box.createVerticalStrut(20));

        return menu;
    }

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

    private JPanel criarPainelCentral() {

        JPanel painel = new JPanel() {

            Image imagem =
                    new ImageIcon(
                            "imagens/logo_fundo.png")
                            .getImage();

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 =
                        (Graphics2D) g;

                g2.setComposite(
                        AlphaComposite.getInstance(
                                AlphaComposite.SRC_OVER,
                                0.08f));

                int largura = 360;
                int altura = 120;

                int x =
                        (getWidth() - largura) / 2;

                int y =
                        (getHeight() - altura) / 2;

                g2.drawImage(
                        imagem,
                        x,
                        y,
                        largura,
                        altura,
                        this);
            }
        };

        painel.setLayout(new BorderLayout());

        painel.setBackground(
                new Color(
                        245,
                        247,
                        250));

        painel.add(
                criarPainelBoasVindas(),
                BorderLayout.NORTH);

        return painel;
    }

    private JPanel criarPainelBoasVindas() {

        JPanel card = new JPanel(
                new BorderLayout());

        card.setBackground(new Color(243, 243, 248));

        card.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20));

        JPanel esquerda =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT));

        esquerda.setOpaque(false);

        //JLabel icone = new JLabel("🏠");

        //icone.setFont(new Font("Segoe UI Emoji",Font.PLAIN, 40));

        //esquerda.add(icone);

        JPanel textos = new JPanel();

        textos.setOpaque(false);

        textos.setLayout(
                new BoxLayout(
                        textos,
                        BoxLayout.Y_AXIS));

        //JLabel titulo =new JLabel("Bem vindo à BiblioTech");

        //titulo.setFont(new Font("Segoe UI", Font.BOLD,  30));

        //JLabel descricao = new JLabel( "Use o painel central para acessar conteúdos e gerenciar a biblioteca.");

        //descricao.setFont( new Font( "Segoe UI", Font.PLAIN,16));

        //textos.add(titulo);
        textos.add(Box.createVerticalStrut(5));
        //textos.add(descricao);

        esquerda.add(textos);

        card.add(
                esquerda,
                BorderLayout.WEST);

        JPanel container =
                new JPanel(
                        new BorderLayout());

        container.setBackground(
                new Color(
                        245,
                        247,
                        250));

        container.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20));

        container.add(card);

        return container;
    }
}