package ParcialUno;

class Camion extends Vehiculo {

    public Camion(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
    }

    public double calcularTarifa(int horas) {
        return horas * 1500;
    }
    
    public int getEspacio() {
        return 4;
    }
    
}