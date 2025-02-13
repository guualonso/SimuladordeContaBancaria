public class ContaPoupanca extends ContaBancaria {
    private double taxaCDI;

    public ContaPoupanca(int numeroDaConta, String titular, double saldo, double taxaCDI) {
        super(numeroDaConta, titular, saldo);
        this.taxaCDI = taxaCDI;
    }

    public void aplicarRendimentoCDI() {
        double rendimento = getSaldo() * taxaCDI/100;
        rendimento = Math.round(rendimento * 100.0) / 100.0;
        depositar(rendimento);
        System.out.println(String.format("Rendimento CDI aplicado: R$%.2f", rendimento));

    }

    public void simularMeses(int meses) {
        for (int i = 1; i <= meses; i++){
            aplicarRendimentoCDI();
            System.out.println("Saldo após " + i + " meses: R$ " + getSaldo());
        }
    }

    public void setTaxaCDI(double novaTaxa) {
        this.taxaCDI = novaTaxa;
    }
}
