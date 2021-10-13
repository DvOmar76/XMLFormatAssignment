package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var students:List<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val parser=XmlPullParserHandler()
            val iStream=assets.open("student.xml")
            students=parser.parse(iStream)
            recyclerView.adapter=RVAdapter(students)
            recyclerView.layoutManager=LinearLayoutManager(this)
        }catch (e:IOException){
            Log.d("00000ssssss",e.toString())
        }
    }
}