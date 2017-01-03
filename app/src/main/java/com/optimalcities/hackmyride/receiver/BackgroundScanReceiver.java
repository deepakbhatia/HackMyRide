package com.optimalcities.hackmyride.receiver;

import android.content.Context;

import com.optimalcities.hackmyride.broadcast.AbstractBroadcastInterceptor;
import com.optimalcities.hackmyride.broadcast.NotificationBroadcastInterceptor;

public final class BackgroundScanReceiver extends AbstractScanBroadcastReceiver {

    @Override
    protected AbstractBroadcastInterceptor createBroadcastHandler(Context context) {
        return new NotificationBroadcastInterceptor(context);
    }
}
