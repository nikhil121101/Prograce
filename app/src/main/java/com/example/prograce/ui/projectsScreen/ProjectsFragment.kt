package com.example.prograce.ui.projectsScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.ContactsContract
import android.view.*
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.prograce.R
import com.example.prograce.databinding.ProjectsFragmentBinding
import com.example.prograce.ui.profile.ProfileViewModel
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class ProjectsFragment : Fragment() {

    private lateinit var projectViewModel: ProjectsViewModel
    private lateinit var profileViewModel: ProfileViewModel


    private lateinit var profileImageButton : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ProjectsFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        profileImageButton = requireActivity().findViewById(R.id.profileImage) as ImageButton
        profileImageButton.setOnClickListener {
            findNavController().navigate(R.id.action_projectsFragment_to_profileFragment)
        }

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        projectViewModel = ViewModelProvider(this).get(ProjectsViewModel::class.java)
        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
        profileViewModel.refreshUser()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu , menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId) {
            R.id.menu_sign_out -> AuthUI.getInstance().signOut(requireContext()).addOnCompleteListener {
                findNavController().navigate(R.id.action_projectsFragment_to_welcomeFragment)
            }
        }
        return true
    }

    override fun onStart() {
        super.onStart()
        profileImageButton.visibility = View.VISIBLE
    }

    override fun onStop() {
        super.onStop()
        profileImageButton.visibility = View.GONE
    }
}