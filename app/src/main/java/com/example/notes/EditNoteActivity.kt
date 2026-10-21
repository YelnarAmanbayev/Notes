package com.example.notes

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        Log.d("EditNoteActivity", "onCreate")

        val titleInput = findViewById<EditText>(R.id.etNoteTitle)
        val contentInput = findViewById<EditText>(R.id.etNoteContent)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val index = intent.getIntExtra("NOTE_INDEX", -1)
        val isEditing = index >= 0 && index < NoteStorage.notes.size

        if (isEditing) {
            val note = NoteStorage.notes[index]

            titleInput.setText(note.title)
            contentInput.setText(note.content)

            Log.i("EditNoteActivity", "Редактирование: ${note.title}")
        }

        btnSave.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val content = contentInput.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {
                Log.w("EditNoteActivity", "Пустые поля")

                Toast.makeText(
                    this,
                    R.string.empty_fields,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (isEditing) {
                    NoteStorage.notes[index].title = title
                    NoteStorage.notes[index].content = content

                    Log.i("EditNoteActivity", "Заметка изменена: $title")
                } else {
                    NoteStorage.notes.add(Note(title, content))

                    Log.i("EditNoteActivity", "Заметка создана: $title")
                }

                Toast.makeText(
                    this,
                    R.string.note_saved,
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("EditNoteActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("EditNoteActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("EditNoteActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("EditNoteActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("EditNoteActivity", "onDestroy")
    }
}
