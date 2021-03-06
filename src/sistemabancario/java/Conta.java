package sistemabancario.java;

import java.math.BigDecimal;

public class Conta {
    final static private double PF_JUROS_INVESTIMENTO = 0.03;
    final static private double PJ_TAXA_SAQUE_TRANSFER = 0.005;
    final static private double PJ_JUROS_INVESTIMENTO = PF_JUROS_INVESTIMENTO + 0.02;

    private int numConta;
    private BigDecimal contaCorrente = new BigDecimal(0); // 1
    private BigDecimal contaPoupanca = new BigDecimal(0); // 2
    private BigDecimal contaInvestimento = new BigDecimal(0); //3

    private Conta(){}

    public Conta(int numConta) {
        this.numConta = numConta;
    }

    public Conta(int numConta, BigDecimal contaCorrente) {
        this.numConta = numConta;
        this.contaCorrente = contaCorrente;
    }

    public Conta(int numConta, BigDecimal contaCorrente, BigDecimal contaPoupanca, BigDecimal contaInvestimento) {
        this.numConta = numConta;
        this.contaCorrente = contaCorrente;
        this.contaPoupanca = contaPoupanca;
        this.contaInvestimento = contaInvestimento;
    }

    public int getNumConta() {
        return numConta;
    }

    private void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public BigDecimal getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(BigDecimal contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public BigDecimal getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(BigDecimal contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public BigDecimal getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(BigDecimal contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }

    public boolean temSaldo(Cliente cliente, Conta conta, int tipo, BigDecimal valor){
        if(cliente.getTipo().equals("PJ")){
            valor = valor.multiply(BigDecimal.valueOf(1+PJ_TAXA_SAQUE_TRANSFER));
        }
        if(tipo == 1){
            if (conta.getContaCorrente().doubleValue()  >= valor.doubleValue()){
                return true;
            }
        } else if (tipo == 2){
            if (conta.getContaPoupanca().doubleValue()  >= valor.doubleValue()){
                return true;
            }
        } else if (tipo == 3){
            if (conta.getContaInvestimento().doubleValue()  >= valor.doubleValue()){
                return true;
            }
        }
        return false;
    }

    public boolean sacar( Cliente cliente, Conta conta, int tipoConta, BigDecimal valor ){
        BigDecimal valorSaque = valor;

        if( cliente.getTipo().equals("PJ") ){
            valorSaque = valor.multiply( BigDecimal.valueOf( 1 + PJ_TAXA_SAQUE_TRANSFER) );
        }

        if ( conta.temSaldo( cliente , conta , tipoConta , valorSaque) ) {
            switch ( tipoConta ) {
                case 1:
                    BigDecimal valorEmCC = conta.getContaCorrente();
                    conta.setContaCorrente( valorEmCC.subtract( valorSaque ) );
                    System.out.println("Saque feito com sucesso");
                    break;

                case 2:
                    BigDecimal valorEmCP = conta.getContaPoupanca();
                    conta.setContaPoupanca( valorEmCP.subtract( valorSaque ) );
                    System.out.println("Saque feito com sucesso");
                    break;

                case 3:
                    BigDecimal valorEmCI = conta.getContaInvestimento();
                    conta.setContaInvestimento( valorEmCI.subtract( valorSaque ) );
                    System.out.println("Saque feito com sucesso");
                    break;

                default:
                    break;
            }

            return true;
        }
        System.out.println("Saldo insuficiente!\nSaque cancelado.\n\n");
        return false;
    }

    public boolean transferir(Cliente cliente, Conta[] contas, int numContaRemetente, int numContaDestinataria, int tipoContaRemetente, int tipoContaDestinatario, BigDecimal valor){
        Conta contaRemetente = contas[numContaRemetente];
        BigDecimal valorEmCC = contaRemetente.getContaCorrente();
        BigDecimal valorEmCP = contaRemetente.getContaPoupanca();
        BigDecimal valorEmCI = contaRemetente.getContaInvestimento();

        Conta contaDestinataria = contas[numContaDestinataria];
        BigDecimal valorEmCCdestino = contaDestinataria.getContaCorrente();
        BigDecimal valorEmCPdestino = contaDestinataria.getContaPoupanca();

        BigDecimal valorDebitado = valor;
        if(cliente.getTipo() == "PJ"){
            valorDebitado = valor.multiply(BigDecimal.valueOf(1+PJ_TAXA_SAQUE_TRANSFER));
        }

        if (contas[numContaRemetente].temSaldo(cliente, contaRemetente, tipoContaRemetente, valor)) {
            if (tipoContaRemetente == 1 && tipoContaDestinatario == 1) {
                contaRemetente.setContaCorrente(valorEmCC.subtract(valorDebitado));
                contaDestinataria.setContaCorrente(valorEmCCdestino.add(valor));
            } else if (tipoContaRemetente == 1 && tipoContaDestinatario == 2) {
                contaRemetente.setContaCorrente(valorEmCC.subtract(valorDebitado));
                contaDestinataria.setContaPoupanca(valorEmCPdestino.add(valor));
            } else if (tipoContaRemetente == 2 && tipoContaDestinatario == 1) {
                contaRemetente.setContaPoupanca(valorEmCP.subtract(valorDebitado));
                contaDestinataria.setContaCorrente(valorEmCCdestino.add(valor));
            } else if (tipoContaRemetente == 3 && tipoContaDestinatario == 1) {
                contaRemetente.setContaInvestimento(valorEmCI.subtract(valorDebitado));
                contaDestinataria.setContaCorrente(valorEmCCdestino.add(valor));
            }
            return true;
        }
        return false;
    }

    public boolean depositar(Cliente cliente, Conta conta , BigDecimal valor, int contaSelecionada) {
        switch ( contaSelecionada) {
            case 1:
                BigDecimal valorEmCC = conta.getContaCorrente();
                conta.setContaCorrente(valorEmCC.add(valor));
                break;

            case 2:
                BigDecimal valorEmCP = conta.getContaPoupanca();
                conta.setContaPoupanca(valorEmCP.add(valor));
                break;

            default:
                break;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", contaCorrente=" + contaCorrente +
                ", contaPoupanca=" + contaPoupanca +
                ", contaInvestimento=" + contaInvestimento +
                '}';
    }
}