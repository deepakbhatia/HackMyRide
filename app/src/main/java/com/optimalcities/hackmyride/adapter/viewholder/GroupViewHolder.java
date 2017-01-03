package com.optimalcities.hackmyride.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.optimalcities.hackmyride.R;

public class GroupViewHolder {

    public TextView header;

    public GroupViewHolder(View view) {
        header = (TextView) view.findViewById(R.id.header);
    }


}
