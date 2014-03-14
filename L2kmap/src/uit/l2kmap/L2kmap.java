package uit.l2kmap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;

public class L2kmap extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_l2kmap);
		Button btn_scanwifi=(Button) findViewById(R.id.btn_scanwifi);
		Button btn_loadfile=(Button) findViewById(R.id.btn_loadfile);
		Button btn_position=(Button) findViewById(R.id.btn_position);
		btn_scanwifi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			Wifiscan();
				// TODO Auto-generated method stub
				
			}
		});
		btn_loadfile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				loadfile();
				// TODO Auto-generated method stub
				
			}
		});
		btn_position.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getposition();
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	

	private void Wifiscan()
	{
		Intent wifiIntent=new Intent(this, WifiScan.class);
		 startActivity(wifiIntent);
	}
	
	private void loadfile()
	{
		Intent loadIntent=new Intent(this,LoadingSVGfile.class);
		startActivity(loadIntent);
	}
	
	private void getposition(){
		Intent positionIntent=new Intent(this,GetPosition.class);
		startActivity(positionIntent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.l2kmap, menu);
		return true;
	}

}