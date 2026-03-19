package com.fendasz.moku.planet.ui.base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;

    public RecyclerViewHolder(Context context, View view) {
        super(view);
        this.mViews = new SparseArray<>();
    }

    public <T extends View> T findViewById(int i) {
        T t = (T) this.mViews.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.mViews.put(i, t2);
        return t2;
    }

    public View getView(int i) {
        return findViewById(i);
    }

    public TextView getTextView(int i) {
        return (TextView) getView(i);
    }

    public Button getButton(int i) {
        return (Button) getView(i);
    }

    public ImageView getImageView(int i) {
        return (ImageView) getView(i);
    }

    public ImageButton getImageButton(int i) {
        return (ImageButton) getView(i);
    }

    public EditText getEditText(int i) {
        return (EditText) getView(i);
    }

    public RecyclerViewHolder setText(int i, String str) {
        ((TextView) findViewById(i)).setText(str);
        return this;
    }

    public RecyclerViewHolder setBackground(int i, int i2) {
        findViewById(i).setBackgroundResource(i2);
        return this;
    }

    public RecyclerViewHolder setClickListener(int i, View.OnClickListener onClickListener) {
        findViewById(i).setOnClickListener(onClickListener);
        return this;
    }
}
