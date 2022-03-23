package com.example.week_5_task

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.week_5_task.R.id.Layout_Phone_Number
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.week_5_task.MainActivity as MainActivity


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest{


    private lateinit var scenario: ActivityScenario<MainActivity>

//    @get:Rule
//    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
   fun signUP(){
       scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
   }

    @Test
    fun test_submit(){

        val name = "noel"
        val email = "noel@gmail.com"
        val phone = "07046243186"


     // The emulator is displayed to perform the typeText Action
        onView(withId(R.id.Layout_FullName)).perform(ViewActions.typeText(name))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.Layout_Email)).perform(ViewActions.typeText(email))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.Layout_Phone_Number)).perform(ViewActions.typeText(phone))
        Espresso.closeSoftKeyboard()

        // When the signUp button is clicked the typeText is displayed in the next activity
        onView(withId(R.id.MainActivity_SignUp)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(name)))
        onView(withId(R.id.textView2)).check(matches(withText(email)))
        onView(withId(R.id.textView3)).check(matches(withText(phone)))
    }

}




