package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    public static final float V_LEN = 0.5f;
    private Texture img;
    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        img = new Texture("Cyberpunk.jpg");
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.1f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        pos.add(v);

    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                touch.y =+ 10;
                break;
            case Input.Keys.DOWN:
                touch.y =- 10;
                break;
            case Input.Keys.RIGHT:
                touch.x =+ 10;
                break;
            case Input.Keys.LEFT:
                touch.x =- 10;
                break;
        }
        return false;
    }
}
