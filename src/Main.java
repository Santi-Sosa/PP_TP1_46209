public class Main {

    public static void main(String[] args) {

        Estudiante estudiante1 =
                new Estudiante("48521", "Juan Rodriguez");

        Estudiante estudiante2 =
                new Estudiante("48522", "María Gómez");

        Estudiante estudiante3 =
                new Estudiante("48523", "Lucas Martínez");


        System.out.println("ESTUDIANTES REGISTRADOS");
        System.out.println("-----------------------");
        System.out.println(estudiante1);
        System.out.println(estudiante2);
        System.out.println(estudiante3);
        System.out.println();


        EventoUniversitario evento1 =
                new EventoUniversitario(
                        "001",
                        "Paradigmas de Programación",
                        15000,
                        false
                );


        EventoUniversitario evento2 =
                new EventoUniversitario(
                        "002",
                        "Sistemas Operativos",
                        10000,
                        false
                );

        Sala sala1 =
                new Sala(
                        101,
                        "Física"
                );

        Sala sala2 =
                new Sala(
                        202,
                        "Análisis de Sistemas"
                );


        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);


        evento1.crearActividad(
                1,
                "Introducción a Java",
                30,
                "Charla"
        );

        evento1.crearActividad(
                2,
                "Charla C++",
                20,
                "Taller"
        );


        evento2.crearActividad(
                3,
                "Introducción SO",
                50,
                "Charla"
        );

        evento2.crearActividad(
                4,
                "Procesos e Hilos",
                25,
                "Taller"
        );



        evento1.getActividades().get(0).inscribir(estudiante1);
        evento1.getActividades().get(0).inscribir(estudiante2);


        evento1.getActividades().get(1).inscribir(estudiante2);
        evento1.getActividades().get(1).inscribir(estudiante3);


        evento2.getActividades().get(0).inscribir(estudiante1);
        evento2.getActividades().get(0).inscribir(estudiante3);


        evento2.getActividades().get(1).inscribir(estudiante1);
        evento2.getActividades().get(1).inscribir(estudiante2);

        System.out.println();
        System.out.println("EVENTOS CREADOS");
        System.out.println();

        evento1.mostrarDatos();
        evento2.mostrarDatos();


        EventoUniversitario copiaEvento1 =
                new EventoUniversitario(evento1);

        System.out.println("COPIA DEL EVENTO 1");
        copiaEvento1.mostrarDatos();


        System.out.println("DEMOSTRACIÓN DE POLIMORFISMO");

        for (Actividad actividad : evento1.getActividades()) {

            actividad.mostrarIdentificacion();

            System.out.println(
                    "Tipo detectado: " +
                            actividad.getTipo()
            );

            System.out.println(
                    "Costo de materiales: $" +
                            actividad.calcularCostoMateriales()
            );

            System.out.println();
        }


        System.out.println(
                "TOTAL DE EVENTOS CREADOS: " +
                        EventoUniversitario.getCantidadEventos()
        );
    }
}