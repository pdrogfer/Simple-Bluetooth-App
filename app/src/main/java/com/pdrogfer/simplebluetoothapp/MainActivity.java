package com.pdrogfer.simplebluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter bluetoothAdapter;

    Button btnOn, btnOff, btnVisible, btnDevices;
    ListView lvDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        btnOn = (Button) findViewById(R.id.btn_on);
        btnOff = (Button) findViewById(R.id.btn_off);
        btnVisible = (Button) findViewById(R.id.btn_visible);
        btnDevices = (Button) findViewById(R.id.btn_listDevices);
        lvDevices = (ListView) findViewById(R.id.lv_devices);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }
}
