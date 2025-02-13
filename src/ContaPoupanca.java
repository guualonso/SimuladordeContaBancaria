import java.text.DecimalFormat;

public class ContaPoupanca extends ContaBancaria {
    private double taxaCDI;

    public ContaPoupanca(int numeroDaConta, String titular, double saldo, double taxaCDI) {
        super(numeroDaConta, titular, saldo);
        this.taxaCDI = taxaCDI;
    }

    public void aplicarRendimentoCDI() {
        double rendimento = getSaldo() * taxaCDI/100;
        depositar(rendimento);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Rendimento CDI aplicado: R$" + df.format(rendimento));
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
