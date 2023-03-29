package com.alarcon.mynewapp



    import android.os.Bundle
    import android.widget.Button
    import androidx.appcompat.app.AppCompatActivity
//    import kotlinx.android.synthetic.main.login_success.*

    class ActivityLogIn : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.login_success)
            val signUpButton: Button = findViewById(R.id.sign_up_button)
            signUpButton.setOnClickListener {
                // Handle sign in button click here
            }
        }
    }
