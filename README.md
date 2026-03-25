# Sistema de Gestión de Eventos Deportivos

## Integrantes

- MORALES TORUÑO MARIA DE JESUS  
- VEGA BARQUERO DEREK STUARD  
- MARTINEZ ABARCA MARTIN ALEXANDER  
- ALFARO CAMPOS JOSE ALBERTO  

---

# Introducción

Este proyecto corresponde al desarrollo de una aplicación de escritorio en **Java** utilizando **Swing**, cuyo objetivo es gestionar y visualizar información relacionada con eventos deportivos.

El sistema permite administrar participantes, partidos, resultados y clasificaciones, además de mostrar relaciones entre equipos mediante un **grafo**.

La aplicación cuenta con diferentes vistas que organizan las funciones del sistema, separando el acceso entre **administradores** y **espectadores**, permitiendo así una navegación clara y estructurada dentro del programa.

---

# Descripción de las Vistas

## VistaLogin

Esta vista corresponde a la pantalla de inicio del sistema.  
Permite al usuario ingresar sus credenciales para acceder a la aplicación.

En esta primera versión se utiliza un usuario administrador básico para permitir el acceso al sistema.

---

## VistaPrincipal

La **VistaPrincipal** funciona como el menú principal del sistema.

Desde esta ventana el usuario puede elegir a qué sección desea ingresar, como el menú del administrador o el menú del espectador.

Esta vista sirve como punto central de navegación dentro del programa.

---

## VistaMenuAdmin

La **VistaMenuAdmin** corresponde al menú de administración del sistema.

Desde esta pantalla el administrador puede acceder a las diferentes funciones de gestión del sistema, como:

- Gestión de participantes  
- Gestión de partidos  
- Registro de resultados  
- Visualización del grafo de enfrentamientos  
- Visualización de la clasificación  

Esta vista centraliza todas las funciones de control del sistema.

---

## VistaMenuEspectador

La **VistaMenuEspectador** permite a los usuarios que solo desean consultar información acceder a los datos del sistema sin modificar información.

Desde esta vista se pueden observar:

- Resultados
- Clasificación
- Partidos programados

---

## VistaParticipantes

La **VistaParticipantes** permite gestionar la información de los participantes del evento deportivo.

En esta sección el administrador puede registrar, consultar o modificar los datos de los equipos o jugadores que participan en la competición.

---

## VistaPartidos

La **VistaPartidos** permite administrar los partidos del evento deportivo.

En esta vista se registran los enfrentamientos entre los participantes y se organiza la programación de los encuentros.

---

## VistaResultados

La **VistaResultados** permite registrar y consultar los resultados de los partidos que ya se han jugado.

Esta información se utiliza posteriormente para calcular la clasificación del torneo.

---

## VistaClasificacion

La **VistaClasificacion** muestra la tabla de posiciones de los participantes en el torneo.

La clasificación se genera con base en los resultados registrados en los partidos.

---

## VistaGrafo

La **VistaGrafo** representa gráficamente las relaciones entre los participantes mediante una estructura de **grafo**.

Esta vista permite visualizar los enfrentamientos entre los equipos y analizar la estructura de la competición.

---

# Estructuras de Datos Utilizadas

## Colas Dinámicas

Las **colas dinámicas** son muy adecuadas para este proyecto porque funcionan bajo el principio **FIFO (First In, First Out)**, lo que significa que el primer elemento que entra es el primero en salir.

En el sistema, esta estructura se utilizará para organizar la programación de los partidos. Esto permite que el primer juego programado sea el primero en disputarse, mientras que los nuevos partidos que se agreguen se colocarán al final de la cola.

De esta manera se mantiene un orden claro en la programación de los encuentros deportivos.

---

## Pilas Dinámicas

Las **pilas dinámicas** funcionan bajo el principio **LIFO (Last In, First Out)**, donde el último elemento que entra es el primero en salir.

En este proyecto se utilizarán para almacenar los resultados de los partidos que ya se han jugado. Esto permite mostrar primero el resultado del partido más reciente.

Esto resulta útil para los espectadores, ya que podrán visualizar rápidamente los últimos resultados registrados en el sistema.

Además, el uso de estructuras **dinámicas** permite agregar nuevos elementos sin un límite fijo de memoria, lo que facilita la gestión de información conforme se agregan más partidos o resultados.

---

# Componentes Visuales Utilizados

Para el desarrollo de la interfaz gráfica del sistema se utilizarán componentes de **Java Swing**, los cuales permiten construir aplicaciones de escritorio interactivas.

## JFrame

El **JFrame** será utilizado como la ventana principal de la aplicación.

Este componente funcionará como contenedor base donde se agregarán los distintos paneles del sistema, como el menú principal, el menú de administrador y las vistas de consulta.

---

## JPanel

El **JPanel** se utilizará para organizar visualmente los componentes dentro de la ventana.

Cada sección del sistema puede implementarse como un panel diferente, lo que permite separar las distintas vistas del programa.

---

## JButton

El **JButton** se utilizará para crear botones interactivos que permitirán al usuario ejecutar acciones dentro del sistema.

Por ejemplo:

- Acceder al menú de administrador
- Consultar resultados
- Registrar participantes
- Visualizar clasificación

---

## JLabel

El **JLabel** se utilizará para mostrar textos informativos dentro de la interfaz gráfica.

Se utilizará principalmente para mostrar títulos, nombres de campos o mensajes informativos al usuario.

---

## JTextField

El **JTextField** permitirá que el usuario ingrese información dentro del sistema.

Se utilizará en formularios como el registro de participantes, registro de partidos o búsquedas dentro del sistema.

---

## JTextArea

El **JTextArea** se utilizará para mostrar información más extensa, como listas de participantes, resultados o partidos programados.

Este componente permite mostrar varias líneas de texto dentro de la interfaz.

---

## JScrollPane

El **JScrollPane** se utilizará cuando la información mostrada sea extensa y requiera desplazamiento.

Esto permitirá que el usuario pueda desplazarse verticalmente para visualizar toda la información disponible.

---

# Librerías Utilizadas

## javax.swing.*

Esta librería será utilizada para la creación de la **interfaz gráfica del sistema**, incluyendo componentes como ventanas, botones, paneles y campos de texto.

---

## java.awt.*

La librería **java.awt** se utilizará para el manejo de elementos gráficos básicos y para la organización visual de los componentes dentro de la interfaz.

---

## java.io.*

Esta librería permitirá implementar la **persistencia de datos**, permitiendo guardar y cargar información del sistema mediante archivos.

---

## java.util.*

La librería **java.util** se utilizará para diversas utilidades del sistema, como manejo de colecciones, fechas y otras funcionalidades auxiliares necesarias para el desarrollo del proyecto.
