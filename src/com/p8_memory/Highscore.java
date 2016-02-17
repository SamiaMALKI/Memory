package com.p8_memory;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.content.SharedPreferences;

public class Highscore extends Activity {
		private String message = null ;
	int meilleurspoints = 0 ;
    private TextView texte = null;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	SharedPreferences Prefs = this.getSharedPreferences("prefs", MODE_WORLD_READABLE);
    	SharedPreferences.Editor prefsEditor = Prefs.edit();
    	
    	meilleurspoints = Prefs.getInt("bestscore", 0);
    	message = "Meilleur score = " + Integer.toString(meilleurspoints); 
    	
        texte = new TextView(this);
        texte.setText(message);
        setContentView(texte);
    } 
}