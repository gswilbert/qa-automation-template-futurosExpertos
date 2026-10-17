package automatizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002ValidacionDeLogin {
//Script para Validar el Login Page 
   WebDriver driver;

//Acciones que se ejecutaran antes de cada test.
    @BeforeEach 
    public void inicializarNavegador(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//Test 1: Validar el titulo de la pagina antes de realizar el login
    @Test 
    public void validarTitutloDeLaPagina(){
        //Abrir nuestro Navegador.
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Obtener Titulo de Sitio WEB
        String tituloActual = driver.getTitle();
        String tituloEsperado = "Test Login | Practice Test Automation";

    //Validar el titulo del sitio Web
        Assertions.assertEquals(tituloEsperado, tituloActual, "El titulo Encontrado no coincide con lo esperado");

        System.out.println("Titulo fue validado correctamente");

    }
//Test 2: Validar un Login Exitoso
    @Test 
    public void loginExitoso(){
        //Abrir nuestro Navegador.
        driver.get("https://practicetestautomation.com/practice-test-login/");

    //Ingresar las Credenciales de Autenticación
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("Pruebas123");
        driver.findElement(By.id("submit")).click();

    }
//Accciones a ejecutar despues de cada Test
    @AfterEach 
    public void cerrarSesion(){
            driver.quit();
    }
}
