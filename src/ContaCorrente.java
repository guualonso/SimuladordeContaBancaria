public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(int numeroDaConta, String titular, double saldoInicial, double limiteChequeEspecial) {
        super(numeroDaConta, titular, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && (getSaldo() + limiteChequeEspecial >= valor)){
            double novoSaldo = getSaldo() - valor;
            if (novoSaldo < 0) {
                limiteChequeEspecial += novoSaldo;
                novoSaldo = 0;
            }
            System.out.println("Saque de R$ " + valor + "realizado com sucesso");
        }
        else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void exibirLimite() {
        System.out.println("Seu limite do cheque especial é de R$ " + limiteChequeEspecial);
    }

    public void cobrarTaxaManutencao(double taxa) {
        sacar(taxa);
        System.out.println("Taxa de manutenção cobrada: R$" + taxa);
    }
}
