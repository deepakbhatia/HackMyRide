package com.optimalcities.hackmyride.ui.activity.range;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.optimalcities.hackmyride.R;
import com.optimalcities.hackmyride.adapter.range.BaseRangeAdapter;
import com.optimalcities.hackmyride.adapter.range.IBeaconRangeAdapter;
import com.optimalcities.hackmyride.dialog.PasswordDialogFragment;
import com.optimalcities.hackmyride.ui.activity.management.BeaconManagementActivity;
import com.optimalcities.hackmyride.ui.activity.management.SyncableBeaconManagementActivity;
import com.kontakt.sdk.android.ble.configuration.scan.EddystoneScanContext;
import com.kontakt.sdk.android.ble.configuration.scan.IBeaconScanContext;
import com.kontakt.sdk.android.common.interfaces.SDKBiConsumer;
import com.kontakt.sdk.android.common.profile.IBeaconDevice;

public class BeaconRangeSyncableActivity extends BaseBeaconRangeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void callOnListItemClick(int position) {
        final IBeaconDevice beacon = (IBeaconDevice) adapter.getItem(position);
        if (beacon != null) {
            PasswordDialogFragment.newInstance(getString(R.string.format_connect, beacon.getAddress()),
                    getString(R.string.password),
                    getString(R.string.connect),
                    new SDKBiConsumer<DialogInterface, String>() {
                        @Override
                        public void accept(DialogInterface dialogInterface, String password) {

                            beacon.setPassword(password.getBytes());

                            final Intent intent = new Intent(BeaconRangeSyncableActivity.this, SyncableBeaconManagementActivity.class);
                            intent.putExtra(BeaconManagementActivity.EXTRA_BEACON_DEVICE, beacon);

                            startActivityForResult(intent, REQUEST_CODE_CONNECT_TO_DEVICE);
                        }
                    }).show(getFragmentManager(), "dialog");
        }
    }

    @Override
    IBeaconScanContext getIBeaconScanContext() {
        return beaconScanContext;
    }

    @Override
    EddystoneScanContext getEddystoneScanContext() {
        return null;
    }

    @Override
    BaseRangeAdapter getAdapter() {
        return new IBeaconRangeAdapter(this);
    }
}
