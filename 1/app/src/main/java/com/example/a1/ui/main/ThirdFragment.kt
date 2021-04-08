package com.example.a1.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.a1.Constants
import com.example.a1.R


class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
        const val TAG = Constants.TAG + " ThirdFrag"
    }

    private lateinit var viewModel: DataViewModel
    private lateinit var tvText: TextView
    private lateinit var text2: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.d(TAG, "onCreateView $savedInstanceState")
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated $savedInstanceState")
        tvText = view.findViewById(R.id.text)
        text2 = view.findViewById(R.id.text2)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated $savedInstanceState")
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        Log.d(TAG,"ViewModel: $viewModel")
        viewModel.getText().observe(this, {
            text2.text = it
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart();
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause();
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop();
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }
    fun setMessage(text: String) {
        Log.d(SecondFragment.TAG, "setMessage $text")
        tvText.text = text
    }

}