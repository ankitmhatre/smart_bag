package com.inruca.smartbag.profile.callback;

import android.bluetooth.BluetoothDevice;

import no.nordicsemi.android.ble.data.Data;

public interface InrucaButtonCallback {

    void onButtonStateChanged(BluetoothDevice device, Data data);
}
