FROM amazoncorretto:8

COPY /target/social-media-0.0.1-SNAPSHOT.jar /socialmedia.jar

CMD ["java","-jar","socialmedia.jar","--spring.profiles.active=prod"]
