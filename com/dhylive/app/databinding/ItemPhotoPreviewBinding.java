package com.dhylive.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ItemPhotoPreviewBinding extends ViewDataBinding {
    public final PhotoView ivPhotoView;

    protected ItemPhotoPreviewBinding(Object obj, View view, int i, PhotoView photoView) {
        super(obj, view, i);
        this.ivPhotoView = photoView;
    }

    public static ItemPhotoPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPhotoPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_photo_preview, viewGroup, z, obj);
    }

    public static ItemPhotoPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoPreviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPhotoPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_photo_preview, null, false, obj);
    }

    public static ItemPhotoPreviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPhotoPreviewBinding bind(View view, Object obj) {
        return (ItemPhotoPreviewBinding) bind(obj, view, R.layout.item_photo_preview);
    }
}
