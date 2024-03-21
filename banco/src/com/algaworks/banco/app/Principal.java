package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;
import com.algaworks.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12345678912");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2024-03-20T15:00:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Catarina");
        titular2.setDocumento("98765432100");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1,123,987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 234, 876,new BigDecimal("1000"));

        System.out.println("*************************");
        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
//        minhaConta.creditarRendimentos(0.8);
//        minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);


            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);


        boletoEscola.imprimirRecibo();
        System.out.println("*************************");
        salarioFuncionario.imprimirRecibo();

//        System.out.println("Boleto pago: " + boletoEscola.estaPago());
//        System.out.println("Salário pago: " + salarioFuncionario.estaPago());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Alguma coisa deu errado: " + e.getMessage());
        }

        System.out.println("*************************");
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("*************************");
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
