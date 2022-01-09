package com.chskela.game

import com.badlogic.gdx.Game

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.chskela.game.screens.MainMenuScreen
import com.chskela.game.screens.SplashScreen

class Application : Game() {

    companion object {
        const val TITLE = "Pong"
        const val VERSION = 0.1f
        const val V_WIDTH = 1080f
        const val V_HEIGHT = 720f
    }

    val camera = OrthographicCamera()
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    override fun create() {
        camera.setToOrtho(false, V_WIDTH, V_HEIGHT)
        batch = SpriteBatch()
//        font = BitmapFont(Gdx.files.internal("roboto_regular.ttf"))
        font = BitmapFont()
        screen = SplashScreen(this)
    }

    override fun dispose() {
        super.dispose()
        batch.dispose()
    }

}