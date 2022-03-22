package com.example.week_5_task


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get

import com.example.week_5_task.databinding.ActivityMainBinding
import kotlin.math.sign




class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        phoneFocusListener()
        nameFocusListener()
        binding.MainActivitySignUp.setOnClickListener { signupForm() }


    }

    private fun signupForm(){
        binding.MainActivityEmail.helperText = validEmail()
        binding.MainActivityFullName.helperText = validName()
        binding.MainActivityPhoneNumber.helperText = validPhone()



        val validEmail = binding.MainActivityEmail.helperText == null
        val validName = binding.MainActivityFullName.helperText == null
        val validPhone = binding.MainActivityPhoneNumber.helperText == null

        if (validEmail && validName && validPhone )
            callActivity()
    else
            invalidForm()
    }
    private fun callActivity() {

        val name = binding.LayoutFullName.text.toString()
        val mail = binding.LayoutEmail.text.toString()
        val phone = binding.LayoutPhoneNumber.text.toString()
        val gender = binding.spinnetr1.selectedItem.toString()
        resetForm()
        Intent (this,MainActivity2::class.java).also {
            it.putExtra("Full Name",name)
            it.putExtra("Email", mail)
            it.putExtra("phone Number", phone)
            it.putExtra("Gender", gender)
            startActivity(it)
        }

    }

    private fun invalidForm(){
      var message = ""
        if (binding.MainActivityEmail.helperText != null)
            message += "\n\nEmail: " + binding.MainActivityEmail.helperText
        if (binding.MainActivityFullName.helperText != null)
            message += "\n\nName: " + binding.MainActivityFullName.helperText
        if (binding.MainActivityPhoneNumber.helperText != null)
            message += "\n\nPhone: " + binding.MainActivityPhoneNumber.helperText
//        if (binding.spinnetr1!= null)
//            message += "\n\nGender: " + binding.spinnetr1
//
//        //dialog toast message for invalid details
        AlertDialog.Builder(this)
            .setTitle("invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                //do something
            }
            .show()

    }
    private  fun resetForm(){

        //dialog toast message for successfull registration
        AlertDialog.Builder(this)
            .setPositiveButton("Okay"){ _,_ ->
                //do something
                binding.LayoutEmail.text = null
                binding.LayoutFullName.text = null
                binding.LayoutPhoneNumber.text = null

                binding.MainActivityEmail.helperText = getString(R.string.required)
                binding.MainActivityFullName.helperText = getString(R.string.required)
                binding.MainActivityPhoneNumber.helperText = getString(R.string.required)
            }
            .show()
    }

    // helperText toast message for the invalid Email address
    private fun nameFocusListener() {

        binding.LayoutFullName.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {
                binding.MainActivityFullName.helperText = validName()

            }
        }
    }
    //validate correct Full Name

    private fun validName(): String? {
        val nameText = binding.LayoutFullName.text.toString()
        if (!nameText.matches(".*[a-zA-Z][A-Z]{0}".toRegex()))
        {

            //$[A-Z][a-zA-Z]*+\$"* ||".*^[a-zA-Z]{0,}(?: [a-zA-Z]){0,0}

            return "invalid full name"

        }

        return null
    }

    // helperText toast message for invalid Email address
    private fun emailFocusListener() {

        binding.LayoutEmail.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {
                binding.MainActivityEmail.helperText = validEmail()

            }
        }

    }
    //validate Email address using pattern regex expression
    private fun validEmail(): String?{
        val emailText = binding.LayoutEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "invalid Email"
        }

        return null
    }
    //helperText toast message for the invalid Phone number

    private fun phoneFocusListener() {

        binding.LayoutPhoneNumber.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {

                binding.MainActivityPhoneNumber.helperText = validPhone()
            }
        }

    }
    //validate Phone Number

    private fun validPhone(): String? {
        val phoneText = binding.LayoutPhoneNumber.text.toString()
//        if (!phoneText.matches(".*[0-9].*".toRegex())) {

//   return "must be all digits"
//        }
        if (!phoneText.matches(".*[+][2][3][4][7-9][0-1][0-9].*".toRegex()) && !phoneText.matches(
            ".*[0][7-9][0-1][0-9].*".toRegex())){
                return "invalid number"
            }

//        if(!phoneText.matches("(?:(?:(?:\\+?234(?:\\h1)?|01)\\h*)?(?:\\(\\d{3}\\)|\\d{3})|\\d{4})(?:\\W*\\d{3})?\\W*\\d{4}(?!\\d)".toRegex())) {
//            return "invalid phone number"
//        }

        return null
    }


}



