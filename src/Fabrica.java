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
		conjuntoCochesFabricados=new Coche[numeroCoches];
		if(numeroCoches>capacidadFabrica) {
			return false;
		}
		else {	
			for (int x=0;x<numeroCoches;x++) {
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
			System.out.println("Numero actual de fabricados: "+conjuntoCochesFabricados.length);
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
		}
		return "";
	}
	
	public boolean retirarCoche(int numeroCoches) {
		if(numeroCoches>conjuntoCochesFabricados.length) {
			return false;
		}
		else {
			sacarCoche(numeroCoches);
			return true;
		}
	}
	private void sacarCoche(int numeroCoches) {
		Coche conjuntoCochesFabricados2[];
		int resto=conjuntoCochesFabricados.length-numeroCoches;
		conjuntoCochesFabricados2=new Coche[resto];
		System.out.println("tamaño2:"+conjuntoCochesFabricados2.length);
		System.arraycopy(conjuntoCochesFabricados,resto+1,conjuntoCochesFabricados2,0,resto);
		conjuntoCochesFabricados=conjuntoCochesFabricados2;
		
	}
	
	
}
