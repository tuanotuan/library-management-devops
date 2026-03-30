# --- STAGE 1: Build (Cái bếp để nấu) ---
FROM node:20-alpine AS builder
WORKDIR /app

# Check định danh để cache thư viện
COPY package*.json ./
RUN npm install

# Copy source và build
COPY . .
# Next.js sẽ tự tạo ra folder standalone nhờ cái config 'output: standalone'
RUN npm run build

# --- STAGE 2: Run (Cái đĩa để dọn món - Chỉ lấy thứ cần thiết) ---
FROM node:20-alpine AS runner
WORKDIR /app

# Thiết lập môi trường Production
ENV NODE_ENV=production

# CHỈ COPY những thứ thực sự cần để chạy app
# 1. Folder public (ảnh, icon...)
COPY --from=builder /app/public ./public
# 2. Folder standalone (chứa code đã nén và server.js)
COPY --from=builder /app/.next/standalone ./
# 3. Folder static (css, js cho trình duyệt)
COPY --from=builder /app/.next/static ./.next/static

EXPOSE 3000

# Next.js standalone chạy bằng node server.js chứ không dùng npm start nữa
CMD ["node", "server.js"]