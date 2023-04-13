package com.haulmer.paymentexample

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.haulmer.paymentexample.databinding.FragmentFirstBinding
import com.haulmer.paymentexample.model.ExtraDataRequest
import com.haulmer.paymentexample.model.Request

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        Log.d("Test", "Code: " + result.resultCode);

        when(result.resultCode) {
            Activity.RESULT_OK -> {
                val json: String? = result.getData()?.getStringExtra("resultJson")
                if (json != null) {
                    Log.d("Test", json)
                }

            }
            Activity.RESULT_CANCELED -> {
                Toast.makeText(activity, "Codigo de error: " + result.resultCode, Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(activity, "Flujo no controlado", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            callInterAPP()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    public fun callInterAPP() {
        val request = Request(
            10000,
            0,
            -1,
            1,
            2,
            false,
            48,
            ExtraDataRequest(
                "76264675-7",
                9000,
                1000,
                "Ejemplo de app",
                "2020.01.2016-6",
                "234456",
                true,
                "AA11SS")
        )
        val paymentConnection = PaymentConnection();
        val packageManager = activity?.packageManager;
        if(packageManager != null) {
            if(paymentConnection.existApp(packageManager)){
                val intent = PaymentConnection().sendIntentPagos(packageManager,request)
                if (intent != null) {
                    resultLauncher.launch(intent)
                }
            } else {
                Toast.makeText(activity?.applicationContext, "Debe instalar la aplicación", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(activity?.applicationContext, "Problemas al iniciar", Toast.LENGTH_LONG).show()
        }
    }

}