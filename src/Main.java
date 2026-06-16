import javax.swing.SwingUtilities;
import view.TelaLogin;
import view.TelaPrincipal;
import view.TelaPesquisar;
import view.TelaCatalogos;
import view.TelaAlunos;
import view.TelaLivros;
import view.TelaCadastroAlunos;
import view.TelaCadastroLivros;
import view.TelaAlunosCadastrados;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaPesquisar().setVisible(true);
        });

    }

}