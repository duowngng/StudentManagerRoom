package vn.edu.hust.roomexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
  @Query("select * from students")
  fun getAllStudents(): List<Student>

  @Query("select * from students where mssv=:mssv")
  fun findStudentById(mssv: String): List<Student>

  @Query("select * from students where hoten like :name")
  fun findStudentByName(name: String): List<Student>

  @Insert
  fun insertStudent(student: Student): Long
}