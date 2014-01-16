/**
 * 
 */
package com.dennisledford.pokerdeal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author dennisledford
 *
 */
public class HandSlideFragment extends Fragment {

	public static final String ARG_PAGE = "page";
	public static final String ARG_CARD = "card";
	private int mCardNumber;
	
	/**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static HandSlideFragment create(int cardNumber,Card c) {
    	HandSlideFragment fragment = new HandSlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, cardNumber);
        args.putSerializable(ARG_CARD, c);
        fragment.setArguments(args);
        return fragment;
    }
    
    public HandSlideFragment() {
    	
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout containing a title and body image.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_hand_slide, container, false);
        Card card = (Card) getArguments().getSerializable(ARG_CARD);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView1);
        //import deck image
        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.classic_deck);
        //crop specific card from deck sheet 
        bMap =Bitmap.createBitmap(bMap,card.getStartX().intValue(),card.getStartY().intValue(),card.getCardWidth(),card.getCardHeight());
        //set the imageview to show card
        imageView.setImageBitmap(bMap);
        // Set the title view to show the page number.
        mCardNumber = getArguments().getInt(ARG_PAGE);
        /*((TextView) rootView.findViewById(android.R.id.text1)).setText(
                getString(R.string.card_header, mCardNumber + 1)+ (mCardNumber+1));*/

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mCardNumber;
    }

	
}
