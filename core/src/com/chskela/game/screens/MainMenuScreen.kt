package com.chskela.game.screens

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.ScreenUtils
import com.chskela.game.Application

class MainMenuScreen(private val app: Application) : Screen {


    private val camera = OrthographicCamera()
    private val style = TextButton.TextButtonStyle()
    init {
        camera.setToOrtho(false, 800f, 480f)
        app.font.data.scale(5f)
        style.font = app.font
    }
    private var button = TextButton("Start game", style)
    override fun show() {
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(1f, 1f, 1f, 1f)

        camera.update()
        app.batch.begin()
        button.color = Color.BLUE
        button.center()

        button.x = 500f
        button.y = 300f
        button.draw(app.batch, 1000000f)

        app.batch.end()
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
    }
}