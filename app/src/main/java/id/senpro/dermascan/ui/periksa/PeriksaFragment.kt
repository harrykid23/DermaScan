package id.senpro.dermascan.ui.periksa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.senpro.dermascan.databinding.FragmentPeriksaBinding

class PeriksaFragment : Fragment() {

    private lateinit var periksaViewModel: PeriksaViewModel
    private var _binding: FragmentPeriksaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        periksaViewModel =
            ViewModelProvider(this).get(PeriksaViewModel::class.java)

        _binding = FragmentPeriksaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        periksaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}