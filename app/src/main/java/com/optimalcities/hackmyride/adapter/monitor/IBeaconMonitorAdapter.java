package com.optimalcities.hackmyride.adapter.monitor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.optimalcities.hackmyride.R;
import com.optimalcities.hackmyride.adapter.viewholder.IBeaconItemViewHolder;
import com.kontakt.sdk.android.ble.device.BeaconDevice;
import com.kontakt.sdk.android.ble.device.BeaconRegion;
import com.kontakt.sdk.android.common.profile.IBeaconDevice;
import com.kontakt.sdk.android.common.profile.IBeaconRegion;

import java.text.DecimalFormat;

public class IBeaconMonitorAdapter extends BaseMonitorAdapter<IBeaconRegion, IBeaconDevice> {


    public IBeaconMonitorAdapter(final Context context) {
        super(context);
    }


    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final BeaconRegion region = (BeaconRegion) getGroup(groupPosition);
        if (convertView == null) {
            convertView = createHeader();
        }
        setHeaderTitle(region.getName(), convertView);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final BeaconDevice device = (BeaconDevice) getChild(groupPosition, childPosition);

        if (convertView == null) {
            convertView = createView(R.layout.beacon_list_row);
            final IBeaconItemViewHolder childViewHolder = new IBeaconItemViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }

        final IBeaconItemViewHolder childViewHolder = (IBeaconItemViewHolder) convertView.getTag();
        childViewHolder.nameTextView.setText(String.format("%s: %s (%s)", device.getName(),
                device.getAddress(),
                new DecimalFormat("#.##").format(device.getDistance())));
        childViewHolder.proximityUUIDTextView.setText(String.format("Proximity UUID: %s", device.getProximityUUID().toString()));
        childViewHolder.majorTextView.setText(String.format("Major: %d", device.getMajor()));
        childViewHolder.minorTextView.setText(String.format("Minor: %d", device.getMinor()));
        childViewHolder.rssiTextView.setText(String.format("Rssi: %f", device.getRssi()));
        childViewHolder.txPowerTextView.setText(String.format("Tx Power: %d", device.getTxPower()));
        childViewHolder.beaconUniqueIdTextView.setText(String.format("Beacon Unique Id: %s", device.getUniqueId()));
        childViewHolder.firmwareVersionTextView.setText(String.format("Firmware version: %d", device.getFirmwareVersion()));
        childViewHolder.proximityTextView.setText(String.format("Proximity: %s", device.getProximity()));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
