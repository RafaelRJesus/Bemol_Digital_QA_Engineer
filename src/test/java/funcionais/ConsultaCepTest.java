package funcionais;

import commons.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CorreiosPages;

public class ConsultaCepTest extends BaseTest {
    @Test
    void consultarCepComSucesso() {
        new CorreiosPages(driver).acessaPagina()
                                 .pesquisa();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")));
        String resultado = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]"))
                                 .getText();
        Assertions.assertEquals(resultado, "Rua Miranda Leão");
    }
}
