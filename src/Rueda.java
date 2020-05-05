public class Rueda {
	double radio;
	static int SECO=0;
	static int HUMEDO=1;
	static int NEVADO=2;
	int tipo;
	public Rueda(double r, int t) {
		radio=r;
		tipo=t;
		
	}
	public Rueda() {
		radio=1;
		tipo=0;
	}
	public String toString() {
		String t;
		if(tipo==0) {
			t="SECO";			
		}
		else if(tipo==1) {
			t= "HUMEDO";			
		}
		else {
			t= "NEVADO";	
		}
		return "[Radio: "+radio+", Tipo: "+t+"]";
		
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double r) {
		radio=r;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int t) {
		tipo=t;
	}
	
}
