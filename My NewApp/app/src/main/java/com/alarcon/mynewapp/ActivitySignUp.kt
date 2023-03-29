package com.alarcon.mynewapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class ActivitySignUp : AppCompatActivity() {
//    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_to_signup)

             // Find the views in the layout by their IDs
        val welcomeToTextView = findViewById<TextView>(R.id.welcome_text)
        val firestoreTextView = findViewById<TextView>(R.id.firestore_text)
        val createAccountTextView = findViewById<TextView>(R.id.create_account_text)
        val facebookButton = findViewById<Button>(R.id.facebook_button)
        val googleButton = findViewById<Button>(R.id.google_button)
        val signUpButton = findViewById<Button>(R.id.sign_up_button)


        // Set the text for the "Welcome to Firestore" TextView
        welcomeToTextView.text = "Welcome to"

        // Set the text for the "Firestore" TextView with larger font size
        firestoreTextView.text = "Firestore"
        firestoreTextView.textSize = 45f

        // Set the text for the "Let's create an account to save your file" TextView
        createAccountTextView.text = "Let's create an account to save your file"

        // Set the text and onClickListener for the "Continue with Facebook" Button
        facebookButton.text = "Continue with Facebook"
        facebookButton.setOnClickListener {
            // Replace with your logic for handling Facebook sign-in
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Set the text and onClickListener for the "Continue with Google" Button
        googleButton.text = "Continue with Google"
        googleButton.setOnClickListener {
            // Replace with your logic for handling Google sign-in
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Set the text and onClickListener for the "Sign Up" Button
        signUpButton.text = "Sign Up"
        signUpButton.setOnClickListener {

        }
    }

}
//package com.alarcon.mynewapp
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat
//import com.google.android.material.button.MaterialButton
//import com.google.android.material.textview.MaterialTextView
//
//class ActivitySignUp : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.welcome_to_signup)
//
//        // Find the views in the layout by their IDs
//        val welcomeToTextView = findViewById<MaterialTextView>(R.id.welcome_text)
//        val firestoreTextView = findViewById<MaterialTextView>(R.id.firestore_text)
//        val createAccountTextView = findViewById<MaterialTextView>(R.id.create_account_text)
//        val facebookButton = findViewById<MaterialButton>(R.id.facebook_button)
//        val googleButton = findViewById<MaterialButton>(R.id.google_button)
//        val signUpButton = findViewById<MaterialButton>(R.id.sign_up_button)
//
//        // Set the text for the "Welcome to Firestore" TextView
//        welcomeToTextView.text = "Welcome to"
//
//        // Set the text for the "Firestore" TextView with larger font size
//        firestoreTextView.text = "Firestore"
//        firestoreTextView.textSize = 45f
//
//        // Set the text for the "Let's create an account to save your file" TextView
//        createAccountTextView.text = getString(R.string.let_s_create_an_account_to_save_your_file)
//
//        // Set the text and onClickListener for the "Continue with Facebook" Button
//        facebookButton.text = "Continue with Facebook"
//        facebookButton.setOnClickListener {
//            // Replace with your logic for handling Facebook sign-in
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//
//        // Set the text and onClickListener for the "Continue with Google" Button
//        googleButton.text = "Continue with Google"
//        googleButton.setOnClickListener {
//            // Replace with your logic for handling Google sign-in
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//
//        // Set the text and onClickListener for the "Sign Up" Button
//        signUpButton.text = "Sign Up"
//        signUpButton.setOnClickListener {
//            // Replace with your logic for handling sign-up
//        }
//    }
//}

