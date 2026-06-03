package aula_06.parte_final.ex_2.parte_2_1;

public class Contato {

    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }

    // Serializa o contato em uma linha para gravar no arquivo
    public String paraLinha() {
        return nome + ";" + telefone + ";" + email;
    }
}
