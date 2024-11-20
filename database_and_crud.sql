CREATE DATABASE IF NOT EXISTS hospital_management;
USE hospital_management;

CREATE TABLE Especialidad (
    ID_Especialidad INT PRIMARY KEY,
    NombreEspecialidad VARCHAR(50) NOT NULL
);

CREATE TABLE Pacientes (
    ID_Paciente INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    Direccion VARCHAR(100),
    Telefono VARCHAR(15)
);

CREATE TABLE Medicos (
    ID_Medico INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Especialidad INT,
    Telefono VARCHAR(15),
    Mentor INT,
    FOREIGN KEY (Especialidad) REFERENCES Especialidad(ID_Especialidad),
    FOREIGN KEY (Mentor) REFERENCES Medicos(ID_Medico)
);

CREATE TABLE Habitaciones (
    ID_Habitacion INT PRIMARY KEY,
    Numero INT NOT NULL,
    Estado VARCHAR(20) NOT NULL,
    ID_Paciente INT,
    FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente)
);

CREATE TABLE Citas (
    ID_Cita INT PRIMARY KEY,
    FechaHora DATETIME NOT NULL,
    Estado VARCHAR(20) NOT NULL,
    ID_Paciente INT,
    ID_Medico INT,
    FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente),
    FOREIGN KEY (ID_Medico) REFERENCES Medicos(ID_Medico)
);

CREATE TABLE Historial_Visitas (
    ID_Historial INT PRIMARY KEY,
    FechaVisita DATE NOT NULL,
    ID_Paciente INT,
    FOREIGN KEY (ID_Paciente) REFERENCES Pacientes(ID_Paciente)
);

CREATE TABLE Consultas (
    ID_Consulta INT PRIMARY KEY,
    DetallesConsulta TEXT,
    ID_Cita INT,
    FOREIGN KEY (ID_Cita) REFERENCES Citas(ID_Cita)
);

CREATE TABLE Tratamientos (
    ID_Tratamiento INT PRIMARY KEY,
    Descripcion VARCHAR(255) NOT NULL,
    FechaInicio DATE NOT NULL,
    DuracionEstimada INT NOT NULL,
    ID_Cita INT,
    FOREIGN KEY (ID_Cita) REFERENCES Citas(ID_Cita)
);

CREATE TABLE Medicamentos (
    ID_Medicamento INT PRIMARY KEY,
    NombreMedicamento VARCHAR(50) NOT NULL,
    Dosis VARCHAR(50) NOT NULL
);

CREATE TABLE Recetas_Medicas (
    ID_Receta INT PRIMARY KEY,
    ID_Tratamiento INT,
    ID_Medicamento INT,
    FOREIGN KEY (ID_Tratamiento) REFERENCES Tratamientos(ID_Tratamiento),
    FOREIGN KEY (ID_Medicamento) REFERENCES Medicamentos(ID_Medicamento)
);

CREATE TABLE Roles (
    ID_Rol INT PRIMARY KEY,
    NombreRol VARCHAR(50) NOT NULL,
    Permisos TEXT
);

CREATE TABLE Usuarios (
    ID_Usuario INT PRIMARY KEY,
    NombreUsuario VARCHAR(50) NOT NULL,
    Contrasena VARCHAR(255) NOT NULL,
    ID_Rol INT,
    FOREIGN KEY (ID_Rol) REFERENCES Roles(ID_Rol)
);

INSERT INTO Pacientes (Nombre, Apellido, Telefono, Direccion)
VALUES 
('Juan', 'Perez', '123456789', 'Calle 123'),
('Ana', 'Gomez', '987654321', 'Avenida 456'),
('Luis', 'Martinez',  '456789123', 'Carrera 789');

INSERT INTO Medicos (Nombre, Apellido, Especialidad, Telefono, Email)
VALUES 
('Dr. Carlos', 'Lopez', 'Cardiología', '111222333', 'clopez@hospital.com'),
('Dra. Maria', 'Hernandez', 'Pediatría', '444555666', 'mhernandez@hospital.com');

INSERT INTO Citas (Fecha, Hora, ID_Paciente, ID_Medico, Estado)
VALUES 
('2024-11-20', '10:00', 1, 1, 'Pendiente'),
('2024-11-21', '14:30', 1, 2, 'Pendiente'),
('2024-11-22', '09:00', 2, 1, 'Pendiente');

INSERT INTO Tratamientos (ID_Cita, Descripcion, Fecha_Inicio, Duracion_Dias)
VALUES 
(1, 'Tratamiento para hipertensión', '2024-11-20', 30);

-- actualizacion de estado de una cita
UPDATE Citas 
SET Estado = 'Completada' 
WHERE ID_Cita = 1;

-- eliminacion de un médico sin citas activas
DELETE FROM Medicos 
WHERE ID_Medico = 2;

-- eliminacion de un médico con citas activas
DELETE FROM Medicos 
WHERE ID_Medico = 1;

SELECT * FROM Medicos;
SELECT m.Nombre AS Medico, c.Fecha, c.Estado
FROM Medicos m
LEFT JOIN Citas c ON m.ID_Medico = c.ID_Medico;

SELECT p.Nombre AS Paciente, c.Fecha, c.Hora, c.Estado, t.Descripcion AS Tratamiento, t.Fecha_Inicio, t.Duracion_Dias
FROM Pacientes p
LEFT JOIN Citas c ON p.ID_Paciente = c.ID_Paciente
LEFT JOIN Tratamientos t ON c.ID_Cita = t.ID_Cita
WHERE p.ID_Paciente = 1;

SELECT m.Nombre, m.Especialidad, COUNT(c.ID_Cita) AS Total_Citas
FROM Medicos m
LEFT JOIN Citas c ON m.ID_Medico = c.ID_Medico
GROUP BY m.ID_Medico;

SELECT c.Fecha, c.Estado, t.Descripcion AS Tratamiento, t.Fecha_Inicio
FROM Citas c
JOIN Tratamientos t ON c.ID_Cita = t.ID_Cita
WHERE c.ID_Paciente = 1;
