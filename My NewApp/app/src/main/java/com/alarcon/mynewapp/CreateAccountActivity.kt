package com.alarcon.mynewapp

//import android.os.Bundle
//import android.widget.Button
//import android.widget.CheckBox
//import android.widget.EditText
//import androidx.appcompat.app.AppCompatActivity
//import com.alarcon.mynewapp.CreateAccountActivity
//
//
//class CreateAccountActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.create_account)
//
////        val nameInput: EditText = findViewById(R.id.name_input)
//        val emailInput: EditText = findViewById(R.id.email_input)
//        val passwordInput: EditText = findViewById(R.id.password_input)
////        val termsCheckbox: CheckBox = findViewById(R.id.term_conditions_checkbox)
//        val signUpButton: Button = findViewById(R.id.sign_up_button)
//
//        signUpButton.setOnClickListener {
////            val name = nameInput.text.toString()
//            val email = emailInput.text.toString()
//            val password = passwordInput.text.toString()
//
//            // Your code to create an account here
//
////            if (termsCheckbox.isChecked) {
//                // Redirect user to Terms and Conditions page
////            } else {
//                // Show error message asking user to agree to terms
//            }
//        }
//    }


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_member)

        // Find views by their ID
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signupButton = findViewById<Button>(R.id.signupButton)

        // TODO: Implement sign up logic here
    }
}
