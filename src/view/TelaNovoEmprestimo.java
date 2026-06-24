package view;

import model.Emprestimo;
import model.Livro;
import model.RepositorioEmprestimos;
import model.RepositorioLivros;
import model.RepositorioUsuarios;
import model.Usuario;
import util.Navegador;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaNovoEmprestimo extends JPanel {

    private JTextField campoCpfUsuario;
    private JTextField campoNomeUsuario;
    private JTextField campoIsbn;
    private JTextField campoNomeLivro;
    private JTextField campoDataEmprestimo;

    public TelaNovoEmprestimo() {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        configurarJanela();

        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                limparFormulario();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }

    private void configurarJanela() {

        setLayout(new BorderLayout());

        add(criarMenuLateral(), BorderLayout.WEST);
        add(criarPainelPrincipal(), BorderLayout.CENTER);
    }

    private JPanel criarMenuLateral() {

        JPanel menu = new JPanel();

        menu.setPreferredSize(new Dimension(220, 0));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBackground(new Color(243, 243, 248));
        menu.add(Box.createVerticalStrut(20));

        JButton btnInicio =
                criarBotaoMenu("\uD83C\uDFE0 Início", false);
        btnInicio.addActionListener(e ->
                Navegador.mostrar("INICIO"));
        menu.add(btnInicio);

        JButton btnPesquisar =
                criarBotaoMenu("\uD83D\uDD0D Pesquisar", false);
        btnPesquisar.addActionListener(e ->
                Navegador.mostrar("PESQUISAR"));
        menu.add(btnPesquisar);

        JButton btnCatalogos =
                criarBotaoMenu("\uD83D\uDCDA Catálogo", false);
        btnCatalogos.addActionListener(e ->
                Navegador.mostrar("CATALOGOS"));
        menu.add(btnCatalogos);

        menu.add(Box.createVerticalStrut(20));

        JButton btnLivros =
                criarBotaoMenu("\uD83D\uDD6E Livros", false);
        btnLivros.addActionListener(e ->
                Navegador.mostrar("LIVROS"));
        menu.add(btnLivros);

        JButton btnUsuarios =
                criarBotaoMenu("\uD83C\uDF93 Usuários", false);
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

    private JButton criarBotaoMenu(
            String texto,
            boolean selecionado) {

        JButton botao = new JButton(texto);

        botao.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 50));
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setFont(new Font("Segoe UI", Font.PLAIN, 24));

        if (selecionado) {
            botao.setBackground(new Color(220, 240, 255));
        } else {
            botao.setBackground(new Color(243, 243, 248));
        }

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(220, 240, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!selecionado) {
                    botao.setBackground(new Color(243, 243, 248));
                }
            }
        });

        return botao;
    }

    private JPanel criarPainelPrincipal() {

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(245, 247, 250));

        JLabel titulo = new JLabel(
                "Novo Empréstimo",
                SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel conteudo = new JPanel();
        conteudo.setOpaque(false);
        conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
        conteudo.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        conteudo.add(criarPainelUsuario());
        conteudo.add(Box.createVerticalStrut(25));
        conteudo.add(criarPainelLivro());
        conteudo.add(Box.createVerticalStrut(25));
        conteudo.add(criarPainelData());
        conteudo.add(Box.createVerticalStrut(30));
        conteudo.add(criarPainelBotoes());

        painelPrincipal.add(conteudo, BorderLayout.CENTER);

        return painelPrincipal;
    }

    private JPanel criarPainelUsuario() {

        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        painel.setBackground(new Color(243, 243, 248));
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                "Usuário",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 16)));

        JLabel labelCpf = new JLabel("CPF do usuário");
        labelCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        campoCpfUsuario = new JTextField(15);
        campoCpfUsuario.setBackground(Color.WHITE);
        campoCpfUsuario.setBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1));
        campoCpfUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                buscarUsuarioPorCpf();
            }
        });

        JLabel labelNome = new JLabel("Nome do Usuário: ");
        labelNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        campoNomeUsuario = criarCampoSomenteLeitura(20);

        painel.add(labelCpf);
        painel.add(campoCpfUsuario);
        painel.add(labelNome);
        painel.add(campoNomeUsuario);

        return painel;
    }

    private JPanel criarPainelLivro() {

        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        painel.setBackground(new Color(243, 243, 248));
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                "Livro",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 16)));

        JLabel labelIsbn = new JLabel("ISBN");
        labelIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        campoIsbn = new JTextField(15);
        campoIsbn.setBackground(Color.WHITE);
        campoIsbn.setBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1));
        campoIsbn.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                buscarLivroPorIsbn();
            }
        });

        JLabel labelNomeLivro = new JLabel("Nome do Livro: ");
        labelNomeLivro.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        campoNomeLivro = criarCampoSomenteLeitura(25);

        painel.add(labelIsbn);
        painel.add(campoIsbn);
        painel.add(labelNomeLivro);
        painel.add(campoNomeLivro);

        return painel;
    }

    private JTextField criarCampoSomenteLeitura(int colunas) {

        JTextField campo = new JTextField(colunas);
        campo.setEditable(false);
        campo.setFocusable(false);
        campo.setBackground(Color.LIGHT_GRAY);
        campo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        return campo;
    }

    private JPanel criarPainelData() {

        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.setOpaque(false);
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                "Dados do Empréstimo",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 16)));

        JLabel labelData = new JLabel("Data do empréstimo:");
        labelData.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        campoDataEmprestimo = new JTextField(
                LocalDate.now().format(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        campoDataEmprestimo.setPreferredSize(new Dimension(150, 24));
        campoDataEmprestimo.setBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1));

        painel.add(labelData);
        painel.add(campoDataEmprestimo);

        return painel;
    }

    private JPanel criarPainelBotoes() {

        JPanel painel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 40, 10));
        painel.setOpaque(false);

        JButton btnRegistrar =
                criarBotaoPrincipal("Registrar Empréstimo");
        btnRegistrar.addActionListener(e ->
                registrarEmprestimo());

        JButton btnVoltar =
                criarBotaoPrincipal("Voltar");
        btnVoltar.addActionListener(e ->
                Navegador.mostrar("EMPRESTIMOS"));

        painel.add(btnRegistrar);
        painel.add(btnVoltar);

        return painel;
    }

    private JButton criarBotaoPrincipal(String texto) {

        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(220, 55));
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.setBackground(new Color(243, 243, 248));
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(220, 240, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(243, 243, 248));
            }
        });

        return botao;
    }

    private void buscarUsuarioPorCpf() {

        String cpf = campoCpfUsuario.getText().trim();

        if (cpf.isEmpty()) {
            campoNomeUsuario.setText("");
            return;
        }

        Usuario usuarioEncontrado = null;

        for (Usuario usuario : RepositorioUsuarios.listar()) {

            if (usuario.getCpf().equals(cpf)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            campoNomeUsuario.setText(usuarioEncontrado.getNome());
        } else {
            campoNomeUsuario.setText("");
        }
    }

    private void buscarLivroPorIsbn() {

        String isbn = campoIsbn.getText().trim();

        if (isbn.isEmpty()) {
            campoNomeLivro.setText("");
            return;
        }

        Livro livro = RepositorioLivros.buscarPorId(isbn);

        if (livro != null) {
            campoNomeLivro.setText(livro.getTitulo());
        } else {
            campoNomeLivro.setText("");
        }
    }

    private void limparFormulario() {

        campoCpfUsuario.setText("");
        campoNomeUsuario.setText("");
        campoIsbn.setText("");
        campoNomeLivro.setText("");
        campoDataEmprestimo.setText(
                LocalDate.now().format(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private void registrarEmprestimo() {

        if (RepositorioUsuarios.listar().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cadastre ao menos um usuário antes de realizar empréstimos.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        if (RepositorioLivros.listar().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cadastre ao menos um livro antes de realizar empréstimos.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        buscarUsuarioPorCpf();
        buscarLivroPorIsbn();

        String cpf = campoCpfUsuario.getText().trim();
        String isbn = campoIsbn.getText().trim();

        if (cpf.isEmpty() || isbn.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe o CPF do usuário e o ISBN do livro.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        Usuario usuario = null;

        for (Usuario item : RepositorioUsuarios.listar()) {

            if (item.getCpf().equals(cpf)) {
                usuario = item;
                break;
            }
        }

        Livro livro = RepositorioLivros.buscarPorId(isbn);

        if (usuario == null || livro == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuário ou livro não encontrado.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (livro.getQuantidade() <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Este livro não possui exemplares disponíveis.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        String dataEmprestimo = campoDataEmprestimo.getText().trim();

        if (dataEmprestimo.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe a data do empréstimo.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        RepositorioEmprestimos.adicionar(
                new Emprestimo(
                        usuario,
                        livro,
                        dataEmprestimo));

        livro.setQuantidade(livro.getQuantidade() - 1);

        JOptionPane.showMessageDialog(
                this,
                "Empréstimo registrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);

        limparFormulario();
    }
}
