package com.optimalcities.hackmyride.ui.activity.range;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.optimalcities.hackmyride.R;
import com.optimalcities.hackmyride.adapter.range.BaseRangeAdapter;
import com.optimalcities.hackmyride.adapter.range.EddystoneRangeAdapter;
import com.optimalcities.hackmyride.dialog.PasswordDialogFragment;
import com.optimalcities.hackmyride.ui.activity.management.EddystoneManagementActivity;
import com.kontakt.sdk.android.ble.configuration.scan.EddystoneScanContext;
import com.kontakt.sdk.android.ble.configuration.scan.IBeaconScanContext;
import com.kontakt.sdk.android.common.interfaces.SDKBiConsumer;
import com.kontakt.sdk.android.common.profile.IEddystoneDevice;

public class EddystoneBeaconRangeActivity extends BaseBeaconRangeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setUpActionBarTitle(getString(R.string.range_eddystone));
    }

    @Override
    void callOnListItemClick(int position) {
        final IEddystoneDevice eddystoneDevice = (IEddystoneDevice) adapter.getItem(position);
        if (eddystoneDevice != null) {
            PasswordDialogFragment.newInstance(getString(R.string.format_connect, eddystoneDevice.getAddress()),
                    getString(R.string.password),
                    getString(R.string.connect),
                    new SDKBiConsumer<DialogInterface, String>() {
                        @Override
                        public void accept(DialogInterface dialogInterface, String password) {
                            eddystoneDevice.setPassword(password.getBytes());

                            final Intent intent = new Intent(EddystoneBeaconRangeActivity.this, EddystoneManagementActivity.class);
                            intent.putExtra(EddystoneManagementActivity.EDDYSTONE_DEVICE, eddystoneDevice);

                            startActivityForResult(intent, REQUEST_CODE_CONNECT_TO_DEVICE);
                        }
                    }).show(getFragmentManager(), "dialog");
        }
    }

    @Override
    EddystoneScanContext getEddystoneScanContext() {
        return eddystoneScanContext;
    }

    @Override
    IBeaconScanContext getIBeaconScanContext() {
        return null;
    }

    @Override
    BaseRangeAdapter getAdapter() {
        return new EddystoneRangeAdapter(this);
    }
}
