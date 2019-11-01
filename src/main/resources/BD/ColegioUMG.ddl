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
    ON DELETE NO ACTION
    ON UPDATE CASCADE
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

CREATE TABLE zonas (
    id_zona	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    punteo		DECIMAL,
    id_estudiante          INT NOT NULL,
    id_tarea               INT NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante),
    FOREIGN KEY (id_tarea) REFERENCES tareas(id_tarea)
);

CREATE TABLE tareas (
    id_tarea	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    punteo		DECIMAL,
    id_curso               INT NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);


--VISTAS-->
CREATE OR REPLACE VIEW view_asignacion_maestro AS 
SELECT m.id_maestro, m.nom_ma1, m.ape_ma1, c.nom_cu, c.horario FROM asignacion_ma am
INNER JOIN maestros m ON am.id_maestro = m.id_maestro
INNER JOIN cursos c ON am.id_curso = c.id_curso;

CREATE OR REPLACE VIEW view_asignacion_estudiante AS 
SELECT e.id_estudiantes, e.nom_es1, e.ape_es1, c.nom_cu, c.horario FROM asignacion_estu ae
INNER JOIN estudiantes e ON ae.id_estudiante = e.id_estudiante
INNER JOIN cursos c ON ae.id_curso = c.id_curso;

CREATE OR REPLACE VIEW view_zonas AS 
SELECT e.id_estudiante, e.nom_es1 , e.ape_es1 , t.id_tarea , t.punteo  FROM zonas zo
INNER JOIN estudiantes e ON zo.id_estudiante = e.id_estudiante
INNER JOIN tareas t ON zo.id_tarea = t.id_tarea;


CREATE OR REPLACE VIEW view_asistencias AS 
SELECT s.id_estudiante, s.nom_es1, s.ape_es1, ass.fecha_asistencia , ass.estado_asistencia FROM asistencias asist
INNER JOIN estudiantes s ON asist.id_estudiante = s.id_estudiante
INNER JOIN asistencias ass ON asist.id_asistencia = ass.id_asistencia;



