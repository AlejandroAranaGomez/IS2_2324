package es.unican.is2.franquiciasUCBusiness;

import es.unican.is2.franquiciasUCCommon.*;


public class GestionEmpleados implements IGestionEmpleados {
	
	private static ITiendasDAO itiendasDAO; 
	private static IEmpleadosDAO iempleadosDAO; 
	
	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		this.itiendasDAO = tiendasDAO;
		this.iempleadosDAO = empleadosDAO;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
