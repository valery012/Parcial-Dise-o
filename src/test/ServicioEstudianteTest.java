package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Clases.Estudiante;
import Clases.EstudiantesRegistrados;
import Clases.Mascota;
import Clases.ServicioEstudiante;

class ServicioEstudianteTest {
	EstudiantesRegistrados esturegistrados= mock(EstudiantesRegistrados.class);
	Estudiante estu=mock(Estudiante.class);
	
	ServicioEstudiante servi= new ServicioEstudiante(esturegistrados);
	@Test
	void esEstudianteRegistradotest() {
		when(esturegistrados.buscarPorMatricula("juan")).thenReturn(estu);
		boolean registro= servi.esEstudianteRegistrado("juan");
		assertTrue(registro);

	}
	@Test
	void esEstudianteRegistradotest2() {
		when(esturegistrados.buscarPorMatricula("juan")).thenReturn(null);
		boolean registro= servi.esEstudianteRegistrado("juan");
		assertFalse(registro);

	}
	@Test
	void esEstudianteRegistradotest2if () {
		IllegalArgumentException excep=assertThrows(IllegalArgumentException.class,()->servi.esEstudianteRegistrado(null));
		assertEquals(excep.getMessage(),"No se admiten matrículas nulas o vacías");
	}
	@Test
	void actualizarEstudiantetest(){
		when(esturegistrados.actualizarEstudiante("pre", estu)).thenReturn(true);
		boolean acepto= servi.actualizarEstudiante("pre", estu);
		assertTrue(acepto);
		
	}
	@Test
	void obtenerPromedioEdadEstudiantestest () {
		Estudiante estu1=mock(Estudiante.class);
		Estudiante estu2=mock(Estudiante.class);
		when(estu1.getEdad()).thenReturn(12);
		when(estu2.getEdad()).thenReturn(12);
		List<Estudiante> mockarrayestu=new ArrayList<>();
		mockarrayestu.add(estu1);
		mockarrayestu.add(estu2);
		double edadp= servi.obtenerPromedioEdadEstudiantes();
		
		assertEquals(12,edadp);
		
		
	
		
	}
}
