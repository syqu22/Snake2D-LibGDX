package pl.snake.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MainMenu implements Screen{
	
	private final float appWidth = 1280;
	private final float appHeight = 720;
	
	private static final int START_BUTTON_WIDTH = 220;
	private static final int START_BUTTON_HEIGHT = 100;
	private static final int EXIT_BUTTON_WIDTH = 220;
	private static final int EXIT_BUTTON_HEIGHT = 100;
	private static final int START_BUTTON_Y = 500;
	private static final int EXIT_BUTTON_Y = 170;
	SnakeGame game;
	
	Sound click;
	OrthographicCamera camera;
	BitmapFont debug;
	Texture title,startbt,exitbt,startbt_select,exitbt_select;
	
	private float width = Gdx.graphics.getWidth();
	private float height = Gdx.graphics.getHeight();
	
	public MainMenu(SnakeGame game) {
		this.game = game;
		
		
		title = new Texture("menu/title.png");
		startbt = new Texture("menu/start_button.png");
		startbt_select = new Texture("menu/start_button_select.png");
		exitbt = new Texture("menu/exit_button.png");
		exitbt_select = new Texture("menu/exit_button_select.png");
		camera = new OrthographicCamera(width,height);
		camera.position.set(camera.viewportWidth /2f, camera.viewportHeight/2f , 0);
		camera.setToOrtho(false,appWidth,appHeight);
		camera.update();
	}

	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
	camera.update();
	game.batch.setProjectionMatrix(camera.combined);
	Gdx.gl.glClearColor(1, 1, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	game.batch.begin();
	game.batch.draw(title,400,355);
	Sound click = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
	int x = game.WIDTH / 4 - START_BUTTON_WIDTH /2;
	if(Gdx.input.getX() < x + START_BUTTON_WIDTH & Gdx.input.getX() > x && Gdx.input.getY()+380 < START_BUTTON_Y + START_BUTTON_HEIGHT &&Gdx.input.getY() + 380> START_BUTTON_Y) {
		game.batch.draw(startbt_select,x,START_BUTTON_Y ,START_BUTTON_WIDTH,START_BUTTON_HEIGHT);
		if(Gdx.input.isTouched()) {
			click.play();
			game.setScreen(new MainScreen(game));
		}
	}else {
		game.batch.draw(startbt,x,START_BUTTON_Y,START_BUTTON_WIDTH,START_BUTTON_HEIGHT);
	}
	if(Gdx.input.getX() < x + EXIT_BUTTON_WIDTH & Gdx.input.getX() > x &&Gdx.input.getY() - 280 < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT &&Gdx.input.getY() - 280> EXIT_BUTTON_Y) {
		game.batch.draw(exitbt_select,x,EXIT_BUTTON_Y,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT);
		if(Gdx.input.isTouched()){
			click.play();
			Gdx.app.exit();
		}
	}else {
		game.batch.draw(exitbt,x,EXIT_BUTTON_Y,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT);
	}
	if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
		click.play();
		Gdx.app.exit();
	}
	game.batch.end();
	
		
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
		title.dispose();
		startbt.dispose();
		startbt_select.dispose();
		exitbt.dispose();
		exitbt_select.dispose();
		
		
	}
	

}
