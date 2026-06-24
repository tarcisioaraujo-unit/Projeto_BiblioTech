package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioEmprestimos {

    private static final List<Emprestimo> emprestimos =
            new ArrayList<>();

    public static void adicionar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public static List<Emprestimo> listar() {
        return Collections.unmodifiableList(emprestimos);
    }
}
