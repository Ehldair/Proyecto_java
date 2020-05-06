public class prueba {

	public static void main(String[] args) {		
		
		Rueda ruedaDefault=new Rueda();
		Rueda ruedaCustom=new Rueda(7,3);
	
		Chasis chasisCustom=new Chasis(2500, Chasis.MATERIAL2);
		Chasis chasis2=new Chasis(3000, Chasis.MATERIAL3);
	
	
		Coche coche1=new Coche(ruedaDefault,chasisCustom,Coche.AZUL);
		
		coche1.setRueda(ruedaCustom, 1);
		coche1.setColor(1);
		coche1.setChasis(chasis2);
		
		Fabrica fabrica=new Fabrica("CHAPAHENAR",Rueda.HUMEDO,0,3000,Chasis.MATERIAL4, 10);
		boolean b=fabrica.iniciarFabricacion(5);
		System.out.println(fabrica);
		fabrica.retirarCoche(3);
		System.out.println(fabrica);
	}

}