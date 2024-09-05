package Clases;



public class ServicioEstudiante {
	private EstudiantesRegistrados estudiantesRegistrados;
	private int maximoNumeroEstudiantes;
	public ServicioEstudiante(EstudiantesRegistrados estudiantesRegistrados) {
		this.estudiantesRegistrados = estudiantesRegistrados;
		this.maximoNumeroEstudiantes = 2000;
	}
	
	
	
	
	public boolean esEstudianteRegistrado(String matricula) {
		if (matricula == null || matricula.isEmpty()) {
			throw new IllegalArgumentException("No se admiten matrículas nulas o vacías");
		}
		return estudiantesRegistrados.buscarPorMatricula(matricula) != null;
	}
	public boolean actualizarEstudiante(String matricula, Estudiante nuevoEstudiante) {
		return estudiantesRegistrados.actualizarEstudiante(matricula, nuevoEstudiante);
	}
	public double obtenerPromedioEdadEstudiantes() {
		return estudiantesRegistrados.calcularPromedioEdad();
	}
	public int obtenerMaximoNumeroEstudiantes() {
		return this.maximoNumeroEstudiantes;
	}
}
