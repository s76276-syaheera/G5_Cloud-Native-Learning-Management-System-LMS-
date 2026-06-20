# Tahap 1: Bina projek (Kompilasi)
FROM eclipse-temurin:11-jdk-jammy AS build
COPY . /usr/src/app
WORKDIR /usr/src/app

# Kompilasi fail Java secara manual
# Kita guna folder /usr/src/app/src untuk kod sumber dan /usr/src/app/build untuk hasil
RUN mkdir -p build && \
    find src -name "*.java" > sources.txt && \
    javac -d build @sources.txt

# Tahap 2: Jalankan dalam Tomcat
# Gunakan imej rasmi Tomcat yang serasi dengan JDK 11
FROM tomcat:9-jdk11-openjdk-slim
# Salin fail .class yang telah dikompilasi ke folder aplikasi Tomcat
COPY --from=build /usr/src/app/build /usr/local/tomcat/webapps/ROOT/WEB-INF/classes
# Salin folder web (jsp, html, css) ke dalam ROOT
COPY --from=build /usr/src/app/web /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]
