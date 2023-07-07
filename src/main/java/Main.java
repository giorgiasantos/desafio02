import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Vendas novaVenda = new Vendas();
        Servico novoServico = new Servico();

        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("BEM-VINDE AO SEU SISTEMA DE GERENCIAMENTO DE VENDAS!");
        System.out.println("*********************************************************");

        while (true) {

            try {
                System.out.println();
                System.out.println("DIGITE A OPÇÃO DESEJADA PARA CONTINUAR: ");
                System.out.println("1) FAZER NOVO CADASTRO / 2) FAZER NOVA VENDA / 3) VER TODAS AS VENDAS / 4) VER TODOS OS CADASTROS / 5) BUSCAR VENDAS DE UM VENDEDOR / 6) BUSCAR COMPRAS DE UM CLIENTE / 7) SAIR: ");
                System.out.println();
                int opcaoMenu = entrada.nextInt();
                entrada.nextLine();

                switch (opcaoMenu) {
                    case 1:
                        novoServico.cadastrarPessoa();
                        break;
                    case 2:
                        novoServico.validarNovaVenda();
                        novoServico.fazerNovaCompra(novaVenda);
                        break;
                    case 3:
                        novoServico.listarTodasAsVendas();
                        break;
                    case 4:
                        novoServico.mostrarListaDePessoasCadastradas();
                        break;
                    case 5:
                        novoServico.buscarPorVendedor();
                        break;
                    case 6:
                        novoServico.buscarPorCliente();
                        break;
                    case 7:
                        System.out.println("TUDO BEM. ATÉ MAIS!");
                        System.out.println("FINALIZANDO SISTEMA.....");
                        return;
                    default:
                        System.out.println("OPÇÃO INVÁLIDA!");
                }
            }catch (InputMismatchException exception){
                System.out.println("OPÇÃO INVÁLIDA! ESCOLHA UM DOS NÚMEROS DO MENU PARA CONTINUAR.");
                entrada.nextLine();
            }
        }

    }
}
