package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private var noteIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Log.d("DetailActivity", "onCreate")

        noteIndex = intent.getIntExtra("NOTE_INDEX", -1)

        if (noteIndex < 0 || noteIndex >= NoteStorage.notes.size) {
            Log.e("DetailActivity", "Заметка не найдена")
            finish()
            return
        }

        val btnEdit = findViewById<Button>(R.id.btnEdit)

        btnEdit.setOnClickListener {
            Log.i("DetailActivity", "Нажата кнопка редактирования")

            val intent = Intent(this, EditNoteActivity::class.java)
            intent.putExtra("NOTE_INDEX", noteIndex)

            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("DetailActivity", "onResume")

        if (noteIndex >= 0 && noteIndex < NoteStorage.notes.size) {
            val note = NoteStorage.notes[noteIndex]

            val titleText = findViewById<TextView>(R.id.tvNoteTitle)
            val contentText = findViewById<TextView>(R.id.tvNoteContent)

            titleText.text = note.title
            contentText.text = note.content

            Log.d("DetailActivity", "Заметка отображена: ${note.title}")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("DetailActivity", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DetailActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DetailActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DetailActivity", "onDestroy")
    }
}
