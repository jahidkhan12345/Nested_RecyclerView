package com.androidshubh.nestedrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(),TeacherOnclick {
    private lateinit var students: ArrayList<StudentModel>
    private lateinit var adapter: TeacherAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        students = arrayListOf()
        val teachers = ArrayList<TeacherModel>()
        students.add(StudentModel(1,"Jahid Raj","Paiga","Android"))
        students.add(StudentModel(2,"Bipul kumar", "janta bazar", "Android"))
        students.add(StudentModel(3,"Mustufa Ansari", "Tara Amnour", "Android"))
        students.add(StudentModel(4,"Sachin", "Shekhpura", "Android"))
        students.add(StudentModel(5,"Rashid Khan", "Paiga", "Android"))
        students.add(StudentModel(6,"Azim Raja", "Tara Amnour", "Android"))
        students.add(StudentModel(7,"Rohit kumar", "Paiga", "Android"))
        students.add(StudentModel(8,"Ahmad Raja", "Paiga", "Android"))

        teachers.add( TeacherModel(1,"Rahul Raj","Android" ,students))
        teachers.add( TeacherModel(2,"Ansar Ali","Android" ,students))

        val teacherList = findViewById<RecyclerView>(R.id.teacherList)
        adapter = TeacherAdapter(this, teachers,this)
        teacherList.adapter = adapter

    }

    @SuppressLint("InflateParams", "NotifyDataSetChanged")
    override fun addStudent() {

        val bottomSheet= BottomSheetDialog(this)
        val layout= LayoutInflater.from(this).inflate(R.layout.add_student_item,null)
        val addName= layout.findViewById<EditText>(R.id.addName)
        val addAddress= layout.findViewById<EditText>(R.id.addAddress)
        val addBatch= layout.findViewById<EditText>(R.id.addBatch)
        val doneBtn= layout.findViewById<Button>(R.id.doneBtn)

        doneBtn.setOnClickListener {

            students.add(StudentModel(9,addName.text.toString(),addAddress.text.toString(),addBatch.text.toString()))
            adapter.notifyDataSetChanged()
            bottomSheet.dismiss()
        }

       bottomSheet.setContentView(layout)
        bottomSheet.show()
    }
}