package ParcialUno;

import java.util.ArrayList;

public class Garage {
	
	private int capacidadMaxima;
	private ArrayList<Vehiculo> vehiculos;
	
	//Constructor
	
	public Garage(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
		this.vehiculos = new ArrayList<>();
	}

	//Calcular espacio ocupado
	
	public int calcularEspacioOcupado() {
	    int total = 0;

	    for (Vehiculo v : vehiculos) {
	        total += v.getEspacio(); 
	    }

	    return total;
	}
	
	//Ingresar vehiculos y las validaciones
	public boolean ingresarVehiculo(Vehiculo v, int horas) {
		
		//Validar que haya espacio
		
		if(calcularEspacioOcupado() + v.getEspacio() > capacidadMaxima) {
			
			System.out.println("\n No hay ma espacio disponible.");
			return false;
		
		}
		
		//Validar que la aptente no este duplicada
		for (Vehiculo vehMatricula : vehiculos) {
			
			if (vehMatricula.matricula.equals(v.matricula)) {
				System.out.println("\n Patente duplicada, no se permite el ingreso.");
				return false;
			}
			
		}
		
		vehiculos.add(v);
		System.out.println("\n Se agrego el vehiculo correctamente: " + v.modelo);
		System.out.println("Ocupa: " + v.getEspacio());
		
		return true; //SACAR FALSE, ES DE TEST
	}
	
	//Retirar vehiculo
	public boolean retirarVehiculo(String matricula) {
		
		//Validar que el vehiculo este
	    for (Vehiculo v : vehiculos) {
	        
	        if (v.matricula.equals(matricula)) {
	            vehiculos.remove(v);
	            System.out.println("\nVehiculo retirado correctamente");
	            return true;
	        }
	    }

	    System.out.println("\nPatente no encontrada");
	    return false;
	}
	
	//Mostrar vehiculos
	
	public void mostrarVehiculos() {

	    if (vehiculos.isEmpty()) {
	        System.out.println("No hay vehiculos en el garage");
	        return;
	    }
	    
	    //Muestro la informacion de los vehiculos
	    for (Vehiculo v : vehiculos) {
	    	
	    	System.out.println("\n  ---   ");
	        System.out.println("Patente: " + v.matricula);
	        System.out.println("Marca: " + v.marca);
	        System.out.println("Modelo: " + v.modelo);
	        System.out.println("  ---   ");
	        
	    }
	    
	}
	
	//Calcular espacio garage
	public int calcularEspacioLibre() {
	    return capacidadMaxima - calcularEspacioOcupado();
	}
	
	//Estado general del agarage
	
	public void mostrarEstadoGarage() {
		
		System.out.println("\n --- ");
	    System.out.println("Capacidad total: " + capacidadMaxima);
	    System.out.println("Espacio ocupado: " + calcularEspacioOcupado());
	    System.out.println("Espacio libre: " + calcularEspacioLibre());
	    System.out.println("Cantidad de vehículos: " + vehiculos.size());
	    System.out.println(" --- ");
	}
	
	

}
