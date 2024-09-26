package ir.androidcoder.testingandroid.util

class RegistrationInput {

    private val existingUsers = listOf("hasan" , "hosein")

    /**
     *the input is not valid if...\
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirm password is not the same as the real password
     * ...the password contains less than 2 digits
     */

    fun validateRegistration(
        username: String,
        password : Int,
        confirmPassword : Int
    ) : Boolean{

        if (username.isEmpty() || password == 0){
            return false
        }

        if (username in existingUsers){
            return false
        }

        if (password != confirmPassword){
            return false
        }

        if (password.toString().count { it.isDigit() } < 2){
            return false
        }

        return true
    }


}