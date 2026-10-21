package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        val btnAdd = findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener {
            Log.i("MainActivity", "Добавление заметки")

            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
        showNotes()
    }

    private fun showNotes() {
        val container = findViewById<LinearLayout>(R.id.notesContainer)
        container.removeAllViews()

        for (i in NoteStorage.notes.indices) {
            val note = NoteStorage.notes[i]

            val textView = TextView(this)

            textView.text = note.title
            textView.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                resources.getDimension(R.dimen.note_title_size)
            )
            textView.setTextColor(getColor(R.color.notes_primary))
            textView.setBackgroundColor(getColor(R.color.notes_card))

            val padding = resources.getDimensionPixelSize(
                R.dimen.large_spacing
            )

            textView.setPadding(
                padding,
                padding,
                padding,
                padding
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.bottomMargin = resources.getDimensionPixelSize(
                R.dimen.note_spacing
            )

            textView.layoutParams = params

            container.addView(textView)

            textView.setOnClickListener {
                Log.i("MainActivity", "Открыта заметка: ${note.title}")

                val intent = Intent(
                    this,
                    DetailActivity::class.java
                )

                intent.putExtra("NOTE_INDEX", i)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}
