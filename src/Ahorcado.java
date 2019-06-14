import static java.lang.System.*;
import java.io.IOException;
import java.util.*;
 
public class Ahorcado {
static int coinciden = 0;
String [] Palabras = {"viernes"};
static int numeroPalabra = (int) Math.round(Math.random());
static char [] LetrasAdivinadas;
static String charIntroducido = "";
static int intentos;
static String palabraActual;
static int posicionAcierto;
static char [] Letras;
static int terminar;
 
//Metodo para pedir letra
public char introducirLetra(){
Scanner entrada = new Scanner(in);
out.print("Introduzca la letra: ");
String cadena = entrada.next();
//char [] charIntr = cadena.toCharArray();
charIntroducido = charIntroducido + cadena.charAt(0) + " _ ";
 
return cadena.charAt(0);
}
 
//Metodo para comparar letra introducida con una palabra del array de palabras
			public char coincide(char charIntroducido) throws IOException{
				
			palabraActual = Palabras[numeroPalabra];
			Letras = palabraActual.toCharArray();
			
			
			for (int i = 0; i < Letras.length; i++){
				if (charIntroducido == Letras[i]){
					posicionAcierto = i;
					coinciden = 1;
			
				}
			 
			}
			
				if (coinciden != 1){
					
					intentos++;
					
			out.println("No coincide. \nNumero de Intentos: " + intentos );
			
			}
				
			return charIntroducido;
			
			}
			 
			//Metodo para mostrar las rayas segun el tamaño de la palabra del array
			public void inicializarPalabra() {
			int indiceArray = Palabras[numeroPalabra].length();
			LetrasAdivinadas = new char[indiceArray];
			for (int i = 0; i < LetrasAdivinadas.length; i++){
			LetrasAdivinadas[i] = '_';
			out.print(LetrasAdivinadas[i] + " ");
			} out.println("\n ");
			}
			 
			//Metodo para cambiar la raya por la letra correspondiente
			public void intercambiarLetra(char charIntroducido) {
			int pos = 0;
			do {
			pos = palabraActual.indexOf(charIntroducido, pos);
			if (pos != -1) {
			LetrasAdivinadas[pos] = charIntroducido;
			pos++;
			}
			}
			while (pos != -1);
			}
			 
			public void mostrarJuego() {
			for (int i = 0; i < Letras.length; i++) {
			System.out.print(LetrasAdivinadas[i] + " ");
			}
			System.out.println();
			System.out.println("Letras que ya introduciste: " + charIntroducido);
			}
			 
			public int fin() {
			int res = 0;
			for ( int i = 0; i < Letras.length; i++) {
			if (LetrasAdivinadas[i] == '_') {
			res = 1;
			break;
			}
			else {
			res = 0;
			}
			}
			System.out.println();
			//System.out.println(res);
			return res;
			}
			 
			public static void main(String[]args) throws IOException {
			 
			while( intentos < 5) {
			 
			char c;
			Ahorcado practica = new Ahorcado();
			practica.inicializarPalabra();
			/*
			practica.coincide(charIntroducido);
			practica.intercambiarLetra(charIntroducido);
			practica.mostrarJuego();
			practica.fin();
			*/
			do {
			c = practica.introducirLetra();
			practica.coincide(c);
			practica.intercambiarLetra(c);
			practica.mostrarJuego();
			}
			while (practica.fin() == 1);
			out.println("Felicidades");
			numeroPalabra = (int) Math.round(Math.random());
			 
			}
			}
			}