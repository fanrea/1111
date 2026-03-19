package com.luck.picture.lib;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureSelectorSystemFragment extends PictureCommonFragment {
    public static final String TAG = "PictureSelectorSystemFragment";
    private ActivityResultLauncher<String> mContentLauncher;
    private ActivityResultLauncher<String> mContentsLauncher;
    private ActivityResultLauncher<String> mDocMultipleLauncher;
    private ActivityResultLauncher<String> mDocSingleLauncher;

    public static PictureSelectorSystemFragment newInstance() {
        return new PictureSelectorSystemFragment();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public String getFragmentTag() {
        return TAG;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int getResourceId() {
        return R.layout.ps_empty;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        createSystemContracts();
        if (PermissionChecker.isCheckReadStorage(this.selectorConfig.chooseMode, getContext())) {
            openSystemAlbum();
            return;
        }
        final String[] readPermissionArray = PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode);
        onPermissionExplainEvent(true, readPermissionArray);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(-2, readPermissionArray);
        } else {
            PermissionChecker.getInstance().requestPermissions(this, readPermissionArray, new PermissionResultCallback() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.1
                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onGranted() {
                    PictureSelectorSystemFragment.this.openSystemAlbum();
                }

                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onDenied() {
                    PictureSelectorSystemFragment.this.handlePermissionDenied(readPermissionArray);
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onApplyPermissionsEvent(int i, String[] strArr) {
        if (i == -2) {
            this.selectorConfig.onPermissionsEventListener.requestPermission(this, PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode), new OnRequestPermissionListener() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.2
                @Override // com.luck.picture.lib.interfaces.OnRequestPermissionListener
                public void onCall(String[] strArr2, boolean z) {
                    if (z) {
                        PictureSelectorSystemFragment.this.openSystemAlbum();
                    } else {
                        PictureSelectorSystemFragment.this.handlePermissionDenied(strArr2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSystemAlbum() {
        onPermissionExplainEvent(false, null);
        if (this.selectorConfig.selectionMode == 1) {
            if (this.selectorConfig.chooseMode == SelectMimeType.ofAll()) {
                this.mDocSingleLauncher.launch(SelectMimeType.SYSTEM_ALL);
                return;
            } else {
                this.mContentLauncher.launch(getInput());
                return;
            }
        }
        if (this.selectorConfig.chooseMode == SelectMimeType.ofAll()) {
            this.mDocMultipleLauncher.launch(SelectMimeType.SYSTEM_ALL);
        } else {
            this.mContentsLauncher.launch(getInput());
        }
    }

    private void createSystemContracts() {
        if (this.selectorConfig.selectionMode == 1) {
            if (this.selectorConfig.chooseMode == SelectMimeType.ofAll()) {
                createSingleDocuments();
                return;
            } else {
                createContent();
                return;
            }
        }
        if (this.selectorConfig.chooseMode == SelectMimeType.ofAll()) {
            createMultipleDocuments();
        } else {
            createMultipleContents();
        }
    }

    private void createMultipleDocuments() {
        this.mDocMultipleLauncher = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.3
            @Override // androidx.activity.result.contract.ActivityResultContract
            public List<Uri> parseResult(int i, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType(str);
                return intent;
            }
        }, new ActivityResultCallback<List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.4
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(List<Uri> list) {
                if (list == null || list.size() == 0) {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    LocalMedia localMediaBuildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(list.get(i).toString());
                    localMediaBuildLocalMedia.setPath(SdkVersionUtils.isQ() ? localMediaBuildLocalMedia.getPath() : localMediaBuildLocalMedia.getRealPath());
                    PictureSelectorSystemFragment.this.selectorConfig.addSelectResult(localMediaBuildLocalMedia);
                }
                PictureSelectorSystemFragment.this.dispatchTransformResult();
            }
        });
    }

    private void createSingleDocuments() {
        this.mDocSingleLauncher = registerForActivityResult(new ActivityResultContract<String, Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Uri parseResult(int i, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(str);
                return intent;
            }
        }, new ActivityResultCallback<Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.6
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(Uri uri) {
                if (uri != null) {
                    LocalMedia localMediaBuildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(uri.toString());
                    localMediaBuildLocalMedia.setPath(SdkVersionUtils.isQ() ? localMediaBuildLocalMedia.getPath() : localMediaBuildLocalMedia.getRealPath());
                    if (PictureSelectorSystemFragment.this.confirmSelect(localMediaBuildLocalMedia, false) == 0) {
                        PictureSelectorSystemFragment.this.dispatchTransformResult();
                        return;
                    } else {
                        PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                        return;
                    }
                }
                PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
            }
        });
    }

    private void createMultipleContents() {
        this.mContentsLauncher = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.7
            @Override // androidx.activity.result.contract.ActivityResultContract
            public List<Uri> parseResult(int i, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                Intent intent;
                if (TextUtils.equals(SelectMimeType.SYSTEM_VIDEO, str)) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                } else if (TextUtils.equals(SelectMimeType.SYSTEM_AUDIO, str)) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                } else {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                return intent;
            }
        }, new ActivityResultCallback<List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.8
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(List<Uri> list) {
                if (list == null || list.size() == 0) {
                    PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    LocalMedia localMediaBuildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(list.get(i).toString());
                    localMediaBuildLocalMedia.setPath(SdkVersionUtils.isQ() ? localMediaBuildLocalMedia.getPath() : localMediaBuildLocalMedia.getRealPath());
                    PictureSelectorSystemFragment.this.selectorConfig.addSelectResult(localMediaBuildLocalMedia);
                }
                PictureSelectorSystemFragment.this.dispatchTransformResult();
            }
        });
    }

    private void createContent() {
        this.mContentLauncher = registerForActivityResult(new ActivityResultContract<String, Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Uri parseResult(int i, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                if (TextUtils.equals(SelectMimeType.SYSTEM_VIDEO, str)) {
                    return new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                }
                if (TextUtils.equals(SelectMimeType.SYSTEM_AUDIO, str)) {
                    return new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                }
                return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }
        }, new ActivityResultCallback<Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.10
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(Uri uri) {
                if (uri != null) {
                    LocalMedia localMediaBuildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(uri.toString());
                    localMediaBuildLocalMedia.setPath(SdkVersionUtils.isQ() ? localMediaBuildLocalMedia.getPath() : localMediaBuildLocalMedia.getRealPath());
                    if (PictureSelectorSystemFragment.this.confirmSelect(localMediaBuildLocalMedia, false) == 0) {
                        PictureSelectorSystemFragment.this.dispatchTransformResult();
                        return;
                    } else {
                        PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                        return;
                    }
                }
                PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
            }
        });
    }

    private String getInput() {
        return this.selectorConfig.chooseMode == SelectMimeType.ofVideo() ? SelectMimeType.SYSTEM_VIDEO : this.selectorConfig.chooseMode == SelectMimeType.ofAudio() ? SelectMimeType.SYSTEM_AUDIO : SelectMimeType.SYSTEM_IMAGE;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void handlePermissionSettingResult(String[] strArr) {
        boolean zIsCheckReadStorage;
        onPermissionExplainEvent(false, null);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            zIsCheckReadStorage = this.selectorConfig.onPermissionsEventListener.hasPermissions(this, strArr);
        } else {
            zIsCheckReadStorage = PermissionChecker.isCheckReadStorage(this.selectorConfig.chooseMode, getContext());
        }
        if (zIsCheckReadStorage) {
            openSystemAlbum();
        } else {
            ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
            onKeyBackFragmentFinish();
        }
        PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            onKeyBackFragmentFinish();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ActivityResultLauncher<String> activityResultLauncher = this.mDocMultipleLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        ActivityResultLauncher<String> activityResultLauncher2 = this.mDocSingleLauncher;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.unregister();
        }
        ActivityResultLauncher<String> activityResultLauncher3 = this.mContentsLauncher;
        if (activityResultLauncher3 != null) {
            activityResultLauncher3.unregister();
        }
        ActivityResultLauncher<String> activityResultLauncher4 = this.mContentLauncher;
        if (activityResultLauncher4 != null) {
            activityResultLauncher4.unregister();
        }
    }
}
