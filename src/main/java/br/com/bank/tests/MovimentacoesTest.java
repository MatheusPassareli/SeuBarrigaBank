package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.MenuPage;
import br.com.bank.page.MovimentacoesPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


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
        movimentacoesPage.valor("50");
        movimentacoesPage.escolherConta("Conta do Teste");
        movimentacoesPage.escolherSituacao("Pago");
        movimentacoesPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacoesPage.obterTexto(By.xpath(
                "//div[@class= 'alert alert-success' and contains(text(), 'Movimentação adicionada com sucesso!')]")));
    }

    @Test
    public void obrigatorioTodosOsCampos(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.salvar();
        Assert.assertEquals("Data da Movimentação é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Data da Movimentação é obrigatório')]")));
        Assert.assertEquals("Data do pagamento é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Data do pagamento é obrigatório')]")));
        Assert.assertEquals("Descrição é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Descrição é obrigatório')]")));
        Assert.assertEquals("Interessado é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Interessado é obrigatório')]")));
        Assert.assertEquals("Valor é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Valor é obrigatório')]")));
        Assert.assertEquals("Valor deve ser um número", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Valor deve ser um número')]")));
    }

    @Test
    public void obrigatorioDataMovimentação(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.salvar();
        Assert.assertEquals("Data da Movimentação é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Data da Movimentação é obrigatório')]")));
    }

    @Test
    public void obrigatorioDataPagamento(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.salvar();
        Assert.assertEquals("Data do pagamento é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                ".//ul//li[contains(.,'Data do pagamento é obrigatório')]")));
    }

    @Test
    public void obrigatorioDescricao(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.salvar();
        Assert.assertEquals("Descrição é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Descrição é obrigatório')]")));
    }

    @Test
    public void obrigatorioInteressado(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.salvar();
        Assert.assertEquals("Interessado é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Interessado é obrigatório')]")));
    }

    @Test
    public void obrigatorioValor() {
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.interessado("MP");
        movimentacoesPage.salvar();
        Assert.assertEquals("Valor é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Valor é obrigatório')]")));
    }

    @Test
    public void valorDeveSerNumero() {
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.interessado("MP");
        movimentacoesPage.valor("Número");
        movimentacoesPage.salvar();
        Assert.assertEquals("Valor deve ser um número", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Valor deve ser um número')]")));
    }
}