package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.*;


public class GestionEmpleados implements IGestionEmpleados {
	
	private ITiendasDAO itiendasDAO; 
	private IEmpleadosDAO iempleadosDAO; 
	
	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		this.itiendasDAO = tiendasDAO;
		this.iempleadosDAO = empleadosDAO;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		
		Tienda tienda = itiendasDAO.tiendaPorNombre(nombre);
		Empleado empleado = iempleadosDAO.empleado(e.getDNI());
		
		if (tienda == null) {
			return null;
		}
		
		if (empleado != null) {
			throw new OperacionNoValidaException(e.getNombre());
		}
		
		return iempleadosDAO.crearEmpleado(empleado);
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		
		Tienda tienda = itiendasDAO.tiendaPorNombre(nombre);
		Empleado empleado = iempleadosDAO.empleado(dni);
		
		if (tienda == null || empleado == null) {
			return null;
		}
		
		if (!tienda.getEmpleados().contains(empleado)) {
			throw new OperacionNoValidaException(empleado.getNombre());
		}
		
		
		tienda.getEmpleados().remove(empleado);
	
		return empleado;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		Tienda tiendaActual = itiendasDAO.tiendaPorNombre(actual);
		Tienda tiendaDestino = itiendasDAO.tiendaPorNombre(destino);
		Empleado empleado = iempleadosDAO.empleado(dni);
		
		if (tiendaActual == null || tiendaDestino == null || empleado == null) {
			return false;
		}
		
		if (!tiendaActual.getEmpleados().contains(empleado)) {
			throw new OperacionNoValidaException(empleado.getNombre());
		}
		
		tiendaActual.getEmpleados().remove(empleado);
		tiendaDestino.getEmpleados().add(empleado);
		
		return true;
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		
		return iempleadosDAO.empleado(dni);
	}
	
	

}
