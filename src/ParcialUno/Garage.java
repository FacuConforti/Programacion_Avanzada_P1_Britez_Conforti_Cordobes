package ParcialUno;

import java.util.ArrayList;

public class Garage {
    private int capacidadMaxima;
    private ArrayList<Vehiculo> vehiculos;
    private double recaudacionTotal = 0;

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

    public boolean ingresarVehiculo(Vehiculo v) {
        // Validar espacio
        if (calcularEspacioOcupado() + v.getEspacio() > capacidadMaxima) {
            System.out.println("\nError: No hay espacio disponible para este vehículo.");
            return false;
        }

        // Validar patente duplicada
        for (Vehiculo veh : vehiculos) {
            if (veh.matricula.equalsIgnoreCase(v.matricula)) {
                System.out.println("\nError: La patente " + v.matricula + " ya está en el garage.");
                return false;
            }
        }

        vehiculos.add(v);
        System.out.println("\nVehículo ingresado con éxito: " + v.modelo);
        return true;
    }

    public void retirarVehiculo(String matricula) {
        Vehiculo encontrado = null;

        // Buscamos el vehículo primero
        for (Vehiculo v : vehiculos) {
            if (v.matricula.equalsIgnoreCase(matricula)) {
                encontrado = v;
                break; 
            }
        }

        if (encontrado != null) {
            // Obtenemos las horas que guardamos al ingresar
            int horas = encontrado.getHorasEstimadas();
            double pagar = encontrado.calcularTarifa(horas);
            
            recaudacionTotal += pagar;
            vehiculos.remove(encontrado); // Borramos fuera del bucle
            
            System.out.println("\nVehículo con patente " + matricula + " retirado.");
            System.out.println("Total a pagar por " + horas + " horas: $" + pagar);
        } else {
            System.out.println("\nError: Vehículo no encontrado.");
        }
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

    public void imprimirCierreDeCaja() {
        System.out.println("\n********** CIERRE DE SESIÓN **********");
        System.out.println("Recaudación total acumulada: $" + recaudacionTotal);
        System.out.println("**************************************");
    }
}