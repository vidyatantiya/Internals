package we.minor.internals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import we.minor.internals.databinding.FragmentClassBinding
import we.minor.internals.databinding.FragmentLoginBinding

class ClassFragment : Fragment() {
    private lateinit var binding: FragmentClassBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClassBinding.inflate(inflater, container, false)

        binding.view2.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragment).navigate(R.id.action_classFragment_to_classDetailsFragment)
        }

        return binding.root
    }

}