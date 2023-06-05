package com.example.cheng.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cheng.Data.AdapterClass
import com.example.cheng.Data.DataClass
import com.example.cheng.R


class TestingFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageList = arrayOf(
            R.drawable.free_icon_2,
            R.drawable.free_icon_1,
            R.drawable.pngwing_com__4_,
            R.drawable.pngwing_com__3_,
            R.drawable.pngwing_com__2_,
            R.drawable.pngwing_com__1_
        )

        titleList = arrayOf(
            getString(R.string.titleInternet),
            getString(R.string.titlePC),
            getString(R.string.titleVirus),
            getString(R.string.titleTypePC),
            getString(R.string.titleCPU),
            getString(R.string.titleTypeMemory)
        )

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()
    }

    private fun getData(){
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)

        }
        recyclerView.adapter = AdapterClass(dataList, 2)
    }
}