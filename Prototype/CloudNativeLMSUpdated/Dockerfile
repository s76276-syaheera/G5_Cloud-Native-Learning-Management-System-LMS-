# Tahap 1: Bina projek (Kompilasi)
FROM openjdk:11-jdk-slim AS build
COPY . /usr/src/app
WORKDIR /usr/src/app

# Kompilasi fail Java secara manual - TIADA ARAHAN ANT DI SINI
RUN mkdir -p build && \
    find . -name "*.java" > sources.txt && \
    javac -d build @sources.txt

# Tahap 2: Jalankan dalam Tomcat
FROM tomcat:9-jdk11-openjdk
# Salin hasil kompilasi ke folder ROOT supaya Tomcat boleh jalankan
COPY --from=build /usr/src/app/build /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]
