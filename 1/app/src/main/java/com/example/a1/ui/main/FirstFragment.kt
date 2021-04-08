package com.example.a1.ui.main

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a1.*


class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
        const val TAG = Constants.TAG + " FirstFrag"
    }

    private lateinit var viewModel: DataViewModel
    private lateinit var input: EditText
    private lateinit var inputSecond: EditText
    private lateinit var listener: DataListener
    private lateinit var button: Button
    private var changeFragment: MainActivity? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.d(TAG, "onCreateView $savedInstanceState")
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated $savedInstanceState")
        input = view.findViewById(R.id.input)
        inputSecond = view.findViewById(R.id.input_second)
        button = view.findViewById(R.id.button)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated $savedInstanceState")
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        Log.d(TAG, "ViewModel: $viewModel")
        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d(TAG, "onTextChanged $s -> $listener")
                listener.onTextChanged(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        }
        )
        inputSecond.doOnTextChanged { text, _, _, _ ->
            viewModel.setText(text.toString())
        }
        button.setOnClickListener {
            changeFragment?.changeFragment()
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
        if (context is MainActivity){
            changeFragment = context
        }
        if (context is DataListener) {
            listener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
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


}




