package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var TxtgotoSignUp:TextView
    lateinit var edtLoginEmail:EditText
    lateinit var edtLoginPassword:EditText
    lateinit var btnLogin:Button
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TxtgotoSignUp=findViewById(R.id.TxtLogtoSignup)
        edtLoginEmail=findViewById(R.id.edtLoginEmail)
        edtLoginPassword=findViewById(R.id.edtLoginPassword)
        btnLogin=findViewById(R.id.btn_login)
        auth= FirebaseAuth.getInstance()

        TxtgotoSignUp.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            Login()

        }
    }
    private fun Login() {
        val email=edtLoginEmail.text.toString()
        val password=edtLoginPassword.text.toString()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener (this){
            if (it.isSuccessful){
                val intenention=Intent(this,ListofCanteens::class.java)
                startActivity(intenention)
               // Toast.makeText(this,"LoginSucceful",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()
            }
        }
    }


}