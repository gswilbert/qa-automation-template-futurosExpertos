package automatizacion;

public class TC001CondicionalesEnJava {

    public static void main(String[] args) {
        //Declarar Variables
        String nombre = "Wilbert Gomez";
        int edad = 30;
        boolean estudiante = true;

        //Mostrar Variable en consola
        System.out.println("=== Datos de las Variables ====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Es estudiante de este curso: " + estudiante);

       //Condicionales If - ELSE
       System.out.println("\n=== Ejemplos con Condicionales ====\n");
       if(edad>=18) {
        System.out.println(nombre + " es mayor de edad");
       }else {
        System.out.println(nombre + " es menor de edad");        
       }

        //Ejemplo if - else 2
       if(estudiante){
        System.out.println(nombre + " Si es estudiante de este curso");
       }else{
         System.out.println(nombre + " NO es estudiante de este curso");
       }
        
       //Ejemplo ciclo for
       System.out.println("\n===Ejemplo Ciclo FOR ====\n");
       for(int i  = 1; i<=5;i++){        
        System.out.println("Iteracion For Numero: " + i);
       }

       //Ejemplo Ciclo While
       System.out.println("\n===Ejemplo Ciclo WHILE ====\n");
       int contador = 1;
       while (contador<=5) {
        System.out.println("Iteracion WHILE Numero: " + contador);
        contador++;        
       }
       System.out.println("\n === Finalizan los Ejemplos de JAVA ====");
    }
}
