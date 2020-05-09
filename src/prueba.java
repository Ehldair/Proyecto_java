public class prueba {

	public static void main(String[] args) {		
		boolean b;
		Rueda ruedaDefault=new Rueda();
		Rueda ruedaCustom=new Rueda(7,3);
	
		Chasis chasisCustom=new Chasis(2500, Chasis.MATERIAL2);
		Chasis chasis2=new Chasis(3000, Chasis.MATERIAL3);
	
	
		Coche coche1=new Coche(ruedaDefault,chasisCustom,Coche.AZUL);
		
		coche1.setRueda(ruedaCustom, 1);
		coche1.setColor(1);
		coche1.setChasis(chasis2);
		
		Fabrica fabrica=new Fabrica("CHAPAHENAR",Rueda.HUMEDO,0,3000,Chasis.MATERIAL4, 15);
		if(fabrica.iniciarFabricacion(8)==false) {
			System.out.println("Error de capacidad");
		}
		else {
			System.out.println(fabrica);
		}
		if(fabrica.iniciarFabricacion(2)==false) {
			System.out.println("Error de capacidad");
		}
		else {
			System.out.println(fabrica);
		}
		if(fabrica.iniciarFabricacion(5)==false) {
			System.out.println("Error de capacidad");
		}
		else {
			System.out.println(fabrica);
		}
		if(fabrica.retirarCoche(3)==false) {
			System.out.println("No hay coches suficientes");
		}
		else {
			System.out.println(fabrica);
		}
		if(fabrica.retirarCoche(3,2)==false) {
			System.out.println("No hay coches suficientes");
		}
		else {
			System.out.println(fabrica);
		}

	
	
		

	}

}