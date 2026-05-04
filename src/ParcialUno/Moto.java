package ParcialUno;

class Moto extends Vehiculo {

    public Moto(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
    }

    public double calcularTarifa(int horas) {
        return horas * 700;
    }
    
    public int getEspacio() {
        return 1;
    }
    
}

