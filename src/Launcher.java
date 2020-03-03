public class Launcher {

	public static void main(String[] args){
		Game game = new Game("Soccer Hack", 1580, 1000);
		game.setGame(game);
	    Game.goalCount = 0;
		game.start();
		
	
	}
	
}