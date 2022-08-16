FROM java:8-jdk-alpine

COPY /target/social-media-0.0.1-SNAPSHOT.jar /socialmedia.jar

CMD ["java","-jar","socialmedia.jar"]
