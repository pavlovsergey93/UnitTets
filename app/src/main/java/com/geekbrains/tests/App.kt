package com.geekbrains.tests

import android.app.Application
import di.module
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
	override fun onCreate() {
		super.onCreate()
		startKoin {
//			androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
//			androidContext(this@App)
			modules(module)
		}
	}
}