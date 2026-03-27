# Library Management - API Contract (RESTful)

## 🔐 Authentication
| Method | Endpoint | Description | Body |
| :--- | :--- | :--- | :--- |
| POST | `/api/auth/register` | Đăng ký tài khoản | `{username, password}` |
| POST | `/api/auth/login` | Đăng nhập lấy Token | `{username, password}` |

## 📚 Books Management
| Method | Endpoint | Role | Description |
| :--- | :--- | :--- | :--- |
| GET | `/api/books` | Public | Xem danh sách sách |
| POST | `/api/books` | Admin | Thêm sách mới |
| PUT | `/api/books/{id}` | Admin | Cập nhật thông tin sách |
| DELETE | `/api/books/{id}` | Admin | Xóa sách |

## 🤝 Borrowing Logic
| Method | Endpoint | Role | Description |
| :--- | :--- | :--- | :--- |
| POST | `/api/borrow/{bookId}` | User | Đăng ký mượn sách |
| POST | `/api/return/{recordId}` | User | Xác nhận trả sách |
| GET | `/api/records/me` | User | Xem lịch sử mượn cá nhân |

> **Note:** Tất cả các API yêu cầu Role (Admin/User) đều phải đính kèm `Authorization: Bearer <JWT_TOKEN>` vào Header.