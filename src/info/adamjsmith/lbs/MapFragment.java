package info.adamjsmith.lbs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {
	 
	MapView mapView;
	GoogleMap map;
 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.main, container, false);
 
 		// Gets the MapView from the XML layout and creates it
		mapView = (MapView) v.findViewById(R.id.mapView);
		mapView.onCreate(savedInstanceState);
 
		// Gets to GoogleMap from the MapView and does initialization stuff
		map = mapView.getMap();
		map.getUiSettings().setMyLocationButtonEnabled(true);
		map.setMyLocationEnabled(true);
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		
		MapsInitializer.initialize(this.getActivity());	
		
		
		map.setOnMapClickListener(new OnMapClickListener(){
			@Override
			public void onMapClick(LatLng latLng) {
				map.clear();
				map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
				map.addMarker(new MarkerOptions()
				.position(latLng)
				.title("Where you touched"));
			}
		});
		
		return v;
	}
 
	@Override
	public void onResume() {
		mapView.onResume();
		super.onResume();
	}
 
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}
 
	@Override
	public void onLowMemory() {
		super.onLowMemory();
		mapView.onLowMemory();
	}
	
	public void onMapClick(LatLng point) {
		
	}
 
}
