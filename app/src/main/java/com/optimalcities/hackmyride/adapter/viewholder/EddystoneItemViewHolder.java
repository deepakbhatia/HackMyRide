package com.optimalcities.hackmyride.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.optimalcities.hackmyride.R;

import butterknife.ButterKnife;
import butterknife.Bind;

public class EddystoneItemViewHolder {
    @Bind(R.id.power)
    public TextView txPowerTextView;
    @Bind(R.id.namespace_id)
    public TextView namespace;
    @Bind(R.id.instance_id)
    public TextView instance;
    @Bind(R.id.url)
    public TextView url;
    @Bind(R.id.temperature)
    public TextView temperature;
    @Bind(R.id.battery_voltage)
    public TextView batteryVoltage;
    @Bind(R.id.pdu_count)
    public TextView pduCount;
    @Bind(R.id.time_since_power_up)
    public TextView timeSincePowerUp;
    @Bind(R.id.telemetry_version)
    public TextView telemetryVersion;

    public EddystoneItemViewHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }
}
