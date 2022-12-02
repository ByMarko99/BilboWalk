package com.example.fortheloveofgodcanyoujsutworik;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.support.v4.app.Fragment;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnCameraMoveListener, GoogleMap.OnMapClickListener  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Context globalContext = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    MapView mapView;
    GoogleMap map;
boolean check = false;


    private static final String TAG = HomeFragment.class.getSimpleName();
    private CameraPosition cameraPosition;

    // The entry point to the Places API.
    private PlacesClient placesClient;

    // The entry point to the Fused Location Provider.
    private FusedLocationProviderClient fusedLocationProviderClient;

    // A default location (Sydney, Australia) and default zoom to use when location permission is
    // not granted.


    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private Location lastKnownLocation;
    ImageView walter;
    // Keys for storing activity state.
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    private FusedLocationProviderClient fusedLocationClient;

    // Used for selecting the current place.
    private List allPoints;
    String localizacion;
    TextView bubble;
    Drawable marker;
    private static View v;
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 500;
    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            bubble.setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        globalContext = this.getActivity();

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        if (savedInstanceState != null) {
            lastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
            cameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
        }

        // Retrieve the content view that renders the map.


    }
    private class MyAsyncTask extends AsyncTask<Void, Void, Void> // Bro?
    {
        @Override
        protected Void doInBackground(Void... params) {
            buildAlertMessageNoGps();
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            final Handler ha=new Handler();
            ha.postDelayed(new Runnable() {

                @Override
                public void run() { // Una vez habre el intent de ajustes empieza a comprobar cada un segundo si se ha activado o no
                    //    getLocation();
                    // Toast.makeText(getContext(), "aaaa", Toast.LENGTH_SHORT).show();
                    if(canGetLocation()){ // Si se activa carga splash screen de nuevo para hacer el zoom al cargar homefragment entra en el else
                        Intent intent = new Intent(getActivity(), SplashScreen.class);
                        startActivity(intent);
                    //    fragmentTransaction.remove(HomeFragment.this).commit();
                        try { // Fuerza destrozar el fragmento, salta error, el usuario no lo nota
                            getActivity().getSupportFragmentManager().beginTransaction().remove(HomeFragment.this).commit();
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }


                    }
                    ha.postDelayed(this, 1000);
                }
            }, 1000);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_home, container, false);
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != //Comprueba solo si tiene write, no hace falta mas, y lo pide sino junto al read
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        }

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);


        mapView.getMapAsync(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location == null) {

                                    new MyAsyncTask().execute();

                        }else {
                            LatLng here = new LatLng(location.getLatitude(), location.getLongitude());
                            float zoomLevel = 13.5f;
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(here, zoomLevel));
                            map.addMarker(new MarkerOptions().position(here).title("Hemen zaude"));

                        }

                    }
                });

        bubble = v.findViewById(R.id.msgView);
        marker = getResources().getDrawable(R.drawable.tvbackground);

        bubble.setBackground(marker);

        walter = v.findViewById(R.id.waltre);
        Random r = new Random();
        int low = 1;
        int high = 4; // 3


        walter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {


                    int result = r.nextInt(high - low) + low;
                    //Toast.makeText(getContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();

                    if (result == 1) {

                        bubble.setVisibility(v.VISIBLE);
                        animateText("    My name is Walter Wartwell White. I live at 308 negra arroyo.");
                        setCharacterDelay(50);


                    }else if(result == 2){

                        bubble.setVisibility(v.VISIBLE);
                        animateText("    Amongus sussy remix");
                        setCharacterDelay(50);


                    }else{
                        bubble.setVisibility(v.VISIBLE);
                        animateText("    Hola niños os voy a enseñar a hacer metanfetamina");
                        setCharacterDelay(50);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bubble.setVisibility(v.INVISIBLE);
                } catch (Exception except) {
                    Log.e(TAG,except +except.getMessage());
                }
            }
        });


        return v;
    }

  /*  @SuppressLint("MissingPermission")
    public void getLocation(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {


                            try {
                                LatLng here = new LatLng(location.getLatitude(), location.getLongitude());
                                map.addMarker(new MarkerOptions().position(here).title("Hemen zaude"));
                            }catch (Exception e){

                            }


                        }


                    }
                });
    }*/
    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;

        bubble.setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);

    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }

    public void onDestroy2() {
        super.onDestroy();

        getFragmentManager().beginTransaction().remove((Fragment) HomeFragment.this).commitAllowingStateLoss();

    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        check = true;

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });

        getActivity().runOnUiThread(new Runnable() { // Hilo no puede sacar popups por eso se le pone que ejecute el hilo en el principal grafico
            public void run() {
                final AlertDialog alert = builder.create();
                alert.show();            }
        });


    }


    public boolean canGetLocation() {
        return isLocationEnabled(getActivity().getApplicationContext()); // application context
    }

    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            return !TextUtils.isEmpty(locationProviders);
        }
    }


       /*
       //in old Api Needs to call MapsInitializer before doing any CameraUpdateFactory call
        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
       */

    // Updates the location and zoom of the MapView
        /*CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10);
        map.animateCamera(cameraUpdate);*/


    @Override


    public void onMapReady(final GoogleMap map) {
        this.map = map;

        LatLng bilbo = new LatLng(43.256962, -2.923460);
        LatLng begoñako_igogailua = new LatLng(43.2605556, -2.9216667);
        LatLng begoñako_basilika = new LatLng(43.25868611, -2.91384722);
        LatLng bilborock  = new LatLng(43.2569444, -2.9275000);
        LatLng arriaga_plaza  = new LatLng(43.2594444, -2.9250000);
        LatLng arenal   = new LatLng(43.2602778, -2.9236111);
        LatLng alhondiga   = new LatLng(43.2597222, -2.9369444);
        LatLng zuricalday_gozotegia   = new LatLng(43.2508333, -2.9427778);


        map.addMarker(new MarkerOptions().position(bilbo).title("Bilbo"));
        map.addMarker(new MarkerOptions().position(begoñako_igogailua).title("Begoñako Igogailua"));
        map.addMarker(new MarkerOptions().position(begoñako_basilika).title("Begoñako Basilika"));
        map.addMarker(new MarkerOptions().position(bilborock).title("Bilborock"));
        map.addMarker(new MarkerOptions().position(arriaga_plaza).title("Arriaga Plaza"));
        map.addMarker(new MarkerOptions().position(arenal).title("Arenal"));
        map.addMarker(new MarkerOptions().position(alhondiga).title("Azkuna Zentroa / Alhondiga"));
        map.addMarker(new MarkerOptions().position(zuricalday_gozotegia).title("Zuricalday Gozotegia"));


        //map.setOnMapClickListener(this);


    }


    // Clase para añadir marcadores onclick
    public void onMapClick(LatLng point) {
     /*   map.clear();
        map.addMarker(new MarkerOptions()
                .position(point)
                .title("You are here")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        //

        getAddress(point.latitude, point.longitude);
*/
    }

    private Object getSystemService(String locationService) {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager;
    }


    //TODO nothing mar submarine brum brum
 /*   public String getAddress(double lat, double lng) {
        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Address obj = addresses.get(0);
            String add = obj.getAddressLine(0);
          //  add = add + "\n" + obj.getCountryName();
          //  add = add + "\n" + obj.getCountryCode();
          //  add = add + "\n" + obj.getAdminArea();
         //   add = add + "\n" + obj.getPostalCode();
            //   add = add + "\n" + obj.getSubAdminArea();

            Log.v("IGA", "Address" + add);
            // Toast.makeText(this, "Address=>" + add,
            // Toast.LENGTH_SHORT).show();
            return add;

            // TennisAppActivity.showDialog(add);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return "";

    } */


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
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


    @Override
    public void onCameraMove() {

    }



}