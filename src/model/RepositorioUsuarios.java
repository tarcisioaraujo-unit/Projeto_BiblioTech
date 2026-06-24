package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioUsuarios {

    private static final List<Usuario> usuarios =
            new ArrayList<>();

    public static void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> listar() {
        return Collections.unmodifiableList(usuarios);
    }
}
