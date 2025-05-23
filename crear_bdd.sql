-- Creacion de la base de datos
CREATE DATABASE PuertoGames2025;
GO

USE PuertoGames2025;
GO

-- Creacion de las tablas necesarias
CREATE TABLE Plataformas(
    id_plataforma INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    nombre  NVARCHAR(50) NOT NULL
);

CREATE TABLE Videojuegos(
    id_videojuego INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    titulo  NVARCHAR(100) NOT NULL,
    precio  DECIMAL(10,2) NOT NULL CHECK (precio > 0),
    stock   INT NOT NULL,
    id_plataforma INT NOT NULL,
    FOREIGN KEY (id_plataforma) REFERENCES Plataformas (id_plataforma)
);

-- Insertando datos en las tablas
INSERT INTO Plataformas (nombre) VALUES
('PlayStation 5'), ('Xbox Series X'), ('Nintendo Switch'), ('Pc'), ('Steam Deck')

INSERT INTO Videojuegos (titulo, precio, stock, id_plataforma) VALUES
('The Legend of Zelda: Breath of the Wild', 56390, 30, 1),
('God of War: Ragnarök', 65790, 20, 1),
('Halo Infinite', 56390, 50, 1),
('Red Dead Redemption 2', 37590, 25, 1),
('Elden Ring', 56390, 40, 1),
('Super Mario Odyssey', 56390, 35, 1),
('Minecraft', 28190, 60, 1),
('The Last of Us Part II', 46990, 15, 1),
('Hades', 23490, 45, 1),
('Cyberpunk 2077', 46990, 30, 1)