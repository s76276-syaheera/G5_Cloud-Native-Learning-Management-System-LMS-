# Tahap 1: Bina projek
FROM openjdk:11-jdk-slim AS build
COPY . /app
WORKDIR /app

# Kompilasi fail Java
RUN mkdir -p build/classes && \
    find src -name "*.java" > sources.txt && \
    javac -d build/classes -sourcepath src @sources.txt

# Tahap 2: Jalankan dalam Tomcat
FROM tomcat:9-jdk11-openjdk
# Salin fail .class ke webapps/ROOT/WEB-INF/classes
COPY --from=build /app/build/classes /usr/local/tomcat/webapps/ROOT/WEB-INF/classes
# Salin fail web (seperti .jsp, .html, .css)
COPY --from=build /app/web /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]
