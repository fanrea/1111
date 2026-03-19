package com.just.agentweb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.just.agentweb.AgentActionFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultUIController extends AbsAgentWebUIController {
    private Activity mActivity;
    private AlertDialog mAlertDialog;
    protected AlertDialog mConfirmDialog;
    private ProgressDialog mProgressDialog;
    private WebParentLayout mWebParentLayout;
    private JsPromptResult mJsPromptResult = null;
    private JsResult mJsResult = null;
    private AlertDialog mPromptDialog = null;
    private AlertDialog mAskOpenOtherAppDialog = null;
    private Resources mResources = null;

    private void onForceDownloadAlertInternal(final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            new AlertDialog.Builder(activity).setTitle(this.mResources.getString(R.string.agentweb_tips)).setMessage(this.mResources.getString(R.string.agentweb_honeycomblow)).setNegativeButton(this.mResources.getString(R.string.agentweb_download), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain());
                    }
                }
            }).setPositiveButton(this.mResources.getString(R.string.agentweb_cancel), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }).create().show();
        }
    }

    private void onJsConfirmInternal(String str, JsResult jsResult) {
        LogUtils.i(this.TAG, "activity:" + this.mActivity.hashCode() + "  ");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            toCancelJsresult(jsResult);
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            toCancelJsresult(jsResult);
            return;
        }
        if (this.mConfirmDialog == null) {
            this.mConfirmDialog = new AlertDialog.Builder(activity).setMessage(str).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                    DefaultUIController defaultUIController2 = DefaultUIController.this;
                    defaultUIController2.toCancelJsresult(defaultUIController2.mJsResult);
                }
            }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                    if (DefaultUIController.this.mJsResult != null) {
                        DefaultUIController.this.mJsResult.confirm();
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toCancelJsresult(defaultUIController.mJsResult);
                }
            }).create();
        }
        this.mConfirmDialog.setMessage(str);
        this.mJsResult = jsResult;
        this.mConfirmDialog.show();
    }

    private void onJsPromptInternal(String str, String str2, JsPromptResult jsPromptResult) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            jsPromptResult.cancel();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            jsPromptResult.cancel();
            return;
        }
        if (this.mPromptDialog == null) {
            final EditText editText = new EditText(activity);
            editText.setText(str2);
            this.mPromptDialog = new AlertDialog.Builder(activity).setView(editText).setTitle(str).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                    DefaultUIController defaultUIController2 = DefaultUIController.this;
                    defaultUIController2.toCancelJsresult(defaultUIController2.mJsPromptResult);
                }
            }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                    if (DefaultUIController.this.mJsPromptResult != null) {
                        DefaultUIController.this.mJsPromptResult.confirm(editText.getText().toString());
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.10
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    DefaultUIController defaultUIController = DefaultUIController.this;
                    defaultUIController.toCancelJsresult(defaultUIController.mJsPromptResult);
                }
            }).create();
        }
        this.mJsPromptResult = jsPromptResult;
        this.mPromptDialog.show();
    }

    private void showChooserInternal(String[] strArr, final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).setSingleChoiceItems(strArr, -1, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    LogUtils.i(DefaultUIController.this.TAG, "which:" + i);
                    if (callback != null) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = i;
                        callback.handleMessage(messageObtain);
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain((Handler) null, -1));
                    }
                }
            }).create();
            this.mAlertDialog = alertDialogCreate;
            alertDialogCreate.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCancelJsresult(JsResult jsResult) {
        if (jsResult != null) {
            jsResult.cancel();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    protected void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {
        this.mActivity = activity;
        this.mWebParentLayout = webParentLayout;
        this.mResources = activity.getResources();
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onCancelLoading() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = null;
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onForceDownloadAlert(String str, Handler.Callback callback) {
        onForceDownloadAlertInternal(callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsAlert(WebView webView, String str, String str2) {
        AgentWebUtils.toastShowShort(webView.getContext().getApplicationContext(), str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        onJsConfirmInternal(str2, jsResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        onJsPromptInternal(str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onLoading(String str) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(activity);
            }
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(str);
            this.mProgressDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onMainFrameError(WebView webView, int i, String str, String str2) {
        LogUtils.i(this.TAG, "mWebParentLayout onMainFrameError:" + this.mWebParentLayout);
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.showPageMainFrameError();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onOpenPagePrompt(WebView webView, String str, final Handler.Callback callback) {
        LogUtils.i(this.TAG, "onOpenPagePrompt");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mAskOpenOtherAppDialog == null) {
                this.mAskOpenOtherAppDialog = new AlertDialog.Builder(activity).setMessage(this.mResources.getString(R.string.agentweb_leave_app_and_go_other_page, AgentWebUtils.getApplicationName(activity))).setTitle(this.mResources.getString(R.string.agentweb_tips)).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, -1));
                        }
                    }
                }).setPositiveButton(this.mResources.getString(R.string.agentweb_leave), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, 1));
                        }
                    }
                }).create();
            }
            this.mAskOpenOtherAppDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        final String[] resources = permissionRequest.getResources();
        HashSet hashSet = new HashSet(Arrays.asList(resources));
        ArrayList arrayList = new ArrayList(hashSet.size());
        if (hashSet.contains("android.webkit.resource.VIDEO_CAPTURE")) {
            arrayList.add(PermissionUtils.PERMISSION_CAMERA);
        }
        if (hashSet.contains("android.webkit.resource.AUDIO_CAPTURE")) {
            arrayList.add(PermissionUtils.PERMISSION_RECORD_AUDIO);
        }
        if (arrayList.isEmpty()) {
            permissionRequest.grant(resources);
            return;
        }
        final List<String> deniedPermissions = AgentWebUtils.getDeniedPermissions(this.mActivity, (String[]) arrayList.toArray(new String[0]));
        if (deniedPermissions.isEmpty()) {
            permissionRequest.grant(resources);
            return;
        }
        Action actionCreatePermissionsAction = Action.createPermissionsAction((String[]) deniedPermissions.toArray(new String[0]));
        actionCreatePermissionsAction.setPermissionListener(new AgentActionFragment.PermissionListener() { // from class: com.just.agentweb.DefaultUIController.15
            @Override // com.just.agentweb.AgentActionFragment.PermissionListener
            public void onRequestPermissionsResult(String[] strArr, int[] iArr, Bundle bundle) {
                if (AgentWebUtils.getDeniedPermissions(DefaultUIController.this.mActivity, (String[]) deniedPermissions.toArray(new String[0])).isEmpty()) {
                    permissionRequest.grant(resources);
                } else {
                    permissionRequest.deny();
                }
            }
        });
        AgentActionFragment.start(this.mActivity, actionCreatePermissionsAction);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionsDeny(String[] strArr, String str, String str2) {
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        showChooserInternal(strArr, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMainFrame() {
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.hideErrorLayout();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMessage(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
            AgentWebUtils.toastShowShort(this.mActivity.getApplicationContext(), str);
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowSslCertificateErrorDialog(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity;
        int i;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            activity = this.mActivity;
            i = R.string.agentweb_message_show_ssl_not_yet_valid;
        } else if (primaryError == 1) {
            activity = this.mActivity;
            i = R.string.agentweb_message_show_ssl_expired;
        } else if (primaryError == 2) {
            activity = this.mActivity;
            i = R.string.agentweb_message_show_ssl_hostname_mismatch;
        } else if (primaryError != 3) {
            activity = this.mActivity;
            i = R.string.agentweb_message_show_ssl_error;
        } else {
            activity = this.mActivity;
            i = R.string.agentweb_message_show_ssl_untrusted;
        }
        String str = activity.getString(i) + this.mActivity.getString(R.string.agentweb_message_show_continue);
        builder.setTitle(this.mActivity.getString(R.string.agentweb_title_ssl_error));
        builder.setMessage(str);
        builder.setPositiveButton(R.string.agentweb_continue, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                sslErrorHandler.proceed();
            }
        });
        builder.setNegativeButton(R.string.agentweb_cancel, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                sslErrorHandler.cancel();
            }
        });
        builder.show();
    }
}
