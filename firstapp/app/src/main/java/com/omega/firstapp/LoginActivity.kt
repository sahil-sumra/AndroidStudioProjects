package com.omega.firstapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    lateinit var monumber: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var forgotPass: TextView
    lateinit var signup: TextView
    val validMobileNumber = "9054700991"
    val validPassword =
        arrayOf("sahil", "tony", "Spider Man", "bat", "ant", "captain", "deadpool", "jessica")

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }


        setContentView(R.layout.activity_login)
        title = "Log In"
        monumber = findViewById(R.id.monumber)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        forgotPass = findViewById(R.id.forgotPass)
        signup = findViewById(R.id.signup)


// ************* toast long code *****************
//    override fun onClick(p0: View?) {
//        Toast.makeText(this@LoginActivity, "we clicked on the button" , Toast.LENGTH_LONG).show()
//
//    }

//        ***********short cut[*****************
        login.setOnClickListener {
            val mobileNumbr = monumber.text.toString()
            val pass = password.text.toString()
            var nameOfAvengers = "Avengers"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if (mobileNumbr == validMobileNumber) {
                if (pass == validPassword[0]) {

                    nameOfAvengers = "Iron man"
                    savePreference(nameOfAvengers)

//                    intent.putExtra("Name", nameOfAvengers)
                    startActivity(intent)
                } else if (pass == validPassword[1]) {
                    nameOfAvengers = "Spider Man "
                    savePreference(nameOfAvengers)

                    startActivity(intent)
                } else if (pass == validPassword[2]) {
                    nameOfAvengers = "Bat man"
                    savePreference(nameOfAvengers)

                    startActivity(intent)
                } else if (pass == validPassword[3]) {
                    nameOfAvengers = "Ant Man"

                    savePreference(nameOfAvengers)

                    startActivity(intent)
                } else if (pass == validPassword[4]) {

                    nameOfAvengers = "Captain America"
                    savePreference(nameOfAvengers)


                    startActivity(intent)
                } else if (pass == validPassword[5]) {

                    nameOfAvengers = "Dead Pool"
                    savePreference(nameOfAvengers)


                    startActivity(intent)
                } else if (pass == validPassword[6]) {

                    nameOfAvengers = "Jessica"
                    savePreference(nameOfAvengers)

                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Enter Vakid Info", Toast.LENGTH_LONG).show()
                }


            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreference(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()

    }


}