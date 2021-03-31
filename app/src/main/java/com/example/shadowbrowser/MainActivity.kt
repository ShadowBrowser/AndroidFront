package com.example.shadowbrowser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        /*moreButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }*/
        newtab_button.setOnClickListener {
            Snackbar.make(it, "New Tab Created", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun showMenu(v: View) {
        /*PopupMenu(this, v).apply {
            setOnMenuItemClickListener(this@MainActivity.onMenuItemClick())
            inflate(R.menu.menu_main)
            show()
        }*/
        val menu = PopupMenu(this, v)
        menu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.settings ->
                    showSettings()
                R.id.reload -> {
                    Toast.makeText(this@MainActivity, "Reloading I Guess...", Toast.LENGTH_SHORT).show()
                }
            }
            true
        })
        val inflater: MenuInflater = menu.menuInflater
        inflater.inflate(R.menu.menu_main, menu.menu)
        menu.show()
    }

    fun showSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}