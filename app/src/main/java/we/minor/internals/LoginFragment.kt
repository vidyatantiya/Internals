package we.minor.internals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import we.minor.internals.databinding.FragmentLoginBinding

lateinit var binding: FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.signInBtn.setOnClickListener{
            Navigation.findNavController(requireActivity(), R.id.fragment).navigate(R.id.action_loginFragment_to_classFragment)
        }


        return binding.root

    }


}