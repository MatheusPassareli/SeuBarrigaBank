package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.ContasPage;
import br.com.bank.page.MenuPage;
import junit.framework.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void ExcluirContaComMovimentacao(){
        menuPage.acessarTelaEditarConta();
        contasPage.clicarExcluirConta("Conta com movimentacao");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemDeErro());
    }
}
