FROM openjdk:17-jdk-slim

# JAR 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

WORKDIR /app

# Railway 호환성을 위한 JVM 옵션
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# 환경변수를 통한 TNS_ADMIN 설정
ENV ORACLE_TNS_ADMIN=/app/wallet

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Doracle.net.tns_admin=${ORACLE_TNS_ADMIN} -jar app.jar"]