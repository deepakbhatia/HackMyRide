package com.optimalcities.hackmyride.ui.activity.management;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.optimalcities.hackmyride.R;
import com.optimalcities.hackmyride.ui.activity.BaseActivity;
import com.kontakt.sdk.android.common.model.Config;

import java.util.UUID;

import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.OnClick;

public class ConfigFormActivity extends BaseActivity {

    public static final String EXTRA_RESULT_CONFIG = "extra_result_config";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.generate_button)
    Button generateProximityUUIDButton;

    @Bind(R.id.submit_button)
    Button submitButton;

    @Bind(R.id.proximity_uuid_text)
    EditText proximityUUIDText;

    @Bind(R.id.major_text)
    EditText majorText;

    @Bind(R.id.minor_text)
    EditText minorText;

    @Bind(R.id.power_level_text)
    EditText powerLevelText;

    @Bind(R.id.advertising_interval_text)
    EditText advertisingIntervalText;

    @Bind(R.id.beacon_unique_id_text)
    EditText beaconUniqueIdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_form_activity);
        ButterKnife.bind(this);
        setUpActionBar(toolbar);
        setUpActionBarTitle(getString(R.string.configuration));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.generate_button)
    void onGenerateRandomProximityUUID() {
        proximityUUIDText.setText(UUID.randomUUID().toString());
    }

    @OnClick(R.id.submit_button)
    void onSubmit() {
        Config config = createConfig();
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_RESULT_CONFIG, config);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private Config createConfig() {
        return new Config.Builder()
                     .setProximityUUID(UUID.fromString(proximityUUIDText.getText().toString().trim()))
                     .setMajor(Integer.parseInt(majorText.getText().toString()))
                     .setMinor(Integer.parseInt(minorText.getText().toString()))
                     .setTxPower(Integer.parseInt(powerLevelText.getText().toString()))
                     .setDeviceUniqueId(beaconUniqueIdText.getText().toString().trim())
                     .setInterval(Integer.parseInt(advertisingIntervalText.getText().toString()))
                     .build();
    }
}
