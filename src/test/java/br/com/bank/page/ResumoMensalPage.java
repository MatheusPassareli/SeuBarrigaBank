package br.com.bank.page;

import br.com.bank.core.BasePage;
import br.com.bank.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ResumoMensalPage extends BasePage {

    public void excluirMovimentacao(){
        clicarBotao(By.xpath("//span[@class= 'glyphicon glyphicon-remove-circle']"));
    }

    public String obterMensagemSucesso(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(
                "//div[@class= 'alert alert-success' and contains(text(), 'Movimentação removida com sucesso!')]")))).getText();
    }
    public List<String> obterListaVazia(){
        List<WebElement> lista = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']//tbody/tr"));
        List<String> retorno = new ArrayList<String>();
        for (WebElement opcoes: lista) {
            retorno.add(opcoes.getText().trim());
        }
        return retorno;
    }

}
