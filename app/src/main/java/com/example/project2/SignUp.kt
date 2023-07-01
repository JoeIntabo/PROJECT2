package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {
    lateinit var Txtgotologin:TextView
    lateinit var edtSignUpEmail:EditText
    lateinit var edtSignUpPassword:EditText
    lateinit var edtSignUpConfirmPassword:EditText
    lateinit var btnSignUp:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        Txtgotologin=findViewById(R.id.TxtSignUptoLog)
        edtSignUpEmail=findViewById(R.id.edtSignUpEmail)
        edtSignUpPassword=findViewById(R.id.edtSignUpPassword)
        edtSignUpConfirmPassword=findViewById(R.id.edtSignUpConfirmPassword)
        btnSignUp=findViewById(R.id.btn_SignUp)
        auth=Firebase.auth

        Txtgotologin.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
            SignUpUser()

        }
    }
    private fun SignUpUser(){
        val email=edtSignUpEmail.text.toString()
        val password=edtSignUpPassword.text.toString()
        val confirmpassword=edtSignUpConfirmPassword.text.toString()

        if (email.isBlank()||password.isBlank()||confirmpassword.isBlank()){
            Toast.makeText(this,"Password and Email can't be left blank",Toast.LENGTH_LONG)
            return
        }else if (password!=confirmpassword){
            Toast.makeText(this,"Passwords donot match",Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener (this){
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up Successfully",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
            }
        }
    }
}