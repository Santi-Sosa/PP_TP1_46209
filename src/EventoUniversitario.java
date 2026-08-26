import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;

    private static int cantidadEventos = 0;

    private Sala sala;

    private List<Actividad> actividades;


    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();

        cantidadEventos++;
    }


    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;

        this.sala = otro.sala;

        this.actividades = new ArrayList<>();

        for (Actividad actividad : otro.actividades) {
            this.actividades.add(actividad.copiar());
        }

        cantidadEventos++;
    }


    public double calcularCostoEstimado() {

        if (gratuito) {
            return 0;
        }

        double costoTotal = costoBase;

        for (Actividad actividad : actividades) {
            costoTotal += actividad.calcularCostoMateriales();
        }

        return costoTotal * 1.21;
    }


    public void asignarSala(Sala sala) {
        this.sala = sala;
    }


    public void crearActividad(int id, String titulo, int cupo, String tipo) {

        if (tipo.equalsIgnoreCase("Charla")) {

            Charla charla = new Charla(
                    id,
                    titulo,
                    cupo,
                    "Sin disertante especificado"
            );

            actividades.add(charla);

        } else if (tipo.equalsIgnoreCase("Taller")) {

            Taller taller = new Taller(
                    id,
                    titulo,
                    cupo,
                    false
            );

            actividades.add(taller);

        } else {
            System.out.println("Tipo de actividad no válido: " + tipo);
        }
    }


    public void mostrarDatos() {

        System.out.println("EVENTO");

        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Gratuito: " + (gratuito ? "Sí" : "No"));

        if (sala != null) {
            System.out.println("Sala: " + sala);
        } else {
            System.out.println("Sala: No asignada");
        }

        System.out.printf("Costo estimado: $%.2f%n", calcularCostoEstimado());

        System.out.println();
        System.out.println("ACTIVIDADES:");

        if (actividades.isEmpty()) {
            System.out.println("No hay actividades.");
        } else {

            for (Actividad actividad : actividades) {

                actividad.mostrarIdentificacion();

                System.out.println(
                        "Costo de materiales: $" +
                                actividad.calcularCostoMateriales()
                );

                actividad.mostrarInscripciones();

                System.out.println();
            }
        }

        System.out.println();
    }


    public static int getCantidadEventos() {
        return cantidadEventos;
    }


    public List<Actividad> getActividades() {
        return actividades;
    }


    public Sala getSala() {
        return sala;
    }
}