README - Sistema de Garage
Descripción

Este proyecto implementa un sistema de gestión de un garage utilizando Programación Orientada a Objetos en Java. Permite registrar el ingreso y egreso de vehículos, calcular tarifas según el tipo y generar reportes de recaudación.

- Tipos de vehículos
Auto → 2 espacios → $1000/hora
Moto → 1 espacio → $700/hora
Camión → 4 espacios → $1500/hora

- Funcionalidades

Ingreso de vehículos con validación de:
espacio disponible
patente duplicada

Retiro de vehículos:
búsqueda por patente
cálculo de tarifa según horas reales

Visualización:
lista de vehículos
estado del garage
Reportes:
recaudación total
recaudación por tipo
ganancia proyectada
Manejo de errores

Se utilizan excepciones personalizadas:
GarageLlenoException
PatenteDuplicadaException
VehiculoNoEncontradoException
HorasInvalidasException

- Conceptos aplicados
Herencia
Polimorfismo
Encapsulamiento
Abstracción
Manejo de excepciones
Uso de colecciones (ArrayList)

-Ejecución
Ejecutar la clase Main
Utilizar el menú interactivo:
1 → Ingresar vehículo
2 → Retirar vehículo
3 → Listar
4 → Estado
5 → Reporte
6 → Salir

- Notas
El sistema valida entradas incorrectas
No permite patentes duplicadas
Calcula tarifas dinámicamente según tipo de vehículo
