package com.example.week_5_task

import android.util.Patterns

object formValidation {

    fun ValidatePhoneNumber(input: String): Boolean {
        return input.matches("[+][2][3][4][7-9][0-1][0-9]{8}".toRegex()) || input.matches(
            "[0][7-9][0-1][0-9]{8}".toRegex()
        )
    }

    fun ValidateEmail(input: String): Boolean {
        return input.matches("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})".toRegex())
    }


    fun validateName(string: String): Boolean {
        if (string == "") {
            return false
        } else {
            return string.matches(".*[a-zA-Z][A-Z]{0}".toRegex())

        }
    }

}
