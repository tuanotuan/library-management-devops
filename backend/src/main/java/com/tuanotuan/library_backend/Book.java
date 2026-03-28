package com.tuanotuan.library_backend;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data // Tự tạo Getter/Setter nhờ Lombok
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
}