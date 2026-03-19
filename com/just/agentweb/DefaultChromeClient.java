package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.just.agentweb.AgentActionFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultChromeClient extends MiddlewareWebChromeBase {
    public static final String ANDROID_WEBCHROMECLIENT_PATH = "android.webkit.WebChromeClient";
    public static final int FROM_CODE_INTENTION = 24;
    public static final int FROM_CODE_INTENTION_LOCATION = 96;
    private String TAG;
    private WeakReference<Activity> mActivityWeakReference;
    private WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    private GeolocationPermissions.Callback mCallback;
    private Object mFileChooser;
    private IVideo mIVideo;
    private IndicatorController mIndicatorController;
    private boolean mIsWrapper;
    private String mOrigin;
    private PermissionInterceptor mPermissionInterceptor;
    private AgentActionFragment.PermissionListener mPermissionListener;
    private android.webkit.WebChromeClient mWebChromeClient;
    private WebView mWebView;

    DefaultChromeClient(Activity activity, IndicatorController indicatorController, android.webkit.WebChromeClient webChromeClient, IVideo iVideo, PermissionInterceptor permissionInterceptor, WebView webView) {
        super(webChromeClient);
        this.mActivityWeakReference = null;
        this.TAG = "DefaultChromeClient";
        this.mIsWrapper = false;
        this.mOrigin = null;
        this.mCallback = null;
        this.mAgentWebUIController = null;
        this.mPermissionListener = new AgentActionFragment.PermissionListener() { // from class: com.just.agentweb.DefaultChromeClient.1
            @Override // com.just.agentweb.AgentActionFragment.PermissionListener
            public void onRequestPermissionsResult(String[] strArr, int[] iArr, Bundle bundle) {
                if (bundle.getInt(AgentActionFragment.KEY_FROM_INTENTION) == 96) {
                    boolean zHasPermission = AgentWebUtils.hasPermission((Context) DefaultChromeClient.this.mActivityWeakReference.get(), strArr);
                    if (DefaultChromeClient.this.mCallback != null) {
                        GeolocationPermissions.Callback callback = DefaultChromeClient.this.mCallback;
                        String str = DefaultChromeClient.this.mOrigin;
                        if (zHasPermission) {
                            callback.invoke(str, true, false);
                        } else {
                            callback.invoke(str, false, false);
                        }
                        DefaultChromeClient.this.mCallback = null;
                        DefaultChromeClient.this.mOrigin = null;
                    }
                    if (zHasPermission || DefaultChromeClient.this.mAgentWebUIController.get() == null) {
                        return;
                    }
                    ((AbsAgentWebUIController) DefaultChromeClient.this.mAgentWebUIController.get()).onPermissionsDeny(AgentWebPermissions.LOCATION, AgentWebPermissions.ACTION_LOCATION, AgentWebPermissions.ACTION_LOCATION);
                }
            }
        };
        this.mIndicatorController = indicatorController;
        this.mIsWrapper = webChromeClient != null;
        this.mWebChromeClient = webChromeClient;
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mIVideo = iVideo;
        this.mPermissionInterceptor = permissionInterceptor;
        this.mWebView = webView;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(webView));
    }

    private void createAndOpenCommonFileChooser(ValueCallback valueCallback, String str) {
        if (valueCallback == null) {
            return;
        }
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            valueCallback.onReceiveValue(new Object());
        } else {
            AgentWebUtils.showFileChooserCompat(activity, this.mWebView, null, null, this.mPermissionInterceptor, valueCallback, str, null);
        }
    }

    private void onGeolocationPermissionsShowPromptInternal(String str, GeolocationPermissions.Callback callback) {
        PermissionInterceptor permissionInterceptor = this.mPermissionInterceptor;
        if (permissionInterceptor != null && permissionInterceptor.intercept(this.mWebView.getUrl(), AgentWebPermissions.LOCATION, "location")) {
            callback.invoke(str, false, false);
            return;
        }
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null) {
            callback.invoke(str, false, false);
            return;
        }
        List<String> deniedPermissions = AgentWebUtils.getDeniedPermissions(activity, AgentWebPermissions.LOCATION);
        if (deniedPermissions.isEmpty()) {
            LogUtils.i(this.TAG, "onGeolocationPermissionsShowPromptInternal:true");
            callback.invoke(str, true, false);
            return;
        }
        Action actionCreatePermissionsAction = Action.createPermissionsAction((String[]) deniedPermissions.toArray(new String[0]));
        actionCreatePermissionsAction.setFromIntention(96);
        actionCreatePermissionsAction.setPermissionListener(this.mPermissionListener);
        this.mCallback = callback;
        this.mOrigin = str;
        AgentActionFragment.start(activity, actionCreatePermissionsAction);
    }

    private boolean openFileChooserAboveL(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Activity activity;
        if (valueCallback == null || (activity = this.mActivityWeakReference.get()) == null || activity.isFinishing()) {
            return false;
        }
        return AgentWebUtils.showFileChooserCompat(activity, this.mWebView, valueCallback, fileChooserParams, this.mPermissionInterceptor, null, null, null);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        super.onConsoleMessage(consoleMessage);
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j3 * 2);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        onGeolocationPermissionsShowPromptInternal(str, callback);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onHideCustomView() {
        IVideo iVideo = this.mIVideo;
        if (iVideo != null) {
            iVideo.onHideCustomView();
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onJsAlert(webView, str, str2);
        }
        jsResult.confirm();
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mAgentWebUIController.get() == null) {
            return true;
        }
        this.mAgentWebUIController.get().onJsConfirm(webView, str, str2, jsResult);
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if (this.mAgentWebUIController.get() == null) {
                return true;
            }
            this.mAgentWebUIController.get().onJsPrompt(this.mWebView, str, str2, str3, jsPromptResult);
            return true;
        } catch (Exception e) {
            if (!LogUtils.isDebug()) {
                return true;
            }
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (permissionRequest == null) {
            return;
        }
        String[] resources = permissionRequest.getResources();
        if (resources == null || resources.length <= 0) {
            permissionRequest.deny();
            return;
        }
        HashSet hashSet = new HashSet(Arrays.asList(resources));
        ArrayList arrayList = new ArrayList(hashSet.size());
        if (hashSet.contains("android.webkit.resource.VIDEO_CAPTURE")) {
            arrayList.add(PermissionUtils.PERMISSION_CAMERA);
        }
        if (hashSet.contains("android.webkit.resource.AUDIO_CAPTURE")) {
            arrayList.add(PermissionUtils.PERMISSION_RECORD_AUDIO);
        }
        PermissionInterceptor permissionInterceptor = this.mPermissionInterceptor;
        if ((permissionInterceptor == null || !permissionInterceptor.intercept(this.mWebView.getUrl(), (String[]) arrayList.toArray(new String[0]), "onPermissionRequest")) && this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onPermissionRequest(permissionRequest);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        super.onPermissionRequestCanceled(permissionRequest);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        IndicatorController indicatorController = this.mIndicatorController;
        if (indicatorController != null) {
            indicatorController.progress(webView, i);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.mIsWrapper) {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        IVideo iVideo = this.mIVideo;
        if (iVideo != null) {
            iVideo.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        LogUtils.i(this.TAG, "openFileChooser>=5.0");
        return openFileChooserAboveL(webView, valueCallback, fileChooserParams);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        Log.i(this.TAG, "openFileChooser<3.0");
        createAndOpenCommonFileChooser(valueCallback, "*/*");
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback valueCallback, String str) {
        Log.i(this.TAG, "openFileChooser>3.0");
        createAndOpenCommonFileChooser(valueCallback, str);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        LogUtils.i(this.TAG, "openFileChooser>=4.1");
        createAndOpenCommonFileChooser(valueCallback, str);
    }
}
