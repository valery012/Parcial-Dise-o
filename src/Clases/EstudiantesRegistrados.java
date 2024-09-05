package Clases;



import java.util.ArrayList;
import java.util.List;
public class EstudiantesRegistrados {
private List<Estudiante> estudiantes;
public EstudiantesRegistrados() {
this.estudiantes = new ArrayList<>();
	}
	public Estudiante buscarPorMatricula(String matricula) {
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getMatricula().equalsIgnoreCase(matricula)) {
				return estudiante;
			}
		}
		return null;
	}
	public boolean actualizarEstudiante(String matricula, Estudiante nuevoEstudiante) {
		for (int i = 0; i < estudiantes.size(); i++) {
			if (estudiantes.get(i).getMatricula().equalsIgnoreCase(matricula)) {
				estudiantes.set(i, nuevoEstudiante);
				return true;
			}	
		}
		return false;
	}
	public double calcularPromedioEdad() {
		if (estudiantes.isEmpty()) {
			return 0.0;
		}
		int totalEdad = 0;
		for (Estudiante estudiante : estudiantes) {
			totalEdad += estudiante.getEdad();
		}
		return (double) totalEdad / estudiantes.size();
	}
}
