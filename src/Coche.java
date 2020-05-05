
import java.util.Arrays; 

public class Coche {
	static int ROJO=0;
	static int AZUL=1;
	static int AMARILLO=2;
	static int BLANCO=3;
	Rueda conjuntoRuedas[]=new Rueda[4];
	Chasis chasis;
	int color;
	
	public Coche(Rueda ru,Chasis ch,int co) {
		for (int x=0;x<conjuntoRuedas.length;x++) {
			conjuntoRuedas[x]=ru;
		}
		chasis=ch;
		color=co;
	}
	public String toString() {
		String c;
		if(color==0) {
			c ="ROJO";
			
		} else if(color==1) {
			c ="AZUL";
		} else if(color==2) {
			c ="AMARILLO";
		} else {
			c ="BLANCO";
		}
		return "Coche [conjuntoRuedas=[Rueda "+Arrays.toString(conjuntoRuedas)+",chasis=Chasis "+chasis.toString()+", color= "+c;


	}
}
