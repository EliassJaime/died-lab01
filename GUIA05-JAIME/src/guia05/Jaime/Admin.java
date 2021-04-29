package guia05.Jaime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import excepciones.NoEntregaAlquiler;


public class Admin {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
		
		String fecha1="28/04/2021";
		String fecha2="29/04/2021";
		String fecha3="08/05/2021";
		String fecha4="11/05/2021";
		String fecha5="12/05/2021";
		
		Oficio o1= new Oficio("CARPINTERIA",1);
		Oficio o2= new Oficio("CERRAJERIA",2);
		Oficio o3= new Oficio("GASISTA",3);
		Oficio o4= new Oficio("REPARACION ELECTRODOMESTICOS",4);
		Oficio o5= new Oficio("ALBAÑILERIA",5);
		
		Trabajador t1=new Trabajador("Jose", "Jose@hotmail.com", o1, 5.0, 0.15);
		Trabajador t2=new Trabajador("Diego", "diego@hotmail.com", o2, 7.0, 0.05);
		Trabajador t3=new Trabajador("Miguel", "miguel@hotmail.com", o3, 3.5, 0.35);
		Trabajador t4=new Trabajador("Pablo", "pablo@hotmail.com", o4, 4.0, 0.1);
		Trabajador t5=new Trabajador("Pedro", "pedro@hotmail.com", o5, 5.0, 0.3);
		
		Servicio s1= new Estandar(25.0, o1);
		Servicio s2= new Estandar(22.0, o2);
		Servicio s3= new Personalizado(60.0, 15.0, 5.0, o3); 
		
		Herramienta h1= new Herramienta("Martillo",5.0);
		Herramienta h2= new Herramienta("Taladro",7.0);
		Herramienta h3= new Herramienta("Cinta Metrica",3.5);
		
		
		
		Alquiler a1= new Alquiler(h1, sf.parse(fecha1).toInstant(), sf.parse(fecha4).toInstant());
		Alquiler a2= new Alquiler(h2, sf.parse(fecha1).toInstant(), sf.parse(fecha4).toInstant());
		Alquiler a3= new Alquiler(h3, sf.parse(fecha1).toInstant(), sf.parse(fecha4).toInstant());
		
		
		
		//*********************************************************************//
		//************Agrego e imprimo trabajo con servicio estandar*************//
		//*********************************************************************//
	
		
		
		Trabajo trabajo1=Trabajo.crearTrabajo(t1, s1, false, (sf.parse(fecha1)).toInstant());
        trabajo1.setHorasTrabajo(5.0); 
        trabajo1.setFechaFin((sf.parse(fecha3)).toInstant()); 
		
		Usuario user= new Usuario("pepe","pepe@hotmail.com");
		
		try {
			user.contratar(trabajo1);
		} catch (NoEntregaAlquiler e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(user.getServiciosContratados().get(0));
		
		
		//*********************************************************************//
	   //************Agrego e imprimo trabajo con servicio Personalizado*************//
	    //*********************************************************************//
		System.out.println();
		
		Trabajo trabajo4=Trabajo.crearTrabajo(t3, s3, true, (sf.parse(fecha1)).toInstant());
        trabajo4.setHorasTrabajo(8.2); 
        trabajo4.setFechaFin((sf.parse(fecha4)).toInstant()); 
		

		try {
			user.contratar(trabajo4);
		} catch (NoEntregaAlquiler e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println( user.getServiciosContratados().get(1));
		
		
		
		//*********************************************************************//
		//********************OficioNoCoincideException *****************//
		//*********************************************************************//
		System.out.println();
	
		Trabajo trabajo2=Trabajo.crearTrabajo(t1, s2, false, (sf.parse(fecha2)).toInstant());
		

		//*********************************************************************//
		//********************AgendaOcupadaException *****************//
		//*********************************************************************//
		System.out.println();
	
		Trabajo trabajo3=Trabajo.crearTrabajo(t1, s1, false, (sf.parse(fecha1)).toInstant());
		
		
		//*********************************************************************//
		//********************Imprimir Alquiler*****************//
		//*********************************************************************//
	System.out.println();
		try {
			user.contratar(a1);
		} catch (NoEntregaAlquiler e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(user.getServiciosContratados().get(2));
		
		
		
		
		//*********************************************************************//
		//********************AlquilerNoEntregadoException*****************//
	    //*********************************************************************//
		System.out.println();
		try {
			user.contratar(a2);
			user.contratar(a3);
		} catch (NoEntregaAlquiler e) {
			System.out.println(e.getMessage());
		}
		
		//*********************************************************************//
		//********************Metodo enMora clase Alquiler*****************//
	    //*********************************************************************//
		System.out.println();
		
		((Alquiler)user.getServiciosContratados().get(2)).setFechaDevolucion(sf.parse(fecha5).toInstant());
		
		System.out.println(((Alquiler)user.getServiciosContratados().get(2)).enMora());
		
	

		//*********************************************************************//
		//********************Metodo finalizado para clasesContratable*****************//
	    //*********************************************************************//
		System.out.println();
		for(Contratable c:user.getServiciosContratados()) {
			System.out.println(c.getClass().getName()+"  "+c.finalizado());
		}
		
		
		
		
		
	}

}