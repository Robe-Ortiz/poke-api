![Logotipo de Pokemon](pokemon_readme.png)

# Introducción

Este repositorio es una tarea de clase en la que se nos ha pedido entender el funcionamiento de JSON y cómo deserializar la información.

# Desarrollo

El objetivo era crear una lista de Pokémon obtenida mediante la PokéAPI. Desde esa lista, se debería poder seleccionar cualquier Pokémon para mostrar información detallada mediante otra llamada a la API.

Como extra, he decidido incluir un navbar con opciones para las distintas generaciones.

Inicialmente, las llamadas para obtener los datos de las generaciones eran bastante lentas, ya que se realizaban de forma síncrona.

Posteriormente, implementé un enfoque asíncrono para evitar esperar a que se completara una solicitud antes de enviar otra.

El único inconveniente es que la información llegaba desordenada; sin embargo, almacené los datos en una lista en la cual pude ordenar los Pokémon según su campo id.
