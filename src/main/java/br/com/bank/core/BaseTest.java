package br.com.bank.core;

import br.com.bank.page.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.bank.core.DriverFactory.getDriver;
import static br.com.bank.core.DriverFactory.killDriver;

public class BaseTest {

    private LoginPage page = new LoginPage();

    @Rule
    public TestName testeName = new TestName();

    @Before
    public void inicializa(){
        page.acessarTelaInicial();
        page.setEmail("Teste@teste.com");
        page.setSenha("senha123");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testeName.getMethodName() + ".jpg"));

        if (Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }
}
