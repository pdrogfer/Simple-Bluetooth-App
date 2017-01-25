package com.pdrogfer.simplebluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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

    public void off(View view) {
        bluetoothAdapter.disable();
        Toast.makeText(this, "Turned off", Toast.LENGTH_SHORT).show();
    }

    public void on(View view) {
        if (!bluetoothAdapter.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(this, "Turned on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Already on", Toast.LENGTH_SHORT).show();
        }
    }

}
