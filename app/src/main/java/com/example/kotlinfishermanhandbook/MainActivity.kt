package com.example.kotlinfishermanhandbook

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinfishermanhandbook.ui.theme.KotlinFishermanHandbookTheme
import com.google.android.material.navigation.NavigationView
import android.widget.ImageView
import android.widget.SimpleAdapter.ViewBinder
import androidx.compose.material3.LinearProgressIndicator
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfishermanhandbook.databinding.ActivityMainBinding



private lateinit var adapter: MyAdapter
private lateinit var drawerLayout: DrawerLayout
private var currentLayout: String = "main"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener (this)
        drawerLayout = findViewById(R.id.drawerLayout)


        var list = ArrayList<ListItem>()
        list.addAll(fillArras(resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_content),
                getImageId(R.array.fish_image_array),
        ))

        // Инициализация RecyclerView
        val rcView = findViewById<RecyclerView>(R.id.rcView)

        // Устанавливаем фиксированный размер для улучшения производительности
        rcView.setHasFixedSize(true)

        // Устанавливаем LayoutManager
        rcView.layoutManager = LinearLayoutManager(this)

        // Инициализация адаптера
        adapter = MyAdapter(list, this)

        rcView.adapter = adapter

    }
    internal fun saveNote(note: String) {
        val sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("saved_note", note) // Сохраняем заметку под ключом "saved_note"
        editor.apply() // Применяем изменения
    }

    internal fun showNotes() {
        // Устанавливаем контент для интерфейса заметок
        setContentView(R.layout.notes)
        currentLayout = "notes" // Устанавливаем текущий экран как заметки

        // Находим элементы UI
        val editTextNote = findViewById<EditText>(R.id.edTitle)
        val buttonSave = findViewById<Button>(R.id.button)

        // Загружаем сохранённую заметку
        loadNote()

        // Обработчик нажатия на кнопку сохранения
        buttonSave.setOnClickListener {
            val note = editTextNote.text.toString()
            if (note.isNotEmpty()) {
                saveNote(note)
                Toast.makeText(this, "Заметка сохранена", Toast.LENGTH_SHORT).show()
                editTextNote.text.clear()
            } else {
                Toast.makeText(this, "Введите текст заметки", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        if (currentLayout == "notes") { // проверка, какой текущий экран отображается
            currentLayout = "main" // Обновляем текущий экран на "main"
            // Переходим обратно на главный экран
            loadMainActivity()
        } else {
            super.onBackPressed() // обработка стандартного поведения кнопки "Назад"
        }
    }

    private fun loadMainActivity() {
        // Здесь используем setContentView, чтобы вернуться к activity_main
        setContentView(R.layout.activity_main)

        // После этого необходимо восстановить состояние RecyclerView, если это необходимо
        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = adapter // Возможно, вы хотите установить адаптер снова
    }

    internal fun loadNote() {
        val sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)
        val savedNote = sharedPreferences.getString("saved_note", "")
        // Устанавливаем текст в EditText
        val editTextNote = findViewById<EditText>(R.id.edTitle)
        editTextNote.setText(savedNote)
    }

    fun getCurrentLayout(): String {
        return currentLayout
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.id_fish -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_content),
                        getImageId(R.array.fish_image_array)
                    )
                )

            }

            R.id.id_Na -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.na),
                        resources.getStringArray(R.array.na_content),
                        getImageId(R.array.fish_image_array)
                    )
                )

            }
            R.id.id_Sna -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.sna),
                        resources.getStringArray(R.array.sna_content),
                        getImageId(R.array.fish_image_array)
                    )
                )

            }
            R.id.id_History -> {
                adapter?.updateAdapter(
                    fillArras(
                        resources.getStringArray(R.array.history),
                        resources.getStringArray(R.array.history_content),
                        getImageId(R.array.fish_image_array)
                    )
                )
                currentLayout = "main" // Устанавливаем текущий экран как "main"
            }

            R.id.id_Notes -> {

                showNotes()


            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    fun fillArras(titleArray:Array<String>,contentArray:Array<String>, imageArray: IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for(n in 0 ..titleArray.size-1){
            var listItem=ListItem(imageArray[n], titleArray[n],contentArray[n] )
            listItemArray.add(listItem)
        }
        return listItemArray
    }
    fun getImageId(imageArrayId:Int):IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count =tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}