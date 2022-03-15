package com.example.week_5_task


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AlertDialog

import com.example.week_5_task.databinding.ActivityMainBinding
import kotlin.math.sign


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.gdSignUp.setOnClickListener { signupForm() }

        emailFocusListener()
        phoneFocusListener()
        nameFocusListener()

}
    private fun signupForm(){
        binding.svEmail.helperText = validEmail()
        binding.tvFullName.helperText = validName()
        binding.qrPhoneNumber.helperText = validPhone()

        val validEmail = binding.svEmail.helperText == null
        val validName = binding.tvFullName.helperText == null
        val validPhone = binding.qrPhoneNumber.helperText == null


        if (validEmail && validName && validPhone)
            resetForm()
        else
            invalidForm()

    }
    private fun invalidForm(){
      var message = ""
        if (binding.svEmail.helperText != null)
            message += "\n\nEmail: " + binding.svEmail.helperText
        if (binding.tvFullName.helperText != null)
            message += "\n\nName: " + binding.tvFullName.helperText
        if (binding.qrPhoneNumber.helperText != null)
            message += "\n\nPhone: " + binding.qrPhoneNumber.helperText


        AlertDialog.Builder(this)
            .setTitle("invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                //do something
            }
            .show()

    }
    private  fun resetForm(){

        var message = "Email: " + binding.eaEmail.text
            message += "\nName: " + binding.edFullName.text
            message += "\nPhone: " + binding.rbPhoneNumber.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                //do something
                binding.eaEmail.text = null
                binding.edFullName.text = null
                binding.rbPhoneNumber.text = null

                binding.svEmail.helperText = getString(R.string.required)
                binding.tvFullName.helperText = getString(R.string.required)
                binding.qrPhoneNumber.helperText = getString(R.string.required)
            }
            .show()

        val intent = Intent (this,MainActivity2::class.java)
        startActivity(intent)

    }


    private fun nameFocusListener() {

        binding.edFullName.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {
                binding.tvFullName.helperText = validName()

            }
        }
    }
    private fun validName(): String? {
        val nameText = binding.edFullName.text.toString()
        if (!nameText.matches(".*[A-Z]*.".toRegex()))
        {
            return "invalid full name"
        }

        return null
    }


    private fun emailFocusListener() {

        binding.eaEmail.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {
                binding.svEmail.helperText = validEmail()

            }
        }

    }
    private fun validEmail(): String?{
        val emailText = binding.eaEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "invalid Email"
        }

        return null
    }


    private fun phoneFocusListener() {

        binding.rbPhoneNumber.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {

                binding.qrPhoneNumber.helperText = validPhone()
            }
        }

    }

    private fun validPhone(): String? {
        val phoneText = binding.rbPhoneNumber.text.toString()
        if (!phoneText.matches(".*[0-9].*".toRegex())) {

            return "must be all digits"
        }
        if (phoneText.length != 10){
            return "must be 10 digits"
        }

        return null
    }
//


}



