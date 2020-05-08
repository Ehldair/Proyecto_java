import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Fabrica {
	String nombreFabrica;
	double defaultRadio=5;
	int defaultTipo=0;
	double defaultPeso=3000;
	String defaultMaterial="FIBRA";
	int capacidadFabrica;
	Coche conjuntoCochesFabricados[];
	int numeroFabricados=0;
	public Fabrica(String nombre, double r, int t, double p, String m, int c) {
		nombreFabrica=nombre;
		defaultRadio=r;
		defaultTipo=t;
		defaultPeso=p;
		defaultMaterial=m;
		capacidadFabrica=c;
		conjuntoCochesFabricados=new Coche[capacidadFabrica];
	}
	public void setDefaultRadio(double r) {
		defaultRadio=r;
	}
	public double getDefaultRadio() {
		return defaultRadio;
	}
	public void setDefaultTipo(int t) {
		defaultTipo=t;
	}
	public int getDefaultTipo() {
		return defaultTipo;
	}
	public void setDefaultPeso(double p) {
		defaultPeso=p;
	}
	public double getDefaultPeso() {
		return defaultPeso;
	}
	public void setDefaultMaterial(String m) {
		defaultMaterial=m;
	}
	public String getDefaultMaterial() {
		return defaultMaterial;
	}
	public boolean iniciarFabricacion(int numeroCoches) {
		if(numeroCoches>capacidadFabrica) {
			return false;
		}
		else {	
			for (int x=numeroFabricados;x<numeroCoches+numeroFabricados;x++) {
				try {
					conjuntoCochesFabricados[x]=fabricarCoche();
				}
				catch(Exception e) {
					System.out.println("Error "+e);
					conjuntoCochesFabricados[x]=fabricarCoche();
				}
			}
			numeroFabricados=numeroFabricados+numeroCoches;
			return true;
		}
	}
	private Coche fabricarCoche() {
		Rueda r=new Rueda(defaultRadio, defaultTipo);
		Chasis c=new Chasis(defaultPeso, defaultMaterial);
		int color = (int) (Math.random()* 4);
		Coche defaultCoche=new Coche(r,c,color);
		return defaultCoche;
	}
	public String toString() {
		try {
			System.out.println("#########################");
			System.out.println("Fabrica: "+nombreFabrica);
			System.out.println("Numero actual de fabricados: "+numeroFabricados+"/"+conjuntoCochesFabricados.length);
			System.out.println("*************************");
			
			for(int x=0;x<numeroFabricados;x++) {
				int i=x+1;
				System.out.println("Coche"+i+ " color: "+conjuntoCochesFabricados[x].getColor());
				System.out.println (conjuntoCochesFabricados[x]);
				System.out.println("*************************");
			}
		}
		catch(Exception e) {
			System.out.println("No hay capacidad suficiente en la fábrica");	
		}
		return "";
	}
	
	public boolean retirarCoche(int numeroCoches) {
		if(numeroCoches>numeroFabricados) {
			return false;
		}
		else {
			for(int x=0;x<numeroCoches;x++) {
				sacarCoche(0);
			}
			numeroFabricados=numeroFabricados-numeroCoches;
			return true;
		}
	}
	
	public boolean retirarCoche(int numeroCoches,int color) {
		if(numeroCoches>numeroFabricados) {
			return false;
		}
		else {
			int posicion=0;
			int cochesDelColor=0;
			int posiciones[]=new int[numeroCoches];
			for(int i=0;i<numeroFabricados;i++) {
				
				if(conjuntoCochesFabricados[i].getColorInt()==color)  {
					cochesDelColor++;
					if(posicion<numeroCoches) {
						posiciones[posicion]=i;
						posicion++;
					}
					else {
						
					}
				}
			}
			
			if (cochesDelColor<numeroCoches) {
				return false;
			}
			else {
				System.out.println("Hay "+cochesDelColor+" coches del color seleccionado. Se procede a eliminar "+numeroCoches+" coches." );
				
			for(int x=0;x<posiciones.length;x++) {
				posiciones[x]=posiciones[x]-x;
				sacarCoche(posiciones[x]);
			}
			numeroFabricados=numeroFabricados-numeroCoches;
			return true;
			}
		}
	}
	
	
	private void sacarCoche(int numero) {
		ArrayList<Coche> lista = new ArrayList<>(Arrays.asList(conjuntoCochesFabricados));
		lista.remove(numero);
		conjuntoCochesFabricados = lista.toArray(new Coche[lista.size()+1]);
	}
	
}
