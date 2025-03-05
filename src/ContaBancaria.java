import java.util.ArrayList;
import java.util.List;


public abstract class ContaBancaria implements ServicosBancarios {

    private int numeroDaConta;
    private String titular;
    private double saldo;
    private List<String> historico = new ArrayList<>();

    public ContaBancaria(int numeroDaConta, String titular, double saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor){
        if (valor > 0) {
            saldo += valor;
            historico.add("Depósito: +R$" + valor);
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso");
        }
        else {
            System.out.println("Valor inválido para depósito");
        }
    }

    public void sacar(double valor){
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + "realizado com sucesso");
        }
        else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void exibirHistorico() { // Nome correto
        historico.forEach(System.out::println);
    }

    public void exibirSaldo(){
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
