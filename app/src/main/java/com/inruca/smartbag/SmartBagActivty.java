/*
 * Copyright (c) 2018, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.inruca.smartbag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.inruca.smartbag.adapter.DiscoveredBluetoothDevice;
import com.inruca.smartbag.viewmodels.BlinkyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import no.nordicsemi.android.ble.livedata.state.ConnectionState;

@SuppressWarnings("ConstantConditions")
public class SmartBagActivty extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String EXTRA_DEVICE = "com.inruca.smartbag.blinky.EXTRA_DEVICE";

    private BlinkyViewModel viewModel;

    @BindView(R.id.led_switch)
    SwitchMaterial led;
    @BindView(R.id.button_state)
    TextView buttonState;
    @BindView(R.id.quickAccess)
    GridLayout quickAccess;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_drawer_icon_toolbar)
    ImageView nav_drawer_icon_toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_bag_home);
        ButterKnife.bind(this);

        final Intent intent = getIntent();
        final DiscoveredBluetoothDevice device = intent.getParcelableExtra(EXTRA_DEVICE);
        final String deviceName = device.getName();
        final String deviceAddress = device.getAddress();

        //final MaterialToolbar toolbar = findViewById(R.id.toolbar);
//
//
//        toolbar.setTitle(deviceName != null ? deviceName : getString(R.string.unknown_device));
//        toolbar.setSubtitle(deviceAddress);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        nav_drawer_icon_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });


        // Configure the view model.
        viewModel = new ViewModelProvider(this).get(BlinkyViewModel.class);
        viewModel.connect(device);

        // Set up views.
        final TextView ledState = findViewById(R.id.led_state);
        final LinearLayout progressContainer = findViewById(R.id.progress_container);
        final TextView connectionState = findViewById(R.id.connection_state);
        final View content = findViewById(R.id.device_container);
        final View notSupported = findViewById(R.id.not_supported);

        ///////////////////////////////////////
        ImageView imagebutton = new ImageView(SmartBagActivty.this);
        imagebutton.setImageResource(R.drawable.icon_sterile);
        imagebutton.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton);

        ImageView imagebutton2 = new ImageView(SmartBagActivty.this);
        imagebutton2.setImageResource(R.drawable.icon_security);
        imagebutton2.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton2);

        ImageView imagebutton3 = new ImageView(SmartBagActivty.this);
        imagebutton3.setImageResource(R.drawable.icon_laptop);
        imagebutton3.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton3);

        ImageView imagebutton4 = new ImageView(SmartBagActivty.this);
        imagebutton4.setImageResource(R.drawable.icon_battery);
        imagebutton4.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton4);

        ImageView imagebutton5 = new ImageView(SmartBagActivty.this);
        imagebutton5.setImageResource(R.drawable.icon_findmybag);
        imagebutton5.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton5);



        ImageView imagebutton6 = new ImageView(SmartBagActivty.this);
        imagebutton6.setImageResource(R.drawable.icon_flashlight);
        imagebutton6.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton6);


        ImageView imagebutton7 = new ImageView(SmartBagActivty.this);
        imagebutton7.setImageResource(R.drawable.icon_pocket1);
        imagebutton7.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton7);

        ImageView imagebutton8 = new ImageView(SmartBagActivty.this);
        imagebutton8.setImageResource(R.drawable.icon_pocket2);
        imagebutton8.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton8);


        ImageView imagebutton9 = new ImageView(SmartBagActivty.this);
        imagebutton9.setImageResource(R.drawable.icon_pocket3);
        imagebutton9.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.icon_width), getResources().getDimensionPixelSize(R.dimen.icon_height)));
        quickAccess.addView(imagebutton9);
        ///////////////////////////////////////


        led.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.setLedState(isChecked));
        viewModel.getConnectionState().observe(this, state -> {
            switch (state.getState()) {
                case CONNECTING:
                    progressContainer.setVisibility(View.VISIBLE);
                    notSupported.setVisibility(View.GONE);
                    connectionState.setText(R.string.state_connecting);
                    break;
                case INITIALIZING:
                    connectionState.setText(R.string.state_initializing);
                    break;
                case READY:
                    progressContainer.setVisibility(View.GONE);
                    //content.setVisibility(View.VISIBLE);
                    onConnectionStateChanged(true);
                    break;
                case DISCONNECTED:
                    if (state instanceof ConnectionState.Disconnected) {
                        final ConnectionState.Disconnected stateWithReason = (ConnectionState.Disconnected) state;
                        if (stateWithReason.isNotSupported()) {
                            progressContainer.setVisibility(View.GONE);
                            notSupported.setVisibility(View.VISIBLE);
                        }
                    }
                    // fallthrough
                case DISCONNECTING:
                    onConnectionStateChanged(false);
                    break;
            }
        });
        viewModel.getLedState().observe(this, isOn -> {
            ledState.setText(isOn ? R.string.turn_on : R.string.turn_off);
            led.setChecked(isOn);
        });
        viewModel.getButtonState().observe(this,
                pressed -> buttonState.setText(pressed ?
                        R.string.button_pressed : R.string.button_released));
    }

    @OnClick(R.id.action_clear_cache)
    public void onTryAgainClicked() {
        viewModel.reconnect();
    }

    private void onConnectionStateChanged(final boolean connected) {
        led.setEnabled(connected);
        if (!connected) {
            led.setChecked(false);
            buttonState.setText(R.string.button_unknown);
        }
    }

    private void openLink(String address) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(address));
        startActivity(i);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_help:
                openLink("https://inruca.com/apps/help-center");
                break;
            case R.id.menu_shop:
                openLink("https://inruca.com");
                break;
            case R.id.menu_terms:
                openLink("https://inruca.com/policies/terms-of-service");
                break;
            case R.id.menu_privacy:
                openLink("https://inruca.com/policies/privacy-policy");
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
