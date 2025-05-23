import tkinter as tk
from conexion_sqlserver import *
import matplotlib.pyplot as plt

listav = obtener_videojuegos()
graf, plataformas, cantidades = obtener_grafico()

ventana = tk.Tk()
ventana.title("Catálogo de Videojuegos")
ventana.geometry("700x400")

titulo = tk.Label(ventana, text="👾 PuertoGames 👾", font=("Arial", 20),foreground='red')
titulo.pack(pady=10)

titulo = tk.Label(ventana, text="Crear Videojuego", font=("Arial", 14))
titulo.pack(pady=9)

tk.Label(ventana, text="Título:").pack()
entrada_titulo = tk.Entry(ventana)
entrada_titulo.pack()

tk.Label(ventana, text="Precio:").pack()
entrada_precio = tk.Entry(ventana)
entrada_precio.pack()


ventana.mainloop()