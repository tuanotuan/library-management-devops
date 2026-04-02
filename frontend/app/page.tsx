'use client';
import { useEffect, useState } from 'react';
import axios from 'axios';

export default function Home() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    // Gọi API từ Backend Java (Cổng 8080)
    axios.get('/api/books')
      .then(res => setBooks(res.data))
      .catch(err => console.error("Lỗi rồi mày ơi:", err));
  }, []);

  return (
    <div className="p-10">
      <h1 className="text-3xl font-bold mb-5">Thư viện của Tuấn o Tuấn</h1>
      <div className="grid gap-4">
        {books.map((book: any) => (
          <div key={book.id} className="p-4 border rounded-lg shadow-sm bg-white text-black">
            <h2 className="text-xl font-semibold">{book.title}</h2>
            <p className="text-gray-600">Tác giả: {book.author}</p>
          </div>
        ))}
        {books.length === 0 && <p>Đang đợi Backend trả hàng...</p>}
      </div>
    </div>
  );
}