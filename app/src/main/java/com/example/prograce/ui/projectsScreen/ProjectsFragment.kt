package com.example.prograce.ui.projectsScreen

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.prograce.R
import com.example.prograce.databinding.ProjectsFragmentBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class ProjectsFragment : Fragment() {

    private lateinit var projectViewModel: ProjectsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        context?.theme?.applyStyle(R.style.Theme_Prograce, true);
//        Log.i("mytag", )
        val binding = ProjectsFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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

}