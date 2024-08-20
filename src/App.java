public class App {
    public static void main(String[] args) throws Exception {

        // Configuração da agência e contas
        Agencia caixaLuizote = new Agencia("0205-08");

        ContaCorrente contaTarifavel = new ContaCorrente(caixaLuizote, "1164-9", 500d, 1000);

        // Conta corrente para testar o saldo negativo
        ContaCorrente contaTarifavel2 = new ContaCorrente(caixaLuizote, "1165-9", 300d, 1000);

        ContaPoupanca contaPoupanca = new ContaPoupanca(caixaLuizote, "1324-9", 700d);
        
        ContaSalario contaSalario = new ContaSalario(caixaLuizote, "1478-5", 1500d);

        caixaLuizote.addContaRentavel(contaPoupanca);
        caixaLuizote.addContaTarifavel(contaTarifavel);
        caixaLuizote.addContaTarifavel(contaTarifavel2);
        caixaLuizote.addContaEssencial(contaSalario);

        // Realizando saques
        caixaLuizote.saque("1164-9", 200);
        caixaLuizote.saque("1165-9", 1200);
        caixaLuizote.saque("1324-9", 100);
        caixaLuizote.saque("1478-5", 500);

        // Considerando uma taxa de rendimento fixa
        caixaLuizote.atualizarRendimentoContas(0.04);
        caixaLuizote.cobrarTarifaContas(20d);

        System.out.println("Saldo da conta corrente: R$ " + contaTarifavel.saldo);
        System.out.println("Saldo da conta corrente 2: R$ " + contaTarifavel2.saldo);
        System.out.println("Saldo da conta poupança R$ " + contaPoupanca.saldo);
        System.out.println("Saldo da conta salário: R$ " + contaSalario.saldo);

    }
}
