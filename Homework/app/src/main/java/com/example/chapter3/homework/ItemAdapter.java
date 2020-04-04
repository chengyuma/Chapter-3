package com.example.chapter3.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 适配器
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.NumberViewHolder> {

    private static final String TAG = "ItemAdapter";
    private int mNumberItems = 7;

    private static int viewHolderCount;
    Context context;

    public ItemAdapter(Context context) {
        this.context = context;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.fragment_item_detail;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        int num = viewHolderCount + 1;
        viewHolder.textview.setText("Item " + num);

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    //    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public class NumberViewHolder extends RecyclerView.ViewHolder {

        private final TextView textview;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.textview);
        }

        public void bind(int position) {
            ;
        }
    }
}
