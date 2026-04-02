# Stage 1: Build - Dùng Maven để build từ source
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
# Tải dependencies trước để cache (cho nhanh lần sau)
RUN gradle build -x test --dry-run || true
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run - Chỉ lấy file jar sang JRE Alpine siêu nhẹ
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy file jar từ stage build sang
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]