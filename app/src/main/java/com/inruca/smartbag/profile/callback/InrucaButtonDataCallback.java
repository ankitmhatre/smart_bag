package com.inruca.smartbag.profile.callback;

import android.bluetooth.BluetoothDevice;
import android.util.Log;

import androidx.annotation.NonNull;

import no.nordicsemi.android.ble.callback.DataSentCallback;
import no.nordicsemi.android.ble.callback.profile.ProfileDataCallback;
import no.nordicsemi.android.ble.data.Data;

public abstract class InrucaButtonDataCallback implements ProfileDataCallback, InrucaButtonCallback, DataSentCallback {
    private static final int STATE_RELEASED = 0x00;
    private static final int STATE_PRESSED = 0x01;

    @Override
    public void onDataReceived(@NonNull final BluetoothDevice device, final Data data) {
        Log.d("IBDC", data.toString());
//        if (data.size() != 1) {
//            onInvalidDataReceived(device, data);
//            return;
//        }
//
//        final int state = data.getIntValue(Data.FORMAT_UINT8, 0);
//        if (state == STATE_PRESSED) {
//            onButtonStateChanged(device, true);
//        } else if (state == STATE_RELEASED) {
//            onButtonStateChanged(device, false);
//        } else {
//            onInvalidDataReceived(device, data);
//        }
        onButtonStateChanged(device, data);
    }
}

