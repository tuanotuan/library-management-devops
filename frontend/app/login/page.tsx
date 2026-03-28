"use client";
import { useState } from "react";
import axios from "axios";
import Cookies from "js-cookie";
import { useRouter } from "next/navigation";

export default function LoginPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const router = useRouter();

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      // Gọi API lấy "Thẻ bài"
      const response = await axios.post("http://localhost:8080/api/auth/login", {
        username,
        password,
      });
      
      const token = response.data; // Đây là chuỗi eyJ...
      
      // Cất thẻ bài vào Cookie (để F5 không bị mất)
      Cookies.set("token", token, { expires: 1 }); // Hết hạn sau 1 ngày
      
      alert("Đăng nhập ngon rồi mày ơi!");
      router.push("/"); // Về trang chủ xem sách
    } catch (error) {
      alert("Sai pass hoặc lỗi rồi!");
    }
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <form onSubmit={handleLogin} className="p-8 bg-gray-100 rounded shadow-md">
        <h1 className="mb-4 text-2xl font-bold text-black">Đăng nhập đi mày</h1>
        <input
          type="text"
          placeholder="Username"
          className="w-full p-2 mb-4 border rounded text-black"
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          className="w-full p-2 mb-4 border rounded text-black"
          onChange={(e) => setPassword(e.target.value)}
        />
        <button className="w-full p-2 text-white bg-blue-500 rounded hover:bg-blue-600">
          Vào Bar
        </button>
      </form>
    </div>
  );
}