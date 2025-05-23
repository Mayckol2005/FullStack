import pyodbc

def obtener_videojuegos():
    # Conexión con SQL Server
    conn = pyodbc.connect(
        'DRIVER={ODBC Driver 17 for SQL Server};'
        'SERVER=DESKTOP-HVP6NH6;'
        'DATABASE=PuertoGames2025;'
        'Trusted_Connection=yes;'
    )

    # Cursor para ejecutar las consultas
    cursor = conn.cursor()
    
    # Consulta JOIN 
    cursor.execute("""
    SELECT v.titulo, v.precio, v.stock
    FROM Videojuegos v
    JOIN Plataformas p ON v.id_plataforma = p.id_plataforma     
    """)
    
    listav = cursor.fetchall()
    
    conn.close()

    return listav

def obtener_grafico():
    # Conexión con SQL Server
    connn = pyodbc.connect(
        'DRIVER={ODBC Driver 17 for SQL Server};'
        'SERVER=DESKTOP-HVP6NH6;'
        'DATABASE=PuertoGames2025;'
        'Trusted_Connection=yes;'
    )

    # Cursor para ejecutar las consultas    
    curs = connn.cursor()
    
    # Consulta JOIN
    curs.execute("""
    SELECT p.nombre AS plataforma,COUNT(*) AS cantidad
    FROM Videojuegos v
    JOIN Plataformas p ON v.id_plataforma = p.id_plataforma
    GROUP BY p.nombre
    ORDER BY cantidad;               
    """)
        
    graf = curs.fetchall()
    
    connn.close()
    
    plataformas = [fila[0] for fila in graf] # "Nombre de Plataforma"
    cantidades = [fila[1] for fila in graf] # Cantidad de videojuegos en la plataforma
    
    return graf, plataformas, cantidades

# def insertar_juego(cons,titulo, precio, stock, id_plataforma):
#     cur = pyodbc.connect(
#         'DRIVER={ODBC Driver 17 for SQL Server};'
#         'SERVER=DESKTOP-HVP6NH6;'
#         'DATABASE=PuertoGames2025;'
#         'Trusted_Connection=yes;'
#         )
    
#     cur.execute('''INSERT INTO Videojuegos (TITULO, PRECIO, STOCK, ID_PLATAFORMA)
#         VALUES('{}','{}','{}','{}')'''.format(titulo, precio, stock, id_plataforma))
        
#     cons.commit()
#     cur.close()