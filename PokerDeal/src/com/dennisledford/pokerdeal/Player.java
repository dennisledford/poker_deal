/**
 * 
 */
package com.dennisledford.pokerdeal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author phesto
 * 
 */
public class Player implements Serializable{

	private List<Card> hand = new ArrayList<Card>();
	
	 private static final long serialVersionUID = 1L;

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public boolean validCard(Card drawnCard) {
		if (cardInHand(drawnCard)) {
			return false;
		}
		return true;
	}

	private boolean cardInHand(Card drawnCard) {

		if (this.getHand().indexOf(drawnCard) >= 0) {
			return true;
		}
		return false;
	}
  
}
