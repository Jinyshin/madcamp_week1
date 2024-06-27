package com.madcamp.tabapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.madcamp.tabapp.databinding.ActivityNaviBinding

private const val TAG_ADDRESS = "address_fragment"
private const val TAG_IMAGE = "image_fragment"
private const val TAG_FREE = "free_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_ADDRESS, AddressFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.addressFragment -> setFragment(TAG_ADDRESS, AddressFragment())
                R.id.imageFragment -> setFragment(TAG_IMAGE, ImageFragment())
                R.id.freeFragment-> setFragment(TAG_FREE, FreeFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager : FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }
        val address = manager.findFragmentByTag(TAG_ADDRESS)
        val image = manager.findFragmentByTag(TAG_IMAGE)
        val free = manager.findFragmentByTag(TAG_FREE)

        if (address != null){
            fragTransaction.hide(address)
        }

        if (image != null){
            fragTransaction.hide(image)
        }

        if (free != null) {
            fragTransaction.hide(free)
        }

        if (tag == TAG_ADDRESS) {
            if (address!=null){
                fragTransaction.show(address)
            }
        }
        else if (tag == TAG_IMAGE) {
            if (image != null) {
                fragTransaction.show(image)
            }
        }

        else if (tag == TAG_FREE){
            if (free != null){
                fragTransaction.show(free)
            }
        }

        fragTransaction.commitAllowingStateLoss()


    }
}