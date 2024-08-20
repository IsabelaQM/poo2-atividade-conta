public class ContaCorrente implements ContaTarifavel{

   private Agencia agencia;
   private String numeroConta;
   protected double saldo;
   private double limiteChequeEspecial;

   public ContaCorrente(Agencia agencia, String numeroConta, double saldo, double limiteChequeEspecial) {
      this.agencia = agencia;
      this.numeroConta = numeroConta;
      this.saldo = saldo;
      this.limiteChequeEspecial = limiteChequeEspecial;
   }

   @Override
   public void saque(Double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo + limiteChequeEspecial >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Conta com saldo insuficiente. Saldo atual: " + this.saldo);
         }
      } else {
         throw new ContaException("O valor é inválido para saque: " + valor);
      }
   }

   @Override
   public void deposito(Double valor) throws ContaException {
      if (valor > 0) {
         this.saldo += valor;
      } else {
         throw new ContaException("O valor é inválido para depósito: " + valor);
      }
   }

   @Override
   public void cobrarTarifa(Double tarifa) {
      // Atualiza o valor do saldo, descontando a tarifa (considerando um valor fixo, por exemplo, uma taxa para manutencao da conta)
      if (tarifa > 0) {
         this.saldo -= tarifa;
      }
   }

   public String getNumeroConta() {
      return numeroConta;
   }
}