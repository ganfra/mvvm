package fr.ganfra.lib.mvvm.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class HolderViewModel<T, VM extends ItemViewModel> extends RecyclerView.ViewHolder {

    protected Context mContext;
    protected VM mViewModel;

    protected abstract VM createViewModel();

    public HolderViewModel(Context context, View view) {
        super(view);
        mContext = context;
        mViewModel = createViewModel();
    }

    public final void bind(T item) {
        mViewModel.update(item);
    }
}
