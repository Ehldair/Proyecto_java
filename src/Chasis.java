
public class Chasis {
	double peso;
	static String MATERIAL1="ALUMINIO";
	static String MATERIAL2="ACERO";
	static String MATERIAL3="HIERRO";
	static String MATERIAL4="FIBRA";
	String material;
	
	public Chasis(double p, String m) {
		peso=p;
		material=m;
	}
	public Chasis() {
		peso=1000;
		material="ALUMINIO";
	}
	
	public String toString() {
		String m;
		if(material=="ALUMINIO") {
			m= "ALUMINIO";
		} else if (material=="ACERO") {
			m= "ACERO";
		} else if (material=="HIERRO") {
			m= "HIERRO";
		} else {
			m= "FIBRA";
		}
		return "[Peso= "+peso+", Material= "+m+"]";
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double p) {
		peso=p;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String m) {
		material=m;
	}
}
