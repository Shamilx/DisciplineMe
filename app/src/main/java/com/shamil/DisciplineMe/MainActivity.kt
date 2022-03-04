package com.shamil.DisciplineMe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.shamil.DisciplineMe.R
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import org.w3c.dom.Text
import java.sql.Time
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)

        LoadData()

        var fragment = ListViewFragment()
        var frTranscition = supportFragmentManager.beginTransaction()
        frTranscition.add(R.id.frameLayout1,fragment)
        frTranscition.commit()

        supportActionBar?.hide();
        var x = this.layoutInflater
        var test: View = x.inflate(R.layout.activity_main,null)

        var textView = findViewById<TextView>(R.id.motivatorTextView)
        textView.ellipsize = TextUtils.TruncateAt.MARQUEE
        textView.isSelected = true
        textView.isSingleLine = true

        var floatingButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingButton.setOnClickListener{
            AllData.Tasks.add(Task("hey","sg", Time(11,11,11)))
        }

    }

    override fun onStop() {
        SetData()
        super.onStop()
    }
    private fun LoadData() {
        var prefs = getSharedPreferences("allData", MODE_PRIVATE)
        var json = prefs?.getString("allData","")
        var gson = Gson()
        if(!json.isNullOrBlank()) {
            var obj = gson.fromJson(json, mutableListOf<Task>()::class.java)
            AllData.Tasks = obj
        }
    }

    private fun SetData() {
        var prefs = getSharedPreferences("allData", MODE_PRIVATE)
        with(prefs.edit()) {
            var gson = Gson()
            var json = gson.toJson(AllData.Tasks)
            putString("allData",json).apply()
        }
    }
}