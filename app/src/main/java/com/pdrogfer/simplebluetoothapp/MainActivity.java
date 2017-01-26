package com.pdrogfer.simplebluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_BLUETOOTH = 0;
    private BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> pairedDevices;

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
            startActivityForResult(turnOn, REQUEST_BLUETOOTH);
            Toast.makeText(this, "Turned on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Already on", Toast.LENGTH_SHORT).show();
        }
    }

    public void visible(View view) {
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }

    public void list(View view) {
        pairedDevices = bluetoothAdapter.getBondedDevices();

        ArrayList listDevicesNames = new ArrayList();

        for (BluetoothDevice device :
                pairedDevices) {
            listDevicesNames.add(device.getName());
        }
        Toast.makeText(this, "Showing Paired Devices", Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listDevicesNames);
        lvDevices.setAdapter(adapter);


    }
}
