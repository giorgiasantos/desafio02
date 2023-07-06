
public class Cliente extends Pessoa{

    //ATRIBUTOS
    Pessoa pessoa;

    //CONSTRUCTOR
    public Cliente(String nome, String cpf, String email, String tipoPessoa, Pessoa pessoa) {
        super(nome, cpf, email, tipoPessoa);
        this.pessoa = pessoa;
    }

    public Cliente() {
    }


}
