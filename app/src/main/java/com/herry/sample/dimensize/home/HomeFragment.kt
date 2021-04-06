package com.herry.sample.dimensize.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.herry.sample.dimensize.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val text: TextView = root.findViewById(R.id.text_dimen)
        text.text = "densityDpi = ${resources.displayMetrics.densityDpi}\n" +
                "size = ${printScreenSize()}\n" +
                "dimen/size120 is ${requireContext().resources.getDimensionPixelSize(R.dimen.size120)}px, ${dpToPx(requireContext().resources.getDimension(R.dimen.size120))}dp "
        return root
    }

    private fun printScreenSize() : String {
        val metrics = resources.displayMetrics
        val screenHeight = metrics.heightPixels
        val screenWidth = metrics.widthPixels
        val density =  metrics.density

        return "${screenWidth} x ${screenHeight} , ${pxToDp(screenWidth)}dp x ${pxToDp(screenHeight)}dp"
    }

    private fun pxToDp(px: Int) : Float {
        val metrics = resources.displayMetrics

        return px.toFloat() / metrics.density
    }

    private fun dpToPx(dp: Float) : Int {
        val metrics = resources.displayMetrics

        return (dp * metrics.density + 0.5f).toInt()
    }
}