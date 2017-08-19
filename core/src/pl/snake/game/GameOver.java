package pl.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameOver implements Screen{
	SnakeGame game;
	BitmapFont scoreFont;
	
	
	public GameOver(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		scoreFont = new BitmapFont();
		scoreFont.setColor(Color.YELLOW);
	
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
	

		scoreFont.draw(game.batch, "Your score: TODO", 700, 500); //TODO
		
		game.batch.end();
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			game.setScreen(new MainMenu(game));
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
