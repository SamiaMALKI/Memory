package com.p8_memory;

import com.p8_tp2android.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

public class MainActivity extends Activity {

    public	Menu	mMenu;	
	private MainActivity instance;
    
	private boolean soundlanched = false;
	
	private MediaPlayer mMediaPlayerbckgnd; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;		
		setContentView(R.layout.activity_main);
		
		final Button ButtonQuitter = (Button) findViewById(R.id.buttonquitter);
		final Button ButtonSon  = (Button) findViewById(R.id.buttonhighscores);
		final Button ButtonJouer   = (Button) findViewById(R.id.buttonJouer);
	    final Button Buttonabout   = (Button) findViewById(R.id.buttonabout);
	    final Button Buttonhighscore=(Button) findViewById(R.id.buttonhighscore);
		
		
		mMediaPlayerbckgnd = MediaPlayer.create(instance.getBaseContext(), R.raw.ambiance); 
		mMediaPlayerbckgnd.setLooping(true);
		
		ButtonQuitter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
				Drawable a = getResources().getDrawable(R.drawable.quitter_clik);
				ButtonQuitter.setBackgroundDrawable(a);
				
				
			}
		});		

		ButtonSon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				soundlanched = !soundlanched;
				if (soundlanched) {
					Drawable f = getResources().getDrawable(R.drawable.option);
					ButtonSon.setBackgroundDrawable(f);
					
					//ButtonSon.setText(R.string.btn_sonoui);
					mMediaPlayerbckgnd.start();
				} else {
					Drawable g = getResources().getDrawable(R.drawable.option_clik);
					ButtonSon.setBackgroundDrawable(g);
					//ButtonSon.setText(R.string.btn_sonnon);
					if(mMediaPlayerbckgnd.isPlaying()) {
						mMediaPlayerbckgnd.pause();
					}
				}
			}
		});		

		ButtonJouer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(instance, P8_memory.class);
				startActivity(intent);
				Drawable d = getResources().getDrawable(R.drawable.jouer_clik);
				ButtonJouer.setBackgroundDrawable(d);
				
				
			}
		});		
		
		Buttonhighscore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(instance, Highscore.class);
				startActivity(intent);	
				Drawable c = getResources().getDrawable(R.drawable.hight_clik);
				Buttonhighscore.setBackgroundDrawable(c);
			}
		});		
		
		Buttonabout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(instance, About.class);
				startActivity(intent);		
				Drawable e = getResources().getDrawable(R.drawable.about_clik);
				Buttonabout.setBackgroundDrawable(e);
			}
		});		
		
		
	}

    /* *********************************************************** */                   	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    /* *********************************************************** */                   

    /* *********************************************************** */                   
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
   		return true;	
    }    
    /* *********************************************************** */      

    /* *********************************************************** */                   
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
			case R.id.about:
				showAbout();
		    	return true;		    	
			case R.id.help:
				showHelp();
		    	return true;		    			    			    			    	
			default:
		    	return false;
		}	
    }    
    /* *********************************************************** */	
	
    
    /* *********************************************************** */                       
    private void showAbout() {
    	AlertDialog.Builder	about = new AlertDialog.Builder(this);
    	about.setTitle(
   			Html.fromHtml(
				"<b>TP2 PARIS 8</b>")		    			
    	);
    	about.setIcon(R.drawable.ic_about);
    	
    	TextView l_viewabout	= new TextView(this);    	
    	l_viewabout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
    	l_viewabout.setPadding(20, 10, 20, 10);    	
    	l_viewabout.setTextSize(20);    	
    	l_viewabout.setText(
    			Html.fromHtml(
    					"<small>TP 2 - PARIS 8 - SNAKE</small>"+
    					"<br/>"+"<br/>"+
    					"<b>Developped by:</b>"+
    					"<br/>"+    	
    					"<small>- Ludovic GREMY</small>"+
    					"<br/>"+"<br/>"+
    					"<small>PARIS 8 MIME<br/><a href=\"http://www.univ-paris8.fr\">univ-paris8.fr</a></small>"+
    					"<br/>"
    					)		
    	);   	
    	//l_viewabout.setMovementMethod(LinkMovementMethod.getInstance());
    	 
    	about.setView(l_viewabout);
    	about.setPositiveButton(
    			"OK",
    			new android.content.DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {						
					}
				}
    			);
    	
    	about.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				
			}
		}
		);
    	
    	about.show();
    }    
    /* *********************************************************** */                       
    
    /* *********************************************************** */                       
    private void showHelp() {
    	AlertDialog.Builder	help = new AlertDialog.Builder(this);
    	
    	//TextView l_viewhelp	= new TextView(this);    	  
    	
    	
    	help.setTitle(
   			Html.fromHtml(
   					"<b>TP2 PARIS 8</b>")		    			
    	);
    	help.setIcon(R.drawable.ic_help);    	
    	help.setMessage(
    			Html.fromHtml(
    					"<b><u>Règles:</u></b>"+
    					"<br/>"+    	
    					"<small>Le joueur contrôle un serpent, qui doit se déplacer à l'intérieur d’une zone définie et éviter les obstacles qui sont situés dans la zone. Le joueur doit faire manger à son serpent un certain nombre de pastilles, allongeant à chaque fois la taille du serpent, l'objectif est de manger le maximum de pastilles et de faire grossir le serpent. Une fois le premier choix de direction effectué, le serpent avance inexorablement, le joueur ne peut que lui indiquer une direction à suivre (en haut, en bas, à gauche, à droite) afin d'éviter que la tête du serpent ne touche les murs, les obstacles ou son propre corps.</small>"+
    					"<br/>"+"<br/>"
    			)		
    	);   	
    	
    	help.setPositiveButton(
    			"OK",
    			new android.content.DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				}
    			);
    	
    	help.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
			
			}
		}
		);
    	
    	help.show();
    }    
    /* *********************************************************** */       
    
}
