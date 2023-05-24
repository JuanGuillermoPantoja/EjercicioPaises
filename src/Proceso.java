import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.Map;


public class Proceso {
	public void iniciar() {

		String menu="GESTION PAISES\n";
			   menu+="1. Registrar pais\n";
		       menu+="2. Registrar ciudades\n";
		       menu+="3. consultar ciudades por pais\n";
		       menu+="4. consultar ciudad\n";
		       menu+="5. Salir\n";
		       menu+="Ingrese una opcion:\n";
		       
	    int opc=0;
		do {
				opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
		        validarMenu(opc);

		} while (opc!=5);
	}
	
	HashMap<String, ArrayList<String>> listCountries = new HashMap<String, ArrayList<String>>();
	
	public void validarMenu(int opc) {

        switch (opc) {
        case 1:
        	 agregarPais();
             break;
        case 2:
        	agregarCiudad();
             break;
        case 3:
        	buscarPorPais();
             break;
        case 4:
        	buscarCiudad();
            break;
        case 5:
            System.out.println("Salio!");
            break;

        default:
            System.out.println("Ingrese una opcion valida");
            break;
        }

	}
	
	public void agregarPais() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del pais");
		ArrayList<String> listaCiudades = new ArrayList<String>();
		listCountries.put(name, listaCiudades);
		
	}
	
	public void agregarCiudad() {
		String country = JOptionPane.showInputDialog("Ingrese el pais donde desea registrar una ciudad");
		if(listCountries.containsKey(country)) {
			String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
			listCountries.get(country).add(city);
			System.out.println(listCountries);
		}
		else {
			JOptionPane.showMessageDialog(null, "El pais no se ecuentra registrado");
		}
	}
	
	public void buscarPorPais() {
		String country = JOptionPane.showInputDialog("Ingrese el pais donde desea registrar una ciudad");
		if(listCountries.containsKey(country)) {
			System.out.println("Pais: " + country + "\n");
			for (int i = 0; i < listCountries.get(country).size() ; i++) {
				System.out.println(listCountries.get(country).get(i));
			}
		}
	}
	
	public void buscarCiudad() {
		String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
		
		for (Map.Entry<String, ArrayList<String>> entry : listCountries.entrySet()) {
            String clave = entry.getKey();
            ArrayList<String> lista = entry.getValue();
            if(lista.contains(city)) {
            	System.out.println(city + " se encontro en " + clave);
            }
        }	
	}
}

