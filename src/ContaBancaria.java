public class ContaBancaria {

    private int numeroDaConta;
    private String titular;
    private double saldo;

    public ContaBancaria(int numeroDaConta, String titular, double saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor){
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + "realizado com sucesso");
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
    public void exibirSaldo(){
        System.out.println("Saldo atual: R$" + saldo);
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
