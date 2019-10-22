CREATE TABLE cursos (
    id_curso   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom_cu           VARCHAR(100),
    descripcion_cu         VARCHAR(300),
    horario      VARCHAR(100)
);


CREATE TABLE estudiantes (
    id_estudiante   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom_es1         VARCHAR(100),
    nom_es2         VARCHAR(100),
    nom_es3         VARCHAR(100),
    ape_es1         VARCHAR(100),
    ape_es2         VARCHAR(100),
    correo_es       VARCHAR(100),
    sexo_es         VARCHAR(1),
    edad_es         INT NOT NULL
);

CREATE TABLE pagos (
    id_pago                     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    monto_pago             DECIMAL,
    fecha_pago                  DATE,
    descripcion_pago            VARCHAR(300),
    id_estudiante   INT NOT NULL, 
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante)
);

CREATE TABLE maestros (
    id_maestro   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom_ma1      VARCHAR(100),
    nom_ma2      VARCHAR(100),
    nom_ma3      VARCHAR(100),
    ape_ma1      VARCHAR(100),
    ape_ma2      VARCHAR(100),
    correo_ma    VARCHAR(100),
    sexo_ma      VARCHAR(1),
    edad_ma      DATE,
    dpi_ma       INT NOT NULL
);



CREATE TABLE asignacion_ma (
    id_asignacion_ma                 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_maestro          INT NOT NULL,
    id_curso               INT NOT NULL,
    FOREIGN KEY (id_maestro) REFERENCES maestros(id_maestro),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

CREATE TABLE asignacion_estu (
    id_asignacion_estu                 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_estudiante          INT NOT NULL,
    id_curso               INT NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

CREATE TABLE asistencias (
    id_asistencia  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha_asistencia	DATE,	
estado_asistencia	INT NOT NULL,
    id_estudiante          INT NOT NULL,
    id_curso               INT NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

CREATE TABLE estu_tareas (
    id_estu_tareas	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    punteo		DECIMAL,
    id_estudiante          INT NOT NULL,
    id_curso               INT NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

