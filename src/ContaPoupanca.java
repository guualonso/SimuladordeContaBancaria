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
        System.out.printf("Rendimento CDI aplicado: R$%.2f%n", rendimento);
    }

    public void simularMeses(int meses) {
        double saldoSimulado = this.getSaldo();

        for (int i = 1; i <= meses; i++) {
            double rendimento = saldoSimulado * taxaCDI/100;
            rendimento = Math.round(rendimento * 100.0) / 100.0;
            saldoSimulado += rendimento;

            System.out.printf(
                    "Simulação %d meses: Rendimento R$%.2f | Saldo Projetado R$%.2f%n",
                    i,
                    rendimento,
                    saldoSimulado
            );
        }
    }

    public void simularRendimentoPersonalizado(double taxaPersonalizada, int meses) {
        double saldoSimulado = getSaldo();
        for (int i = 1; i <= meses; i++) {
            saldoSimulado+= saldoSimulado * (taxaPersonalizada/100);
            System.out.printf("Mês %d: R$%.2f%n", i, saldoSimulado);
        }
    }

    public void setTaxaCDI(double novaTaxa) {
        this.taxaCDI = novaTaxa;
    }
}
