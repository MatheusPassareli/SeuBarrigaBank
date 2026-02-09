package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.HomePage;
import br.com.bank.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();

    @Test
    public void testSaldoConta(){
        menuPage.acessarTelaHome();
        Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
    }
}