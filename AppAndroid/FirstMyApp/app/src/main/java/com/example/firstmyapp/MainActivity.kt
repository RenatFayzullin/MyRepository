package com.example.firstmyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*
import models.User

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate")

        mAuth = FirebaseAuth.getInstance()
//        mAuth.signOut()

//        auth.signInWithEmailAndPassword("renat@yandex.ru","password").addOnCompleteListener {
//            if (it.isSuccessful){
//                Log.d(TAG,"signIn: success")
//            } else{
//                Log.e(TAG,"signIn: failure", it.exception )
//            }
//        }


//        val auth = FirebaseAuth.getInstance()
//        val user = auth.currentUser
//        val database = FirebaseDatabase.getInstance().reference
//        database.child("users").child(user!!.uid).addListenerForSingleValueEvent(object : ValueEventListener{
//            override fun onDataChange(data: DataSnapshot) {
//                val user = data.getValue(User::class.java)
//                name_input.setText(user!!.name,TextView.BufferType.EDITABLE)
//                username_input.setText(user.username, TextView.BufferType.EDITABLE)
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.e(TAG,"onCancelled",error.toException())
//            }
//
//        })
        // по идее код с 39 по 54 строчку должен сохранять данные пользователя из баззы данных FireBase,
        // но у меня вылетает приложение и я не понимаю почему

        sign_out_text.setOnClickListener{
            mAuth.signOut()
        }
        mAuth.addAuthStateListener {
            if(it.currentUser == null){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }


    }

    override fun onStart() {
        super.onStart()
        if (mAuth.currentUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

}
