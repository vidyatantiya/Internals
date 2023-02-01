package we.minor.internals
import android.app.DownloadManager
import android.content.Context
import android.hardware.SensorManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import we.minor.internals.databinding.FragmentClassDetailsBinding
import java.io.File


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
        binding.exportBtn.setOnClickListener {
           download("https://docs.google.com/spreadsheets/d/1mYUvw1YniPLQBPWOryYSxNuSD6HtO3NNQHVQIqU3LrQ/edit?usp=sharing",
           "TotalMarks")
        }
        return binding.root
    }

   private fun download(url: String,  fileName: String) {
//       var request = DownloadManager.Request(
//           Uri.parse(url))
//           .setTitle("Exported")
//           .setDescription("pdf is downloading")
//           .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
//           .setAllowedOverMetered(true)
//       var downloadManager = requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//       downloadManager.enqueue(request)
       try {
           var downloadManager = requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
           val imageLink = Uri.parse(url)
           var request = DownloadManager.Request(imageLink)
           request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
               .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
               .setTitle(fileName)
               .setMimeType("*/*")
               .setDescription("pdf is downloading")
               .setAllowedOverMetered(true)



            downloadManager?.enqueue(request)
           Toast.makeText(requireContext(), "File is Downloaded",Toast.LENGTH_SHORT).show()
       }
       catch(e:java.lang.Exception) {
           Log.d("error is", e.message.toString())
           Toast.makeText(requireContext(), "Image Download Failed", Toast.LENGTH_LONG).show()
       }
   }
}