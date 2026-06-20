# Tahap 1: Bina projek menggunakan Maven/Ant
FROM maven:3.8-openjdk-11 AS build
COPY . /usr/src/app
# Kita kena masuk ke dalam folder CloudNativeLMSUpdated di mana build.xml berada
WORKDIR /usr/src/app/CloudNativeLMSUpdated
# Pasang ant dan jalankan build
RUN apt-get update && apt-get install -y ant && ant

# Tahap 2: Jalankan aplikasi dalam Tomcat
FROM tomcat:9-jdk11-openjdk
# Salin fail .war yang telah dibina ke webapps Tomcat
# Nota: Ant biasanya letak output dalam folder 'dist' di dalam folder projek
COPY --from=build /usr/src/app/CloudNativeLMSUpdated/dist/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
