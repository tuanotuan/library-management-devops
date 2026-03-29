# 1. Dùng Node.js bản nhẹ (alpine)
FROM node:20-alpine

# 2. Tạo thư mục làm việc
WORKDIR /app

# 3. Copy file quản lý thư viện trước để cache cho nhanh
COPY package*.json ./

# 4. Cài đặt thư viện
RUN npm install

# 5. Copy toàn bộ code còn lại
COPY . .

# 6. Build project (dành cho Next.js/React)
RUN npm run build

# 7. Mở cổng 3000
EXPOSE 3000

# 8. Lệnh khởi chạy
CMD ["npm", "start"]