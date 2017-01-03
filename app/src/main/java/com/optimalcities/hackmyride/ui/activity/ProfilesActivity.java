package com.optimalcities.hackmyride.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.optimalcities.hackmyride.R;
import com.optimalcities.hackmyride.adapter.ProfilesAdapter;
import com.optimalcities.hackmyride.loader.ProfilesLoader;
import com.kontakt.sdk.android.common.model.IProfile;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.OnItemClick;

public class ProfilesActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<List<IProfile>> {

    public static final String EXTRA_PROFILE = "extra_profile";

    @Bind(R.id.profiles_list)
    ListView profilesList;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private ProfilesAdapter profilesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiles_activity);
        ButterKnife.bind(this);

        setUpActionBar(toolbar);
        setUpActionBarTitle(getString(R.string.profiles));

        profilesAdapter = new ProfilesAdapter(this);
        setListAdapter(profilesAdapter);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.profiles_list)
    void onListItemClick(final int position) {
        final IProfile profile = profilesAdapter.getItem(position);
        final Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_PROFILE, profile);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public Loader<List<IProfile>> onCreateLoader(int id, Bundle args) {
        return new ProfilesLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<IProfile>> loader, List<IProfile> data) {
        profilesAdapter.replaceWith(data);
    }

    @Override
    public void onLoaderReset(Loader<List<IProfile>> loader) {
        profilesAdapter.replaceWith(Collections.<IProfile>emptyList());
    }

    private void setListAdapter(ProfilesAdapter profilesAdapter) {
        profilesList.setAdapter(profilesAdapter);
    }
}
