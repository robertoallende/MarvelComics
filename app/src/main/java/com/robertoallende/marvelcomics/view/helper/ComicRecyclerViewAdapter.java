package com.robertoallende.marvelcomics.view.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.robertoallende.marvelcomics.MarvelComicsApp;
import com.robertoallende.marvelcomics.R;
import com.robertoallende.marvelcomics.entity.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

import timber.log.Timber;

public class ComicRecyclerViewAdapter extends RecyclerView.Adapter<ComicRecyclerViewAdapter.ViewHolder> {

    private List<Comic> mValues;
    private Context mContext;

    public ComicRecyclerViewAdapter(Context context, List<Comic> items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_comic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitle.setText(mValues.get(position).title);
        holder.mSubtitle.setText(mValues.get(position).format);

        Picasso.with(mContext)
                .load(holder.mItem.thumbnail.getFullUrl())
                .placeholder(R.drawable.marvel_portrait_uncanny)
                .into(holder.mImage);

    }

    public List<Comic> getItems() {
        return mValues;
    }

    @Override
    public int getItemCount() {
        if (mValues == null) {
            return 0;
        }
        return mValues.size();
    }

    public void replaceItems(List<Comic> newItems){
        if (newItems == null) {
            return;
        }
        mValues = newItems;
        notifyItemInserted(newItems.size() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public final TextView mTitle;
        public final TextView mSubtitle;

        public final ImageView mImage;
        public Comic mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitle = (TextView) view.findViewById(R.id.cardview_comic_item_title);
            mSubtitle = (TextView) view.findViewById(R.id.cardview_comic_item_subtitle);
            mImage = (ImageView) view.findViewById(R.id.cardview_comic_item_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '";
        }

        @Override
        public void onClick(View view) {
            Timber timber = MarvelComicsApp.getInstance().getTimber();
            timber.d("TEST TEST TEST", "onClick " + getPosition() + " " + mItem);
        }

    }
}