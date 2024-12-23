package com.example.kotlinfishermanhandbook

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private val sharedPreferences: SharedPreferences =
        ApplicationProvider.getApplicationContext<Context>()
            .getSharedPreferences("notes", Context.MODE_PRIVATE)



    @Test
    fun testLoadNote() {
        // Set saved note in SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putString("saved_note", "This is a test note")
        editor.apply()

        activityScenarioRule.scenario.onActivity { activity ->
            // Load note into the interface
            activity.loadNote()

            // Check that EditText contains the loaded note
            val editTextNote = activity.findViewById<EditText>(R.id.edTitle)
            assertEquals("This is a test note", editTextNote.text.toString())
        }
    }

    @Test
    fun testNavigationToNotes() {
        activityScenarioRule.scenario.onActivity { activity ->
            // Navigate to notes screen
            activity.showNotes()

            // Check that the current layout changed to notes
            assertEquals("notes", activity.getCurrentLayout())
        }
    }

    @Test
    fun testBackPressed() {
        activityScenarioRule.scenario.onActivity { activity ->
            // Navigate to notes screen
            activity.showNotes()
            assertEquals("notes", activity.getCurrentLayout())

            // Press back button
            activity.onBackPressed()

            // Check that we returned to the main screen
            assertEquals("main", activity.getCurrentLayout())
        }
    }
}
