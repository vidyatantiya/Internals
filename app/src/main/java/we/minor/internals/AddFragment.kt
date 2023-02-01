package we.minor.internals

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import we.minor.internals.databinding.FragmentAddBinding
import java.io.File
import java.util.*


class AddFragment : Fragment() {

      private lateinit var binding: FragmentAddBinding
    private val MY_REQUEST_CODE_PERMISSION = 1000;
    private val MY_RESULT_CODE_FILECHOOSER = 2000;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)



        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.date.setOnClickListener {

            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                binding.timetxt.text = "" + dayOfMonth + "/" + month + "/" + year

            }, year, month, day)
            dpd.show()

        }


        binding.upload.setOnClickListener {


            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "*/*"
            startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                1000
            )
            Handler().postDelayed({
                binding.uploadtxt.text =  "Done"
                Toast.makeText(requireContext(), "Uploaded Successfully", Toast.LENGTH_SHORT).show()
            }, 5000)

        }


        binding.signInBtn.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Yey!")
            builder.setMessage("Assignment Added Successfully")
            builder.show()
            Navigation.findNavController(requireActivity(), R.id.fragment).navigate(R.id.action_addFragment_to_classDetailsFragment)
        }









        return binding.root
    }




}