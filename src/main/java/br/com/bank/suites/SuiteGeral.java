package br.com.bank.suites;

import br.com.bank.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacoesTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})
public class SuiteGeral {

}