package com.smarthub.obvious.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.smarthub.obvious.R
import com.smarthub.obvious.adapter.ImageDetailsAdapter
import com.smarthub.obvious.adapter.ImageListAdapter
import com.smarthub.obvious.utils.AppController
import com.smarthub.obvious.utils.AppLogger

/**
 * ImageGalleryScreen basically designed for list of all images
 * This screen containing only preview of images
 */
class ImageShowScreen(var currentPos : Int) : Fragment() {

    private var listView : RecyclerView?=null
    var imageListAdapter : ImageDetailsAdapter ?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitViews(view)
    }
    private fun onInitViews(view : View){
        listView = view.findViewById(R.id.list_view)
        imageListAdapter = ImageDetailsAdapter(AppController.getInstance().imageListItems)
        listView?.adapter = imageListAdapter
        listView?.scrollToPosition(currentPos)

//        var arrowLeft = view.findViewById<View>(R.id.arrow_left)
//        var arrowRight = view.findViewById<View>(R.id.arrow_right)
        var back = view.findViewById<View>(R.id.back)

        back.setOnClickListener {
            requireActivity().onBackPressed()
        }

//        arrowLeft.setOnClickListener {
//            currentPos-=1
//            if (currentPos<=0)
//                it.visibility = View.GONE
//
//            if (currentPos < imageListAdapter?.itemCount!! && arrowRight.visibility == View.GONE)
//                arrowRight.visibility = View.VISIBLE
//
//            listView?.smoothScrollToPosition(currentPos)
//        }
//
//        arrowRight.setOnClickListener {
//            currentPos+=1
//            if (currentPos>0 && arrowLeft.visibility == View.GONE)
//                arrowLeft.visibility = View.VISIBLE
//
//            if (currentPos >= imageListAdapter?.itemCount!!-1)
//                it.visibility = View.GONE
//
//            listView?.smoothScrollToPosition(currentPos)
//        }
//
//        if (currentPos<=0)
//            arrowLeft.visibility = View.GONE
//
//        if (currentPos >= imageListAdapter?.itemCount!!-1)
//            arrowRight.visibility = View.GONE

        var snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(listView)
    }

}