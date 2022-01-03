package com.task.myapp.ViewModel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import com.task.myapp.Interface.LoginResultCallBacks
import com.task.myapp.Model.User

class LoginViewModel(private val listener:LoginResultCallBacks): ViewModel() {
    private val  user: User

    init {
        this.user = User("","")
    }

    //Create function to set Email after user finish enter text
    val emailTextWatcher
    get() = object:TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
           user.setEmail(p0.toString())
        }

    }


    //Create function to set Password after user finish enter text
    val passwordTextWatcher
        get() = object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                user.setPassword(p0.toString())
            }

        }

    //create function to process login button clicked
    fun onLoginClicked(viewModel: ViewModel){
        if (user.isDataValid)
            listener.onSuccess("Login Success")
        else
            listener.onError("Login error")
    }
}