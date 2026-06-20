# Tahap 1: Bina projek menggunakan Maven/Ant
FROM maven:3.8-openjdk-11 AS build
COPY . /usr/src/app
WORKDIR /usr/src/app/CloudNativeLMSUpdated
# Gunakan Ant untuk bina projek (perlu ada ant dalam image)
RUN apt-get update && apt-get install -y ant && ant

# Tahap 2: Jalankan aplikasi dalam Tomcat
FROM tomcat:9-jdk11-openjdk
# Salin fail .war yang telah dibina dari tahap 1 ke webapps Tomcat
COPY --from=build /usr/src/app/CloudNativeLMSUpdated/dist/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
