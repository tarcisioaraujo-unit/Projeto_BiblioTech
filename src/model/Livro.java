package model;

public class Livro {

    private final String id;
    private final String titulo;
    private final String autor;
    private final String ano;
    private int quantidade;

    public Livro(
            String id,
            String titulo,
            String autor,
            String ano,
            int quantidade) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAno() {
        return ano;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
