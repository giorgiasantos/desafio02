public class Vendedor extends Pessoa {

    //ATRIBUTOS
    Pessoa pessoa;

    //CONSTRUCTOR
    public Vendedor(String nome, String cpf, String email, String tipoPessoa, Pessoa pessoa) {
        super(nome, cpf, email, tipoPessoa);
        this.pessoa = pessoa;
    }

    public Vendedor() {
    }

}
