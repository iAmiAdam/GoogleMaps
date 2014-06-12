package info.adamjsmith.lbs;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;


public class LBSActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		MapFragment fragment1 = new MapFragment();
		fragmentTransaction.replace(R.id.mapView, fragment1);
		fragmentTransaction.commit();
		
		
	}
	
		
}
