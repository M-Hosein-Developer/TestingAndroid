package ir.androidcoder.testingandroid.ui

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationInputTest{


    @Test
    fun `empty username return false`() {
        val result = RegistrationInput().validateRegistration(
            "hosein",
            123,
            123
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationInput().validateRegistration(
            "ali",
            123,
            123
        )
        assertThat(result).isTrue()
//        assertThat("hello").isEqualTo("hello")
    }

    @Test
    fun `username exists returns false`() {
        val result = RegistrationInput().validateRegistration(
            "hosein",
            123,
            123
        )
        assertThat(result).isFalse()
    }

     @Test
     fun `empty password returns false`() {
         val result = RegistrationInput().validateRegistration(
             "hosein",
             0,
             0
         )
         assertThat(result).isFalse()
     }

    @Test
    fun `password repeated incorrectly returns false`() {
        val result = RegistrationInput().validateRegistration(
            "hosein",
            123,
            321
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`() {
        val result = RegistrationInput().validateRegistration(
            "hosein",
            12,
            12
        )
        assertThat(result).isFalse()
    }

}