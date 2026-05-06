package ParcialUno;

import java.util.Scanner;

public class Main { //PRUEBA PARA GIT NO SUBIO EL COMMIT

    public static void main(String[] args) throws HorasInvalidasException, GarageLlenoException, PatenteDuplicadaException, VehiculoNoEncontradoException {
        Scanner input = new Scanner(System.in);
        Garage garageUno = new Garage(20);
        int opcion = 0;
        int tipo;
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
           
            
            try {
            	
                opcion = input.nextInt();
                input.nextLine(); //Limpiamos buffer
                
            } catch (Exception e) {
            	
                System.out.println("Error: debe ingresar un numero.");
                input.nextLine();//Limpiamos buffer
                continue;
                
            }

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Tipo: 1-Auto (2 esp) | 2-Moto (1 esp) | 3-Camion (4 esp)");
                        tipo = input.nextInt();
                        input.nextLine();
                        
                        while(tipo < 1 || tipo > 3) {
                        	System.out.println("Tipo: 1-Auto (2 esp) | 2-Moto (1 esp) | 3-Camion (4 esp)");
                            tipo = input.nextInt();
                            input.nextLine();
                        }
                        
                        System.out.print("Patente: ");
                        String matricula = input.nextLine();

                        System.out.print("Marca: ");
                        String marca = input.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();

                        System.out.print("Horas estimadas: ");
                        horas = input.nextInt();
                        input.nextLine();

                        //Validacin con excepción
                        if (horas <= 0) {
                            throw new HorasInvalidasException("Las horas deben ser mayor a 0");
                        }

                        Vehiculo nuevo = null;

                        if (tipo == 1) nuevo = new Auto(matricula, marca, modelo);
                        else if (tipo == 2) nuevo = new Moto(matricula, marca, modelo);
                        else if (tipo == 3) nuevo = new Camion(matricula, marca, modelo);

                        if (nuevo == null) {
                            System.out.println("Tipo de vehículo inválido.");
                            break;
                        }

                        nuevo.setHorasEstimadas(horas);

                        garageUno.ingresarVehiculo(nuevo);

                        System.out.println("Costo proyectado: $" + nuevo.calcularTarifa(horas));

                    } catch (HorasInvalidasException | GarageLlenoException | PatenteDuplicadaException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 2:
                	
                    System.out.print("Ingrese patente a retirar: ");
                    
                    String patRetirar = input.nextLine();

                    try {
                        garageUno.retirarVehiculo(patRetirar);
                        
                    } catch (VehiculoNoEncontradoException e) {
                    	
                        System.out.println("Error: " + e.getMessage());
                        
                    }
                    
                    break;
                    
                case 3:
                    garageUno.mostrarVehiculos();
                    break;

                case 4:
                    garageUno.mostrarEstadoGarage();
                    break;

                case 5:
                	garageUno.generarReporte(false);
                	break;
                	
                case 6:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
        }
        
     
        garageUno.generarReporte(true);
        System.out.println("¡Hasta luego!");
        input.close();
        
    }
}