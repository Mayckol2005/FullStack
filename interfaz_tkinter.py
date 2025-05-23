import tkinter as tk
from conexion_sqlserver import *
import matplotlib.pyplot as plt

# Obtener datos de la BD
listav = obtener_videojuegos()
graf, plataformas, cantidades = obtener_grafico()

# Crear una ventana
ventana = tk.Tk()
ventana.title("Catálogo de Videojuegos")
ventana.geometry("700x400")

# Título
titulo = tk.Label(ventana, text="👾 Lista de Videojuegos 👾", font=("Arial", 30))
titulo.pack(pady=10)

# Area de texto
texto = tk.Text(ventana, height=25, width=90, font=("Courier", 15))
texto.pack()

# Mostrar los datos
for row in listav:
    titulo, precio, stock = row
    texto.insert(tk.END, f"{titulo:40} |$ {precio:15} | {stock:5}\n")

# Datos del grafico de torta
def grafico():
    plt.figure(figsize=(10, 10)) # Configuracion de Alto x Ancho
    plt.pie(cantidades, labels=plataformas, autopct='%1.0f%%', startangle = 140)
    plt.title('Videojuegos x Plataforma')
    plt.axis('equal') # Para que sea circular / Tener misma escala entre eje X y el eje Y
    plt.tight_layout() # Ajustes de márgenes
    plt.show() # Mostrar grafico
    
# Boton para grafico
grafico_btn = tk.Button(ventana, text="Ver Grafico", command = grafico)
grafico_btn.pack(pady = 5)

# Boton cerrar
cerrar_btn = tk.Button(ventana, text="cerrar", command = ventana.destroy)
cerrar_btn.pack(pady = 10)

# Ejecutar la interfaz
ventana.mainloop()

# Crear videojuego
# Editar Videojueo