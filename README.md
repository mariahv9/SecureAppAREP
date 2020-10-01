# SecureAppAREP

Proyecto para explorar los conceptos de web segura y la conexión con servicios usando https.

## Clonacion del repositorio 

Para clonar el proyecto usar el siguiente comando:

```
https://github.com/mariahv9/SecureAppAREP.git
```

### Ejecucion App

```
cd SecureAppAREP
mvn package
cd webSecure
java -cp java -cp target/classes;target/dependency/* edu.escuelaing.arep.SecureApp
```

### Despliegue de la App

Abrir el siguiente para ver el despliegue:

* [Despliegue AWS]()

### Control versionamiento

[![CircleCI](https://circleci.com/gh/mariahv9/SecureAppAREP.svg?style=svg&circle-token=fa8c51f3bedd926b133267148a5e3c22e1617f4a)](https://app.circleci.com/pipelines/github/mariahv9/ClientServicesAREP)

## Construido con 

* [Java 8](https://www.java.com/es/about/whatis_java.jsp)
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [AWS](https://console.aws.amazon.com/ec2/v2/home?region=us-east-1#Home:) - Despliegue
* [CircleCI](https://circleci.com/) - Control de versionamiento


## Autor

* **Maria Fernanda Hernandez Vargas** - [mariahv9](https://github.com/mariahv9)


## Licencia

Este proyecto está bajo la Licencia GNU General Public License - mira el archivo [LICENSE.txt](LICENSE.txt) para detalles