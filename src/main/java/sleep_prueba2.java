import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sleep_prueba2 {

    //comentarios : kenjy tasato
    //no es bueno utilizar el Tread sleep por lo siguiente:
    //  1.-Un elemento podria cargar antes del tiempo que se coloca , en otras palabras puedo hacer que espere 40 segundos y el elemento cargar en 2
    //     ello conlleva a una espera innecesaria de 38 segundos
    //  2.-El tiempo que se va a esperar se coloca por adelantado si o si se va tener que consumir ese tiempo.
    //  3.-Es utilizado en manejo de hilos ,ello implica, multitarea, el utilizarlo solamente para detener la ejecucion es una mala practica de programacion.


    public static void main(String[] args) {

        WebDriver driver = null;
        WebDriverManager.chromedriver().version("87.0.4280.88").setup();
        driver = new ChromeDriver();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://www.mercadolibre.com.pe/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }




}
