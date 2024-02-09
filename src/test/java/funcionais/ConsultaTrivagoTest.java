package funcionais;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TrivagoPages;

import java.time.Duration;

public class ConsultaTrivagoTest {
    public WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.edgedriver()
                        .setup();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void TrivagoTestComSucesso() {
        TrivagoPages trivagoPages = new TrivagoPages(driver).acessaPagina()
                                .selecionaDestino("Manaus")
                                .efetuaPesquisa()
                                .ordenarPorAvaliacaoESugestao();

        Assertions.assertEquals(trivagoPages.retornaHotelPrimeiroElemento(), "ibis budget Manaus");
        Assertions.assertEquals(trivagoPages.retornaAvaliacaoPrimeiroElemento(), "8.4");
        Assertions.assertEquals(trivagoPages.retornaValorPrimeiroElemento(), "8.4");
    }
}