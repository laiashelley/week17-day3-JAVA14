// EJERCICIO TIENDA ZAPATERIA (primera parte)
// Tienes una zapatería con tres categorías de zapatos: Elegante, Casual, Deporte (una clase cada uno). cada categoria es una clase, con las mismas caracteristicas. OK


// Todos tienen las mismas características: marca, modelo, material, talla y precio. De momento, no hay propiedades
// distintas. OK


// En el programa principal, crear al menos dos instancias de cada categoría (zapatos en concreto). OK
// Se listan todos los zapatos con sus características. OK

// Primero se pregunta al usuario qué tipo de zapato quiere comprar, del tipo:

// "Que tipo de zapatos quieres comprar?\n1-ELEGANTES\n2-CASUAL\n3-DEPORTIVOS" ok


// Luego se pregunta al usuario qué modelo quiere comprar. Lo que vale ese modelo, se va sumando al
// gastoTotal, y se sigue preguntando qué modelo quiere comprar hasta que escribe ‘salir’.


// Cuando sale, se le da el gasto total y un mensaje de ‘hasta la próxima’. El gasto total también se
// puede ir mostrando dentro del bucle mientras se va sumando

import java.util.ArrayList;
import java.util.Scanner;

public class Java14ejercicio1 {

    public static void main(String[] args) throws Exception {
        
        // creamos dos instancias de cada categoria

        Elegante zElegante1 = new Elegante("Hugo Boss", "Oxford", "Cuero", 42, 250);
        Elegante zElegante2 = new Elegante("Salvatore Ferragamo", "Monkstrap", "Gamuza", 41, 400);

        Casual zCasual1 = new Casual("Vans", "Old Skool", "Lona", 40, 60);
        Casual zCasual2 = new Casual("Doc Martens", "1461 Smooth", "Cuero", 38, 150);

        Deporte zDeporte1 = new Deporte("Nike", "Air Max 270", "Malla transpirable y sintética", 45, 150);
        Deporte zDeporte2 = new Deporte("Adidas", "Ultraboost 21", "Primeknit", 44, 180);

        // creo arraylist de lista zapatos completa

        ArrayList <Elegante> listaZapatosElegantes = new ArrayList<>();
        ArrayList <Casual> listaZapatosCasuales = new ArrayList<>();
        ArrayList <Deporte> listaZapatosDeportivos = new ArrayList<>();

        // añado las diferentes marcas

        listaZapatosElegantes.add(zElegante1);
        listaZapatosElegantes.add(zElegante2);
        listaZapatosCasuales.add(zCasual1);
        listaZapatosCasuales.add(zCasual2);
        listaZapatosDeportivos.add(zDeporte1);
        listaZapatosDeportivos.add(zDeporte2);

        // muestro en lista

        for (Elegante zapatosE : listaZapatosElegantes){
            System.out.println(zapatosE);
        }

        for (Casual zapatosC : listaZapatosCasuales){
            System.out.println(zapatosC);
        }

        for (Deporte zapatosD : listaZapatosDeportivos){
            System.out.println(zapatosD);
        }

        Scanner sc = new Scanner (System.in);

        // creo arraylist de carrito compra:

        ArrayList <String> carritoCompra = new ArrayList<>();
        ArrayList <Double> precioCompra = new ArrayList<>();

        byte opciones;

        // empiezo bucle para ir preguntandole al usuario el modelo que quiere.

        do{
            menu();
            opciones = sc.nextByte();
            sc.nextLine();

            switch (opciones){
                case 0:
                break;
                case 1:
                    elegantes(listaZapatosElegantes, sc, carritoCompra, precioCompra);
                    break;
                case 2:
                    casuales(listaZapatosCasuales, sc, carritoCompra, precioCompra);
                    break;
                case 3:
                    deportivos(listaZapatosDeportivos, sc, carritoCompra, precioCompra);
                    break;
                default:
                System.out.println("Debes introducir 1, 2 o 3. Por favor, introduce de nuevo.");
            }

        } while (opciones !=0);

        sc.close();

        // mostramos items de la compra:

        mostrarResumen(carritoCompra, precioCompra);

    }

    // método especifico para mostrar el menú.

    public static void menu(){
        System.out.println("**********************");
        System.out.println();
        System.out.println("¿Qué tipo de zapatos quieres comprar?");
        System.out.println("1- ELEGANTES");
        System.out.println("2- CASUALES");
        System.out.println("3- DEPORTIVOS");
        System.out.println("0- SALIR");
        System.out.println();
        System.out.println("**********************");
    }

    // metodos especificos para cada tipo de zapato:

    public static void elegantes(ArrayList <Elegante> listaZapatosElegantes, Scanner sc, ArrayList <String> carritoCompra, ArrayList <Double> precioCompra){
    
        System.out.println("Zapatos de tipo 'ELEGANTES' disponibles en tienda:");

        for (Elegante zapatosE : listaZapatosElegantes) {
            System.out.println(zapatosE);
        }

        String modeloUsuario = "";

        int contador;
        double precioTotal = 0;
        
        while (!modeloUsuario.equalsIgnoreCase("salir")){
            System.out.println("¿Qué modelo quieres comprar? Pon 'salir' si no quieres añadir más modelos");
            modeloUsuario = sc.nextLine();

            contador = 0;

            for (int i = 0; i < listaZapatosElegantes.size(); i++){

                if (listaZapatosElegantes.get(i).getModelo().equals(modeloUsuario)){
                     carritoCompra.add(modeloUsuario);
                     precioTotal += listaZapatosElegantes.get(i).getPrecio();
                     precioCompra.add(listaZapatosElegantes.get(i).getPrecio());
                } else {
                    contador++;
                }
            }

            if (contador==listaZapatosElegantes.size() && !modeloUsuario.equalsIgnoreCase("salir")){
                System.out.println("Ese modelo no se encuentra en la lista.");
            }

        }

        System.out.println(carritoCompra);
        System.out.println(precioTotal);

    }

    public static void casuales(ArrayList <Casual> listaZapatosCasuales, Scanner sc, ArrayList <String> carritoCompra, ArrayList <Double> precioCompra){
        
        System.out.println("Zapatos de tipo 'CASUALES' disponibles en tienda:");

        for (Casual zapatosE : listaZapatosCasuales) {
            System.out.println(zapatosE);
        }

        String modeloUsuario = "";

        int contador;
        double precioTotal = 0;
        
        while (!modeloUsuario.equalsIgnoreCase("salir")){
            System.out.println("¿Qué modelo quieres comprar? Pon 'salir' si no quieres añadir más modelos");
            modeloUsuario = sc.nextLine();

            contador = 0;

            for (int i = 0; i < listaZapatosCasuales.size(); i++){

                if (listaZapatosCasuales.get(i).getModelo().equals(modeloUsuario)){
                     carritoCompra.add(modeloUsuario);
                     precioTotal += listaZapatosCasuales.get(i).getPrecio();
                     precioCompra.add(listaZapatosCasuales.get(i).getPrecio());
                } else {
                    contador++;
                }
            }

            if (contador==listaZapatosCasuales.size() && !modeloUsuario.equalsIgnoreCase("salir")){
                System.out.println("Ese modelo no se encuentra en la lista.");
            }

        }

        System.out.println(carritoCompra);
        System.out.println(precioTotal);

    }

    public static void deportivos(ArrayList <Deporte> listaZapatosDeportivos, Scanner sc, ArrayList <String> carritoCompra, ArrayList <Double> precioCompra){
        
        System.out.println("Zapatos de tipo 'DEPORTIVOS' disponibles en tienda:");

        for (Deporte zapatosE : listaZapatosDeportivos) {
            System.out.println(zapatosE);
        }

        String modeloUsuario = "";

        int contador;
        double precioTotal = 0;
        
        while (!modeloUsuario.equalsIgnoreCase("salir")){
            System.out.println("¿Qué modelo quieres comprar? Pon 'salir' si no quieres añadir más modelos");
            modeloUsuario = sc.nextLine();

            contador = 0;

            for (int i = 0; i < listaZapatosDeportivos.size(); i++){

                if (listaZapatosDeportivos.get(i).getModelo().equals(modeloUsuario)){
                     carritoCompra.add(modeloUsuario);
                     precioTotal += listaZapatosDeportivos.get(i).getPrecio();
                     precioCompra.add(listaZapatosDeportivos.get(i).getPrecio());
                } else {
                    contador++;
                }
            }

            if (contador==listaZapatosDeportivos.size() && !modeloUsuario.equalsIgnoreCase("salir")){
                System.out.println("Ese modelo no se encuentra en la lista.");
            }

        }

        System.out.println(carritoCompra);
        System.out.println(precioTotal);
    }

    public static void mostrarResumen(ArrayList<String> carritoCompra, ArrayList <Double> precioCompra) {
        
        System.out.println("Resumen de la compra:");
        
        for (String zapatosCompleto : carritoCompra) {
            System.out.println(zapatosCompleto);
        }

        double costeTotal = 0;
        for (double precio : precioCompra) {
            costeTotal += precio; 
        }
        System.out.println("El coste total de la compra es: " + costeTotal);


        System.out.println("¡Hasta la próxima!");

    }

}
