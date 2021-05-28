package com.futuremobile.wox.presentation.utiles;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener{

    private Context mContext;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;
    Location location;
    double latitude;
    double longitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1000L;
    private static final long MIN_TIME_BW_UPDATES = 60000L;
    protected LocationManager locationManager;
    Activity activity;

    public GPSTracker() {
    }

    public GPSTracker(Context context, Activity activity) {
        this.mContext = context;
        this.activity = activity;
        this.getLocation();
    }

    public Location getLocation() {
        try {
            this.locationManager = (LocationManager)this.mContext.getSystemService("location");
            this.isGPSEnabled = this.locationManager.isProviderEnabled("gps");
            this.isNetworkEnabled = this.locationManager.isProviderEnabled("network");
            if (this.isGPSEnabled || this.isNetworkEnabled) {
                this.canGetLocation = true;
                if (this.isNetworkEnabled) {
                    int requestPermissionsCode = 50;
                    if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, requestPermissionsCode);
                    } else {
                        this.locationManager.requestLocationUpdates("network", 60000L, 1000.0F, this);
                        Log.d("Network", "Network");
                        if (this.locationManager != null) {
                            this.location = this.locationManager.getLastKnownLocation("network");
                            if (this.location != null) {
                                this.latitude = this.location.getLatitude();
                                this.longitude = this.location.getLongitude();
                            }
                        }
                    }
                }

                if (this.isGPSEnabled && this.location == null) {
                    if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 50);
                    } else {
                        this.locationManager.requestLocationUpdates("gps", 60000L, 1000.0F, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (this.locationManager != null) {
                            this.location = this.locationManager.getLastKnownLocation("gps");
                            if (this.location != null) {
                                this.latitude = this.location.getLatitude();
                                this.longitude = this.location.getLongitude();
                            }
                        }
                    }
                }
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return this.location;
    }

    public void stopUsingGPS() {
        if (this.locationManager != null) {
            if (ContextCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this.activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 50);
            } else {
                this.locationManager.removeUpdates(this);
            }
        }

    }

    public double getLatitude() {
        if (this.location != null) {
            this.latitude = this.location.getLatitude();
        }

        return this.latitude;
    }

    public double getLongitude() {
        if (this.location != null) {
            this.longitude = this.location.getLongitude();
        }

        return this.longitude;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.mContext);
        alertDialog.setTitle("Información");
        alertDialog.setMessage("GPS no está habilitado. ¿Quieres ir al menú de configuración?");
        alertDialog.setPositiveButton("Configurar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                GPSTracker.this.mContext.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void onLocationChanged(Location _location) {
        if (_location != null) {
            this.latitude = _location.getLatitude();
            this.longitude = _location.getLongitude();
        }

    }

    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

}