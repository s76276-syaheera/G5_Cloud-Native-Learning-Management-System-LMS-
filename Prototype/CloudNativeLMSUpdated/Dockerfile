# Tahap 1: Bina projek (Kompilasi)
FROM eclipse-temurin:11-jdk-jammy AS build
COPY . /usr/src/app
WORKDIR /usr/src/app

# 1. Muat turun servlet-api.jar supaya javac kenal javax.servlet
RUN apt-get update && apt-get install -y wget && \
    wget https://repo1.maven.org/maven2/javax/servlet/javax.servlet-api/4.0.1/javax.servlet-api-4.0.1.jar -O servlet-api.jar

# 2. Kompilasi dengan menyertakan servlet-api.jar dalam classpath (-cp)
RUN mkdir -p build && \
    find src -name "*.java" > sources.txt && \
    javac -cp "servlet-api.jar" -d build @sources.txt

# Tahap 2: Jalankan dalam Tomcat
FROM tomcat:9-jdk11-openjdk-slim
# Salin fail .class ke dalam folder yang betul
COPY --from=build /usr/src/app/build /usr/local/tomcat/webapps/ROOT/WEB-INF/classes
# Salin folder web (jsp, html, css) ke dalam ROOT
COPY --from=build /usr/src/app/web /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]
