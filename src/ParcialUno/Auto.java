package ParcialUno;

class Auto extends Vehiculo {

    public Auto(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
    }

    public double calcularTarifa(int horas) {
        return horas * 1000;
    }
    
    public int getEspacio() {
        return 2;
    }
    
}
