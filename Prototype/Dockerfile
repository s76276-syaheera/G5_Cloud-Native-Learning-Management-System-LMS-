FROM tomcat:9-jdk11-openjdk
# Salin fail .war dari folder projek ke dalam Tomcat
COPY CloudNativeLMSUpdated/dist/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
