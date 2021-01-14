package com.example.prograce.ui.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.prograce.databinding.ProfileFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private val EXTERNAL_STORAGE_REQUEST_CODE = 1001
    private val PICK_IMAGE_CODE = 3006


    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding : ProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)
        binding.profileImageButton.setOnClickListener {
            startIntent()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
        binding.viewModel = viewModel
    }

    fun startIntent() {
        if(ifReadExternalStoragePermission()) {
            val intent = Intent(Intent.ACTION_PICK , android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent , PICK_IMAGE_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == PICK_IMAGE_CODE && resultCode == RESULT_OK) {
            val uri = data?.data
            binding.profileImageButton.setImageURI(uri)
        }
    }

    private fun ifReadExternalStoragePermission() : Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext() ,
            android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
    }

    fun askGalleryPermission() {
        if(!ifReadExternalStoragePermission()) {
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE) ,
                EXTERNAL_STORAGE_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == EXTERNAL_STORAGE_REQUEST_CODE) {
            if((grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    startIntent()
            }
            return
        }
    }
}