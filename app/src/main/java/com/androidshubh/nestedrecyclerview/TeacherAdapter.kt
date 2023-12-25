package com.androidshubh.nestedrecyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class TeacherAdapter(val context: Context, private val teachersData: List<TeacherModel>, private val onclick: TeacherOnclick): RecyclerView.Adapter<TeacherAdapter.TeacherHolder>() {
    class TeacherHolder(itemView: View): RecyclerView.ViewHolder (itemView){
        val heading: TextView = itemView.findViewById(R.id.headingText)
        val teacherCard: CardView = itemView.findViewById(R.id.teacherCard)
        val studentListView: RecyclerView = itemView.findViewById(R.id.studentList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherHolder {
        val layout  = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item_list, parent,false)
        return TeacherHolder(layout)
    }

    override fun getItemCount(): Int {
       return  teachersData.size
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onBindViewHolder(holder: TeacherHolder, position: Int) {
        if (position%2==0){
            holder.studentListView.adapter = StudentAdapter(teachersData[position].students)

            holder.teacherCard.setCardBackgroundColor(Color.CYAN)
            holder.heading.setTextColor(Color.RED)
        }else {
            holder.studentListView.adapter = StudentAdapter1(teachersData[position].students)
            holder.heading.setTextColor(Color.MAGENTA)
            holder.teacherCard.setCardBackgroundColor(Color.LTGRAY)

        }
      holder.heading.text ="Name:-"+ teachersData[position].name

        holder.heading.setOnClickListener {
            onclick.addStudent()
        }
    }
}

class StudentAdapter(private val studentsData: List<StudentModel>): RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
    class StudentHolder(itemView: View): RecyclerView.ViewHolder (itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val batch: TextView = itemView.findViewById(R.id.batch)
        val address: TextView = itemView.findViewById(R.id.address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val layout  = LayoutInflater.from(parent.context).inflate(R.layout.student_item_list, parent,false)
        return StudentHolder(layout)
    }
    override fun getItemCount(): Int {
        return  studentsData.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentHolder, position: Int) {

//        if (position==1) {
//            holder.name.setTextColor(Color.YELLOW)
//        }
//        else{
//            holder.name.setTextColor(Color.GREEN)
//        }
        holder.name.text ="Name:-" + studentsData[position].sName
        holder.batch.text = "Batch:-"+ studentsData[position].sBatch
        holder.address.text ="Address:-" +studentsData[position].sAddress

    }
}

class StudentAdapter1(private val studentsData: List<StudentModel>): RecyclerView.Adapter<StudentAdapter1.StudentHolder1>() {
    class StudentHolder1(itemView: View): RecyclerView.ViewHolder (itemView){
        val name1: TextView = itemView.findViewById(R.id.name1)
        val batch1: TextView = itemView.findViewById(R.id.batch1)
        val address1: TextView = itemView.findViewById(R.id.address1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder1 {
        val layout  = LayoutInflater.from(parent.context).inflate(R.layout.student1_item_list, parent,false)
        return StudentHolder1(layout)
    }

    override fun getItemCount(): Int {
        return  studentsData.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StudentHolder1, position: Int) {
        holder.name1.text = "Name:-"+ studentsData[position].sName
        holder.batch1.text = "Batch:-"+ studentsData[position].sBatch
        holder.address1.text = "Address:-"+ studentsData[position].sAddress
    }
}