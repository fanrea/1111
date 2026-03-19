package com.luck.picture.lib.basic;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobstat.forbes.Config;
import com.luck.picture.lib.R;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.CustomIntentKey;
import com.luck.picture.lib.config.PermissionEvent;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.dialog.RemindDialog;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.interfaces.OnCallbackIndexListener;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnItemClickListener;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.permissions.PermissionUtil;
import com.luck.picture.lib.service.ForegroundService;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.BitmapUtils;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.FileDirMap;
import com.luck.picture.lib.utils.MediaStoreUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SpUtils;
import com.luck.picture.lib.utils.ToastUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class PictureCommonFragment extends Fragment implements IPictureSelectorCommonEvent {
    public static final String TAG = "PictureCommonFragment";
    private Context context;
    private long enterAnimDuration;
    protected IBridgePictureBehavior iBridgePictureBehavior;
    protected IBridgeMediaLoader mLoader;
    private Dialog mLoadingDialog;
    protected int mPage = 1;
    private PermissionResultCallback mPermissionResultCallback;
    protected SelectorConfig selectorConfig;
    private int soundID;
    private SoundPool soundPool;
    protected Dialog tipsDialog;

    public void dispatchCameraMediaResult(LocalMedia localMedia) {
    }

    public int getResourceId() {
        return 0;
    }

    public void handlePermissionSettingResult(String[] strArr) {
    }

    public void onCheckOriginalChange() {
    }

    public void onCreateLoader() {
    }

    public void onEditMedia(Intent intent) {
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onEnterFragment() {
    }

    public void onExitFragment() {
    }

    public void onFixedSelectedChange(LocalMedia localMedia) {
    }

    public void onFragmentResume() {
    }

    public void onSelectedChange(boolean z, LocalMedia localMedia) {
    }

    public void reStartSavedInstance(Bundle bundle) {
    }

    public void sendChangeSubSelectPositionEvent(boolean z) {
    }

    public String getFragmentTag() {
        return TAG;
    }

    protected Context getAppContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        Context appContext = PictureAppMaster.getInstance().getAppContext();
        return appContext != null ? appContext : this.context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.mPermissionResultCallback != null) {
            PermissionChecker.getInstance().onRequestPermissionsResult(iArr, this.mPermissionResultCallback);
            this.mPermissionResultCallback = null;
        }
    }

    public void setPermissionsResultAction(PermissionResultCallback permissionResultCallback) {
        this.mPermissionResultCallback = permissionResultCallback;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void handlePermissionDenied(String[] strArr) {
        PermissionConfig.CURRENT_REQUEST_PERMISSION = strArr;
        if (strArr != null && strArr.length > 0) {
            SpUtils.putBoolean(getAppContext(), strArr[0], true);
        }
        if (this.selectorConfig.onPermissionDeniedListener != null) {
            onPermissionExplainEvent(false, null);
            this.selectorConfig.onPermissionDeniedListener.onDenied(this, strArr, 1102, new OnCallbackListener<Boolean>() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.1
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(Boolean bool) {
                    if (bool.booleanValue()) {
                        PictureCommonFragment.this.handlePermissionSettingResult(PermissionConfig.CURRENT_REQUEST_PERMISSION);
                    }
                }
            });
        } else {
            PermissionUtil.goIntentSetting(this, 1102);
        }
    }

    protected boolean isNormalDefaultEnter() {
        return (getActivity() instanceof PictureSelectorSupporterActivity) || (getActivity() instanceof PictureSelectorTransparentActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getResourceId() != 0) {
            return layoutInflater.inflate(getResourceId(), viewGroup, false);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        FileDirMap.init(view.getContext());
        if (this.selectorConfig.viewLifecycle != null) {
            this.selectorConfig.viewLifecycle.onViewCreated(this, view, bundle);
        }
        if (this.selectorConfig.onCustomLoadingListener != null) {
            this.mLoadingDialog = this.selectorConfig.onCustomLoadingListener.create(getAppContext());
        } else {
            this.mLoadingDialog = new PictureLoadingDialog(getAppContext());
        }
        setRequestedOrientation();
        setTranslucentStatusBar();
        setRootViewKeyListener(requireView());
        if (!this.selectorConfig.isOpenClickSound || this.selectorConfig.isOnlyCamera) {
            return;
        }
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.soundPool = soundPool;
        this.soundID = soundPool.load(getAppContext(), R.raw.ps_click_music, 1);
    }

    private void setTranslucentStatusBar() {
        if (this.selectorConfig.isPreviewFullScreenMode) {
            ImmersiveManager.translucentStatusBar(requireActivity(), this.selectorConfig.selectorStyle.getSelectMainStyle().isDarkStatusBarBlack());
        }
    }

    public void setRootViewKeyListener(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                PictureCommonFragment.this.onKeyBackFragmentFinish();
                return true;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        initAppLanguage();
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        PictureWindowAnimationStyle windowAnimationStyle = this.selectorConfig.selectorStyle.getWindowAnimationStyle();
        if (z) {
            if (windowAnimationStyle.activityEnterAnimation != 0) {
                animationLoadAnimation = AnimationUtils.loadAnimation(getAppContext(), windowAnimationStyle.activityEnterAnimation);
            } else {
                animationLoadAnimation = AnimationUtils.loadAnimation(getAppContext(), R.anim.ps_anim_alpha_enter);
            }
            setEnterAnimationDuration(animationLoadAnimation.getDuration());
            onEnterFragment();
        } else {
            if (windowAnimationStyle.activityExitAnimation != 0) {
                animationLoadAnimation = AnimationUtils.loadAnimation(getAppContext(), windowAnimationStyle.activityExitAnimation);
            } else {
                animationLoadAnimation = AnimationUtils.loadAnimation(getAppContext(), R.anim.ps_anim_alpha_exit);
            }
            onExitFragment();
        }
        return animationLoadAnimation;
    }

    public void setEnterAnimationDuration(long j) {
        this.enterAnimDuration = j;
    }

    public long getEnterAnimationDuration() {
        long j = this.enterAnimDuration;
        if (j > 50) {
            j -= 50;
        }
        if (j >= 0) {
            return j;
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int confirmSelect(LocalMedia localMedia, boolean z) {
        int i = 0;
        if (this.selectorConfig.onSelectFilterListener != null && this.selectorConfig.onSelectFilterListener.onSelectFilter(localMedia)) {
            if (!(this.selectorConfig.onSelectLimitTipsListener != null ? this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 13) : false)) {
                ToastUtils.showToast(getAppContext(), getString(R.string.ps_select_no_support));
            }
            return -1;
        }
        if (isCheckSelectValidity(localMedia, z) != 200) {
            return -1;
        }
        ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
        if (z) {
            selectedResult.remove(localMedia);
            i = 1;
        } else {
            if (this.selectorConfig.selectionMode == 1 && selectedResult.size() > 0) {
                sendFixedSelectedChangeEvent(selectedResult.get(0));
                selectedResult.clear();
            }
            selectedResult.add(localMedia);
            localMedia.setNum(selectedResult.size());
            playClickEffect();
        }
        sendSelectedChangeEvent(i ^ 1, localMedia);
        return i;
    }

    protected int isCheckSelectValidity(LocalMedia localMedia, boolean z) {
        String mimeType = localMedia.getMimeType();
        long duration = localMedia.getDuration();
        long size = localMedia.getSize();
        ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
        if (!this.selectorConfig.isWithVideoImage) {
            return checkOnlyMimeTypeValidity(localMedia, z, mimeType, this.selectorConfig.getResultFirstMimeType(), size, duration) ? -1 : 200;
        }
        int i = 0;
        for (int i2 = 0; i2 < selectedResult.size(); i2++) {
            if (PictureMimeType.isHasVideo(selectedResult.get(i2).getMimeType())) {
                i++;
            }
        }
        return checkWithMimeTypeValidity(localMedia, z, mimeType, i, size, duration) ? -1 : 200;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkWithMimeTypeValidity(LocalMedia localMedia, boolean z, String str, int i, long j, long j2) {
        if (this.selectorConfig.selectMaxFileSize > 0 && j > this.selectorConfig.selectMaxFileSize) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 1)) {
                return true;
            }
            showTipsDialog(getString(R.string.ps_select_max_size, PictureFileUtils.formatFileSize(this.selectorConfig.selectMaxFileSize)));
            return true;
        }
        if (this.selectorConfig.selectMinFileSize > 0 && j < this.selectorConfig.selectMinFileSize) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 2)) {
                return true;
            }
            showTipsDialog(getString(R.string.ps_select_min_size, PictureFileUtils.formatFileSize(this.selectorConfig.selectMinFileSize)));
            return true;
        }
        if (PictureMimeType.isHasVideo(str)) {
            if (this.selectorConfig.selectionMode == 2) {
                if (this.selectorConfig.maxVideoSelectNum <= 0) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 3)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_rule));
                    return true;
                }
                if (!z && this.selectorConfig.getSelectedResult().size() >= this.selectorConfig.maxSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_message_max_num, Integer.valueOf(this.selectorConfig.maxSelectNum)));
                    return true;
                }
                if (!z && i >= this.selectorConfig.maxVideoSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 6)) {
                        return true;
                    }
                    showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxVideoSelectNum));
                    return true;
                }
            }
            if (!z && this.selectorConfig.selectMinDurationSecond > 0 && DateUtils.millisecondToSecond(j2) < this.selectorConfig.selectMinDurationSecond) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 9)) {
                    return true;
                }
                showTipsDialog(getString(R.string.ps_select_video_min_second, Integer.valueOf(this.selectorConfig.selectMinDurationSecond / 1000)));
                return true;
            }
            if (!z && this.selectorConfig.selectMaxDurationSecond > 0 && DateUtils.millisecondToSecond(j2) > this.selectorConfig.selectMaxDurationSecond) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 8)) {
                    return true;
                }
                showTipsDialog(getString(R.string.ps_select_video_max_second, Integer.valueOf(this.selectorConfig.selectMaxDurationSecond / 1000)));
                return true;
            }
        } else if (this.selectorConfig.selectionMode == 2 && !z && this.selectorConfig.getSelectedResult().size() >= this.selectorConfig.maxSelectNum) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                return true;
            }
            showTipsDialog(getString(R.string.ps_message_max_num, Integer.valueOf(this.selectorConfig.maxSelectNum)));
            return true;
        }
        return false;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkOnlyMimeTypeValidity(LocalMedia localMedia, boolean z, String str, String str2, long j, long j2) {
        if (!PictureMimeType.isMimeTypeSame(str2, str)) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 3)) {
                return true;
            }
            showTipsDialog(getString(R.string.ps_rule));
            return true;
        }
        if (this.selectorConfig.selectMaxFileSize > 0 && j > this.selectorConfig.selectMaxFileSize) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 1)) {
                return true;
            }
            showTipsDialog(getString(R.string.ps_select_max_size, PictureFileUtils.formatFileSize(this.selectorConfig.selectMaxFileSize)));
            return true;
        }
        if (this.selectorConfig.selectMinFileSize > 0 && j < this.selectorConfig.selectMinFileSize) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 2)) {
                return true;
            }
            showTipsDialog(getString(R.string.ps_select_min_size, PictureFileUtils.formatFileSize(this.selectorConfig.selectMinFileSize)));
            return true;
        }
        if (PictureMimeType.isHasVideo(str)) {
            if (this.selectorConfig.selectionMode == 2) {
                SelectorConfig selectorConfig = this.selectorConfig;
                selectorConfig.maxVideoSelectNum = selectorConfig.maxVideoSelectNum > 0 ? this.selectorConfig.maxVideoSelectNum : this.selectorConfig.maxSelectNum;
                if (!z && this.selectorConfig.getSelectCount() >= this.selectorConfig.maxVideoSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 6)) {
                        return true;
                    }
                    showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxVideoSelectNum));
                    return true;
                }
            }
            if (!z && this.selectorConfig.selectMinDurationSecond > 0 && DateUtils.millisecondToSecond(j2) < this.selectorConfig.selectMinDurationSecond) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 9)) {
                    return true;
                }
                showTipsDialog(getString(R.string.ps_select_video_min_second, Integer.valueOf(this.selectorConfig.selectMinDurationSecond / 1000)));
                return true;
            }
            if (!z && this.selectorConfig.selectMaxDurationSecond > 0 && DateUtils.millisecondToSecond(j2) > this.selectorConfig.selectMaxDurationSecond) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 8)) {
                    return true;
                }
                showTipsDialog(getString(R.string.ps_select_video_max_second, Integer.valueOf(this.selectorConfig.selectMaxDurationSecond / 1000)));
                return true;
            }
        } else if (PictureMimeType.isHasAudio(str)) {
            if (this.selectorConfig.selectionMode == 2 && !z && this.selectorConfig.getSelectedResult().size() >= this.selectorConfig.maxSelectNum) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                    return true;
                }
                showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxSelectNum));
                return true;
            }
            if (!z && this.selectorConfig.selectMinDurationSecond > 0 && DateUtils.millisecondToSecond(j2) < this.selectorConfig.selectMinDurationSecond) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 11)) {
                    return true;
                }
                showTipsDialog(getString(R.string.ps_select_audio_min_second, Integer.valueOf(this.selectorConfig.selectMinDurationSecond / 1000)));
                return true;
            }
            if (!z && this.selectorConfig.selectMaxDurationSecond > 0 && DateUtils.millisecondToSecond(j2) > this.selectorConfig.selectMaxDurationSecond) {
                if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 10)) {
                    return true;
                }
                showTipsDialog(getString(R.string.ps_select_audio_max_second, Integer.valueOf(this.selectorConfig.selectMaxDurationSecond / 1000)));
                return true;
            }
        } else if (this.selectorConfig.selectionMode == 2 && !z && this.selectorConfig.getSelectedResult().size() >= this.selectorConfig.maxSelectNum) {
            if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), localMedia, this.selectorConfig, 4)) {
                return true;
            }
            showTipsDialog(getTipsMsg(getAppContext(), str, this.selectorConfig.maxSelectNum));
            return true;
        }
        return false;
    }

    private void showTipsDialog(String str) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        try {
            Dialog dialog = this.tipsDialog;
            if (dialog == null || !dialog.isShowing()) {
                RemindDialog remindDialogBuildDialog = RemindDialog.buildDialog(getAppContext(), str);
                this.tipsDialog = remindDialogBuildDialog;
                remindDialogBuildDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTipsMsg(Context context, String str, int i) {
        return PictureMimeType.isHasVideo(str) ? context.getString(R.string.ps_message_video_max_num, String.valueOf(i)) : PictureMimeType.isHasAudio(str) ? context.getString(R.string.ps_message_audio_max_num, String.valueOf(i)) : context.getString(R.string.ps_message_max_num, String.valueOf(i));
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void sendSelectedChangeEvent(boolean z, LocalMedia localMedia) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (fragment instanceof PictureCommonFragment) {
                ((PictureCommonFragment) fragment).onSelectedChange(z, localMedia);
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void sendFixedSelectedChangeEvent(LocalMedia localMedia) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (fragment instanceof PictureCommonFragment) {
                ((PictureCommonFragment) fragment).onFixedSelectedChange(localMedia);
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void sendSelectedOriginalChangeEvent() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (fragment instanceof PictureCommonFragment) {
                ((PictureCommonFragment) fragment).onCheckOriginalChange();
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void openSelectedCamera() {
        int i = this.selectorConfig.chooseMode;
        if (i == 0) {
            if (this.selectorConfig.ofAllCameraType == SelectMimeType.ofImage()) {
                openImageCamera();
                return;
            } else if (this.selectorConfig.ofAllCameraType == SelectMimeType.ofVideo()) {
                openVideoCamera();
                return;
            } else {
                onSelectedOnlyCamera();
                return;
            }
        }
        if (i == 1) {
            openImageCamera();
        } else if (i == 2) {
            openVideoCamera();
        } else {
            if (i != 3) {
                return;
            }
            openSoundRecording();
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onSelectedOnlyCamera() {
        PhotoItemSelectedDialog photoItemSelectedDialogNewInstance = PhotoItemSelectedDialog.newInstance();
        photoItemSelectedDialogNewInstance.setOnItemClickListener(new OnItemClickListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.3
            @Override // com.luck.picture.lib.interfaces.OnItemClickListener
            public void onItemClick(View view, int i) {
                if (i == 0) {
                    if (PictureCommonFragment.this.selectorConfig.onCameraInterceptListener != null) {
                        PictureCommonFragment.this.onInterceptCameraEvent(1);
                        return;
                    } else {
                        PictureCommonFragment.this.openImageCamera();
                        return;
                    }
                }
                if (i != 1) {
                    return;
                }
                if (PictureCommonFragment.this.selectorConfig.onCameraInterceptListener != null) {
                    PictureCommonFragment.this.onInterceptCameraEvent(2);
                } else {
                    PictureCommonFragment.this.openVideoCamera();
                }
            }
        });
        photoItemSelectedDialogNewInstance.setOnDismissListener(new PhotoItemSelectedDialog.OnDismissListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.4
            @Override // com.luck.picture.lib.dialog.PhotoItemSelectedDialog.OnDismissListener
            public void onDismiss(boolean z, DialogInterface dialogInterface) {
                if (PictureCommonFragment.this.selectorConfig.isOnlyCamera && z) {
                    PictureCommonFragment.this.onKeyBackFragmentFinish();
                }
            }
        });
        photoItemSelectedDialogNewInstance.show(getChildFragmentManager(), "PhotoItemSelectedDialog");
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void openImageCamera() {
        onPermissionExplainEvent(true, PermissionConfig.CAMERA);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(PermissionEvent.EVENT_IMAGE_CAMERA, PermissionConfig.CAMERA);
        } else {
            PermissionChecker.getInstance().requestPermissions(this, PermissionConfig.CAMERA, new PermissionResultCallback() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.5
                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onGranted() {
                    PictureCommonFragment.this.startCameraImageCapture();
                }

                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onDenied() {
                    PictureCommonFragment.this.handlePermissionDenied(PermissionConfig.CAMERA);
                }
            });
        }
    }

    protected void startCameraImageCapture() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        onPermissionExplainEvent(false, null);
        if (this.selectorConfig.onCameraInterceptListener != null) {
            onInterceptCameraEvent(1);
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
            Uri uriCreateCameraOutImageUri = MediaStoreUtils.createCameraOutImageUri(getAppContext(), this.selectorConfig);
            if (uriCreateCameraOutImageUri != null) {
                if (this.selectorConfig.isCameraAroundState) {
                    intent.putExtra(PictureConfig.CAMERA_FACING, 1);
                }
                intent.putExtra("output", uriCreateCameraOutImageUri);
                startActivityForResult(intent, 909);
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void openVideoCamera() {
        onPermissionExplainEvent(true, PermissionConfig.CAMERA);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(PermissionEvent.EVENT_VIDEO_CAMERA, PermissionConfig.CAMERA);
        } else {
            PermissionChecker.getInstance().requestPermissions(this, PermissionConfig.CAMERA, new PermissionResultCallback() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.6
                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onGranted() {
                    PictureCommonFragment.this.startCameraVideoCapture();
                }

                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onDenied() {
                    PictureCommonFragment.this.handlePermissionDenied(PermissionConfig.CAMERA);
                }
            });
        }
    }

    protected void startCameraVideoCapture() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        onPermissionExplainEvent(false, null);
        if (this.selectorConfig.onCameraInterceptListener != null) {
            onInterceptCameraEvent(2);
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
            Uri uriCreateCameraOutVideoUri = MediaStoreUtils.createCameraOutVideoUri(getAppContext(), this.selectorConfig);
            if (uriCreateCameraOutVideoUri != null) {
                intent.putExtra("output", uriCreateCameraOutVideoUri);
                if (this.selectorConfig.isCameraAroundState) {
                    intent.putExtra(PictureConfig.CAMERA_FACING, 1);
                }
                intent.putExtra(PictureConfig.EXTRA_QUICK_CAPTURE, this.selectorConfig.isQuickCapture);
                intent.putExtra("android.intent.extra.durationLimit", this.selectorConfig.recordVideoMaxSecond);
                intent.putExtra("android.intent.extra.videoQuality", this.selectorConfig.videoQuality);
                startActivityForResult(intent, 909);
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void openSoundRecording() {
        if (this.selectorConfig.onRecordAudioListener != null) {
            ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
            this.selectorConfig.onRecordAudioListener.onRecordAudio(this, 909);
            return;
        }
        throw new NullPointerException("OnRecordAudioInterceptListener interface needs to be implemented for recording");
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onInterceptCameraEvent(int i) {
        ForegroundService.startForegroundService(getAppContext(), this.selectorConfig.isCameraForegroundService);
        this.selectorConfig.onCameraInterceptListener.openCamera(this, i, 909);
    }

    public void onApplyPermissionsEvent(final int i, String[] strArr) {
        this.selectorConfig.onPermissionsEventListener.requestPermission(this, strArr, new OnRequestPermissionListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.7
            @Override // com.luck.picture.lib.interfaces.OnRequestPermissionListener
            public void onCall(String[] strArr2, boolean z) {
                if (z) {
                    if (i == PermissionEvent.EVENT_VIDEO_CAMERA) {
                        PictureCommonFragment.this.startCameraVideoCapture();
                        return;
                    } else {
                        PictureCommonFragment.this.startCameraImageCapture();
                        return;
                    }
                }
                PictureCommonFragment.this.handlePermissionDenied(strArr2);
            }
        });
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onPermissionExplainEvent(boolean z, String[] strArr) {
        if (this.selectorConfig.onPermissionDescriptionListener != null) {
            if (z) {
                if (PermissionChecker.isCheckSelfPermission(getAppContext(), strArr)) {
                    SpUtils.putBoolean(getAppContext(), strArr[0], false);
                    return;
                } else {
                    if (SpUtils.getBoolean(getAppContext(), strArr[0], false)) {
                        return;
                    }
                    this.selectorConfig.onPermissionDescriptionListener.onPermissionDescription(this, strArr);
                    return;
                }
            }
            this.selectorConfig.onPermissionDescriptionListener.onDismiss(this);
        }
    }

    private void playClickEffect() {
        if (this.soundPool == null || !this.selectorConfig.isOpenClickSound) {
            return;
        }
        this.soundPool.play(this.soundID, 0.1f, 0.5f, 0, 1, 1.0f);
    }

    private void releaseSoundPool() {
        try {
            SoundPool soundPool = this.soundPool;
            if (soundPool != null) {
                soundPool.release();
                this.soundPool = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ForegroundService.stopService(getAppContext());
        if (i2 != -1) {
            if (i2 == 96) {
                Throwable error = intent != null ? Crop.getError(intent) : new Throwable("image crop error");
                if (error != null) {
                    ToastUtils.showToast(getAppContext(), error.getMessage());
                    return;
                }
                return;
            }
            if (i2 == 0) {
                if (i != 909) {
                    if (i == 1102) {
                        handlePermissionSettingResult(PermissionConfig.CURRENT_REQUEST_PERMISSION);
                        return;
                    }
                    return;
                } else {
                    if (TextUtils.isEmpty(this.selectorConfig.cameraPath)) {
                        return;
                    }
                    MediaUtils.deleteUri(getAppContext(), this.selectorConfig.cameraPath);
                    this.selectorConfig.cameraPath = "";
                    return;
                }
            }
            return;
        }
        if (i == 909) {
            dispatchHandleCamera(intent);
            return;
        }
        if (i == 696) {
            onEditMedia(intent);
            return;
        }
        if (i == 69) {
            ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
            try {
                if (selectedResult.size() == 1) {
                    LocalMedia localMedia = selectedResult.get(0);
                    Uri output = Crop.getOutput(intent);
                    localMedia.setCutPath(output != null ? output.getPath() : "");
                    localMedia.setCut(TextUtils.isEmpty(localMedia.getCutPath()) ? false : true);
                    localMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
                    localMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
                    localMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
                    localMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
                    localMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
                    localMedia.setCustomData(Crop.getOutputCustomExtraData(intent));
                    localMedia.setSandboxPath(localMedia.getCutPath());
                } else {
                    String stringExtra = intent.getStringExtra("output");
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = intent.getStringExtra(CustomIntentKey.EXTRA_OUTPUT_URI);
                    }
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray.length() == selectedResult.size()) {
                        for (int i3 = 0; i3 < selectedResult.size(); i3++) {
                            LocalMedia localMedia2 = selectedResult.get(i3);
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                            localMedia2.setCutPath(jSONObjectOptJSONObject.optString(CustomIntentKey.EXTRA_OUT_PUT_PATH));
                            localMedia2.setCut(!TextUtils.isEmpty(localMedia2.getCutPath()));
                            localMedia2.setCropImageWidth(jSONObjectOptJSONObject.optInt(CustomIntentKey.EXTRA_IMAGE_WIDTH));
                            localMedia2.setCropImageHeight(jSONObjectOptJSONObject.optInt(CustomIntentKey.EXTRA_IMAGE_HEIGHT));
                            localMedia2.setCropOffsetX(jSONObjectOptJSONObject.optInt(CustomIntentKey.EXTRA_OFFSET_X));
                            localMedia2.setCropOffsetY(jSONObjectOptJSONObject.optInt(CustomIntentKey.EXTRA_OFFSET_Y));
                            localMedia2.setCropResultAspectRatio((float) jSONObjectOptJSONObject.optDouble(CustomIntentKey.EXTRA_ASPECT_RATIO));
                            localMedia2.setCustomData(jSONObjectOptJSONObject.optString(CustomIntentKey.EXTRA_CUSTOM_EXTRA_DATA));
                            localMedia2.setSandboxPath(localMedia2.getCutPath());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtils.showToast(getAppContext(), e.getMessage());
            }
            ArrayList<LocalMedia> arrayList = new ArrayList<>(selectedResult);
            if (checkCompressValidity()) {
                onCompress(arrayList);
            } else if (checkOldCompressValidity()) {
                onOldCompress(arrayList);
            } else {
                onResultEvent(arrayList);
            }
        }
    }

    private void dispatchHandleCamera(final Intent intent) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<LocalMedia>() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.8
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public LocalMedia doInBackground() throws Throwable {
                String outputPath = PictureCommonFragment.this.getOutputPath(intent);
                if (!TextUtils.isEmpty(outputPath)) {
                    PictureCommonFragment.this.selectorConfig.cameraPath = outputPath;
                }
                if (TextUtils.isEmpty(PictureCommonFragment.this.selectorConfig.cameraPath)) {
                    return null;
                }
                if (PictureCommonFragment.this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                    PictureCommonFragment.this.copyOutputAudioToDir();
                }
                PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                LocalMedia localMediaBuildLocalMedia = pictureCommonFragment.buildLocalMedia(pictureCommonFragment.selectorConfig.cameraPath);
                localMediaBuildLocalMedia.setCameraSource(true);
                return localMediaBuildLocalMedia;
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(LocalMedia localMedia) {
                PictureThreadUtils.cancel(this);
                if (localMedia != null) {
                    PictureCommonFragment.this.onScannerScanFile(localMedia);
                    PictureCommonFragment.this.dispatchCameraMediaResult(localMedia);
                }
                PictureCommonFragment.this.selectorConfig.cameraPath = "";
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyOutputAudioToDir() {
        String str;
        try {
            if (TextUtils.isEmpty(this.selectorConfig.outPutAudioDir)) {
                return;
            }
            InputStream inputStreamOpenInputStream = PictureMimeType.isContent(this.selectorConfig.cameraPath) ? PictureContentResolver.openInputStream(getAppContext(), Uri.parse(this.selectorConfig.cameraPath)) : new FileInputStream(this.selectorConfig.cameraPath);
            if (TextUtils.isEmpty(this.selectorConfig.outPutAudioFileName)) {
                str = "";
            } else {
                str = this.selectorConfig.isOnlyCamera ? this.selectorConfig.outPutAudioFileName : System.currentTimeMillis() + Config.replace + this.selectorConfig.outPutAudioFileName;
            }
            File fileCreateCameraFile = PictureFileUtils.createCameraFile(getAppContext(), this.selectorConfig.chooseMode, str, "", this.selectorConfig.outPutAudioDir);
            if (PictureFileUtils.writeFileFromIS(inputStreamOpenInputStream, new FileOutputStream(fileCreateCameraFile.getAbsolutePath()))) {
                MediaUtils.deleteUri(getAppContext(), this.selectorConfig.cameraPath);
                this.selectorConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected String getOutputPath(Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri data = (Uri) intent.getParcelableExtra("output");
        String str = this.selectorConfig.cameraPath;
        boolean z = TextUtils.isEmpty(str) || PictureMimeType.isContent(str) || new File(str).exists();
        if ((this.selectorConfig.chooseMode == SelectMimeType.ofAudio() || !z) && data == null) {
            data = intent.getData();
        }
        if (data == null) {
            return null;
        }
        return PictureMimeType.isContent(data.toString()) ? data.toString() : data.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScannerScanFile(LocalMedia localMedia) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (SdkVersionUtils.isQ()) {
            if (PictureMimeType.isHasVideo(localMedia.getMimeType()) && PictureMimeType.isContent(localMedia.getPath())) {
                new PictureMediaScannerConnection(getActivity(), localMedia.getRealPath());
                return;
            }
            return;
        }
        String realPath = PictureMimeType.isContent(localMedia.getPath()) ? localMedia.getRealPath() : localMedia.getPath();
        new PictureMediaScannerConnection(getActivity(), realPath);
        if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
            int dCIMLastImageId = MediaUtils.getDCIMLastImageId(getAppContext(), new File(realPath).getParent());
            if (dCIMLastImageId != -1) {
                MediaUtils.removeMedia(getAppContext(), dCIMLastImageId);
            }
        }
    }

    protected LocalMedia buildLocalMedia(String str) throws Throwable {
        LocalMedia localMediaGenerateLocalMedia = LocalMedia.generateLocalMedia(getAppContext(), str);
        localMediaGenerateLocalMedia.setChooseModel(this.selectorConfig.chooseMode);
        if (SdkVersionUtils.isQ() && !PictureMimeType.isContent(str)) {
            localMediaGenerateLocalMedia.setSandboxPath(str);
        } else {
            localMediaGenerateLocalMedia.setSandboxPath(null);
        }
        if (this.selectorConfig.isCameraRotateImage && PictureMimeType.isHasImage(localMediaGenerateLocalMedia.getMimeType())) {
            BitmapUtils.rotateImage(getAppContext(), str);
        }
        return localMediaGenerateLocalMedia;
    }

    private boolean checkCompleteSelectLimit() {
        if (this.selectorConfig.selectionMode == 2 && !this.selectorConfig.isOnlyCamera) {
            if (this.selectorConfig.isWithVideoImage) {
                ArrayList<LocalMedia> selectedResult = this.selectorConfig.getSelectedResult();
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < selectedResult.size(); i3++) {
                    if (PictureMimeType.isHasVideo(selectedResult.get(i3).getMimeType())) {
                        i2++;
                    } else {
                        i++;
                    }
                }
                if (this.selectorConfig.minSelectNum > 0 && i < this.selectorConfig.minSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), null, this.selectorConfig, 5)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_min_img_num, String.valueOf(this.selectorConfig.minSelectNum)));
                    return true;
                }
                if (this.selectorConfig.minVideoSelectNum > 0 && i2 < this.selectorConfig.minVideoSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), null, this.selectorConfig, 7)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_min_video_num, String.valueOf(this.selectorConfig.minVideoSelectNum)));
                    return true;
                }
            } else {
                String resultFirstMimeType = this.selectorConfig.getResultFirstMimeType();
                if (PictureMimeType.isHasImage(resultFirstMimeType) && this.selectorConfig.minSelectNum > 0 && this.selectorConfig.getSelectCount() < this.selectorConfig.minSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), null, this.selectorConfig, 5)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_min_img_num, String.valueOf(this.selectorConfig.minSelectNum)));
                    return true;
                }
                if (PictureMimeType.isHasVideo(resultFirstMimeType) && this.selectorConfig.minVideoSelectNum > 0 && this.selectorConfig.getSelectCount() < this.selectorConfig.minVideoSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), null, this.selectorConfig, 7)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_min_video_num, String.valueOf(this.selectorConfig.minVideoSelectNum)));
                    return true;
                }
                if (PictureMimeType.isHasAudio(resultFirstMimeType) && this.selectorConfig.minAudioSelectNum > 0 && this.selectorConfig.getSelectCount() < this.selectorConfig.minAudioSelectNum) {
                    if (this.selectorConfig.onSelectLimitTipsListener != null && this.selectorConfig.onSelectLimitTipsListener.onSelectLimitTips(getAppContext(), null, this.selectorConfig, 12)) {
                        return true;
                    }
                    showTipsDialog(getString(R.string.ps_min_audio_num, String.valueOf(this.selectorConfig.minAudioSelectNum)));
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchTransformResult() {
        if (!checkCompleteSelectLimit() && isAdded()) {
            ArrayList<LocalMedia> arrayList = new ArrayList<>(this.selectorConfig.getSelectedResult());
            if (checkCropValidity()) {
                onCrop(arrayList);
                return;
            }
            if (checkOldCropValidity()) {
                onOldCrop(arrayList);
                return;
            }
            if (checkCompressValidity()) {
                onCompress(arrayList);
            } else if (checkOldCompressValidity()) {
                onOldCompress(arrayList);
            } else {
                onResultEvent(arrayList);
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCrop(ArrayList<LocalMedia> arrayList) {
        Uri uriFromFile;
        ArrayList<String> arrayList2 = new ArrayList<>();
        Uri uri = null;
        Uri uriFromFile2 = null;
        for (int i = 0; i < arrayList.size(); i++) {
            LocalMedia localMedia = arrayList.get(i);
            arrayList2.add(localMedia.getAvailablePath());
            if (uri == null && PictureMimeType.isHasImage(localMedia.getMimeType())) {
                String availablePath = localMedia.getAvailablePath();
                if (PictureMimeType.isContent(availablePath) || PictureMimeType.isHasHttp(availablePath)) {
                    uriFromFile = Uri.parse(availablePath);
                } else {
                    uriFromFile = Uri.fromFile(new File(availablePath));
                }
                uri = uriFromFile;
                uriFromFile2 = Uri.fromFile(new File(new File(FileDirMap.getFileDirPath(getAppContext(), 1)).getAbsolutePath(), DateUtils.getCreateFileName("CROP_") + PictureMimeType.JPG));
            }
        }
        this.selectorConfig.cropFileEngine.onStartCrop(this, uri, uriFromFile2, arrayList2, 69);
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onOldCrop(ArrayList<LocalMedia> arrayList) {
        LocalMedia localMedia;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                localMedia = null;
                break;
            }
            localMedia = arrayList.get(i);
            if (PictureMimeType.isHasImage(arrayList.get(i).getMimeType())) {
                break;
            } else {
                i++;
            }
        }
        this.selectorConfig.cropEngine.onStartCrop(this, localMedia, arrayList, 69);
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCompress(final ArrayList<LocalMedia> arrayList) {
        showLoading();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ArrayList<Uri> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            LocalMedia localMedia = arrayList.get(i);
            String availablePath = localMedia.getAvailablePath();
            if (!PictureMimeType.isHasHttp(availablePath) && ((!this.selectorConfig.isCheckOriginalImage || !this.selectorConfig.isOriginalSkipCompress) && PictureMimeType.isHasImage(localMedia.getMimeType()))) {
                arrayList2.add(PictureMimeType.isContent(availablePath) ? Uri.parse(availablePath) : Uri.fromFile(new File(availablePath)));
                concurrentHashMap.put(availablePath, localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            onResultEvent(arrayList);
        } else {
            this.selectorConfig.compressFileEngine.onStartCompress(getAppContext(), arrayList2, new OnKeyValueResultCallbackListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.9
                @Override // com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener
                public void onCallback(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        PictureCommonFragment.this.onResultEvent(arrayList);
                        return;
                    }
                    LocalMedia localMedia2 = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia2 != null) {
                        if (SdkVersionUtils.isQ()) {
                            if (!TextUtils.isEmpty(str2) && (str2.contains("Android/data/") || str2.contains("data/user/"))) {
                                localMedia2.setCompressPath(str2);
                                localMedia2.setCompressed(!TextUtils.isEmpty(str2));
                                localMedia2.setSandboxPath(localMedia2.getCompressPath());
                            }
                        } else {
                            localMedia2.setCompressPath(str2);
                            localMedia2.setCompressed(!TextUtils.isEmpty(str2));
                        }
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.onResultEvent(arrayList);
                    }
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onOldCompress(ArrayList<LocalMedia> arrayList) {
        showLoading();
        if (this.selectorConfig.isCheckOriginalImage && this.selectorConfig.isOriginalSkipCompress) {
            onResultEvent(arrayList);
        } else {
            this.selectorConfig.compressEngine.onStartCompress(getAppContext(), arrayList, new OnCallbackListener<ArrayList<LocalMedia>>() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.10
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(ArrayList<LocalMedia> arrayList2) {
                    PictureCommonFragment.this.onResultEvent(arrayList2);
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkCropValidity() {
        if (this.selectorConfig.cropFileEngine == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        List<String> list = this.selectorConfig.skipCropList;
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        if (this.selectorConfig.getSelectCount() == 1) {
            String resultFirstMimeType = this.selectorConfig.getResultFirstMimeType();
            boolean zIsHasImage = PictureMimeType.isHasImage(resultFirstMimeType);
            if (zIsHasImage && hashSet.contains(resultFirstMimeType)) {
                return false;
            }
            return zIsHasImage;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.selectorConfig.getSelectCount(); i2++) {
            LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i2);
            if (PictureMimeType.isHasImage(localMedia.getMimeType()) && hashSet.contains(localMedia.getMimeType())) {
                i++;
            }
        }
        return i != this.selectorConfig.getSelectCount();
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkOldCropValidity() {
        if (this.selectorConfig.cropEngine == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        List<String> list = this.selectorConfig.skipCropList;
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        if (this.selectorConfig.getSelectCount() == 1) {
            String resultFirstMimeType = this.selectorConfig.getResultFirstMimeType();
            boolean zIsHasImage = PictureMimeType.isHasImage(resultFirstMimeType);
            if (zIsHasImage && hashSet.contains(resultFirstMimeType)) {
                return false;
            }
            return zIsHasImage;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.selectorConfig.getSelectCount(); i2++) {
            LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i2);
            if (PictureMimeType.isHasImage(localMedia.getMimeType()) && hashSet.contains(localMedia.getMimeType())) {
                i++;
            }
        }
        return i != this.selectorConfig.getSelectCount();
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkCompressValidity() {
        if (this.selectorConfig.compressFileEngine != null) {
            for (int i = 0; i < this.selectorConfig.getSelectCount(); i++) {
                if (PictureMimeType.isHasImage(this.selectorConfig.getSelectedResult().get(i).getMimeType())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkOldCompressValidity() {
        if (this.selectorConfig.compressEngine != null) {
            for (int i = 0; i < this.selectorConfig.getSelectCount(); i++) {
                if (PictureMimeType.isHasImage(this.selectorConfig.getSelectedResult().get(i).getMimeType())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkTransformSandboxFile() {
        return SdkVersionUtils.isQ() && this.selectorConfig.uriToFileTransformEngine != null;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkOldTransformSandboxFile() {
        return SdkVersionUtils.isQ() && this.selectorConfig.sandboxFileEngine != null;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkAddBitmapWatermark() {
        return this.selectorConfig.onBitmapWatermarkListener != null;
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public boolean checkVideoThumbnail() {
        return this.selectorConfig.onVideoThumbnailEventListener != null;
    }

    private void videoThumbnail(final ArrayList<LocalMedia> arrayList) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            LocalMedia localMedia = arrayList.get(i);
            String availablePath = localMedia.getAvailablePath();
            if (PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isUrlHasVideo(availablePath)) {
                concurrentHashMap.put(availablePath, localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            onCallBackResult(arrayList);
            return;
        }
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            this.selectorConfig.onVideoThumbnailEventListener.onVideoThumbnail(getAppContext(), (String) ((Map.Entry) it.next()).getKey(), new OnKeyValueResultCallbackListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.11
                @Override // com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener
                public void onCallback(String str, String str2) {
                    LocalMedia localMedia2 = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia2 != null) {
                        localMedia2.setVideoThumbnailPath(str2);
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.onCallBackResult(arrayList);
                    }
                }
            });
        }
    }

    private void addBitmapWatermark(final ArrayList<LocalMedia> arrayList) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            LocalMedia localMedia = arrayList.get(i);
            if (!PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                concurrentHashMap.put(localMedia.getAvailablePath(), localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            dispatchWatermarkResult(arrayList);
            return;
        }
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            this.selectorConfig.onBitmapWatermarkListener.onAddBitmapWatermark(getAppContext(), (String) entry.getKey(), ((LocalMedia) entry.getValue()).getMimeType(), new OnKeyValueResultCallbackListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.12
                @Override // com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener
                public void onCallback(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        PictureCommonFragment.this.dispatchWatermarkResult(arrayList);
                        return;
                    }
                    LocalMedia localMedia2 = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia2 != null) {
                        localMedia2.setWatermarkPath(str2);
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.dispatchWatermarkResult(arrayList);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchUriToFileTransformResult(ArrayList<LocalMedia> arrayList) {
        showLoading();
        if (checkAddBitmapWatermark()) {
            addBitmapWatermark(arrayList);
        } else if (checkVideoThumbnail()) {
            videoThumbnail(arrayList);
        } else {
            onCallBackResult(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchWatermarkResult(ArrayList<LocalMedia> arrayList) {
        if (checkVideoThumbnail()) {
            videoThumbnail(arrayList);
        } else {
            onCallBackResult(arrayList);
        }
    }

    private void uriToFileTransform29(final ArrayList<LocalMedia> arrayList) {
        showLoading();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            LocalMedia localMedia = arrayList.get(i);
            concurrentHashMap.put(localMedia.getPath(), localMedia);
        }
        if (concurrentHashMap.size() == 0) {
            dispatchUriToFileTransformResult(arrayList);
        } else {
            PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<ArrayList<LocalMedia>>() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.13
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public ArrayList<LocalMedia> doInBackground() {
                    Iterator it = concurrentHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        LocalMedia localMedia2 = (LocalMedia) ((Map.Entry) it.next()).getValue();
                        if (PictureCommonFragment.this.selectorConfig.isCheckOriginalImage || TextUtils.isEmpty(localMedia2.getSandboxPath())) {
                            PictureCommonFragment.this.selectorConfig.uriToFileTransformEngine.onUriToFileAsyncTransform(PictureCommonFragment.this.getAppContext(), localMedia2.getPath(), localMedia2.getMimeType(), new OnKeyValueResultCallbackListener() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.13.1
                                @Override // com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener
                                public void onCallback(String str, String str2) {
                                    LocalMedia localMedia3;
                                    if (TextUtils.isEmpty(str) || (localMedia3 = (LocalMedia) concurrentHashMap.get(str)) == null) {
                                        return;
                                    }
                                    if (TextUtils.isEmpty(localMedia3.getSandboxPath())) {
                                        localMedia3.setSandboxPath(str2);
                                    }
                                    if (PictureCommonFragment.this.selectorConfig.isCheckOriginalImage) {
                                        localMedia3.setOriginalPath(str2);
                                        localMedia3.setOriginal(!TextUtils.isEmpty(str2));
                                    }
                                    concurrentHashMap.remove(str);
                                }
                            });
                        }
                    }
                    return arrayList;
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(ArrayList<LocalMedia> arrayList2) {
                    PictureThreadUtils.cancel(this);
                    PictureCommonFragment.this.dispatchUriToFileTransformResult(arrayList2);
                }
            });
        }
    }

    @Deprecated
    private void copyExternalPathToAppInDirFor29(final ArrayList<LocalMedia> arrayList) {
        showLoading();
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<ArrayList<LocalMedia>>() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.14
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public ArrayList<LocalMedia> doInBackground() {
                for (int i = 0; i < arrayList.size(); i++) {
                    int i2 = i;
                    PictureCommonFragment.this.selectorConfig.sandboxFileEngine.onStartSandboxFileTransform(PictureCommonFragment.this.getAppContext(), PictureCommonFragment.this.selectorConfig.isCheckOriginalImage, i2, (LocalMedia) arrayList.get(i), new OnCallbackIndexListener<LocalMedia>() { // from class: com.luck.picture.lib.basic.PictureCommonFragment.14.1
                        @Override // com.luck.picture.lib.interfaces.OnCallbackIndexListener
                        public void onCall(LocalMedia localMedia, int i3) {
                            LocalMedia localMedia2 = (LocalMedia) arrayList.get(i3);
                            localMedia2.setSandboxPath(localMedia.getSandboxPath());
                            if (PictureCommonFragment.this.selectorConfig.isCheckOriginalImage) {
                                localMedia2.setOriginalPath(localMedia.getOriginalPath());
                                localMedia2.setOriginal(!TextUtils.isEmpty(localMedia.getOriginalPath()));
                            }
                        }
                    });
                }
                return arrayList;
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(ArrayList<LocalMedia> arrayList2) {
                PictureThreadUtils.cancel(this);
                PictureCommonFragment.this.dispatchUriToFileTransformResult(arrayList2);
            }
        });
    }

    private void mergeOriginalImage(ArrayList<LocalMedia> arrayList) {
        if (this.selectorConfig.isCheckOriginalImage) {
            for (int i = 0; i < arrayList.size(); i++) {
                LocalMedia localMedia = arrayList.get(i);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onResultEvent(ArrayList<LocalMedia> arrayList) {
        if (checkTransformSandboxFile()) {
            uriToFileTransform29(arrayList);
        } else if (checkOldTransformSandboxFile()) {
            copyExternalPathToAppInDirFor29(arrayList);
        } else {
            mergeOriginalImage(arrayList);
            dispatchUriToFileTransformResult(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallBackResult(ArrayList<LocalMedia> arrayList) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        dismissLoading();
        if (this.selectorConfig.isActivityResultBack) {
            getActivity().setResult(-1, PictureSelector.putIntentResult(arrayList));
            onSelectFinish(-1, arrayList);
        } else if (this.selectorConfig.onResultCallListener != null) {
            this.selectorConfig.onResultCallListener.onResult(arrayList);
        }
        onExitPictureSelector();
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void initAppLanguage() {
        if (this.selectorConfig == null) {
            this.selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        }
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig == null || selectorConfig.language == -2) {
            return;
        }
        PictureLanguageUtils.setAppLanguage(getActivity(), this.selectorConfig.language, this.selectorConfig.defaultLanguage);
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onRecreateEngine() {
        createImageLoaderEngine();
        createVideoPlayerEngine();
        createCompressEngine();
        createSandboxFileEngine();
        createLoaderDataEngine();
        createResultCallbackListener();
        createLayoutResourceListener();
    }

    public void onKeyBackFragmentFinish() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (this.selectorConfig.isActivityResultBack) {
            getActivity().setResult(0);
            onSelectFinish(0, null);
        } else if (this.selectorConfig.onResultCallListener != null) {
            this.selectorConfig.onResultCallListener.onCancel();
        }
        onExitPictureSelector();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        releaseSoundPool();
        super.onDestroy();
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void showLoading() {
        try {
            if (ActivityCompatHelper.isDestroy(getActivity()) || this.mLoadingDialog.isShowing()) {
                return;
            }
            this.mLoadingDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void dismissLoading() {
        try {
            if (!ActivityCompatHelper.isDestroy(getActivity()) && this.mLoadingDialog.isShowing()) {
                this.mLoadingDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        initAppLanguage();
        onRecreateEngine();
        super.onAttach(context);
        this.context = context;
        if (getParentFragment() instanceof IBridgePictureBehavior) {
            this.iBridgePictureBehavior = (IBridgePictureBehavior) getParentFragment();
        } else if (context instanceof IBridgePictureBehavior) {
            this.iBridgePictureBehavior = (IBridgePictureBehavior) context;
        }
    }

    protected void setRequestedOrientation() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        getActivity().setRequestedOrientation(this.selectorConfig.requestedOrientation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBackCurrentFragment() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (!isStateSaved()) {
            if (this.selectorConfig.viewLifecycle != null) {
                this.selectorConfig.viewLifecycle.onDestroy(this);
            }
            getActivity().getSupportFragmentManager().popBackStack();
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (fragment instanceof PictureCommonFragment) {
                ((PictureCommonFragment) fragment).onFragmentResume();
            }
        }
    }

    protected void onSelectFinish(int i, ArrayList<LocalMedia> arrayList) {
        if (this.iBridgePictureBehavior != null) {
            this.iBridgePictureBehavior.onSelectFinish(getResult(i, arrayList));
        }
    }

    protected void onExitPictureSelector() {
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            if (isNormalDefaultEnter()) {
                if (this.selectorConfig.viewLifecycle != null) {
                    this.selectorConfig.viewLifecycle.onDestroy(this);
                }
                getActivity().finish();
            } else {
                List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
                for (int i = 0; i < fragments.size(); i++) {
                    if (fragments.get(i) instanceof PictureCommonFragment) {
                        onBackCurrentFragment();
                    }
                }
            }
        }
        SelectorProviders.getInstance().destroy();
    }

    private void createImageLoaderEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.selectorConfig.imageEngine != null || (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) == null) {
            return;
        }
        this.selectorConfig.imageEngine = pictureSelectorEngine.createImageLoaderEngine();
    }

    private void createVideoPlayerEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.selectorConfig.videoPlayerEngine != null || (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) == null) {
            return;
        }
        this.selectorConfig.videoPlayerEngine = pictureSelectorEngine.createVideoPlayerEngine();
    }

    private void createLoaderDataEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        PictureSelectorEngine pictureSelectorEngine2;
        if (this.selectorConfig.isLoaderDataEngine && this.selectorConfig.loaderDataEngine == null && (pictureSelectorEngine2 = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.loaderDataEngine = pictureSelectorEngine2.createLoaderDataEngine();
        }
        if (this.selectorConfig.isLoaderFactoryEngine && this.selectorConfig.loaderFactory == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.loaderFactory = pictureSelectorEngine.onCreateLoader();
        }
    }

    private void createCompressEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        PictureSelectorEngine pictureSelectorEngine2;
        if (this.selectorConfig.isCompressEngine) {
            if (this.selectorConfig.compressFileEngine == null && (pictureSelectorEngine2 = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
                this.selectorConfig.compressFileEngine = pictureSelectorEngine2.createCompressFileEngine();
            }
            if (this.selectorConfig.compressEngine != null || (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) == null) {
                return;
            }
            this.selectorConfig.compressEngine = pictureSelectorEngine.createCompressEngine();
        }
    }

    private void createSandboxFileEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        PictureSelectorEngine pictureSelectorEngine2;
        if (this.selectorConfig.isSandboxFileEngine) {
            if (this.selectorConfig.uriToFileTransformEngine == null && (pictureSelectorEngine2 = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
                this.selectorConfig.uriToFileTransformEngine = pictureSelectorEngine2.createUriToFileTransformEngine();
            }
            if (this.selectorConfig.sandboxFileEngine != null || (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) == null) {
                return;
            }
            this.selectorConfig.sandboxFileEngine = pictureSelectorEngine.createSandboxFileEngine();
        }
    }

    private void createResultCallbackListener() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.selectorConfig.isResultListenerBack && this.selectorConfig.onResultCallListener == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.onResultCallListener = pictureSelectorEngine.getResultCallbackListener();
        }
    }

    private void createLayoutResourceListener() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.selectorConfig.isInjectLayoutResource && this.selectorConfig.onLayoutResourceListener == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            this.selectorConfig.onLayoutResourceListener = pictureSelectorEngine.createLayoutResourceListener();
        }
    }

    protected SelectorResult getResult(int i, ArrayList<LocalMedia> arrayList) {
        return new SelectorResult(i, arrayList != null ? PictureSelector.putIntentResult(arrayList) : null);
    }

    public static class SelectorResult {
        public int mResultCode;
        public Intent mResultData;

        public SelectorResult(int i, Intent intent) {
            this.mResultCode = i;
            this.mResultData = intent;
        }
    }
}
