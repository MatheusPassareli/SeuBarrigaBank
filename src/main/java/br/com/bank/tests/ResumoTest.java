package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.MenuPage;
import br.com.bank.page.ResumoMensalPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ResumoMensalPage resumoMensalPage = new ResumoMensalPage();


    @Test
    public void testeExcluirMovimentacao (){
        menuPage.acessarTelaResumoMensal();
        resumoMensalPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.obterMensagemSucesso());
    }
}


