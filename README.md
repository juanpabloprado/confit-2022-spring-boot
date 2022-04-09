# ConfIT 2022 - Spring Boot and GraalVM

This is the code of my talk at ConfIT [Construyendo un API REST con Spring Boot y GraalVM](https://confit.es/ponencias/spring-boot/)

The slides are available at [https://es.slideshare.net/ilopmar/construyendo-un-api-rest-con-spring-boot-y-graalvm](https://es.slideshare.net/ilopmar/construyendo-un-api-rest-con-spring-boot-y-graalvm).

To build the runnable fatjar:

```
./gradlew assemble
```

To run the application:

```
docker run -it --rm -p 5432:5432 -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=demo postgres:14.2-alpine

java -jar build/libs/confit-0.0.1-SNAPSHOT.jar
```

To build the GraalVM native image:

```
sdk use java 22.0.0.2.r17-grl

gu install native-image # only the first time

./gradlew nativeBuild
```

To run the native image:

```
./build/native/nativeCompile/confit
```
