package com.miroslavka.gym.entity;

public enum GrupoMuscular {
    PECTORAL("Pectoral", "Ejercicios enfocados en el desarrollo del pecho.", "https://i.ibb.co/WPMN20X/pectoral.jpg"),
    ESPALDA("Espalda", "Ejercicios enfocados en el desarrollo de la espalda.", "https://i.ibb.co/bswLNLJ/espalda.jpg"),
    PIERNAS("Piernas", "Ejercicios enfocados en el desarrollo de las piernas.", "https://i.ibb.co/n1cY5mM/piernas.jpg"),
    GLUTEOS("Glúteos", "Ejercicios enfocados en el desarrollo de los glúteos.", "https://i.ibb.co/s90ZYR4/gluteos.jpg"),
    HOMBROS("Hombros", "Ejercicios enfocados en el desarrollo de los hombros.", "https://i.ibb.co/Xsk75tJ/hombros.jpg"),
    BICEPS("Bíceps", "Ejercicios enfocados en el desarrollo de los bíceps.", "https://i.ibb.co/fvGDJgX/biceps.jpg"),
    TRICEPS("Tríceps", "Ejercicios enfocados en el desarrollo de los tríceps.", "https://i.ibb.co/D95w5xV/triceps.jpg"),
    ANTEBRAZO("Antebrazo", "Ejercicios enfocados en el desarrollo de los antebrazos.", "https://i.ibb.co/mNhhbNc/antebrazo.jpg"),
    ABDOMINALES("Abdominales", "Ejercicios enfocados en el desarrollo del core y abdominales.", "https://i.ibb.co/qY646Sg/abdominales.jpg"),
    FULLBODY("Full Body", "Entrenamientos que trabajan todo el cuerpo.", "https://i.ibb.co/JjCBxwm/fullbody.jpg"),
    CARDIO("Cardio", "Ejercicios enfocados en el acondicionamiento cardiovascular.", "https://i.ibb.co/Vqzs62R/cardio.jpg"),
    ESTIRAMIENTOS("Estiramientos", "Ejercicios enfocados en mejorar la flexibilidad y movilidad.", "https://i.ibb.co/2v2ddFB/estiramientos.jpg");

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
