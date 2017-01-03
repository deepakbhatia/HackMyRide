package com.optimalcities.hackmyride.ui.activity.monitor;

import android.os.Bundle;

import com.optimalcities.hackmyride.R;
import com.optimalcities.hackmyride.adapter.monitor.BaseMonitorAdapter;
import com.optimalcities.hackmyride.adapter.monitor.EddystoneMonitorAdapter;
import com.kontakt.sdk.android.ble.configuration.scan.EddystoneScanContext;
import com.kontakt.sdk.android.ble.configuration.scan.IBeaconScanContext;

public class EddystoneMonitorActivity extends BaseBeaconMonitorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpActionBarTitle(getString(R.string.monitor_eddystone));
    }

    @Override
    IBeaconScanContext getIBeaconScanContext() {
        return null;
    }

    @Override
    EddystoneScanContext getEddystoneScanContext() {
        return eddystoneScanContext;
    }

    @Override
    BaseMonitorAdapter getAdapter() {
        return new EddystoneMonitorAdapter(this);
    }
}
