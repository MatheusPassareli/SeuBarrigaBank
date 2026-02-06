package br.com.bank.page;

import br.com.bank.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.bank.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contas")));
        clicarLink("Contas");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Adicionar")));
        clicarLink("Adicionar");
    }
    public void acessarTelaEditarConta(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contas")));
        clicarLink("Contas");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Listar")));
        clicarLink("Listar");
    }
    public void acessarTelaMovimentacoes(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Criar Movimentação")));
        clicarLink("Criar Movimentação");
    }
    public void acessarTelaResumoMensal(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Resumo Mensal")));
        clicarLink("Resumo Mensal");
    }

    public void acessarTelaHome(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
        clicarLink("Home");
    }
}