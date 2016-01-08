package fr.ganfra.lib.mvvm;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

public abstract class FragmentViewModel<VM extends ViewModel> extends Fragment {

    protected VM mViewModel;

    protected abstract VM createViewModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mViewModel == null) {
            mViewModel = createViewModel();
            if (mViewModel instanceof ISavedData && savedInstanceState != null) {
                final ISavedData savedViewModel = (ISavedData) mViewModel;
                final Parcelable data = (Parcelable) savedInstanceState.get(ISavedData.EXTRA_VIEW_MODEL_DATA);
                savedViewModel.restoreData(data);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel instanceof ISavedData) {
            final ISavedData savedViewModel = (ISavedData) mViewModel;
            final Parcelable data = savedViewModel.getDataToSave();
            outState.putParcelable(ISavedData.EXTRA_VIEW_MODEL_DATA, data);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    public void onPause() {
        mViewModel.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    @Override
    public void onDestroy() {
        mViewModel.onDestroy();
        super.onDestroy();
    }
}
