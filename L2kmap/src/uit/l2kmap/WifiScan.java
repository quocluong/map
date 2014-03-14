package uit.l2kmap;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;

import java.util.List;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.MenuItem;
import android.widget.TextView;


public class WifiScan extends Activity {
	
	TextView mainText;
    WifiManager mainWifi;
    WifiReceiver receiverWifi;
    List<ScanResult> wifiList;
    StringBuilder sb = new StringBuilder();
    StringBuilder distance = new StringBuilder();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_scan);
		mainText = (TextView) findViewById(R.id.mainText);
	       mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	       receiverWifi = new WifiReceiver();
	       registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	       mainWifi.startScan();
	       mainText.setText("\\nStarting Scan...\\n");
	       
	} 
	 public boolean onCreateOptionsMenu(Menu menu) {
	        menu.add(0, 0, 0, "Refresh");
	        return super.onCreateOptionsMenu(menu);
	    }

	    public boolean onMenuItemSelected(int featureId, MenuItem item) {
	        mainWifi.startScan();
	        mainText.setText("Starting Scan");
	        return super.onMenuItemSelected(featureId, item);
	    }

	    protected void onPause() {
	        unregisterReceiver(receiverWifi);
	        super.onPause();
	    }

	    protected void onResume() {
	        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	        super.onResume();
	    }
	    
	    class WifiReceiver extends BroadcastReceiver {
	        @SuppressLint("UseValueOf")
			public void onReceive(Context c, Intent intent) {
	            sb = new StringBuilder();
	            
	            
	            wifiList = mainWifi.getScanResults();
	            for(int i = 0; i < wifiList.size(); i++){
	            
	            		            	
	               sb.append(new Integer(i+1).toString() + ".");
	            
	               sb.append("SSID:").append((wifiList.get(i).SSID).toString());
	               
	               
	               if(wifiList.get(i).level <= -100)
	            	   wifiList.get(i).level = 0;
	               else if(wifiList.get(i).level >= -50)
	            	   wifiList.get(i).level = 100; 
	               else
	            	  wifiList.get(i).level = 2 * (wifiList.get(i).level + 100);
	               // get distances from access point to device
	               sb.append("\t Level:").append((wifiList.get(i).level)+"%");
	               
	               wifiList.get(i).level=((100-wifiList.get(i).level))/2+5;
	               
	               sb.append("\t Distance: ").append((wifiList.get(i).level)+"m");
	               
	               sb.append("\n");        
	            	
	            }
	            			
	         mainText.setText(sb);
	        }
	    }

}