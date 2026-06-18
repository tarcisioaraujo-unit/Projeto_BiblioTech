package view;

import javax.swing.*;
import java.awt.*;

import util.Navegador;
import view.TelaPesquisar;
import view.TelaCatalogos;
import view.TelaLivros;
import view.TelaAlunos;

public class TelaPesquisar extends JPanel {

    private JTextField txtPesquisa;

    public TelaPesquisar() {

        configurarPainel();

    }

    private void configurarPainel() {

        //setTitle("BiblioTech - Pesquisar");
        //setSize(1400, 800);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(criarMenuLateral(), BorderLayout.WEST);
        add(criarPainelCentral(), BorderLayout.CENTER);
    }


    // MENU LATERAL
    private JPanel criarMenuLateral() {

        JPanel menu = new JPanel();

        menu.setPreferredSize(new Dimension(220, 0));

        menu.setLayout(new BoxLayout(  menu,   BoxLayout.Y_AXIS));

        menu.setBackground(new Color(243, 243, 248));

        menu.add(Box.createVerticalStrut(20));

        //menu.add(criarBotaoMenu("🏠 Início", true));
        JButton btnInicio =   criarBotaoMenu(  "\uD83C\uDFE0 Início",false);
        Box.createVerticalStrut(15);

        btnInicio.addActionListener(e ->
                Navegador.mostrar("INICIO"));
        menu.add(btnInicio);

        //menu.add(criarBotaoMenu("🔎 Pesquisar", false));
        JButton btnPesquisar =   criarBotaoMenu(   "\uD83D\uDD0D Pesquisar",  false);
        Box.createVerticalStrut(15);

        btnPesquisar.addActionListener(e ->
                Navegador.mostrar("PESQUISAR"));

        menu.add(btnPesquisar);

        //menu.add(criarBotaoMenu("📖 Catálogo", false));
        JButton btnCatalogos =                criarBotaoMenu("\uD83D\uDCDA Catálogo", false);
        Box.createVerticalStrut(15);

        btnCatalogos.addActionListener(e ->
                Navegador.mostrar("CATALOGOS"));

        menu.add(btnCatalogos);

        menu.add(Box.createVerticalStrut(20));

        //menu.add(criarBotaoMenu("📚 Livros", false));
        JButton btnLivros =   criarBotaoMenu("\uD83D\uDD6E Livros", false);
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
    private JPanel criarPainelCentral() {

        JPanel painel =
                new JPanel(
                        new BorderLayout());

        painel.setBackground(
                new Color(
                        245,
                        247,
                        250));

        painel.add(
                criarBarraPesquisa(),
                BorderLayout.NORTH);

        painel.add(
                criarPainelLogo(),
                BorderLayout.CENTER);

        return painel;
    }


    // TOPO COM PESQUISA
    private JPanel criarBarraPesquisa() {

        JPanel topo =
                new JPanel(
                        new GridBagLayout()) {

                    @Override
                    protected void paintComponent(
                            Graphics g) {

                        super.paintComponent(g);

                        Graphics2D g2 =
                                (Graphics2D) g;

                        GradientPaint gradient =
                                new GradientPaint(
                                        0,
                                        0,
                                        new Color(
                                                53,
                                                50,
                                                130),

                                        getWidth(),
                                        0,

                                        new Color(
                                                8,
                                                33,
                                                83));

                        g2.setPaint(gradient);

                        g2.fillRect(
                                0,
                                0,
                                getWidth(),
                                getHeight());
                    }
                };

        topo.setPreferredSize(
                new Dimension(
                        0,
                        140));


        // CAIXA DE PESQUISA ARREDONDADA
        JPanel caixaPesquisa =
                new JPanel(
                        new BorderLayout()) {

                    @Override
                    protected void paintComponent(
                            Graphics g) {

                        Graphics2D g2 =
                                (Graphics2D) g.create();

                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

                        // Fundo branco

                        g2.setColor(new Color(243, 243, 248));

                        g2.fillRoundRect(
                                0,
                                0,
                                getWidth() - 1,
                                getHeight() - 1,
                                20,
                                20);

                        // Borda

                        g2.setColor(
                                new Color(
                                        220,
                                        220,
                                        220));

                        g2.drawRoundRect(
                                0,
                                0,
                                getWidth() - 1,
                                getHeight() - 1,
                                20,
                                20);

                        g2.dispose();

                        super.paintComponent(g);
                    }
                };

        caixaPesquisa.setOpaque(false);

        caixaPesquisa.setPreferredSize(
                new Dimension(
                        500,
                        36));

        caixaPesquisa.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        15,
                        0,
                        15));


        // CAMPO DE TEXTO
        txtPesquisa =
                new JTextField();

        txtPesquisa.setBorder(null);

        txtPesquisa.setOpaque(false);

        txtPesquisa.setBackground(
                new Color(243, 243, 248));

        txtPesquisa.setForeground(
                Color.GRAY);

        txtPesquisa.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14));

        txtPesquisa.setText(
                "Procure por ISBN, título, autor ou editora...");


        // LUPA
        JLabel lblPesquisa =
                new JLabel("🔍");

        lblPesquisa.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        16));

        lblPesquisa.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        5,
                        0,
                        5));


        // MONTA COMPONENTES
        caixaPesquisa.add(
                txtPesquisa,
                BorderLayout.CENTER);

        caixaPesquisa.add(
                lblPesquisa,
                BorderLayout.EAST);

        topo.add(caixaPesquisa);

        return topo;
    }


    // PAINEL DO LOGO
    private JPanel criarPainelLogo() {

        return new JPanel() {

            Image imagem =
                    new ImageIcon(
                            "imagens/logo_fundo.png")
                            .getImage();

            @Override
            protected void paintComponent(
                    Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 =
                        (Graphics2D) g;

                g2.setComposite(
                        AlphaComposite.getInstance(
                                AlphaComposite.SRC_OVER,
                                0.10f));

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
    }
}