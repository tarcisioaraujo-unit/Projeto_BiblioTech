package view;

import util.Navegador;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelCentral;

    public JanelaPrincipal() {


        // CONFIGURAÇÃO DA JANELA

        setTitle("BiblioTech");

        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // CARDLAYOUT

        cardLayout = new CardLayout();

        painelCentral = new JPanel(cardLayout);


        // CONFIGURA NAVEGADOR

        Navegador.configurar(
                cardLayout,
                painelCentral);


        // ADICIONA AS TELAS

        painelCentral.add(
                new TelaLogin(),
                "LOGIN");

        painelCentral.add(
                new TelaPrincipal(),
                "INICIO");

        painelCentral.add(
                new TelaPesquisar(),
                "PESQUISAR");

        painelCentral.add(
                new TelaCatalogos(),
                "CATALOGOS");

        painelCentral.add(
                new TelaAlunos(),
                "ALUNOS");

        painelCentral.add(
                new TelaCadastroAlunos(),
                "CADASTRO_ALUNOS");

        painelCentral.add(
                new TelaAlunosCadastrados(),
                "ALUNOS_CADASTRADOS");

        painelCentral.add(
                new TelaLivros(),
                "LIVROS");

        painelCentral.add(
                new TelaCadastroLivros(),
                "CADASTRO_LIVROS");

        painelCentral.add(
                new TelaEmprestimos(),
                "EMPRESTIMOS");

        painelCentral.add(
                new TelaNovoEmprestimo(),
                "NOVO_EMPRESTIMO");


        // ADICIONA AO FRAME

        add(painelCentral);

        // TELA INICIAL


        cardLayout.show(
                painelCentral,
                "LOGIN");


        // EXIBE A JANELA

        setVisible(true);
    }
}