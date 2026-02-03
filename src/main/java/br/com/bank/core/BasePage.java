package br.com.bank.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static br.com.bank.core.DriverFactory.getDriver;

public class BasePage {

    public void escreve(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarRadio(By by) {
        getDriver().findElement(by).click();
    }

    public boolean isRadioMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public boolean isComboSelecionado(By by) {
        return getDriver().findElement(by).isSelected();
    }

    public void clicarCheckBox(By by) {
        getDriver().findElement(by).click();
    }

    public boolean isCheckBoxMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public boolean isConfimacaoLogin (By by) {
        return getDriver().findElement(by).isSelected();
    }

    public void selecionarCombo(By by, String valor) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String obterValorCombo(By by) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBotao(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public String alertaObterTexto() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        return valor;
    }
    public String alertaObterTextoSemTrocarTela(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public String alertaObterTextoENega() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
    }

    public void trocarFrame(String frame){
        getDriver().switchTo().frame(frame);
    }

    /*************** JS *******************/

    public Object executarJS(String cmd, Object... param){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    /*************** Tabela *******************/

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();
    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath(".//tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++){
            if (linhas.get(i).getText().equals(valor)){
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++){
            if (colunas.get(i).getText().equals(coluna)){
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }
}