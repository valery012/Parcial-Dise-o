package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Clases.Estudiante;
import Clases.EstudiantesRegistrados;
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
	
}
