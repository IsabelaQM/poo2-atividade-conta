public interface ContaEssencial {

    public void saque(Double valor) throws ContaException;

    public void deposito(Double valor) throws ContaException;

    public String getNumeroConta();
}
