package Calculadora;
import java.util.Scanner; // Importaci�n de la clase Scanner.
 
public class Calculadora{
  public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;
 
        do{
            String numero1;
            do {
                System.out.println("\n Por favor, dame el primer n�mero de la operaci�n. ");
                numero1 = leer.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double n1 = new Double(numero1);
            // Fin de la verificaci�n de los datos puestos por el usuario del n�mero 1.
 
            do {
                System.out.println("\n �Que operaci�n desea hacer? (Solo coloque un signo)");
                System.out.println("Teniendo en cuenta que: \n + = sumar \n - = restar \n"
                        + " x = multiplicar \n / = dividir \n * = elevar primer n�mero al segundo numero."
                        + "\n % = residuo");
            operacion = leer.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x") ||
                    operacion.equals("X") || operacion.equals("/") || operacion.equals("%") ||
                    operacion.equals("*")) {
                    comprobar = true;
                }else { comprobar = false; }
            } while (comprobar != true);
 
            // Verificaci�n de los datos puestos por el usuario del n�mero 2.
            String numero2;
            do {
                System.out.println("\n Por favor, dame el segundo n�mero.");
                numero2 = leer.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);
            // Fin de la verificaci�n de los datos puestos por el usuario del n�mero 2.
 
            do{
                comprobar = true;
                switch(operacion){
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        /* Por tal de evitar errores y a�adir n�meros complejos, si el usuario coloca 0 como segundo n�mero, se piensa entonces que el denominador es 0, y por ello a�ado una condicional que lo verifique, y para hacer el codigo mas dinamico y no solo a�adir un 1, le vuelvo a preguntar al usuario que a�ada un n�mero distinto, podr�a volver a colocar 0, y es la raz�n por la que se encuentra en un ciclo, as� que mientras n2 sea 0, el c�digo seguir� ejecutando hasta que ponga otro. */
                        while(n2 == 0){
                                 do {
                                    System.err.println(" En el denominador se encuentra \n"
                                            + "un cero, para evitar errores coloca otro n�mero.");
                                    numero2 = leer.nextLine();
                                }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                                    nume2 = Double.parseDouble(numero2);
                                    n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while(n2 == 0){
                                 do {
                                    System.err.println(" En el denominador se encuentra \n"
                                            + "un cero, para evitar errores coloca otro n�mero.");
                                    numero2 = leer.nextLine();
                                }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                                    nume2 = Double.parseDouble(numero2);
                                    n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            }while(comprobar != true);
 
            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n �Desea hacer alguna otra operaci�n? \n");
            System.out.println(" [s/n]");
            do{
                comprobar = true;
                operacion = leer.nextLine();
 
                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, ponga un literal valido. \n");
                        comprobar = false;
                }
            }while(comprobar != true);
        }while(operacion.equals("s") || operacion.equals("S"));
  }
}