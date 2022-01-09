package com.chskela.game.screens

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.ScreenUtils
import com.chskela.game.Application

class LoadingScreen(private val app: Application) : Screen {

    private val shapeRenderer = ShapeRenderer()
    private var progressLoad = 0f

    init {
        queueAssets()
    }

    override fun show() {
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color(0.5f, 0.8471f, 1f, 1f))

        update(delta)

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.color = Color.BLACK
        shapeRenderer.rect(
            32f,
            app.camera.viewportHeight / 2 - 80f,
            app.camera.viewportWidth - 64f,
            16f
        )
        shapeRenderer.color = Color.BLUE
        shapeRenderer.rect(
            32f,
            app.camera.viewportHeight / 2 - 80f,
            (app.camera.viewportWidth - 64f) * progressLoad,
            16f
        )
        shapeRenderer.end()
    }

    private fun update(delta: Float) {
        progressLoad = MathUtils.lerp(progressLoad, app.asset.progress, 0.1f)

        if (app.asset.update() && progressLoad <= app.asset.progress - .0001f) {
            app.screen = SplashScreen(app)
        }
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
        shapeRenderer.dispose()
    }

    private fun queueAssets() {
        app.asset.load("img/pong_splashscreen.png", Texture::class.java)
    }
}