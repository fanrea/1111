package com.bytedance.sdk.djx.core.business.view.rv.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.model.SourceMode;
import com.bytedance.sdk.djx.model.ev.BEHomeFirstFrame;
import com.bytedance.sdk.djx.model.ev.BEHomeLoadFrame;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.img.Callback;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestCreator;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final Context mContext;
    private final View mConvertView;
    private final SparseArray<View> mViews;

    public void onItemClick(int i, Object obj) {
    }

    public boolean onItemLongClick(int i, Object obj) {
        return false;
    }

    public BaseViewHolder(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mConvertView = view;
        this.mViews = new SparseArray<>();
    }

    public static BaseViewHolder createViewHolder(Context context, View view) {
        return new BaseViewHolder(context, view);
    }

    public static BaseViewHolder createViewHolder(Context context, ViewGroup viewGroup, int i) {
        return new BaseViewHolder(context, LayoutInflater.from(context).inflate(i, viewGroup, false));
    }

    public <T extends View> T getView(int i) {
        T t = (T) this.mViews.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.mConvertView.findViewById(i);
        this.mViews.put(i, t2);
        return t2;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public BaseViewHolder setText(int i, CharSequence charSequence) {
        ((TextView) getView(i)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setText(int i, int i2) {
        ((TextView) getView(i)).setText(i2);
        return this;
    }

    public BaseViewHolder setTextSize(int i, float f) {
        ((TextView) getView(i)).setTextSize(f);
        return this;
    }

    public BaseViewHolder setTextColor(int i, int i2) {
        ((TextView) getView(i)).setTextColor(i2);
        return this;
    }

    public BaseViewHolder setTextColorRes(int i, int i2) {
        ((TextView) getView(i)).setTextColor(this.mContext.getResources().getColor(i2));
        return this;
    }

    public BaseViewHolder setImageUrl(int i, String str) {
        Picasso.with(this.mContext).load(str).config(Bitmap.Config.ARGB_8888).placeholder(R.drawable.djx_grid_item_bg).fit().into((ImageView) getView(i));
        return this;
    }

    public BaseViewHolder setImageUrl(int i, String str, int i2, int i3) {
        return setImageUrl(i, str, i2, i3, R.drawable.djx_grid_item_bg);
    }

    public BaseViewHolder setImageUrl(int i, String str, int i2, int i3, int i4) {
        ImageView imageView = (ImageView) getView(i);
        RequestCreator requestCreatorCenterCrop = Picasso.with(this.mContext).load(str).tag(ImageTag.TAG_DRAW_VIDEO).config(Bitmap.Config.RGB_565).placeholder(i4).centerCrop();
        if (i2 > 0 && i3 > 0) {
            requestCreatorCenterCrop.resize(i2, i3);
        } else {
            requestCreatorCenterCrop.fit();
        }
        requestCreatorCenterCrop.into(imageView);
        return this;
    }

    public BaseViewHolder setImageUrl(int i, String str, int i2, int i3, int i4, final int i5, final SourceMode sourceMode) {
        ImageView imageView = (ImageView) getView(i);
        new BEHomeLoadFrame(i5, sourceMode).send();
        RequestCreator requestCreatorCenterCrop = Picasso.with(this.mContext).load(str).tag(ImageTag.TAG_DRAW_VIDEO).config(Bitmap.Config.RGB_565).placeholder(i4).centerCrop();
        if (i2 > 0 && i3 > 0) {
            requestCreatorCenterCrop.resize(i2, i3);
        } else {
            requestCreatorCenterCrop.fit();
        }
        requestCreatorCenterCrop.into(imageView, new Callback() { // from class: com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder.1
            @Override // com.bytedance.sdk.djx.net.img.Callback
            public void onError() {
            }

            @Override // com.bytedance.sdk.djx.net.img.Callback
            public void onSuccess() {
                new BEHomeFirstFrame(i5, sourceMode).send();
            }
        });
        return this;
    }

    public BaseViewHolder setImageResource(int i, int i2) {
        ((ImageView) getView(i)).setImageResource(i2);
        return this;
    }

    public BaseViewHolder setImageBitmap(int i, Bitmap bitmap) {
        ((ImageView) getView(i)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int i, Drawable drawable) {
        ((ImageView) getView(i)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setBackgroundColor(int i, int i2) {
        getView(i).setBackgroundColor(i2);
        return this;
    }

    public BaseViewHolder setBackgroundRes(int i, int i2) {
        getView(i).setBackgroundResource(i2);
        return this;
    }

    public BaseViewHolder setAlpha(int i, float f) {
        getView(i).setAlpha(f);
        return this;
    }

    public BaseViewHolder setVisible(int i, boolean z) {
        getView(i).setVisibility(z ? 0 : 8);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface typeface, int... iArr) {
        for (int i : iArr) {
            TextView textView = (TextView) getView(i);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public BaseViewHolder setTag(int i, Object obj) {
        getView(i).setTag(obj);
        return this;
    }

    public BaseViewHolder setTag(int i, int i2, Object obj) {
        getView(i).setTag(i2, obj);
        return this;
    }

    public BaseViewHolder setOnClickListener(int i, View.OnClickListener onClickListener) {
        getView(i).setOnClickListener(onClickListener);
        return this;
    }

    public BaseViewHolder setOnTouchListener(int i, View.OnTouchListener onTouchListener) {
        getView(i).setOnTouchListener(onTouchListener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int i, View.OnLongClickListener onLongClickListener) {
        getView(i).setOnLongClickListener(onLongClickListener);
        return this;
    }
}
