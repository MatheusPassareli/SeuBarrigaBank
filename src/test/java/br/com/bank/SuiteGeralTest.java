package br.com.bank;

import br.com.bank.core.DriverFactory;
import br.com.bank.page.LoginPage;
import br.com.bank.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacoesTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class,
})
public class SuiteGeralTest {

    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializa(){
        page.acessarTelaInicial();
        page.setEmail("teste.matheus@email.com.br");
        page.setSenha("tzKriYS7sqFhJAjl");
        page.entrar();
        page.confirmacaoLogin();
    }

    @AfterClass
    public static void finaliza(){
        DriverFactory.killDriver();
    }
}