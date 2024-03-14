package es.unican.is2.franquiciasUCBusiness;


import es.unican.is2.franquiciasUCCommon.*;

public class GestionTiendas implements IGestionTiendas {
	
	 private ITiendasDAO itiendasDAO;
	 
	public GestionTiendas(ITiendasDAO tiendasDAO) {
		this.itiendasDAO = tiendasDAO;
	}

	@Override
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		
		if (itiendasDAO.tiendas().contains(t)) {
			return null;
		}
		
		itiendasDAO.crearTienda(t);
		return t;
	}

	@Override
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda tienda = tienda(nombre);
		if (tienda == null) {
			return null;
		}
		
		if (!tienda.getEmpleados().isEmpty()) {
			throw new OperacionNoValidaException(nombre);
		}
		
		return itiendasDAO.eliminarTienda(tienda.getId());
	}

	@Override
	public Tienda tienda(String nombre) throws DataAccessException {
		return itiendasDAO.tiendaPorNombre(nombre);
	}

	 

}
