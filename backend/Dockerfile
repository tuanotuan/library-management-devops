# 1. Mượn cái máy có sẵn Java 17 bản nhẹ (Alpine) để chạy app cho đỡ tốn RAM
FROM eclipse-temurin:21-jdk-alpine

# 2. Tạo một cái thư mục tên là /app bên trong "thế giới ảo" của Docker
WORKDIR /app

# 3. Bốc cái file .jar mày vừa build xong ở thư mục target/ ném vào trong Docker
# Lưu ý: Cái tên file phải khớp với cái mày thấy trong ảnh lúc nãy nhé
COPY target/library-backend-0.0.1-SNAPSHOT.jar app.jar

# 4. Mở cái cổng 8080 để tí nữa mình còn "thò tay" vào gọi API được
EXPOSE 8080

# 5. Lệnh để tự động bật cái App lên mỗi khi Container này khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]