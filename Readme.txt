Sistema de Eventos Deportivos
Introducción

Este proyecto corresponde al desarrollo de una aplicación de escritorio en Java utilizando Swing, cuyo objetivo es gestionar y visualizar información relacionada con eventos deportivos.

El sistema permite administrar participantes, partidos, resultados y clasificaciones, además de mostrar relaciones entre equipos mediante un grafo.

La aplicación cuenta con diferentes vistas que organizan las funciones del sistema, separando el acceso entre administradores y espectadores, permitiendo así una navegación clara y estructurada dentro del programa.

Descripción de las Vistas
VistaLogin

Esta vista corresponde a la pantalla de inicio del sistema.
Permite al usuario ingresar sus credenciales para acceder a la aplicación.
En esta primera versión se utiliza un usuario administrador básico para permitir el acceso al sistema.

VistaPrincipal

La VistaPrincipal funciona como el menú principal del sistema.
Desde esta ventana el usuario puede elegir a qué sección desea ingresar, como el menú del administrador o el menú del espectador.
Esta vista sirve como punto central de navegación dentro del programa.

VistaMenuAdmin

La VistaMenuAdmin corresponde al menú de administración del sistema.
Desde esta pantalla el administrador puede acceder a las diferentes funciones de gestión del sistema, como:

Gestión de participantes

Gestión de partidos

Registro de resultados

Visualización del grafo de enfrentamientos

Visualización de la clasificación

Esta vista centraliza todas las funciones de control del sistema.

VistaMenuEspectador

La VistaMenuEspectador permite a los usuarios que solo desean consultar información acceder a los datos del sistema sin modificar información.
Desde esta vista se pueden observar los resultados, la clasificación y los partidos programados.

VistaParticipantes

La VistaParticipantes permite gestionar la información de los participantes del evento deportivo.
En esta sección el administrador puede registrar, consultar o modificar los datos de los equipos o jugadores que participan en la competición.

VistaPartidos

La VistaPartidos permite administrar los partidos del evento deportivo.
En esta vista se registran los enfrentamientos entre los participantes y se organiza la programación de los encuentros.

VistaResultados

La VistaResultados permite registrar y consultar los resultados de los partidos que ya se han jugado.
Esta información se utiliza posteriormente para calcular la clasificación del torneo.

VistaClasificacion

La VistaClasificacion muestra la tabla de posiciones de los participantes en el torneo.
La clasificación se genera con base en los resultados registrados en los partidos.

VistaGrafo

La VistaGrafo representa gráficamente las relaciones entre los participantes mediante una estructura de grafo.
Esta vista permite visualizar los enfrentamientos entre los equipos y analizar la estructura de la competición.

