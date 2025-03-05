import java.util.Scanner;

public class ContaPoupanca extends ContaBancaria {
    private double taxaCDI;

    public ContaPoupanca(int numeroDaConta, String titular, double saldo, double taxaCDI) {
        super(numeroDaConta, titular, saldo);
        this.taxaCDI = taxaCDI;
    }

    public void simularEAplicar(Scanner scanner) {
        System.out.println("\nEscolha o valor para simular:");
        System.out.println("1. Usar saldo atual (" + formatarMoeda(getSaldo()) + ")");
        System.out.println("2. Definir valor manual");
        System.out.print("Opção: ");
        int escolha = scanner.nextInt();

        double valorSimulacao = escolha == 1 ? getSaldo() : solicitarValor(scanner);
        int meses = solicitarMeses(scanner);

        double rendimentoTotal = simularInvestimento(valorSimulacao, meses);

        System.out.print("\nDeseja aplicar este investimento? (S/N): ");
        String resposta = scanner.next().toUpperCase();

        if(resposta.equals("S")) {
            aplicarInvestimento(rendimentoTotal);
            System.out.println("→ Investimento aplicado com sucesso!");
            exibirSaldo();
        }
    }
    private double simularInvestimento(double valorInvestido, int meses) {
        System.out.println("\n=== PROJEÇÃO DO INVESTIMENTO ===");
        System.out.printf("%-20s: %s\n", "Valor inicial", formatarMoeda(valorInvestido));
        System.out.printf("%-20s: %.2f%%\n", "Taxa CDI mensal", taxaCDI);
        System.out.printf("%-20s: %d meses\n\n", "Período", meses);

        double saldoSimulado = valorInvestido;

        for(int i = 1; i <= meses; i++) {
            double rendimento = calcularRendimento(saldoSimulado);
            saldoSimulado += rendimento;

            System.out.printf("Mês %02d | Rendimento: %9s | Saldo: %s\n",
                    i,
                    formatarMoeda(rendimento),
                    formatarMoeda(saldoSimulado));
        }

        double rendimentoTotal = saldoSimulado - valorInvestido;
        System.out.println("\n" + "-".repeat(50));
        System.out.printf("%-20s: %s\n", "Valor investido", formatarMoeda(valorInvestido));
        System.out.printf("%-20s: %s\n", "Rendimento total", formatarMoeda(rendimentoTotal));
        System.out.printf("%-20s: %s\n", "Valor final", formatarMoeda(saldoSimulado));

        return rendimentoTotal;
    }

    private void aplicarInvestimento(double rendimento) {
        depositar(rendimento);
    }

    private double calcularRendimento(double saldo) {
        return Math.round(saldo * taxaCDI) / 100.0;
    }

    private String formatarMoeda(double valor) {
        String sinal = valor >= 0 ? "+" : "-";
        return sinal + String.format("R$%,.2f", Math.abs(valor)).replace(".", ",");
    }

    private double solicitarValor(Scanner scanner) {
        System.out.print("Digite o valor para simulação: R$");
        return scanner.nextDouble();
    }

    private int solicitarMeses(Scanner scanner) {
        System.out.print("Quantos meses para simular: ");
        return scanner.nextInt();
    }

    public void setTaxaCDI(double novaTaxa) {
        this.taxaCDI = novaTaxa;
    }
}
