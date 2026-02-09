package br.com.bank.tests;

import br.com.bank.core.BaseTest;
import br.com.bank.page.MenuPage;
import br.com.bank.page.MovimentacoesPage;
import br.com.bank.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static br.com.bank.utils.DataUtils.obterDataFormatada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacoesTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    MovimentacoesPage movimentacoesPage = new MovimentacoesPage();

    @Test
    public void test1_CadastrarMovimentacao(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherTipoMovimentacao("Receita");
        movimentacoesPage.escolherDataMovimentacao(obterDataFormatada(new Date()));
        movimentacoesPage.escolherDataPagamento(obterDataFormatada(new Date()));
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.interessado("MP");
        movimentacoesPage.valor("50");
        movimentacoesPage.escolherConta("Conta para movimentacoes");
        movimentacoesPage.escolherSituacao("Pago");
        movimentacoesPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacoesPage.obterMensagemSucesso());
    }

    @Test
    public void test2_ObrigatorioTodosOsCampos(){
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
    public void test3_InserirMovimetacaoFuturo() {
        menuPage.acessarTelaMovimentacoes();
        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
        movimentacoesPage.escolherTipoMovimentacao("Receita");
        movimentacoesPage.escolherDataMovimentacao(obterDataFormatada(dataFutura));
        movimentacoesPage.escolherDataPagamento(obterDataFormatada(dataFutura));
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.interessado("MP");
        movimentacoesPage.valor("50");
        movimentacoesPage.escolherConta("Conta para movimentacoes");
        movimentacoesPage.escolherSituacao("Pago");
        movimentacoesPage.salvar();
        List<String> erros = movimentacoesPage.obterErros();
        Assert.assertFalse(erros.containsAll(Arrays.asList(
                "Data da Movimentação deve ser menor ou igual à data atual"
        )));
    }

    @Test
    public void test4_obrigatorioDataMovimentação(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.salvar();
        Assert.assertEquals("Data da Movimentação é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Data da Movimentação é obrigatório')]")));
    }

    @Test
    public void test5_obrigatorioDataPagamento(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.salvar();
        Assert.assertEquals("Data do pagamento é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                ".//ul//li[contains(.,'Data do pagamento é obrigatório')]")));
    }

    @Test
    public void test6_obrigatorioDescricao(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.salvar();
        Assert.assertEquals("Descrição é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Descrição é obrigatório')]")));
    }

    @Test
    public void test7_obrigatorioInteressado(){
        menuPage.acessarTelaMovimentacoes();
        movimentacoesPage.escolherDataMovimentacao("08/01/2026");
        movimentacoesPage.escolherDataPagamento("07/02/2026");
        movimentacoesPage.descricao("Teste");
        movimentacoesPage.salvar();
        Assert.assertEquals("Interessado é obrigatório", movimentacoesPage.obterTexto(By.xpath(
                "//ul//li[contains(.,'Interessado é obrigatório')]")));
    }

    @Test
    public void test8_obrigatorioValor() {
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
    public void test9_valorDeveSerNumero() {
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