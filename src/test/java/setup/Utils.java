package setup;

import java.io.*;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.text.Normalizer.Form;
import java.util.Date;
import java.util.Properties;


/**
 *
 * @author David Chavez Avila (david.chavez.avila@gmail.com)
 */
public class Utils {

	/**
	 * String estatus del test cuando es pass
	 */
	public static String TEST_STATUS_PASSED = "EJECUCIÓN EXITOSA";

	/**
	 * String estatus del test cuando es fail
	 */
	public static String TEST_STATUS_FAILED = "EJECUCIÓN FALLIDA";
	
    /**
     * Permite obtener un archivo properties
     * @param Archivo
     * @return
     * @throws FileNotFoundException
     */
    public static Properties getPropetiesFile(String Archivo) {
        Properties prop = new Properties();
        try {
            Reader reader = new InputStreamReader((new FileInputStream(Archivo)), "UTF-8"); 
            prop.load(reader);
        } catch(IOException e){
            System.out.println("Mensaje Properties: "+ e);
        } catch(Exception e){
            System.out.println("Mensaje Properties: "+ e);
        }
        return prop;
    }
        
    public static String crearDirectorio(String directorio) {
        File carpeta = new File(directorio);
        
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("El directorio ya existe");
                
            }
        }
        return directorio;
    }
    
	public static String crearDirectorio(File directorio) {
	    
	    if (!directorio.exists()) {
	        if (directorio.mkdirs()) {
	            System.out.println("Directorio creado");
	        } else {
	            System.out.println("El directorio ya existe");
	            
	        }
	    }
	    return directorio.getAbsolutePath();
	}
    
    public static String fechaFormato(){
        SimpleDateFormat d = new SimpleDateFormat("yyMMdd");
        Date fecha = new Date();
        return d.format(fecha);
    }
    
    public static String fechaFormato(String fechaFormato){
        SimpleDateFormat d = new SimpleDateFormat(fechaFormato);
        Date fecha = new Date();
        return d.format(fecha);
    }
    
    public static String horaMinSeg(){
        Date fecha = new Date();
        String hora = ""+fecha.getHours()+":"+fecha.getMinutes()+"."+fecha.getSeconds();
        return hora;
    }
    
    /**
     * Permite obtener el nombre "numero" de carpeta de evidencia para N iteraciones
     * 		- Ej. dir = C:/Evidencia/<empty> bajo el supuesto que el directorio esta vacio se retorna 1
     * 		- Ej. dir = C:/Evidencia/1 bajo el supuesto que dentro existe la carpeta 1 entonces retorna 2
     * @param directorio
     * @return
     */
    public static int obtenerPathIteracion(File directorio){
        try{
            String[] arregloArchivos = directorio.list();
            int numArchivos = arregloArchivos.length;
            
            if(numArchivos >= 1){
                return numArchivos;
            }else{
                return 1;
            }
        }catch(Exception e){
            return 1;
        }
    }
    
    public static int crearNuevoPathIteracion(File directorio){
        try{
            String[] arregloArchivos = directorio.list();
            int numArchivos = arregloArchivos.length;
            
            if(numArchivos >= 1){
                return numArchivos + 1;
            }else{
                return 1;
            }
        }catch(Exception e){
            return 1;
        }
    }
    
	public static String remplazarCaracteresEspeciales(String texto) {
		texto = Normalizer.normalize(texto, Form.NFD);
		texto = texto.replaceAll("\\p{M}", "");
		texto = texto.replaceAll("[^a-zA-Z0-9]", "_");
		texto = texto.replaceAll("__________", "_");
		texto = texto.replaceAll("_________", "_");
		texto = texto.replaceAll("________", "_");
		texto = texto.replaceAll("_______", "_");
		texto = texto.replaceAll("______", "_");
		texto = texto.replaceAll("_____", "_");
		texto = texto.replaceAll("____", "_");
		texto = texto.replaceAll("___", "_");
		texto = texto.replaceAll("__", "_");

		if(texto.startsWith("_")) {
			texto = texto.substring(1, texto.length());
		}
		if(texto.endsWith("_")) {
			texto = texto.substring(0, texto.length() - 1);
		}

		return texto;
	}
	
	public static String remplazarSlash(String texto) {
		texto = texto.replaceAll("\\\\", "/");
		return texto;
	}
	
	public static String remplazarAcentos(String texto) {
		texto = Normalizer.normalize(texto, Form.NFD);
		texto = texto.replaceAll("\\p{M}", "");
		return texto;
	}
	
	public static long contarLineasArchivo(String archivo) {     
	      long lines = 0;
	      try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
	          while (reader.readLine() != null) lines++;
	          reader.close();
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      return lines;
	}
	
}
