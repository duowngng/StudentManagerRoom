package vn.edu.hust.roomexample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.edu.hust.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  lateinit var binding : ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.main)

    val studentDao = StudentDatabase.getInstance(this).studentDao()

    binding.buttonInsert.setOnClickListener {
      val hoten = binding.editHoten.text.toString()
      val mssv = binding.editMssv.text.toString()
      lifecycleScope.launch(Dispatchers.IO) {
        val result = studentDao.insertStudent(Student(hoten = hoten, mssv = mssv))
        Log.v("TAG", "Result: $result")
      }
    }

    binding.buttonGetAll.setOnClickListener {
      lifecycleScope.launch(Dispatchers.IO) {
        val students = studentDao.getAllStudents()
        Log.v("TAG", "Result: $students")
      }
    }
  }
}