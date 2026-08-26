import java.time.LocalDate;

public class Inscripcion {

    private LocalDate fecha;
    private String estado;

    private Estudiante estudiante;


    public Inscripcion(
            LocalDate fecha,
            String estado,
            Estudiante estudiante
    ) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
    }


    public Inscripcion(Inscripcion otra) {
        this.fecha = otra.fecha;
        this.estado = otra.estado;
        this.estudiante = otra.estudiante;
    }


    public Inscripcion copiar() {
        return new Inscripcion(this);
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public String getEstado() {
        return estado;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }


    @Override
    public String toString() {
        return estudiante +
                " | Fecha: " +
                fecha +
                " | Estado: " +
                estado;
    }
}