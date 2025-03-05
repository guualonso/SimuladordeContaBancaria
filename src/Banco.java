import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas = new ArrayList<>();

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public ContaBancaria buscarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroDaConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}