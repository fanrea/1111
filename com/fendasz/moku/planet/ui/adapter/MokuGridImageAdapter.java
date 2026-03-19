package com.fendasz.moku.planet.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.utils.ImageUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuGridImageAdapter extends BaseAdapter {
    private static final String TAG = "MokuGridImageAdapter==>";
    private Context context;
    private int itemWidth;
    private LayoutInflater mInflater;
    private List<String> urlList;
    private ImageUtils imageUtils = ImageUtils.getInstance();
    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -1);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MokuGridImageAdapter(Context context, List<String> list, int i) {
        this.urlList = list;
        this.context = context;
        this.itemWidth = i;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.urlList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.urlList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.moku_grid_image, (ViewGroup) null);
            view.setLayoutParams(this.params);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv_moku_image);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Context context = this.context;
            if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                Log.d(TAG, "context is activity and is not destroyed");
                this.imageUtils.setImageView(viewHolder.imageView.getContext(), this.urlList.get(i), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.adapter.MokuGridImageAdapter.1
                    @Override // com.fendasz.moku.planet.interf.functions.Consumer
                    public void accept(Bitmap bitmap) throws Exception {
                        viewHolder.imageView.setImageBitmap(bitmap);
                    }
                }, Float.valueOf(this.itemWidth), null);
            }
        }
        return view;
    }

    static class ViewHolder {
        ImageView imageView;

        ViewHolder() {
        }
    }
}
