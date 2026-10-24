package automatizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001EjercicioPracticoLlenarFormulario {
    //Script para Validar el Login Page 
   WebDriver driver;

//Acciones que se ejecutaran antes de cada test.
    @BeforeEach 
    public void inicializarNavegador(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Test 1: Validar Ingreso al Formulario
    @Test 
    public void completarFormulario(){
        //Abrir nuestro Navegador.
        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        //Obtener Titulo de Sitio WEB
        String tituloActual = driver.getTitle();
        String tituloEsperado = "Contact Form";

    //Validar el titulo del sitio Web
        Assertions.assertEquals(tituloEsperado, tituloActual, "El titulo Encontrado no coincide con lo esperado");

    //Validacion Nombre de Formulario
    WebElement nombFormulario = driver.findElement(By.cssSelector("#content"));
    String tituloFormulario = nombFormulario.getText();
    
    //Uso de condicional para validar el login exitoso
        if(tituloFormulario.contains("Contact Form Test")){
            System.out.println("Estas en Formulario de Contacto");
    }else{
        System.out.println("No estas en el formulario esperado");
        Assertions.fail("Se esperaba el titulo de Formulario: Contact Form Test! " 
        + "\n Pero se encontró: " + tituloFormulario);
    }

    //Completar Formulario
        driver.findElement(By.name("first_name")).sendKeys("Wilbert");
        driver.findElement(By.name("last_name")).sendKeys("Gomez");
        driver.findElement(By.name("email")).sendKeys("test@qa.com.sv");
        driver.findElement(By.name("message")).sendKeys("Este es un mensaje de prueba para llenar/Validar el formulario.");
        driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();

    //Validar mensaje de formulario llenado con exito.
        WebElement formularioCompletado = driver.findElement(By.cssSelector("div[class='col-8 col-12-small'] h3"));
    String mensajeExitoso = formularioCompletado.getText();
    
    //Uso de condicional para validar el login exitoso
        if(mensajeExitoso.equals("Thank you for your mail!")){
            System.out.println("Formulario llenado Exitosamente");
    }else{
        System.out.println("Formulario no fue llenado Exitosamente");
        Assertions.fail("Se esperaba el titulo de Formulario: Thank you for your mail! " 
        + "\n Pero se encontró: " + tituloFormulario);
    }

    }

    //Test 2: Reset Formulario
    @Test 
     public void resetFormulario(){
    //Abrir nuestro Navegador.
        driver.get("https://www.automationtesting.co.uk/contactForm.html");
        
        //Completar Formulario
        driver.findElement(By.name("first_name")).sendKeys("Wilbert");
        driver.findElement(By.name("last_name")).sendKeys("Gomez");
        driver.findElement(By.name("email")).sendKeys("test@qa.com.sv");
        driver.findElement(By.name("message")).sendKeys("Este es un mensaje de prueba para llenar/Validar el formulario.");

    //Resetear Formulario
        driver.findElement(By.cssSelector("input[value='RESET']")).click();


     }
//Accciones a ejecutar despues de cada Test
    @AfterEach 
    public void cerrarSesion(){
            driver.quit();
    }
       
}
