package view;

import javax.swing.*;
import java.awt.*;

import view.TelaPesquisar;
import view.TelaCatalogos;
import view.TelaLivros;
import view.TelaAlunos;

public class TelaCatalogos extends JFrame {

    public TelaCatalogos() {

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

        setTitle("BiblioTech - Catálogos");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(criarMenuLateral(), BorderLayout.WEST);
        add(criarPainelCatalogos(), BorderLayout.CENTER);
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
                        18));

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
    private JPanel criarPainelCatalogos() {

        JPanel painel = new JPanel();

        painel.setLayout(
                new GridBagLayout());

        painel.setBackground(
                new Color(
                        245,
                        247,
                        250));

        JPanel grade =
                new JPanel(
                        new GridLayout(
                                5,
                                3,
                                200,
                                70));

        grade.setOpaque(false);

        grade.add(criarBotaoCatalogo("Ciências Exatas e da Terra"));
        grade.add(criarBotaoCatalogo("Computação e Tecnologia"));
        grade.add(criarBotaoCatalogo("Engenharias"));

        grade.add(criarBotaoCatalogo("Ciências Biológicas"));
        grade.add(criarBotaoCatalogo("Ciências da Saúde"));
        grade.add(criarBotaoCatalogo("Ciências Agrárias"));

        grade.add(criarBotaoCatalogo("Ciências Humanas"));
        grade.add(criarBotaoCatalogo("Ciências Sociais Aplicadas"));
        grade.add(criarBotaoCatalogo("Linguística, Letras e Artes"));

        grade.add(criarBotaoCatalogo("Educação"));
        grade.add(criarBotaoCatalogo("Pesquisa e Metodologia Científica"));
        grade.add(criarBotaoCatalogo("Obras de Referência"));

        grade.add(criarBotaoCatalogo("Trabalhos Acadêmicos"));
        grade.add(criarBotaoCatalogo("Periódicos"));
        grade.add(criarBotaoCatalogo("Acervo Digital"));

        painel.add(grade);

        return painel;
    }


    // BOTÕES CATÁLOGO
    private JButton criarBotaoCatalogo(String texto) {

        JButton botao = new JButton(
                "<html><center>" +
                        texto +
                        "</center></html>");

        botao.setPreferredSize(
                new Dimension(
                        230,
                        90));

        botao.setBackground(new Color(243, 243, 248));

        botao.setForeground(Color.BLACK);

        botao.setOpaque(true);

        botao.setContentAreaFilled(true);

        botao.setFocusPainted(false);

        botao.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15));

        botao.setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK,
                        4));

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