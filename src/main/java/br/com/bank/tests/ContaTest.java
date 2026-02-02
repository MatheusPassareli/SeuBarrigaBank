package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.ContasPage;
import br.com.bank.page.MenuPage;
import junit.framework.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void InserirConta() throws InterruptedException{
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }
    @Test
    public void EditarConta(){
        menuPage.acessarTelaEditarConta();
        contasPage.editarConta();
        contasPage.setNome("Conta do Teste alterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void ExcluirConta(){
        menuPage.acessarTelaEditarConta();
        contasPage.excluirConta();
    }
}
