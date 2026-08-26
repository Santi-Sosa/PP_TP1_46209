import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {

    private int id;
    private String titulo;
    private int cupoMaximo;

    private static final int CUPO_MINIMO = 1;

    private List<Inscripcion> inscripciones;


    public Actividad(int id, String titulo, int cupoMaximo) {

        if (cupoMaximo < CUPO_MINIMO) {
            throw new IllegalArgumentException(
                    "El cupo máximo debe ser mayor o igual a " + CUPO_MINIMO
            );
        }

        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;

        this.inscripciones = new ArrayList<>();
    }


    protected Actividad(Actividad otra) {
        this.id = otra.id;
        this.titulo = otra.titulo;
        this.cupoMaximo = otra.cupoMaximo;

        this.inscripciones = new ArrayList<>();

        for (Inscripcion inscripcion : otra.inscripciones) {
            this.inscripciones.add(inscripcion.copiar());
        }
    }


    public Inscripcion inscribir(Estudiante estudiante) {

        if (inscripciones.size() >= cupoMaximo) {
            System.out.println(
                    "No hay cupo disponible para la actividad: " + titulo
            );

            return null;
        }

        Inscripcion nuevaInscripcion =
                new Inscripcion(
                        java.time.LocalDate.now(),
                        "ACTIVA",
                        estudiante
                );

        inscripciones.add(nuevaInscripcion);

        return nuevaInscripcion;
    }


    public void mostrarInscripciones() {

        System.out.println("Inscripciones:");

        if (inscripciones.isEmpty()) {
            System.out.println("  No hay estudiantes inscriptos.");
            return;
        }

        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("  " + inscripcion);
        }
    }


    public final void mostrarIdentificacion() {

        System.out.println(
                "[" + getTipo() + "] " +
                        id + " - " +
                        titulo +
                        " - Cupo: " +
                        cupoMaximo
        );
    }


    public abstract double calcularCostoMateriales();


    public abstract String getTipo();


    public abstract Actividad copiar();


    public int getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }


    public int getCupoMaximo() {
        return cupoMaximo;
    }


    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}