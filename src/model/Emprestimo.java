package model;

public class Emprestimo {

    private final Usuario usuario;
    private final Livro livro;
    private final String dataEmprestimo;

    public Emprestimo(
            Usuario usuario,
            Livro livro,
            String dataEmprestimo) {

        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
}
