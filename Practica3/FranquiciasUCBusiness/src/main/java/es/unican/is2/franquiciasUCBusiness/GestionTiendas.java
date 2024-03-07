package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.*;

public class GestionTiendas implements IGestionTiendas {
	
	 private static ITiendasDAO itiendasDAO; 
	
	public GestionTiendas(ITiendasDAO itiendasDAO) {
		this.itiendasDAO = itiendasDAO;
	}

	@Override
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tienda tienda(String nombre) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	 

}
