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
	public Fabrica(String nombre, double r, int t, double p, String m, int c) {
		nombreFabrica=nombre;
		defaultRadio=r;
		defaultTipo=t;
		defaultPeso=p;
		defaultMaterial=m;
		capacidadFabrica=c;
		conjuntoCochesFabricados=new Coche[0];
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
		Coche[] conjuntoCochesFabricados2=new Coche[0];
		if(conjuntoCochesFabricados.length+numeroCoches>capacidadFabrica) {
			return false;
		}
		else {	
			if(conjuntoCochesFabricados.length==0) {
				conjuntoCochesFabricados=new Coche[numeroCoches];
			}
			else {
			conjuntoCochesFabricados2=conjuntoCochesFabricados; 
			conjuntoCochesFabricados=new Coche[conjuntoCochesFabricados2.length+numeroCoches];
				for(int x=0;x<conjuntoCochesFabricados2.length;x++) {
				conjuntoCochesFabricados[x]=conjuntoCochesFabricados2[x];
				}
			}
			for (int x=conjuntoCochesFabricados2.length;x<conjuntoCochesFabricados.length;x++) {
				try {
					conjuntoCochesFabricados[x]=fabricarCoche();
				}
				catch(Exception e) {
					System.out.println("Error "+e);
					conjuntoCochesFabricados[x]=fabricarCoche();
				}
			}
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
			System.out.println("Numero actual de fabricados: "+conjuntoCochesFabricados.length+"/"+capacidadFabrica);
			System.out.println("*************************");
			for(int x=0;x<conjuntoCochesFabricados.length;x++) {
				int i=x+1;
				System.out.println("Coche"+i+ " color: "+conjuntoCochesFabricados[x].getColor());
				System.out.println (conjuntoCochesFabricados[x]);
				System.out.println("*************************");
			}
		}
		catch(Exception e) {
			System.out.println("No hay capacidad suficiente en la fábrica");	
			System.out.println("Error "+e);
		}
		return "";
	}
	
	public boolean retirarCoche(int numeroCoches) {
		if(numeroCoches>conjuntoCochesFabricados.length) {
			return false;
		}
		else {
			for(int x=0;x<numeroCoches;x++) {
				sacarCoche(0);
			}
			return true;
		}
	}
	
	public boolean retirarCoche(int numeroCoches,int color) {
		if(numeroCoches>conjuntoCochesFabricados.length) {
			return false;
		}
		else {
			int posicion=0;
			int cochesDelColor=0;
			int posiciones[]=new int[numeroCoches];
			for(int i=0;i<conjuntoCochesFabricados.length;i++) {
				
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
			return true;
			}
		}
	}
	
	
	private void sacarCoche(int numero) {
		ArrayList<Coche> lista = new ArrayList<>(Arrays.asList(conjuntoCochesFabricados));
		lista.remove(numero);
		conjuntoCochesFabricados = lista.toArray(new Coche[lista.size()]);
	}
	
}
