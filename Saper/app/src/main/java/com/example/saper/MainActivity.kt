package com.example.saper

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity(), ItemClicklistener {

    private lateinit var field: RecyclerView
    var myAdapter: MyAdapter? = null
    private lateinit var manager: RecyclerView.LayoutManager
    private val columns: Int = 9
    private val data: MutableList<Int> = generateData(columns)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        manager = GridLayoutManager(this, columns)
        // myAdapter = MyAdapter(this, data)

        field = findViewById<RecyclerView>(R.id.field).apply {
            layoutManager = manager
            //adapter = myAdapter

        }
        //myAdapter.setListener(this)
        setAdapter()


    }

    private fun generateData(columns: Int): MutableList<Int> {
        val random = Random()
        val field: MutableList<Int> = mutableListOf()
        for (i in 0 until columns * columns) {
            field.add(-1)
        }
        for (i in 0..9) {
            val nextCell = random.nextInt(columns * columns)
            field.set(nextCell, 10)
        }

        return field
    }

    override fun onItemClick(view: View?, position: Int) {
        val value = data[position]
        var setClickListener = true
        if (value == -1) {
            val near = calculateNearBy(position)
            data[position] = if (near>0) near else 0
        } else {
            data[position] = 11
            setClickListener = false
        }


        Log.d(MainActivity::class.java.simpleName, "$position : $value")
        setAdapter(setClickListener)

    }

    private fun setAdapter(setClickListener: Boolean = true) {
        myAdapter = MyAdapter(this, data)
                .apply {
                    if (setClickListener)
                        setClickListener(this@MainActivity)
                }
        field.adapter = myAdapter
    }

    private fun calculateNearBy(position: Int): Int {
        var valueTop = 0
        if (position in columns..data.size) {
            val top = data[position - columns]
            if (top == 10) valueTop = 1
        } else valueTop = 0

        var valueBottom = 0
        if (position in 0..(data.size-1 - columns)) {
            val bottom = data[position + columns]
            if (bottom == 10) valueBottom = 1
        } else valueBottom = 0

        var valueRight = 0
        if (position in 0 until (data.size-1)) {
            val right = data[position + 1]
            if (right == 10) valueRight = 1
        }  else valueRight = 0

        var valueLeft = 0
        if (position in 1..data.size) {
            val left = data[position - 1]
            if (left == 10) valueLeft = 1
        } else valueLeft = 0

        var valueTopLeft = 0
        if (position in (columns + 1)..data.size) {
            val topLeft = data[position - columns - 1]
            if (topLeft == 10) valueTopLeft = 1
        } else valueTopLeft = 0

        var valueTopRight = 0
        if (position in (columns - 1)..data.size) {
            val topRight = data[position - columns + 1]
            if (topRight == 10) valueTopRight = 1
        } else valueTopRight = 0

        var valueBottomLeft = 0
        if (position in 0..(data.size - columns )) {
            val bottomLeft = data[position + columns - 1]
            if (bottomLeft == 10) valueBottomLeft = 1
        } else valueBottomLeft = 0

        var valueBottomRight = 0
        if (position in 0 until data.size - columns-1) {
            val bottomRight = data[position + columns + 1]
            if (bottomRight == 10) valueBottomRight = 1
        } else valueBottomRight = 0
        return valueBottom + valueBottomLeft + valueBottomRight + valueTop + valueTopRight + valueTopLeft + valueLeft + valueRight
    }


}



