package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import view.TelaPesquisar;
import view.TelaCatalogos;
import view.TelaLivros;
import view.TelaAlunos;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {

        configurarJanela();

    }

    private void configurarJanela() {

        setTitle("BiblioTech");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(criarMenuLateral(), BorderLayout.WEST);
        add(criarPainelCentral(), BorderLayout.CENTER);

    }

    private void abrirTela(JFrame novaTela) {

        novaTela.setSize(
                getSize());

        novaTela.setExtendedState(
                getExtendedState());

        novaTela.setLocation(
                getLocation());

        novaTela.setVisible(true);

        dispose();
    }

    //Menu Lateral
    private JPanel criarMenuLateral() {

        JPanel menu = new JPanel();

        menu.setPreferredSize(new Dimension(220, 0));

        menu.setLayout(new BoxLayout(
                menu,
                BoxLayout.Y_AXIS));

        menu.setBackground(Color.WHITE);

        menu.add(Box.createVerticalStrut(20));

        //menu.add(criarBotaoMenu("🏠 Início", true));
        JButton btnInicio =
                criarBotaoMenu(
                        "Início",
                        false);

        btnInicio.addActionListener(e ->
            abrirTela(new TelaPrincipal()));
        menu.add(btnInicio);

        //menu.add(criarBotaoMenu("🔎 Pesquisar", false));
        JButton btnPesquisar =
                criarBotaoMenu(
                        "Pesquisar",
                        false);

        btnPesquisar.addActionListener(e ->
            abrirTela(new TelaPesquisar()));

        menu.add(btnPesquisar);

        //menu.add(criarBotaoMenu("📖 Catálogo", false));
        JButton btnCatalogos =
                criarBotaoMenu("Catálogo", false);

        btnCatalogos.addActionListener(e ->
                abrirTela(new TelaCatalogos()));

        menu.add(btnCatalogos);

        menu.add(Box.createVerticalStrut(20));

        //menu.add(criarBotaoMenu("📚 Livros", false));
        JButton btnLivros =
                criarBotaoMenu("Livros", false);

        btnLivros.addActionListener(e ->
                abrirTela(new TelaLivros()));

        menu.add(btnLivros);

        //menu.add(criarBotaoMenu("🎓 Usuários", false));
        JButton btnUsuarios =
                criarBotaoMenu("Usuários", false);

        btnUsuarios.addActionListener(e ->
            abrirTela(new TelaAlunos()));

        menu.add(btnUsuarios);


        menu.add(criarBotaoMenu("Relatórios", false));

        menu.add(Box.createVerticalGlue());

        menu.add(new JSeparator());

        menu.add(Box.createVerticalStrut(10));

        menu.add(criarBotaoMenu("Ajuda", false));

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
                        18));

        if (selecionado) {

            botao.setBackground(
                    new Color(
                            220,
                            240,
                            255));

        } else {

            botao.setBackground(Color.WHITE);

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
                                    Color.WHITE);
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

                int largura = 700;
                int altura = 700;

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

        card.setBackground(Color.WHITE);

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