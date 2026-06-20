# Tahap 1: Bina projek menggunakan Maven/Ant
FROM maven:3.8-openjdk-11 AS build
COPY . /usr/src/app
# Tukar WORKDIR ke folder utama supaya dia nampak build.xml
WORKDIR /usr/src/app
# Pasang ant dan jalankan build
RUN apt-get update && apt-get install -y ant && ant

# Tahap 2: Jalankan aplikasi dalam Tomcat
FROM tomcat:9-jdk11-openjdk
# Salin fail .war yang telah dibina (biasanya dalam folder dist) ke webapps Tomcat
COPY --from=build /usr/src/app/dist/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
