package com.chskela.game

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.chskela.game.screens.LoadingScreen
import com.chskela.game.screens.MainMenuScreen
import com.chskela.game.screens.SplashScreen
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

class Application : Game() {

    companion object {
        const val TITLE = "Pong"
        const val VERSION = 0.1f
        const val V_WIDTH = 1080f
        const val V_HEIGHT = 720f
    }

    val asset = AssetManager()
    val camera = OrthographicCamera()
    lateinit var batch: SpriteBatch
    lateinit var font24: BitmapFont

    lateinit var loadingScreen: LoadingScreen
    lateinit var splashScreen: SplashScreen
    lateinit var mainMenuScreen: MainMenuScreen

    override fun create() {
        camera.setToOrtho(false, V_WIDTH, V_HEIGHT)
        batch = SpriteBatch()
        initFonts()

        // Screen init
        loadingScreen = LoadingScreen(this)
        splashScreen = SplashScreen(this)
        mainMenuScreen = MainMenuScreen(this)

        screen = loadingScreen
    }

    private fun initFonts() {
        val generator = FreeTypeFontGenerator(Gdx.files.internal("fonts/roboto_regular.ttf"))
        val params = FreeTypeFontGenerator.FreeTypeFontParameter()
        params.size = 24
        params.color = Color.BLACK
        font24 = generator.generateFont(params)
    }

    override fun dispose() {
        super.dispose()
        batch.dispose()
        font24.dispose()
        asset.dispose()
        loadingScreen.dispose()
        splashScreen.dispose()
        mainMenuScreen.dispose()
    }

}