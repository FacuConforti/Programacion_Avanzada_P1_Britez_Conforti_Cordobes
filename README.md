# Sistema de Garage

## Descripción
Este proyecto implementa un sistema de gestión de un garage utilizando Programación Orientada a Objetos en Java. Permite registrar el ingreso y egreso de vehículos, calcular tarifas según el tipo y generar reportes de recaudación.

---

## Tipos de Vehículos

| Tipo    | Espacio | Tarifa por hora |
|--------|--------|----------------|
| Auto   | 2      | $1000          |
| Moto   | 1      | $700           |
| Camión | 4      | $1500          |

---

##  Funcionalidades

-  Ingreso de vehículos
  - Validación de espacio disponible
  - Validación de patente duplicada

-  Retiro de vehículos
  - Búsqueda por patente
  - Cálculo de tarifa según horas reales

-  Listado de vehículos estacionados

-  Estado del garage
  - Capacidad total
  - Espacio ocupado
  - Espacio libre

-  Reportes
  - Recaudación total
  - Recaudación por tipo de vehículo
  - Ganancia proyectada

---

##  Manejo de Excepciones

El sistema utiliza excepciones personalizadas:

- `GarageLlenoException`
- `PatenteDuplicadaException`
- `VehiculoNoEncontradoException`
- `HorasInvalidasException`

Las excepciones se lanzan desde la lógica del sistema (`Garage`) y se capturan en la interfaz (`Main`).

---

##  Conceptos Aplicados

- Programación Orientada a Objetos (POO)
- Herencia
- Polimorfismo
- Encapsulamiento
- Abstracción
- Manejo de Excepciones
- Uso de colecciones (`ArrayList`)

---

##  Ejecución

1. Ejecutar la clase `Main`
2. Utilizar el menú interactivo:

1 - Ingresar vehículo
2 - Retirar vehículo
3 - Listar vehículos
4 - Estado del garage
5 - Reporte
6 - Salir


##  Notas

- No se permiten patentes duplicadas dentro del garage
- No se permite el ingreso si no hay espacio disponible
- Las horas deben ser mayores a 0
- El cálculo de la tarifa se realiza según el tipo de vehículo
- Se diferencia entre recaudación real y proyectada

---
