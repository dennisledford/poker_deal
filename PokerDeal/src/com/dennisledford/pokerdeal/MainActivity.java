package com.dennisledford.pokerdeal;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import static com.dennisledford.pokerdeal.PokerConstants.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void dealCards(View view){
    	Intent intent = new Intent(this, DisplayHandActivity.class);
    	Player player = new Player();
    	player = generateHand(player);
    	intent.putExtra(EXTRA_PLAYER, player);
    	startActivity(intent);
    }
    
    private Player generateHand(Player player){
    	while(player.getHand().size()<5){
    		Random r = new Random();
	        int cardNumber=r.nextInt(52-1) + 1;
	        Card card = new Card(cardNumber);
	        if(player.validCard(card)){	        	
		        double row = Math.ceil(cardNumber/XCOUNT);
		        card.setSuit((int) row);
		        Double startX=0D;
		        Double startY=0D;
		        startX = (double) (((cardNumber-((row-1)*XCOUNT))*CARD_WIDTH)-CARD_WIDTH);
		        startY =  (row*CARD_HEIGHT)-CARD_HEIGHT;
		        startX +=MARGIN_WIDTH;
		        startY +=MARGIN_HEIGHT;
		        card.setStartX(startX);
		        card.setStartY(startY);
		        player.getHand().add(card);	 
	        }
    	}
    	return player;
    }
    
	@Test
    private void testCreateHand(){
    	Player player = new Player();
    	generateHand(player);
    	Set<Integer> tempSet = new HashSet<Integer>();
        for (Card card : player.getHand()) {
            if (!tempSet.add(card.getCardNumber())) {
                Assert.assertTrue(false);
            }
        }
        Assert.assertTrue(true);
        
    }
    
}
