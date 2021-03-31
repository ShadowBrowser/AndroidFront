package com.example.shadowbrowser

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        reset_shadow_btn.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            //Set message
            dialogBuilder.setMessage("Are you sure you want to reset Shadow Browser?")
                    .setCancelable(true)
                    .setPositiveButton("YES", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                    })
                    .setNegativeButton("NO", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                    })

            val alert = dialogBuilder.create()
            alert.setTitle("Confimation")
            alert.show()

        }
    }
}