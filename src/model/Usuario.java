package model;

public class Usuario {

    private final String id;
    private final String nome;
    private final String telefone;
    private final String email;
    private final String cpf;

    public Usuario(
            String id,
            String nome,
            String telefone,
            String email,
            String cpf) {

        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
