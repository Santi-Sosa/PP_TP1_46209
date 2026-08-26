public class Taller extends Actividad {

    private boolean requiereNotebook;


    public Taller(
            int id,
            String titulo,
            int cupoMaximo,
            boolean requiereNotebook
    ) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }


    public Taller(Taller otro) {
        super(otro);
        this.requiereNotebook = otro.requiereNotebook;
    }


    @Override
    public double calcularCostoMateriales() {

        if (requiereNotebook) {
            return 5000;
        }

        return 2000;
    }


    @Override
    public String getTipo() {
        return "Taller";
    }


    @Override
    public Actividad copiar() {
        return new Taller(this);
    }


    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }


    @Override
    public String toString() {
        return "Taller: " + getTitulo() +
                " | Requiere notebook: " +
                (requiereNotebook ? "Sí" : "No");
    }
}