
public class Pessoa {

    //ATRIBUTOS
    private String nome;
    private String cpf;
    private String email;
    private String tipoPessoa;

    //CONSTRUCTOR
    public Pessoa(String nome, String cpf, String email, String tipoPessoa) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipoPessoa = tipoPessoa;
    }
    public Pessoa() {
    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return ("NOME: " + nome.toUpperCase() + " | CPF: " + cpf + " | EMAIL: " +email.toUpperCase() + "\n");
    }
}
