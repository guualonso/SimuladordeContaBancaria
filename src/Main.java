//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ContaPoupanca cp = new ContaPoupanca(54312, "Gustavo", 2000, 1.08);
        cp.exibirSaldo();

        // Simulando rendimento do CDI em 8 meses
        cp.simularMeses(8);

        //Atualizando a taxa CDI e simulando novamente

        System.out.println("Atualizando taxa CDI...");
        cp.setTaxaCDI(1.20);
        cp.simularMeses(3);
    }
}