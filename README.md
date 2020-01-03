# segundamano
Test SegundaMano

# Importante: Dado que la API: http://data.fixer.io/ solo es gratis para consultas por una fecha (y no por rango de fechas) se utilizó una lógica para llamarla 10 veces y mostrar un histórico, si se pagará la licencia de la API podríamos usar el método para rango de fechas sin ningun problema

##### Este proyecto usa Clean Architecture, y tiene 2 módulos (App y Converter) 
* El Módulo de Converter tiene las siguientes capas
  * Data
  * Domain 
  * Interactors
 * El Módulo App tiene las siguientes capas
  * Presentation
  * Framework
  
  * ¿Qué hace cada capa?
  
  * Data: Contiene todo lo relacionado a los datos de la aplicación, su acceso, guardado etc. En ella se guardaron los services: (para conexión con la API), dataSource: Interfaz que define los métodos para el acceso y guardado de los datos, repository: Es el encargado de orquestar las dos anteriores, usando el patrón repository el cual si hay error en los datos que obtenemos por internet, carga los datos en caché
  * Domain: Capa que tiene los objetos de negocio
  *Interactor: Es la capa puente entre el módulo App y el módulo converter
  
  * Presentation: Usando MVVM y LiveData es la capa encargada de la presentación de los datos al usuario
  * Framework: Todos los objetos que tienen relación directa con el SDK de Android y librerías relacionadas, en esta capa está la implementación del dataSource de la capa Data de Converter y toda la lógica se base de datos usando Room
  
  
####  Librerías y tecnologías usadas:

* API: http://data.fixer.io
* Lenguaje: Kotlin
* Room: para Base de datos
* Retrofit: Conexión con API
* Corutinas: Para llamadas asíncronas
* MVVM: Como patron para la capa presentación
* Dagger: Inyección de dependencias (Para este ejemplo se usó para inyectar el repository en la activity, pero es posible usarlo para inyectar todos los componenter, como una instancia de retrofit, etc)
* MPAndroidChart: como ayuda para mostrar los datos en gráficas

