package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioLivros {

    private static final List<Livro> livros =
            new ArrayList<>();

    public static void adicionar(Livro livro) {
        livros.add(livro);
    }

    public static List<Livro> listar() {
        return Collections.unmodifiableList(livros);
    }

    public static Livro buscarPorId(String id) {

        for (Livro livro : livros) {

            if (livro.getId().equals(id)) {
                return livro;
            }
        }

        return null;
    }
}
