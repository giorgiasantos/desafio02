import java.time.LocalDate;
import java.util.*;

public class Servico {

    //ATRIBUTOS
    Pessoa pessoa;
    Vendedor vendedor;
    Cliente cliente;
    String novoItem;
    private double novoPreco;
    private String clienteCpf;
    private String vendedorEmail;
    private List<Vendas> novaVenda = new ArrayList<>();
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private LocalDate dataAtual;

    //GETTERS E SETTERS
    public String getNovoItem() {
        return novoItem;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getVendedorEmail() {
        return vendedorEmail;
    }

    public void setVendedorEmail(String vendedorEmail) {
        this.vendedorEmail = vendedorEmail;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    //MÉTODOS

    public void cadastrarPessoa() {
        Scanner entrada = new Scanner(System.in);
        boolean deNovo = true;
        Cliente novoCliente = new Cliente();
        Vendedor novoVendedor = new Vendedor();


        do {
            try {
                System.out.println("DIGITE 'V' PARA CADASTRAR UM VENDEDOR OU 'C' PARA CADASTRAR UM CLIENTE: ");
                String opcaoPessoa = entrada.nextLine();

                if (opcaoPessoa.equalsIgnoreCase("V")) {

                    System.out.println("DIGITE O NOME: ");
                    String novoNome = entrada.nextLine();

                    System.out.println("DIGITE O CPF: ");
                    String novoCpf = entrada.nextLine();

                    System.out.println("DIGITE O E-MAIL: ");
                    String novoEmail = entrada.next();
                    verificaCadastro(novoEmail, novoCpf);

                    novoVendedor.setNome(novoNome);
                    novoVendedor.setCpf(novoCpf);
                    novoVendedor.setEmail(novoEmail);
                    novoVendedor.setTipoPessoa(opcaoPessoa);
                    listaPessoas.add(novoVendedor);
                    System.out.println("NOVO CADASTRADO FEITO COM SUCESSO.");
                    deNovo = false;
                } else if (opcaoPessoa.equalsIgnoreCase("C")) {

                    System.out.println("DIGITE O NOME: ");
                    String novoNome = entrada.nextLine();

                    System.out.println("DIGITE O CPF: ");
                    String novoCpf = entrada.nextLine();

                    System.out.println("DIGITE O E-MAIL: ");
                    String novoEmail = entrada.next();
                    verificaCadastro(novoEmail, novoCpf);

                    novoCliente.setNome(novoNome);
                    novoCliente.setCpf(novoCpf);
                    novoCliente.setEmail(novoEmail);
                    novoCliente.setTipoPessoa(opcaoPessoa);
                    listaPessoas.add(novoCliente);
                    System.out.println("NOVO CADASTRADO FEITO COM SUCESSO.");
                    deNovo = false;
                } else {
                    System.out.println("OPÇÃO INVÁLIDA.");
                }

            } catch (IllegalArgumentException exception) {
                entrada.nextLine();
                System.out.println(exception.getMessage());
            }
        } while (deNovo);
    }

    public void mostrarListaDePessoasCadastradas() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("DIGITE 'V' PARA EXIBIR A LISTA DE VENDEDORES OU  'C' PARA A DE CLIENTES: ");
        String opcaoLista = entrada.nextLine();

        if(opcaoLista.equalsIgnoreCase("V")){
            System.out.println(">>>LISTA DE VENDEDORES CADASTRADOS NO SISTEMA<<<");
            List<Pessoa> listaVendedores = new ArrayList<>();
            for(Pessoa vendedor : listaPessoas) {
                if(vendedor.getTipoPessoa().equalsIgnoreCase("V")){
                    listaVendedores.add(vendedor);
                }
            }
            for(Pessoa vendedor: listaVendedores) {
                System.out.println(vendedor);
            }
        }else if(opcaoLista.equalsIgnoreCase("C")){
            System.out.println(">>>LISTA DE CLIENTES CADASTRADOS NO SISTEMA<<<");
            List<Pessoa> listaClientes = new ArrayList<>();
            for(Pessoa cliente : listaPessoas) {
                if(cliente.getTipoPessoa().equalsIgnoreCase("C")){
                    listaClientes.add(cliente);
                }
            }
            for(Pessoa cliente: listaClientes) {
                System.out.println(cliente);
            }
        }else {
            System.out.println("OPÇÃO INVÁLIDA.");
        }
    }

    public static boolean verificaEmail (String email){
        String novoRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(novoRegex);
    }

    public void verificaCadastro (String email,String cpf){
        if (!verificaEmail(email)) {
            throw new IllegalArgumentException("O EMAIL INFORMADO É INVÁLIDO.");
        }
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getEmail().equalsIgnoreCase(email)) {
                throw new IllegalArgumentException("O EMAIL INFORMADO JÁ ESTÁ CADASTRADO NO SISTEMA.");
            }
            if (pessoa.getCpf().equalsIgnoreCase(cpf)) {
                throw new IllegalArgumentException("O CPF INFORMADO JÁ ESTÁ CADASTRADO NO SISTEMA.");
            }
        }
    }
    public void validarNovaVenda () {
        Scanner entrada = new Scanner(System.in);
        boolean deNovo = true;
        String validaVendedorEmail;
        String validaClienteCpf;

        do {
            try {
                System.out.println("INFORME O EMAIL DO VENDEDOR:");
                validaVendedorEmail = entrada.nextLine();
                System.out.println("INFORME O CPF DO CLIENTE:");
                validaClienteCpf = entrada.nextLine();

                if (verificaPessoa(validaVendedorEmail, validaClienteCpf)) {
                    System.out.println("CADASTROS VERIFICADOS COM SUCESSO!");
                    setClienteCpf(validaClienteCpf);
                    setVendedorEmail(validaVendedorEmail);
                    deNovo = false;
                }

            }catch(IllegalArgumentException exception){
                System.out.println("HOUVE UM ERRO AO ENCONTRAR UM DOS CADASTROS. TENTE NOVAMENTE.");
            }

        }while (deNovo);
    }
    public void fazerNovaCompra (Vendas venda){
        Scanner entrada = new Scanner(System.in);
        System.out.println("QUANTOS ITENS DESEJA COMPRAR?");
        int qtdeitens = entrada.nextInt();
        entrada.nextLine();
        LocalDate dataAtendimento = LocalDate.now();

        for (int i = 0; i < qtdeitens; i++) {
            System.out.println("INFORME O NOME DO ITEM PARA COMPRA: ");
            novoItem = entrada.nextLine();
            System.out.println("INFORME O VALOR DO ITEM: ");
            novoPreco = entrada.nextDouble();
            entrada.nextLine();
            venda = new Vendas(novoItem, novoPreco, getClienteCpf(), getVendedorEmail(), dataAtendimento);
            novaVenda.add(venda);
            setDataAtual(dataAtendimento);

            System.out.println("O ITEM " + getNovoItem().toUpperCase() + " FOI ADICIONADO COM SUCESSO.");
            System.out.println("--------------------------------------");
        }

    }
    public void buscarPorVendedor () {
        Scanner entrada = new Scanner(System.in);
        List<Vendas> vendasEncontradas = new ArrayList<>();
        boolean achou = false;
        System.out.println("DIGITE O EMAIL DO VENDEDOR: ");
        String vendedorEmail = entrada.nextLine();

        if(verificaEmail(vendedorEmail)) {
            for (Vendas venda : novaVenda) {
                if (venda.getEmailVendedor().equalsIgnoreCase(vendedorEmail)) {
                    vendasEncontradas.add(venda);
                    achou = true;
                }
            }
            if (achou) {
                System.out.println("VENDAS ENCONTRADAS.");
                for(Vendas vendasPorVendedor: vendasEncontradas) {
                    System.out.println(vendasPorVendedor);
                }
            } else if (!achou) {
                System.out.println("NÃO FORAM ENCONTRADAS VENDAS PARA ESTE EMAIL.");
            }
        }else {
            System.out.println("E-MAIL INVÁLIDO.");
        }
    }

    public void buscarPorCliente () {
        Scanner entrada = new Scanner(System.in);
        List<Vendas> comprasEncontradas = new ArrayList<>();
        boolean achou = false;

        System.out.println("DIGITE O CPF DO CLIENTE: ");
        String clienteCpf = entrada.nextLine();

        for (Vendas venda : novaVenda) {
            if (venda.getCpfCliente().equalsIgnoreCase(clienteCpf)) {
                comprasEncontradas.add(venda);
                achou = true;
            }
        }

        if (achou) {
            System.out.println("VENDAS ENCONTRADAS. ");
            for(Vendas vendasPorCliente: comprasEncontradas) {
                System.out.println(vendasPorCliente);
            }
        } else if (!achou) {
            System.out.println("NÃO FORAM ENCONTRADAS VENDAS PARA ESTE CPF.");
        }
    }
    public boolean verificaPessoa (String email, String cpf) {
        boolean achouVendedor = false;
        boolean achouCliente = false;

        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getEmail().equalsIgnoreCase(email) && pessoa.getTipoPessoa().equalsIgnoreCase("V")) {
                System.out.println("CADASTRO DO VENDEDOR ENCONTRADO COM SUCESSO.");
                achouVendedor = true;
            }

            if (pessoa.getCpf().equalsIgnoreCase(cpf) && pessoa.getTipoPessoa().equalsIgnoreCase("C")) {
                System.out.println("CADASTRO DO CLIENTE ENCONTRADO COM SUCESSO.");
                achouCliente= true;
            }
        }
        if(!achouVendedor) {
            throw new IllegalArgumentException("CADASTRO DO VENDEDOR NÃO ENCONTRADO.");
        }
        if(!achouCliente) {
            throw new IllegalArgumentException("CADASTRO DO CLIENTE NÃO ENCONTRADO.");
        }
        return achouVendedor;
    }
    public void listarTodasAsVendas () {
        System.out.println(">>>LISTA COMPLETA DE VENDAS CADASTRADAS NO SISTEMA<<<");
        for (int i = 0; i < novaVenda.size(); i++) {
            System.out.println(novaVenda.get(i));
        }
    }

    @Override
    public String toString() {
        return "Servico{" +
                "pessoa=" + pessoa +
                ", vendedor=" + vendedor +
                ", cliente=" + cliente +
                ", novoItem='" + novoItem + '\'' +
                ", novoPreco=" + novoPreco +
                ", clienteCpf=" + clienteCpf +
                ", vendedorEmail='" + vendedorEmail + '\'' +
                ", novaVenda=" + novaVenda +
                ", listaPessoas=" + listaPessoas +
                ", dataAtual=" + dataAtual +
                '}';
    }
}