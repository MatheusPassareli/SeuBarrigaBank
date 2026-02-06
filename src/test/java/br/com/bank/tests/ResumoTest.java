package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.core.DriverFactory;
import br.com.bank.page.ContasPage;
import br.com.bank.page.MenuPage;
import br.com.bank.page.ResumoMensalPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ResumoMensalPage resumoMensalPage = new ResumoMensalPage();
    ContasPage contasPage = new ContasPage();


    @Test
    public void test1_ExcluirMovimentacao (){
        menuPage.acessarTelaResumoMensal();
        resumoMensalPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.obterMensagemSucesso());
    }

    @Test
    public void test2_ExcluirConta(){
        menuPage.acessarTelaEditarConta();
        contasPage.clicarExcluirConta("Conta do Teste alterada");
        Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_ResumoMensal(){
        menuPage.acessarTelaResumoMensal();
        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
    }

    @Test
    public void test4_ListaVazia(){
        menuPage.acessarTelaResumoMensal();
        List<String> elementosEncontrados = resumoMensalPage.obterListaVazia();
        Assert.assertTrue(elementosEncontrados.isEmpty());
    }
}


