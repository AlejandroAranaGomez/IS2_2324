package es.unican.is2.franquiciasUCCommon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	
	private Empleado empleado;
	
	
	
	
	@Test 
	public void testConstructor() throws NullPointerException, OperacionNoValidaException {  
		
		//Casos de prueba validos
		empleado = new Empleado("10203040A", "Carlos", Categoria.ENCARGADO, LocalDate.now()); 
		
		assertEquals("10203040A", empleado.getDNI());
		assertEquals("Carlos", empleado.getNombre()); 
		assertEquals(Categoria.ENCARGADO, empleado.getCategoria());
		assertEquals(LocalDate.now(), empleado.getFechaContratacion());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.VENDEDOR, LocalDate.now()); 
		
		assertEquals("10203040A", empleado.getDNI());
		assertEquals("Carlos", empleado.getNombre()); 
		assertEquals(Categoria.VENDEDOR, empleado.getCategoria());
		assertEquals(LocalDate.now(), empleado.getFechaContratacion());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.AUXILIAR, LocalDate.now()); 
		
		assertEquals("10203040A", empleado.getDNI());
		assertEquals("Carlos", empleado.getNombre()); 
		assertEquals(Categoria.AUXILIAR, empleado.getCategoria());
		assertEquals(LocalDate.now(), empleado.getFechaContratacion());
		
		//Casos de pruebas no validos
		
		assertThrows(NullPointerException.class, () -> new Empleado(null, "Carlos", Categoria.AUXILIAR, LocalDate.now()));
		
		assertThrows(NullPointerException.class, () -> new Empleado("10203040A", null, Categoria.AUXILIAR, LocalDate.now()));
		
		assertThrows(NullPointerException.class, () -> new Empleado("10203040A", "Carlos", null, LocalDate.now()));
		
		assertThrows(NullPointerException.class, () -> new Empleado("10203040A", "Carlos", Categoria.AUXILIAR, null));
		
		assertThrows(OperacionNoValidaException.class, () -> new Empleado("10203040A", "Carlos", Categoria.AUXILIAR, LocalDate.now().plusDays(1)));
		}
	
	@Test
	public void testSueldoBruto() throws NullPointerException, OperacionNoValidaException {
		
		//Casos de prueba validos
		empleado = new Empleado("10203040A", "Carlos", Categoria.ENCARGADO, LocalDate.now());
		empleado.darDeBaja();
		
		assertEquals(1500.0, empleado.sueldoBruto());
		
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.VENDEDOR, LocalDate.now().minusYears(2));
		
		assertEquals(1500.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.AUXILIAR, LocalDate.now().minusYears(5));
		
		assertEquals(1000.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.ENCARGADO, LocalDate.now().minusYears(5).minusDays(1));
		
		assertEquals(2050.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.VENDEDOR, LocalDate.now().minusYears(7));
		
		assertEquals(1550.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.AUXILIAR, LocalDate.now().minusYears(10));
		
		assertEquals(1050.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.ENCARGADO, LocalDate.now().minusYears(10).minusDays(1));
		
		assertEquals(2100.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.VENDEDOR, LocalDate.now().minusYears(15));
		
		assertEquals(1600.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.AUXILIAR, LocalDate.now().minusYears(20));
		
		assertEquals(1100.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.ENCARGADO, LocalDate.now().minusYears(20).minusDays(1));
		
		assertEquals(2200.0, empleado.sueldoBruto());
		
		empleado = new Empleado("10203040A", "Carlos", Categoria.VENDEDOR, LocalDate.now().minusYears(30));
		
		assertEquals(1700.0, empleado.sueldoBruto());
		
		//Casos de prueba no validos
		
		}
}
