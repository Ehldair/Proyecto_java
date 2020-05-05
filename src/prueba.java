public class prueba {

	public static void main(String[] args) {		
		
		Rueda ruedaDefault=new Rueda();
	
		Chasis chasisCustom=new Chasis(2500, Chasis.MATERIAL2);
	
	
		Coche coche1=new Coche(ruedaDefault,chasisCustom,Coche.AZUL);
		System.out.println(coche1);
	}

}