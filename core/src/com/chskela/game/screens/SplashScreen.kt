package com.chskela.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.chskela.game.Application

@Suppress("CustomSplashScreen")
class SplashScreen(private val app: Application) : Screen {

    private val stage = Stage(FitViewport(Application.V_WIDTH, Application.V_HEIGHT))
    private val splashScreenTexture = Texture(Gdx.files.internal("img/pong_splashscreen.png"))
    private val splashScreenImage = Image(splashScreenTexture)

    init {
        Gdx.input.inputProcessor = stage
        splashScreenImage.setPosition(stage.width / 2 - 179f, stage.height / 2 - 78f)
        stage.addActor(splashScreenImage)
        app.font.data.scale(3f)
    }

    override fun show() {}

    override fun render(delta: Float) {
        ScreenUtils.clear(Color(0.5f, 0.8471f, 1f, 1f))
//        ScreenUtils.clear(Color(0x80_D8_ff))


        update(delta)

        stage.draw()

        app.batch.begin()
//        app.font.draw(app.batch, "SplashScreen!", stage.width / 2 - 150f, stage.height / 2)
        app.batch.end()
    }

    private fun update(delta: Float) {
        stage.act(delta)
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width,height)
    }

    override fun pause() {}

    override fun resume() {}

    override fun hide() {}

    override fun dispose() {}
}