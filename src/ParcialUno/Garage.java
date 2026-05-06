package ParcialUno;

import java.util.ArrayList;

public class Garage {
    private int capacidadMaxima;
    private ArrayList<Vehiculo> vehiculos;
    private double recaudacionTotal = 0;
    //Contadores
    private int cantAutos = 0;
    private int cantMotos = 0;
    private int cantCamiones = 0;
    double recaudacionAutos= 0 ;
    double recaudacionMotos= 0;
    double recaudacionCamiones= 0;
    
    
    public Garage(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();
    }

    public int calcularEspacioOcupado() {
        int total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.getEspacio();
        }
        return total;
    }

    //INGRESAR VEHICULO CON LAS EXCEPCIONES 
    public boolean ingresarVehiculo(Vehiculo v) 
            throws GarageLlenoException, PatenteDuplicadaException {

        if (calcularEspacioOcupado() + v.getEspacio() > capacidadMaxima) {
            throw new GarageLlenoException("No hay espacio disponible.");
        }

        for (Vehiculo veh : vehiculos) {
            if (veh.matricula.equalsIgnoreCase(v.matricula)) {
                throw new PatenteDuplicadaException("Patente duplicada: " + v.matricula);
            }
        }
        
        System.out.println("\nVehiculo ingresado con exito: " + v.matricula + ", " + v.marca + ", " + v.modelo);
        vehiculos.add(v);
        return true;
    }

    //RETIRAR VEHICULO CON LAS EXCEPCIONES
    public void retirarVehiculo(String matricula) 
            throws VehiculoNoEncontradoException {

        Vehiculo encontrado = null;

        for (Vehiculo v : vehiculos) {
            if (v.matricula.equalsIgnoreCase(matricula)) {
                encontrado = v;
                break;
            }
        }

        if (encontrado == null) {
            throw new VehiculoNoEncontradoException("Vehículo no encontrado.");
        }

        int horas = encontrado.getHorasEstimadas();
        double pagar = encontrado.calcularTarifa(horas);
        
     // acumulador de vehiculos para generar el reporte final
        if (encontrado instanceof Auto) {
            cantAutos++;
            recaudacionAutos += pagar;
        } else if (encontrado instanceof Moto) {
            cantMotos++;
            recaudacionMotos += pagar;
        } else if (encontrado instanceof Camion) {
            cantCamiones++;
            recaudacionCamiones += pagar;
        }
        
        recaudacionTotal += pagar;
        vehiculos.remove(encontrado);

        System.out.println("Total a pagar: $" + pagar);
    }

    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("\nEl garage está vacío.");
            return;
        }
        System.out.println("\n--- Lista de Vehículos ---");
        for (Vehiculo v : vehiculos) {
            System.out.println("Patente: " + v.matricula + " | Marca: " + v.marca + " | Modelo: " + v.modelo);
        }
    }

    public void mostrarEstadoGarage() {
        int ocupado = calcularEspacioOcupado();
        System.out.println("\n--- Estado del Garage ---");
        System.out.println("Capacidad Total: " + capacidadMaxima);
        System.out.println("Espacio Ocupado: " + ocupado);
        System.out.println("Espacio Libre: " + (capacidadMaxima - ocupado));
        System.out.println("Vehículos: " + vehiculos.size());
    }

    
    public void generarReporte(boolean esCierreFinal) {
        String titulo = esCierreFinal ? "CIERRE DE SESIÓN (FINAL)" : "REPORTE PARCIAL DE CAJA";
        
        // calculo de recaudacion proyectada 
        double recaudacionEnCurso = 0;
        for (Vehiculo v : vehiculos) {
            recaudacionEnCurso += v.calcularTarifa(v.getHorasEstimadas());
        }

        System.out.println("\n********** " + titulo + " **********");
        System.out.println("CAJA REAL (Vehiculos que salieron):");
        System.out.println("- Autos: " + cantAutos + " | Subtotal: $" + recaudacionAutos);
        System.out.println("- Motos: " + cantMotos + " | Subtotal: $" + recaudacionMotos);
        System.out.println("- Camiones: " + cantCamiones + " | Subtotal: $" + recaudacionCamiones);
        System.out.println("TOTAL EN CAJA: $" + recaudacionTotal);
        
        if (!esCierreFinal) {
            System.out.println("--------------------------------------");
            System.out.println("GANANCIA PROYECTADA (Vehículos adentro):");
            System.out.println("- Total a cobrar: $" + recaudacionEnCurso);
            System.out.println("- Total Estimado (Caja + Proyectado): $" + (recaudacionTotal + recaudacionEnCurso));
            System.out.println("Estado: El garage sigue operativo.");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Estado: Sesión finalizada correctamente.");
        }
        System.out.println("**************************************");
    }
    
}