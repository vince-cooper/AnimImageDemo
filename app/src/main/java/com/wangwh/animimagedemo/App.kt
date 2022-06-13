package com.wangwh.animimagedemo

import android.app.Application
import com.arthenica.ffmpegkit.*
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * @Author: 王文辉
 * @Date: 2022-06-09 18:42
 * @Desc:
 * @Note:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
//        initFFmpeg()
    }

    private fun initFFmpeg() {
//        FFmpegKitConfig.enableFFmpegSessionCompleteCallback(object :
//            FFmpegSessionCompleteCallback() {
//            fun apply(session: FFmpegSession?) {}
//        })
//        FFmpegKitConfig.enableFFprobeSessionCompleteCallback(object :
//            FFprobeSessionCompleteCallback() {
//            fun apply(session: FFprobeSession?) {}
//        })
//        FFmpegKitConfig.enableMediaInformationSessionCompleteCallback(object :
//            MediaInformationSessionCompleteCallback() {
//            fun apply(session: MediaInformationSession?) {}
//        })
    }
}