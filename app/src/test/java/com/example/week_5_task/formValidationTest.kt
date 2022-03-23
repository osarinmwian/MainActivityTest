package com.example.week_5_task

import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Test

class formValidationTest{


        @Test
        fun validName_whenInputIsValid_returnTrue() {
            //Given
            val name = "jane clavin"
            val testFunction = formValidation
            //When
            val solution = testFunction.validateName(name)
            // Assert
            TestCase.assertEquals(solution, true)
        }

        @Test
        fun validName_whenInputIsEmpty_returnFalse() {
            //Given
            val name = ""
            val testFunction = formValidation
            //When
            val solution = testFunction.validateName(name)
            // Assert
            TestCase.assertEquals(solution, false)
        }

        @Test
        fun validName_whenInputContainDigit_returnFalse() {
            //Given
            val name = "23456"
            val testFunction = formValidation
            //When
            val solution = testFunction.validateName(name)
            // Assert
            TestCase.assertEquals(solution, false)
        }

        @Test
        fun validName_whenInputContainSpecialCharacter_returnFalse() {
            //Given
            val name = "@%$&*"
            val testFunction = formValidation
            //When
            val solution = testFunction.validateName(name)
            // Assert
            TestCase.assertEquals(solution, false)
        }

        @Test
        fun validName_whenInputContainsLettersNumbersAndSpecialCharacters_returnFalse() {
            //Given
            val name = "praise12@3#"
            val testFunction = formValidation
            //When
            val solution = testFunction.validateName(name)
            // Assert
            TestCase.assertEquals(solution, false)
        }

        @Test
        fun validName_whenInputLengthIsGreaterOne_returnTrue() {
            //Given
            val name = "Julie"
            val testFunction = formValidation
            //When
            val solution = testFunction.validateName(name)
            // Assert
            TestCase.assertEquals(solution, true)
        }
    @Test
    fun validEmail_whenInputIsValid_returnTrue() {
        //Given
        val email = "love@gmail.com"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, true)
    }

    @Test
    fun validEmail_whenInputIsEmpty_returnFalse() {
        //Given
        val email = ""
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validEmail_whenInputContainDigit_returnFalse() {
        //Given
        val email= "23456"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validEmail_whenInputContainSpecialCharacter_returnFalse() {
        //Given
        val email = "^+#...@%$&*"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validEmail_whenInputLengthIsLessThanThree_returnFalse() {
        //Given
        val email = "dan"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validEmail_whenInputContainsCamelCaseAndUnderScore_returnTrue() {
        //Given
        val email = "Gift_theresa@gmail.com"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, true)
    }

    @Test
    fun validEmail_whenInputLengthIsGreaterThanTwo_returnTrue() {
        //Given
        val email = "whyte"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidateEmail(email)
        // Assert
        TestCase.assertEquals(solution, false)
    }
    @Test
    fun validPhone_whenInputIsValid_returnTrue() {
        //Given
        val phone = "09098765432"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidatePhoneNumber(phone)
        // Assert
        TestCase.assertEquals(solution, true)
    }

    @Test
    fun validPhone_whenInputIsEmpty_returnFalse() {
        //Given
        val phone = ""
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidatePhoneNumber(phone)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validPhone_whenInputContainDigitAndLetters_returnFalse() {
        //Given
        val phone = "23456adcs"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidatePhoneNumber(phone)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validPhone_whenInputIsValid2_returnTrue() {
        //Given
        val phone = "+2347098675432"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidatePhoneNumber(phone)
        // Assert
        TestCase.assertEquals(solution, true)
    }

    @Test
    fun validPhone_whenInputContainsNumbersAndSpecialCharacters_returnFalse() {
        //Given
        val phone = "012@3#"
        val testFunction = formValidation
        //When
        val solution = testFunction.ValidatePhoneNumber(phone)
        // Assert
        TestCase.assertEquals(solution, false)
    }

    @Test
    fun validPhone_whenInputLengthIsLessThanEeven_returnfalse() {
        //Given
        val name = "080765432"
        val testFunction = formValidation
        //When
        val solution = testFunction.validateName(name)
        // Assert
        TestCase.assertEquals(solution, false)
    }

}