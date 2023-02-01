package we.minor.internals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import we.minor.internals.databinding.FragmentClassDetailsBinding
import we.minor.internals.databinding.FragmentLoginBinding

class ClassDetailsFragment : Fragment() {
    private lateinit var binding: FragmentClassDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClassDetailsBinding.inflate(inflater, container, false)
        binding.addBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragment).navigate(R.id.action_classDetailsFragment_to_addFragment)
        }
        return binding.root
    }


}