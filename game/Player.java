package game;
import java.util.ArrayList;
import java.util.List;

public class Player
{
    String name;
    List<Hand> hands;
    Wallet wallet;
    boolean finished;
    int currentHandIndex;
    int splits;
    
    int initialBet;
    
    public Player(String name) {
    	this.name = name;
    	this.wallet = new Wallet();
    	this.setup();
    }
    
    private Player(String name, Wallet wallet) {
    	this.name = name;
    	this.wallet = wallet;
    	this.setup();
    }
    
    private void setup() {
    	this.hands = new ArrayList<>();
    	this.finished = false;
    	this.currentHandIndex = 0;
    	this.splits = 0;
    }
    
    public boolean setBet(int bet) {
    	if (bet <= this.wallet.getcurrentAmount() && bet > 0) {
            this.initialBet = bet;
            return true;
    	}
		return false;
    }
    
    public int getInitialBet() {
		return initialBet;
	}

    public Hand getCurrentHand() {
        return this.hands.get(this.currentHandIndex);
    }
    
    public List<Hand> getHands() {
    	return hands;
    }

    public boolean newHand() {
        return ++this.currentHandIndex < hands.size();
        //return false if currenHandIndex exceeds List of Hand
    }
    
    public String getName() {
		return name;
	}
    
    public void setFinished(boolean finished) {
		this.finished = finished;
	}
    
    public boolean isFinished() {
		return finished;
	}
    
    /**
     * takes name and wallet in new player object for the next game
     * @return new Player object
     */
    public Player prepareForNewGame() {
    	return new Player(name, wallet);
    }
    
    public Wallet getWallet() {
		return wallet;
	}
}
