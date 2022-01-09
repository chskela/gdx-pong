package com.chskela.game.desktop

import kotlin.jvm.JvmStatic
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.chskela.game.Application

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration()
        config.setTitle(Application.TITLE + " " + Application.VERSION)
        config.setForegroundFPS(60)
        config.setWindowedMode(Application.V_WIDTH.toInt(), Application.V_HEIGHT.toInt())
        Lwjgl3Application(Application(), config)
    }
}