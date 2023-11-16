package mx.org.hugo4295;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PrincipalActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtlong, txtalt;

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtlong = findViewById(R.id.txtlongitud);
        txtalt = findViewById(R.id.txtlatitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng latLng = new LatLng(19.38617,-99.00312);
        mMap.addMarker(new MarkerOptions().position(latLng).title("conocido"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtalt.setText("Latitud "+latLng.latitude);
        txtlong.setText("Longitud "+latLng.longitude);

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtalt.setText("Latitud "+latLng.latitude);
        txtlong.setText("Longitud "+latLng.longitude);

    }
}