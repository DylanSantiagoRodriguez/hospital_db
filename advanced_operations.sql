-- 1. Listar citas pendientes
SELECT 
    c.ID_Cita, 
    p.Nombre AS Paciente, 
    p.Apellido AS Apellido_Paciente, 
    m.Nombre AS Medico, 
    m.Apellido AS Apellido_Medico, 
    c.Fecha, 
    c.Hora, 
    c.Estado
FROM 
    Citas c
JOIN 
    Pacientes p ON c.ID_Paciente = p.ID_Paciente
JOIN 
    Medicos m ON c.ID_Medico = m.ID_Medico
WHERE 
    c.Estado = 'Pendiente';

-- 2. Listar tratamientos por paciente
SELECT 
    p.Nombre AS Paciente, 
    p.Apellido AS Apellido_Paciente, 
    t.Descripcion AS Tratamiento, 
    t.Fecha_Inicio, 
    t.Duracion_Dias, 
    c.Fecha AS Fecha_Cita, 
    c.Hora AS Hora_Cita
FROM 
    Tratamientos t
JOIN 
    Citas c ON t.ID_Cita = c.ID_Cita
JOIN 
    Pacientes p ON c.ID_Paciente = p.ID_Paciente;

-- 3. Buscar citas por médico
SELECT 
    m.Nombre AS Medico, 
    m.Apellido AS Apellido_Medico, 
    c.ID_Cita, 
    p.Nombre AS Paciente, 
    p.Apellido AS Apellido_Paciente, 
    c.Fecha, 
    c.Hora, 
    c.Estado
FROM 
    Medicos m
JOIN 
    Citas c ON m.ID_Medico = c.ID_Medico
JOIN 
    Pacientes p ON c.ID_Paciente = p.ID_Paciente
ORDER BY 
    m.Nombre, c.Fecha, c.Hora;
