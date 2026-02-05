package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void testSaldoConta(){
        Assert.assertEquals("50.00", homePage.obterSaldoConta("Conta do Teste alterada"));
    }
}