FROM amazoncorretto:11-alpine-jdk

COPY /target/social-media-0.0.1-SNAPSHOT.jar /socialmedia.jar

CMD ["java","-jar","socialmedia.jar","--spring.profiles.active=prod"]
