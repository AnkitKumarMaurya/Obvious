package com.smarthub.obvious.activities

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.smarthub.obvious.R
import com.smarthub.obvious.adapter.ImageListAdapter
import com.smarthub.obvious.base.BaseActivity
import com.smarthub.obvious.fragments.ImageShowScreen
import com.smarthub.obvious.utils.AppController
import com.smarthub.obvious.utils.AppLogger

/**
 * ImageGalleryScreen basically designed for list of all images
 * This screen containing only preview of images
 */
class ImageGalleryScreen : BaseActivity() {

    var listView : RecyclerView?=null
    var imageListAdapter : ImageListAdapter ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onInitViews()
    }

    private fun onInitViews(){
        listView = findViewById(R.id.list_view)
        imageListAdapter = ImageListAdapter(AppController.getInstance().imageListItems) {
            var imageShowScreen = ImageShowScreen(it)
            addFragment(imageShowScreen)
            AppLogger.d("clicked Item :$it")
        }
        listView?.adapter = imageListAdapter
    }

    fun addFragment(fragment: Fragment?) {
        val backStateName: String = supportFragmentManager.javaClass.name
        val manager = supportFragmentManager
        val fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
        if (!fragmentPopped) {
            val transaction = manager.beginTransaction()
            transaction.setCustomAnimations(
                R.anim.enter,
                R.anim.exit,
                R.anim.pop_enter,
                R.anim.pop_exit
            )
            transaction.replace(R.id.level_container, fragment!!)
            transaction.addToBackStack(backStateName)
            transaction.commit()
        }
    }
}