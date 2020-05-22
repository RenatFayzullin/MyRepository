package com.example.firstmyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private val TAG = "LoginActivity"
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG,"onCreate")
        login_btn.isEnabled = false
        email_input.addTextChangedListener(this)
        password_input.addTextChangedListener(this)
        login_btn.setOnClickListener(this)
        mAuth = FirebaseAuth.getInstance()

    }

    override fun onClick(v: View) {
        val email = email_input.text.toString()
        val password = password_input.text.toString()
        if (validate(email, password)) {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if(it.isSuccessful){
            startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
        else {
            Toast.makeText(this,"Please enter email and password",Toast.LENGTH_SHORT)
                .show()
        }

    }
    private fun validate(email: String, password: String)=
        email.isNotEmpty()&&password.isNotEmpty()

    override fun afterTextChanged(s: Editable?) {
        login_btn.isEnabled = validate(email_input.text.toString(),password_input.text.toString())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}
