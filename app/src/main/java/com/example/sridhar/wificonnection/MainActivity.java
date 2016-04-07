//package com.example.sridhar.wificonnection;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.IntentFilter;
//import android.net.wifi.WifiConfiguration;
//import android.net.wifi.WifiInfo;
//import android.net.wifi.WifiManager;
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.List;
//
//
//public class MainActivity extends Activity implements View.OnClickListener {
//    private static final String TAG = "WiFiDemo";
//    public WifiManager wifi;
//    private BroadcastReceiver receiver;
//
//    private TextView textStatus;
//    private Button buttonScan;
//
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        // Setup UI
//        textStatus = (TextView) findViewById(R.id.textStatus);
//        buttonScan = (Button) findViewById(R.id.buttonScan);
//        buttonScan.setOnClickListener(this);
//
//        setWiFiStatus();
//    }
//
//    private void setWiFiStatus() {
//        // Setup WiFi
//        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//
//        // Get WiFi status
//        WifiInfo info = wifi.getConnectionInfo();
//        textStatus.append("\n\nWiFi Status: " + info.toString());
//
//        // List available networks
//        List<WifiConfiguration> configs = wifi.getConfiguredNetworks();
//        for (WifiConfiguration config : configs) {
//            textStatus.append("\n\n" + config.toString());
//        }
//
//        // Register Broadcast Receiver
//        if (receiver == null)
//            receiver = new WiFiScanReceiver(this);
//
//        registerReceiver(receiver, new IntentFilter(
//                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//        Log.d(TAG, "onCreate()");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        unregisterReceiver(receiver);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        registerReceiver(receiver, new IntentFilter(
//                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//    }
//
//    public void onClick(View view) {
//        Toast.makeText(this, "On Click Clicked. Toast to that!!!",
//                Toast.LENGTH_LONG).show();
//
//        if (view.getId() == R.id.buttonScan) {
//            Log.d(TAG, "onClick() wifi.startScan()");
//            wifi.startScan();
//        }
//    }
//
//}