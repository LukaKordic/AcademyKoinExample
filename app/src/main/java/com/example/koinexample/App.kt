package com.example.koinexample

import android.app.Application
import com.example.koinexample.di.domainModule
import com.example.koinexample.di.networkingModule
import com.example.koinexample.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
  
  override fun onCreate() {
    super.onCreate()
    
    startKoin {
      modules(listOf(networkingModule, presentationModule, domainModule))
      androidContext(this@App)
    }
  }
}