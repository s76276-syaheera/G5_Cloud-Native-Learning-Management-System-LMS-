# Tahap 1: Bina projek (Kompilasi)
# Gunakan imej eclipse-temurin yang sah dan stabil
FROM eclipse-temurin:11-jdk-jammy AS build
COPY . /usr/src/app
WORKDIR /usr/src/app

# Kompilasi fail Java secara manual
RUN mkdir -p build && \
    find . -name "*.java" > sources.txt && \
    javac -d build @sources.txt

# Tahap 2: Jalankan dalam Tomcat
# Kita guna imej tomcat yang padan dengan JDK 11
FROM tomcat:9-jdk11-openjdk
COPY --from=build /usr/src/app/build /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]
