package com.fendasz.moku.planet.ui.adapter;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.utils.ImageUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FloatImageAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "FloatImageAdapter=>";
    private ImageUtils imageUtils = ImageUtils.getInstance();
    private Float requWidth;
    private List<String> urlList;

    public FloatImageAdapter(List<String> list) {
        this.urlList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = View.inflate(viewGroup.getContext(), R.layout.moku_grid_image, null);
        viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return new ViewHolder(viewInflate);
    }

    public void setRequWidth(Float f) {
        this.requWidth = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        this.imageUtils.setImageView(viewHolder.imageView.getContext(), this.urlList.get(i), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.adapter.FloatImageAdapter.1
            @Override // com.fendasz.moku.planet.interf.functions.Consumer
            public void accept(Bitmap bitmap) throws Exception {
                viewHolder.imageView.setImageBitmap(bitmap);
                Log.d(FloatImageAdapter.TAG, "image bitmap height=>" + bitmap.getHeight());
            }
        }, this.requWidth, null);
        viewHolder.itemView.setTag(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.urlList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.iv_moku_image);
        }
    }
}
