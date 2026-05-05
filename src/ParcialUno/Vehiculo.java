package ParcialUno;

public abstract class Vehiculo implements CalculoHoras {
	
	protected String matricula;
    protected String marca;
    protected String modelo;
    private int horasEstimadas;
    
    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }
        
    public abstract int getEspacio();
    
    public void setHorasEstimadas(int horas) { 
		this.horasEstimadas = horas;	
	}
	
	public int getHorasEstimadas(){
		return this.horasEstimadas;
	}
}
