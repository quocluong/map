package uit.l2kmap;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;

import android.graphics.Color;
import android.widget.ImageView;
import android.view.Menu;
import android.view.View;

public class LoadingSVGfile extends Activity {

	@SuppressLint("NewApi") @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading_svgfile);
		ImageView imageView = new ImageView(this);
      // Set the background color to white
      imageView.setBackgroundColor(Color.WHITE);
     // Parse the SVG file from the resource
      SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.map);
      //Get a drawable from the parsed SVG and set it as the drawable for the ImageView
      imageView.setImageDrawable(svg.createPictureDrawable());
      //Set the ImageView as the content view for the Activity
      setContentView(imageView);
      imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loading_svgfile, menu);
		return true;
	}

}