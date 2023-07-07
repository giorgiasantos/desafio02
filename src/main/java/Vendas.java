import java.time.LocalDate;
public class Vendas {

    //ATRIBUTOS
    private String item;
    private double preço;
    private String cpfCliente;
    private String emailVendedor;
    private LocalDate data;

    //CONSTRUCTOR
    public Vendas(String item, double preço, String cpfCliente, String emailVendedor, LocalDate data) {
        this.item = item;
        this.preço = preço;
        this.cpfCliente = cpfCliente;
        this.emailVendedor = emailVendedor;
        this.data = data;
    }

    public Vendas() {
    }

    //GETTERS E SETTERS

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }


    @Override
    public String toString() {
        return ">>>VENDA<<<\n" + "ITEM -> " + item + " | PREÇO = R$" + preço + "\nCPF DO CLIENTE: " + cpfCliente + "\nEMAIL DO VENDEDOR: " + emailVendedor + "\nDATA DA COMPRA: " + data;
    }
}
