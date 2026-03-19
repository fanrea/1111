package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PictureSelector {
    private final SoftReference<Activity> mActivity;
    private final SoftReference<Fragment> mFragment;

    private PictureSelector(Activity activity) {
        this(activity, null);
    }

    private PictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    private PictureSelector(Activity activity, Fragment fragment) {
        this.mActivity = new SoftReference<>(activity);
        this.mFragment = new SoftReference<>(fragment);
    }

    public static PictureSelector create(Context context) {
        return new PictureSelector((Activity) context);
    }

    public static PictureSelector create(AppCompatActivity appCompatActivity) {
        return new PictureSelector(appCompatActivity);
    }

    public static PictureSelector create(FragmentActivity fragmentActivity) {
        return new PictureSelector(fragmentActivity);
    }

    public static PictureSelector create(Fragment fragment) {
        return new PictureSelector(fragment);
    }

    public PictureSelectionModel openGallery(int i) {
        return new PictureSelectionModel(this, i);
    }

    public PictureSelectionCameraModel openCamera(int i) {
        return new PictureSelectionCameraModel(this, i);
    }

    public PictureSelectionSystemModel openSystemGallery(int i) {
        return new PictureSelectionSystemModel(this, i);
    }

    public PictureSelectionQueryModel dataSource(int i) {
        return new PictureSelectionQueryModel(this, i);
    }

    public PictureSelectionPreviewModel openPreview() {
        return new PictureSelectionPreviewModel(this);
    }

    public static Intent putIntentResult(ArrayList<LocalMedia> arrayList) {
        return new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, arrayList);
    }

    public static ArrayList<LocalMedia> obtainSelectorList(Intent intent) {
        if (intent == null) {
            return new ArrayList<>();
        }
        ArrayList<LocalMedia> parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION);
        return parcelableArrayListExtra != null ? parcelableArrayListExtra : new ArrayList<>();
    }

    Activity getActivity() {
        return this.mActivity.get();
    }

    Fragment getFragment() {
        SoftReference<Fragment> softReference = this.mFragment;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }
}
