package uit.l2kmap;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GetPosition extends Activity {
	
	LoadingSVGfile file =new LoadingSVGfile();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_position);
		setContentView(new SampleView(this));
		
	}
	
	private static class SampleView extends View {
		 
	
		public SampleView(Context context) {
			super(context);
			setFocusable(true);
 
		}
 
		@SuppressLint("DrawAllocation") @Override
		protected void onDraw(Canvas canvas) {
 
			
			Paint p = new Paint();
			p.setAntiAlias(true);
			p.setColor(Color.RED);
			p.setStyle(Paint.Style.STROKE); 
			p.setStrokeWidth(2.5f);
			
			
			canvas.drawCircle(120, 90, 70, p);
			canvas.drawCircle(80, 60, 50, p);
			canvas.drawCircle(160,50,60,p);
		}
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_position, menu);
		return true;
	}

}
