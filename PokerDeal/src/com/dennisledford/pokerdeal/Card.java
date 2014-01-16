/**
 * 
 */
package com.dennisledford.pokerdeal;

import java.io.Serializable;

/**
 * @author phesto
 *
 */
public class Card implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4859245538700639191L;
	private int cardNumber;
	private Double startX;
	private Double startY;
	private int cardWidth;
	private int cardHeight;
	private int suit;
	
	public Card(int cardNumber){
		this.cardNumber = cardNumber;
		this.cardWidth = PokerConstants.CARD_WIDTH;
		this.cardHeight = PokerConstants.CARD_HEIGHT;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Double getStartX() {
		return startX;
	}
	public void setStartX(Double startX) {
		this.startX = startX;
	}
	public Double getStartY() {
		return startY;
	}
	public void setStartY(Double startY) {
		this.startY = startY;
	}
	
	@Override
	public boolean equals(Object o) {
	    if(!(o instanceof Card)) return false;
	    Card other = (Card) o;
	    return (this.cardNumber == other.getCardNumber());
	}
	public int getCardWidth() {
		return cardWidth;
	}
	public int getCardHeight() {
		return cardHeight;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

}
