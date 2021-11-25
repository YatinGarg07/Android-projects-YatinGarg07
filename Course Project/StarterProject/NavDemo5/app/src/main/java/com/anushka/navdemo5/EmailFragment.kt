package com.anushka.navdemo5


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentEmailBinding
import com.anushka.navdemo5.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        binding.submitButton.setOnClickListener {
            val input : String? = requireArguments()!!.getString("name_key")
            if(!TextUtils.isEmpty(binding.emailEditText.text.toString())){
        var bundle : Bundle? = bundleOf("email_key" to binding.emailEditText.text.toString(),"name_key" to input)
            it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment,bundle)}
            else{Toast.makeText(activity,"User's email address cannot be empty ",LENGTH_SHORT).show()}
        }
        return binding.root
    }
}
