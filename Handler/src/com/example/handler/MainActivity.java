package com.example.handler;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private ProgressBar progressBar;
	private TextView text;
	private RadioButton odd,even;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar = (ProgressBar)findViewById(R.id.progressBar1);
		text = (TextView)findViewById(R.id.textView1);
		odd =(RadioButton)findViewById(R.id.odd);
		even =(RadioButton)findViewById(R.id.even);
		startProgress();
	}
	public void startProgress(){
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for( int i=0 ; i< 100 ;i++){
					final int value =i ;
					dofakework();
					progressBar.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
						text.setText("Updating :"+ value);
						progressBar.setProgress(value);
						if(value%2==0){
							even.setChecked(true);
							odd.setChecked(false);
						}else{
							odd.setChecked(true);
							even.setChecked(false);
						}
							
						
						}
					});
				}
			}

			
		};
		new Thread(runnable).start();
	}
	private void dofakework() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
