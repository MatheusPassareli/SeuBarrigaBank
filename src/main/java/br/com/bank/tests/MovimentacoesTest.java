package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.MenuPage;
import br.com.bank.page.MovimentacoesPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacoesTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    MovimentacoesPage movimentacoesPage = new MovimentacoesPage();

    @Test
    public void cadastrarMovimentacao(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherTipoMovimentacao("Receita");
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.interessado("MP");
        movimentacoesPage.valor(50.0F);
        movimentacoesPage.escolherConta("Conta do Teste");
        movimentacoesPage.escolherSituacao("Pago");
        movimentacoesPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacoesPage.obterMensagemSucesso());
    }
}