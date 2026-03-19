package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.dhylive.app.utils.PreviewRecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ActivityPhotoPreviewBinding extends ViewDataBinding {
    public final LayoutToolbarBinding includeToolbar;
    public final PreviewRecyclerView rvPhotos;

    protected ActivityPhotoPreviewBinding(Object obj, View view, int i, LayoutToolbarBinding layoutToolbarBinding, PreviewRecyclerView previewRecyclerView) {
        super(obj, view, i);
        this.includeToolbar = layoutToolbarBinding;
        this.rvPhotos = previewRecyclerView;
    }

    public static ActivityPhotoPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPhotoPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityPhotoPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_photo_preview, viewGroup, z, obj);
    }

    public static ActivityPhotoPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPhotoPreviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityPhotoPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_photo_preview, null, false, obj);
    }

    public static ActivityPhotoPreviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPhotoPreviewBinding bind(View view, Object obj) {
        return (ActivityPhotoPreviewBinding) bind(obj, view, R.layout.activity_photo_preview);
    }
}
