package com.optimalcities.hackmyride.ui.activity.monitor;

import com.optimalcities.hackmyride.adapter.monitor.BaseMonitorAdapter;
import com.optimalcities.hackmyride.adapter.monitor.IBeaconMonitorAdapter;
import com.kontakt.sdk.android.ble.configuration.scan.EddystoneScanContext;
import com.kontakt.sdk.android.ble.configuration.scan.IBeaconScanContext;

public class IBeaconMonitorActivity extends BaseBeaconMonitorActivity {


    @Override
    IBeaconScanContext getIBeaconScanContext() {
        return iBeaconScanContext;
    }

    @Override
    EddystoneScanContext getEddystoneScanContext() {
        return null;
    }

    @Override
    BaseMonitorAdapter getAdapter() {
        return new IBeaconMonitorAdapter(this);
    }
}
