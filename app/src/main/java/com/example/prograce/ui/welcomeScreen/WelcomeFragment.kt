package com.example.prograce.ui.welcomeScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prograce.R
import com.example.prograce.databinding.WelcomeFragmentBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth


class WelcomeFragment : Fragment() {

    //val db = Firebase.firestore
    private val RC_SIGN_IN = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding =  WelcomeFragmentBinding.inflate(inflater, container, false)

        binding.loginOrRegister.setOnClickListener{
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(getAvailableProviders())
                    .setTheme(R.style.Theme_Prograce_NoActionBar)
                    .setLogo(R.drawable.ic_app_logo)
                    .build(),
                RC_SIGN_IN)
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                findNavController().navigate(R.id.action_welcomeFragment_to_projectsFragment)

            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                if(response == null) {
                    Toast.makeText(context, "Login cancelled", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(context, "Something is wrong, Please try Again!!", Toast.LENGTH_LONG).show()
                    Log.i("Authentication error", response.error?.message!!)
                }
            }
        }
    }

    private fun getAvailableProviders(): List<AuthUI.IdpConfig> {
        val actionCodeSettings = ActionCodeSettings.newBuilder()
                .setAndroidPackageName("com.example.prograce", true, "0.1  ")
                .setHandleCodeInApp(true) // This must be set to true
                .setUrl("https://prograceapp.page.link") // This URL needs to be whitelisted
                .build()

        return listOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.PhoneBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build(),
                AuthUI.IdpConfig.FacebookBuilder().build())
    }



}