package com.bytedance.sdk.djx.core.business.view.rv2.base;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.net.img.RequestCreator;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    private ItemView mDelegate;
    private final SparseArray<View> mViews;

    public CommonViewHolder(View view) {
        super(view);
        this.mViews = new SparseArray<>();
    }

    public void bind(ItemView itemView, int i, List<Object> list) {
        if (itemView == null) {
            return;
        }
        this.mDelegate = itemView;
        if (list == null || list.isEmpty()) {
            itemView.bind(this);
        } else {
            itemView.bind(this, list);
        }
    }

    public void unbind() {
        ItemView itemView = this.mDelegate;
        if (itemView == null) {
            return;
        }
        itemView.unbind(this);
    }

    public <T extends View> T getView(int i) {
        T t = (T) this.mViews.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.mViews.put(i, t2);
        return t2;
    }

    public CommonViewHolder setText(int i, String str) {
        ((TextView) getView(i)).setText(str);
        return this;
    }

    public CommonViewHolder setText(int i, int i2) {
        ((TextView) getView(i)).setText(i2);
        return this;
    }

    public CommonViewHolder setTextSize(int i, float f) {
        ((TextView) getView(i)).setTextSize(f);
        return this;
    }

    public CommonViewHolder setTextColor(int i, int i2) {
        ((TextView) getView(i)).setTextColor(i2);
        return this;
    }

    public CommonViewHolder setTextColorRes(int i, int i2) {
        ((TextView) getView(i)).setTextColor(this.itemView.getContext().getResources().getColor(i2));
        return this;
    }

    public CommonViewHolder setImageUrl(int i, String str) {
        setImageUrl(i, str, 0, 0);
        return this;
    }

    public CommonViewHolder setImageUrl(int i, String str, int i2, int i3) {
        ImageView imageView = (ImageView) getView(i);
        RequestCreator requestCreatorCenterCrop = Picasso.with(this.itemView.getContext()).load(str).tag(ImageTag.TAG_DRAW_VIDEO).config(Bitmap.Config.RGB_565).placeholder(R.drawable.djx_grid_item_bg).centerCrop();
        if (i2 > 0 && i3 > 0) {
            requestCreatorCenterCrop.resize(i2, i3);
        } else {
            requestCreatorCenterCrop.fit();
        }
        requestCreatorCenterCrop.into(imageView);
        return this;
    }

    public CommonViewHolder setImageResource(int i, int i2) {
        ((ImageView) getView(i)).setImageResource(i2);
        return this;
    }

    public CommonViewHolder setImageBitmap(int i, Bitmap bitmap) {
        ((ImageView) getView(i)).setImageBitmap(bitmap);
        return this;
    }

    public CommonViewHolder setImageDrawable(int i, Drawable drawable) {
        ((ImageView) getView(i)).setImageDrawable(drawable);
        return this;
    }

    public CommonViewHolder setBackgroundColor(int i, int i2) {
        getView(i).setBackgroundColor(i2);
        return this;
    }

    public CommonViewHolder setBackgroundRes(int i, int i2) {
        getView(i).setBackgroundResource(i2);
        return this;
    }

    public CommonViewHolder setAlpha(int i, float f) {
        getView(i).setAlpha(f);
        return this;
    }

    public CommonViewHolder setVisible(int i, boolean z) {
        getView(i).setVisibility(z ? 0 : 8);
        return this;
    }

    public CommonViewHolder setTypeface(Typeface typeface, int... iArr) {
        for (int i : iArr) {
            TextView textView = (TextView) getView(i);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public CommonViewHolder setTag(int i, Object obj) {
        getView(i).setTag(obj);
        return this;
    }

    public Object getTag(int i) {
        return getView(i).getTag();
    }

    public CommonViewHolder setTag(int i, int i2, Object obj) {
        getView(i).setTag(i2, obj);
        return this;
    }

    public CommonViewHolder setOnClickListener(int i, View.OnClickListener onClickListener) {
        getView(i).setOnClickListener(onClickListener);
        return this;
    }

    public CommonViewHolder setOnTouchListener(int i, View.OnTouchListener onTouchListener) {
        getView(i).setOnTouchListener(onTouchListener);
        return this;
    }

    public CommonViewHolder setOnLongClickListener(int i, View.OnLongClickListener onLongClickListener) {
        getView(i).setOnLongClickListener(onLongClickListener);
        return this;
    }
}
