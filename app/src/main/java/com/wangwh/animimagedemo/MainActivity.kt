package com.wangwh.animimagedemo

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import com.facebook.drawee.backends.pipeline.Fresco
import com.github.penfeizhou.animation.FrameAnimationDrawable
import com.github.penfeizhou.animation.apng.APNGDrawable
import com.github.penfeizhou.animation.loader.AssetStreamLoader
import com.github.penfeizhou.animation.webp.WebPDrawable
import com.wangwh.animimagedemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.osapng.setOnClickListener { loadAPNG() }
        binding.oswebp.setOnClickListener { loadWEBP() }
        binding.frescoapng.setOnClickListener { loadAPNGUseFresco() }
        binding.frescowebp.setOnClickListener { loadWEBPUseFresco() }
    }

    /**
    循环播放，内存：一直上涨，CPU：5～8%
     */
    private fun loadAPNG() {
        binding.draweeView.controller = null
        binding.draweeView.isVisible = false
        binding.imageView.isVisible = true

        val assetLoader = AssetStreamLoader(this, "person.png")
        val apngDrawable = APNGDrawable(assetLoader)
        binding.imageView.setImageDrawable(apngDrawable)
        apngDrawable.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationStart(drawable: Drawable) {
                super.onAnimationStart(drawable)
            }
        })
    }

    /**
    循环播放，内存：一直上涨，CPU：6～8%
     */
    private fun loadWEBP() {
        binding.draweeView.controller = null
        binding.draweeView.isVisible = false
        binding.imageView.isVisible = true

        val assetLoader = AssetStreamLoader(this, "person.webp")
        val webpDrawable = WebPDrawable(assetLoader)
        binding.imageView.setImageDrawable(webpDrawable)
        webpDrawable.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationStart(drawable: Drawable) {
                super.onAnimationStart(drawable)
            }
        })
    }

    private fun loadAPNGUseFresco() {
        val drawable = binding.imageView.drawable
        if (drawable is FrameAnimationDrawable<*>) {
            drawable.reset()
        }
        binding.imageView.setImageDrawable(null)
        binding.imageView.isVisible = false
        binding.draweeView.isVisible = true

        val controller = Fresco.newDraweeControllerBuilder()
            .setUri(Uri.parse("asset:///person.png"))
            .setAutoPlayAnimations(true)
            .build()
        binding.draweeView.controller = controller
    }

    /**
    循环播放，内存：177MB，CPU：3%
     */
    private fun loadWEBPUseFresco() {
        val drawable = binding.imageView.drawable
        if (drawable is FrameAnimationDrawable<*>) {
            drawable.reset()
        }
        binding.imageView.setImageDrawable(null)
        binding.imageView.isVisible = false
        binding.draweeView.isVisible = true

        val controller = Fresco.newDraweeControllerBuilder()
            .setUri(Uri.parse("asset:///person.webp"))
            .setAutoPlayAnimations(true)
            .build()
        binding.draweeView.controller = controller
    }
}