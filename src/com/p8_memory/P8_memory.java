package com.p8_memory;

import com.p8_tp2android.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


public class P8_memory extends Activity {

    private MemoryView mView;
    private int meilleurspoints;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mView = (MemoryView)findViewById(R.id.MemoryView);
        mView.setVisibility(View.VISIBLE);        
    }


	public void savepoint() {
		int a = mView.score;
		if (a > meilleurspoints) {

			SharedPreferences Prefs = this.getSharedPreferences("prefs",MODE_WORLD_READABLE);
			SharedPreferences.Editor prefsEditor = Prefs.edit();
			prefsEditor.putInt("bestscore", mView.score);
			prefsEditor.commit();
		} else {
			SharedPreferences Prefs = this.getSharedPreferences("prefs", MODE_WORLD_READABLE);
			SharedPreferences.Editor prefsEditor = Prefs.edit();
			prefsEditor.putInt("bestscore", meilleurspoints);
			prefsEditor.commit();
		}
	}

	public void recupBestScore() {
		SharedPreferences Prefs = this.getSharedPreferences("prefs", MODE_WORLD_READABLE);
		SharedPreferences.Editor prefsEditor = Prefs.edit();
		meilleurspoints = Prefs.getInt("bestscore", 0);
}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		recupBestScore();
		mView.score = 0;

	}

	@Override
	protected void onPause() {
		savepoint();
		super.onPause();

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if(mView.win)
		savepoint();
		super.onDestroy();
	}


}