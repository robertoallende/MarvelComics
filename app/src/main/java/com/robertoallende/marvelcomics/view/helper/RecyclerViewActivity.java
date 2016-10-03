package com.robertoallende.marvelcomics.view.helper;

import android.support.v7.widget.RecyclerView;

// Following:
// https://github.com/commonsguy/cw-omnibus/blob/master/RecyclerView/CardViewList

public class RecyclerViewActivity extends BaseActivity {
    private RecyclerView rv = null;

    public void setAdapter(RecyclerView.Adapter adapter) {
        getRecyclerView().setAdapter(adapter);
    }

    public RecyclerView.Adapter getAdapter() {
        return (getRecyclerView().getAdapter());
    }

    public void setLayoutManager(RecyclerView.LayoutManager mgr) {
        getRecyclerView().setLayoutManager(mgr);
    }

    public RecyclerView getRecyclerView() {
        if (rv == null) {
            rv = new RecyclerView(this);
            rv.setHasFixedSize(true);
            setContentView(rv);
        }

        return (rv);
    }
}