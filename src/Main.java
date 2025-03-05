import java.util.Scanner;

public class Main {
    private static Banco banco = new Banco();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar Conta");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void criarConta() {
        System.out.println("\nTipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Limite do cheque especial: ");
            double limite = scanner.nextDouble();
            banco.adicionarConta(new ContaCorrente(numero, titular, saldo, limite));
        } else if (tipo == 2) {
            System.out.print("Taxa CDI (%): ");
            double taxa = scanner.nextDouble();
            banco.adicionarConta(new ContaPoupanca(numero, titular, saldo, taxa));
        }

        System.out.println("Conta criada com sucesso!");
    }

    private static void acessarConta() {
        System.out.print("\nNúmero da conta: ");
        int numero = scanner.nextInt();
        ContaBancaria conta = banco.buscarConta(numero);

        if (conta != null) {
            menuConta(conta);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void menuConta(ContaBancaria conta) {
        while (true) {
            System.out.println("\n=== MENU DA CONTA ===");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Ver Saldo");
            System.out.println("4. Histórico");
            System.out.println("5. Simular Rendimento (Poupança)");
            System.out.println("6. Voltar");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.print("Valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 3:
                    conta.exibirSaldo();
                    break;

                case 4:
                    conta.exibirHistorico();
                    break;

                case 5:
                    if (conta instanceof ContaPoupanca) {
                        System.out.print("Quantos meses para simular: ");
                        int meses = scanner.nextInt();
                        ((ContaPoupanca) conta).simularMeses(meses);
                    } else {
                        System.out.println("Este recurso é apenas para contas poupança!");
                    }
                    break;

                case 6:
                    return; // Retorna ao menu principal

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}