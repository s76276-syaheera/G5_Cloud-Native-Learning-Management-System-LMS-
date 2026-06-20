# Tahap 1: Kompilasi manual menggunakan javac
FROM openjdk:11-jdk-slim AS build
# Salin semua fail ke dalam direktori kerja
COPY . /app
WORKDIR /app

# Buat folder untuk simpan fail .class hasil kompilasi
RUN mkdir -p build/classes

# Kompilasi semua fail .java dalam folder src/ dan masukkan ke folder build/classes
# Kita anggap semua library jar berada dalam folder 'lib' (jika ada)
RUN find src -name "*.java" > sources.txt && \
    javac -d build/classes -sourcepath src @sources.txt

# Tahap 2: Jalankan aplikasi dalam Tomcat
FROM tomcat:9-jdk11-openjdk
# Salin fail .class atau .war yang telah siap ke dalam webapps Tomcat
# Jika awak mempunyai fail .war, salin terus ke ROOT.war
COPY --from=build /app/build/classes /usr/local/tomcat/webapps/ROOT
EXPOSE 8080
CMD ["catalina.sh", "run"]
