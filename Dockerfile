FROM public.ecr.aws/amazoncorretto/amazoncorretto:11

WORKDIR /opt/app

COPY target/hotel-book-service.jar /opt/app/hotel-book-service.jar

ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dspring.profiles.active=dev", "-Dorg.apache.catalina.STRICT_SERVLET_COMPLIANCE=true", "-jar", "/opt/app/hotel-book-service.jar"]

EXPOSE 8080