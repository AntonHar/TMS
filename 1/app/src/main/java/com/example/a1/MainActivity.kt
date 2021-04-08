package com.example.a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a1.ui.main.FirstFragment
import com.example.a1.ui.main.SecondFragment
import com.example.a1.ui.main.ThirdFragment

class MainActivity : AppCompatActivity(),DataListener {
private lateinit var secondFragment: SecondFragment
private lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate $savedInstanceState")
        setContentView(R.layout.main_activity)
        val savedSecondFragment = supportFragmentManager.findFragmentByTag(SecondFragment.TAG)
        secondFragment = (savedSecondFragment ?: SecondFragment.newInstance()) as SecondFragment
        val savedThirdFragment = supportFragmentManager.findFragmentByTag(ThirdFragment.TAG)
        thirdFragment = (savedThirdFragment ?: ThirdFragment.newInstance()) as ThirdFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    //.replace(R.id.container, SecondFragment.newInstance())
                    .replace(R.id.container,secondFragment,SecondFragment.TAG)
                    .commitNow()
        }
    }

    override fun onDestroy(){
            super.onDestroy();
            Log.d(TAG, "onDestroy")
    }
    override fun onStop(){
            super.onStop();
            Log.d(TAG, "onStop")
    }
    override fun onStart(){
            super.onStart();
            Log.d(TAG, "onStart")
    }
    override fun onPause(){
            super.onPause();
            Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onRestart")
    }


    override fun onRestart(){
            super.onRestart();
            Log.d(TAG, "onRestart")
    }
    companion object{
        const val TAG = Constants.TAG + " MainActivity"
    }

    override fun onTextChanged(text: String) {
        Log.d(TAG, "onTextChanged $text -> $secondFragment")
        if(secondFragment.isResumed){
            secondFragment.setMessage(text)
        } else if (thirdFragment.isResumed){
            thirdFragment.setMessage(text)
        }
    }

    fun changeFragment(){
        if(secondFragment.isResumed){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,thirdFragment, ThirdFragment.TAG).commit()
        }else if(thirdFragment.isResumed){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,secondFragment,SecondFragment.TAG).commit()
        }
    }


}