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

    public void imprimirCierreDeCaja() {
        System.out.println("\n********** CIERRE DE SESIÓN **********");
        System.out.println("Recaudación total acumulada: $" + recaudacionTotal);
        System.out.println("**************************************");
    }
}