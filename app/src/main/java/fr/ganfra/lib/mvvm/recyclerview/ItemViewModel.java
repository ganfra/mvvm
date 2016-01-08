package fr.ganfra.lib.mvvm.recyclerview;

import android.content.Context;

import fr.ganfra.lib.mvvm.ViewModel;

public abstract class ItemViewModel<T> extends ViewModel {

    protected T mItem;

    public ItemViewModel(Context context) {
        super(context);
    }

    public abstract void update(T item);

}
