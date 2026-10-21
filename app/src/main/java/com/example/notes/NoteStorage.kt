package com.example.notes

// Одна заметка
data class Note(
    var title: String,
    var content: String
)

// Общее хранилище заметок
object NoteStorage {

    val notes = mutableListOf(
        Note("Купить продукты", "Молоко, хлеб, яйца"),
        Note("Домашнее задание", "Сделать практическую работу"),
        Note("Планы на выходные", "Встретиться с друзьями")
    )
}
