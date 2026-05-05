package ParcialUno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Garage garageUno = new Garage(20);
        int opcion = 0;
        int horas;
        
        while (opcion != 6) {
            System.out.println("\n===== SISTEMA DE GARAGE =====");
            System.out.println("1 - Ingresar vehículo");
            System.out.println("2 - Retirar vehículo");
            System.out.println("3 - Listar vehículos");
            System.out.println("4 - Estado de ocupación");
            System.out.println("5 - Reporte");
            System.out.println("6 - Salir");
            System.out.print("Seleccione una opción: ");
           
            
            opcion = input.nextInt();
            input.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Tipo: 1-Auto (2 esp) | 2-Moto (1 esp) | 3-Camion (4 esp)");
                    int tipo = input.nextInt();
                    input.nextLine();

                    System.out.print("Patente: ");
                    String matricula = input.nextLine();
                    System.out.print("Marca: ");
                    String marca = input.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = input.nextLine();
                    System.out.print("Horas estimadas: ");
                    horas = input.nextInt();
                    
                    while (horas <= 0) {
                    	
                    	System.out.print("Error. Las horas deben ser mayor a 0");
                    	System.out.print("Horas estimadas: ");
                        horas = input.nextInt();
                    	
                    }
                    
                    input.nextLine();

                    Vehiculo nuevo = null;
                    if (tipo == 1) nuevo = new Auto(matricula, marca, modelo);
                    else if (tipo == 2) nuevo = new Moto(matricula, marca, modelo);
                    else if (tipo == 3) nuevo = new Camion(matricula, marca, modelo);

                    if (nuevo != null) {
                        nuevo.setHorasEstimadas(horas); 
                        boolean exito = garageUno.ingresarVehiculo(nuevo);
                        if (exito) {
                            System.out.println("Costo proyectado: $" + nuevo.calcularTarifa(horas));
                        }
                    } else {
                        System.out.println("Tipo de vehículo inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese patente a retirar: ");
                    String patRetirar = input.nextLine();
                    garageUno.retirarVehiculo(patRetirar);
                    break;

                case 3:
                    garageUno.mostrarVehiculos();
                    break;

                case 4:
                    garageUno.mostrarEstadoGarage();
                    break;

                case 5:
                    garageUno.imprimirCierreDeCaja();
                    break;

                case 6:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
        }
        
        garageUno.imprimirCierreDeCaja();
        System.out.println("¡Hasta luego!");
        input.close();
        
    }
}