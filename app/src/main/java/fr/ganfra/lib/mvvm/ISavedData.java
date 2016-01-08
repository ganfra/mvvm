package fr.ganfra.lib.mvvm;

import android.os.Parcelable;

public interface ISavedData {

    final String EXTRA_VIEW_MODEL_DATA = "EXTRA_VIEW_MODEL_DATA";

    public abstract void restoreData(Parcelable data);

    public abstract Parcelable getDataToSave();

}
