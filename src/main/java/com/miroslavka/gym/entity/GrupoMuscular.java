package com.miroslavka.gym.entity;

public enum GrupoMuscular {
    PECTORAL("Pectoral", "Ejercicios enfocados en el desarrollo del pecho.", "/images/pectoral.png"),
    ESPALDA("Espalda", "Ejercicios enfocados en el desarrollo de la espalda.", "/images/espalda.png"),
    PIERNAS("Piernas", "Ejercicios enfocados en el desarrollo de las piernas.", "/images/piernas.png"),
    GLUTEOS("Glúteos", "Ejercicios enfocados en el desarrollo de los glúteos.", "/images/gluteos.png"),
    HOMBROS("Hombros", "Ejercicios enfocados en el desarrollo de los hombros.", "/images/hombros.png"),
    BICEPS("Bíceps", "Ejercicios enfocados en el desarrollo de los bíceps.", "/images/biceps.png"),
    TRICEPS("Tríceps", "Ejercicios enfocados en el desarrollo de los tríceps.", "/images/triceps.png"),
    ANTEBRAZO("Antebrazo", "Ejercicios enfocados en el desarrollo de los antebrazos.", "/images/antebrazo.png"),
    ABDOMINALES("Abdominales", "Ejercicios enfocados en el desarrollo del core y abdominales.", "/images/abdominales.png"),
    FULLBODY("Full Body", "Entrenamientos que trabajan todo el cuerpo.", "/images/fullbody.png"),
    CARDIO("Cardio", "Ejercicios enfocados en el acondicionamiento cardiovascular.", "/images/cardio.png"),
    ESTIRAMIENTOS("Estiramientos", "Ejercicios enfocados en mejorar la flexibilidad y movilidad.", "/images/estiramientos.png");

    private final String nombre;
    private final String descripcion;
    private final String imagen;



    GrupoMuscular(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
}
