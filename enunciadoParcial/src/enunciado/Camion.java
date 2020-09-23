package enunciado;
import enunciado.Vehiculo;
import enunciado.Carga;
import enunciado.SobrepesoException;

public class Camion extends Vehiculo {
	private Boolean tieneAcoplado;

	
	public Camion(String patente, String nombreTitular, String apellidoTitular, Integer pesoMaximo,
			Boolean tieneAcoplado) {
		super(patente, nombreTitular, apellidoTitular, pesoMaximo);
		this.tieneAcoplado = tieneAcoplado;
	}

	/*
	 * �Permite agregar una carga. Si el camion tiene acoplado permite almacenar el doble de su cargaMAxima.
	 * y sino tiene acoplado solo permite el cargaMAxima. En caso que que la carga a cargar supere el peso maximo
	 * retorna una excepcion SobrepesoException
	 */
	
	@Override
	public Boolean agregarCarga(Carga carga) throws SobrepesoException {
		
		Integer pesoCargado = obtenerPesoCargado();
		
		if(tieneAcoplado){
			setPesoMaximo(getPesoMaximo()*2);
		}
		if(pesoCargado + carga.getPeso() <=getPesoMaximo()){
			super.getCargas().add(carga);
			return true;
		}
		
		throw new SobrepesoException ("El vehiculo ha excedido su peso maximo");
}

	public Boolean getTieneAcoplado() {
		return tieneAcoplado;
	}

	public void setTieneAcoplado(Boolean tieneAcoplado) {
		this.tieneAcoplado = tieneAcoplado;
	}
	
	
}
