package com.chskela.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions.*
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.chskela.game.Application

@Suppress("CustomSplashScreen")
class SplashScreen(private val app: Application) : Screen {

    private val stage = Stage(FitViewport(Application.V_WIDTH, Application.V_HEIGHT))
    private val splashScreenTexture =
        app.asset.get("img/pong_splashscreen.png", Texture::class.java)
    private val splashScreenImage = Image(splashScreenTexture)

    init {
        Gdx.input.inputProcessor = stage
        splashScreenImage.setOrigin(splashScreenImage.width / 2, splashScreenImage.height / 2)
        splashScreenImage.setPosition(stage.width / 2 - 179f, stage.height + 78f)
        splashScreenImage.addAction(
            sequence(
                alpha(0f), scaleTo(.1f, .1f), parallel(
                    fadeIn(1.5f, Interpolation.pow2),
                    scaleTo(1f, 1f, 2f, Interpolation.pow5),
                    moveTo(
                        stage.width / 2 - 179f,
                        stage.height / 2 - 78f,
                        1.5f,
                        Interpolation.swing
                    )
                ), delay(.5f), fadeOut(1f)
            )
        )
        stage.addActor(splashScreenImage)
        app.font.data.scale(3f)
    }

    override fun show() {}

    override fun render(delta: Float) {
        ScreenUtils.clear(Color(0.5f, 0.8471f, 1f, 1f))

        update(delta)

        stage.draw()

        app.batch.begin()

        app.batch.end()
    }

    private fun update(delta: Float) {
        stage.act(delta)
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height)
    }

    override fun pause() {}

    override fun resume() {}

    override fun hide() {}

    override fun dispose() {
        stage.dispose()
    }
}