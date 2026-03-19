package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.sdk.m.u.i;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.MokuJsObjectListenerImpl;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.interf.functions.Action;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.ViewImageDialog;
import com.fendasz.moku.planet.utils.FileUtils;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.QrCodeUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.WeChatUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ArbitrationActivity extends BaseBackActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int REQUEST_CODE_FOR_MOKU_DETAIL = 200;
    private Bitmap currentBitmap;
    private String currentUrl;
    private TreeMap<Integer, File> fileMap;
    private LinearLayout mContentView;
    private Context mContext;
    private LinearLayout mLlBrowser;
    private LinearLayout mLlOptions;
    private LinearLayout mLlWeChat;
    private PhoneScreenUtils mPhoneScreenUtils;
    private RelativeLayout mRlOptionsContainer;
    private int taskDataId;
    private int taskRecordId;
    private int taskRecordState;
    private WebView webView;
    private static final String DATA_DETAILURL_DEBUG = MokuConstants.H5Url.H5_ARBITRATION_DEBUG_LOCAL.getUrl();
    private static final String DATA_DETAILURL_RELEASE = MokuConstants.H5Url.H5_ARBITRATION_DEBUG_RELEASE.getUrl();
    private static final String TAG = "ArbitrationActivity";
    private MokuJsObjectListenerImpl mokuJsListener = null;
    private long lastOpenAlbumTime = 0;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_task_arbitration, (ViewGroup) null);
        this.mContentView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        textView.setText("");
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initLlOptionsView();
        initWebView();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        if (bundle == null) {
            Intent intent = getIntent();
            this.taskDataId = intent.getIntExtra("taskDataId", -1);
            this.taskRecordId = intent.getIntExtra("taskRecordId", 0);
            this.taskRecordState = intent.getIntExtra("taskRecordState", -10);
        } else {
            this.taskDataId = bundle.getInt("taskDataId", -1);
            this.taskRecordId = bundle.getInt("taskRecordId", 0);
            this.taskRecordState = bundle.getInt("taskRecordState", -10);
        }
        LogUtils.logD(TAG, "onSuperCreate,taskDataId==>" + this.taskDataId + ",taskRecordId==>" + this.taskRecordId);
    }

    private void initLlOptionsView() {
        RelativeLayout rlContentBottom = ((ArbitrationActivity) this.mContext).getRlContentBottom();
        rlContentBottom.setVisibility(0);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mRlOptionsContainer = relativeLayout;
        rlContentBottom.addView(relativeLayout);
        this.mRlOptionsContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRlOptionsContainer.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_image_options, (ViewGroup) this.mRlOptionsContainer, false);
        this.mLlOptions = linearLayout;
        this.mRlOptionsContainer.addView(linearLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mLlOptions.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_save);
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout2, 20, 20);
        LinearLayout linearLayout3 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_we_chat);
        this.mLlWeChat = linearLayout3;
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout3, 20, 20);
        LinearLayout linearLayout4 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_browser);
        this.mLlBrowser = linearLayout4;
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout4, 20, 20);
        ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_save), 100, 100);
        ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_we_chat), 100, 100);
        ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_browser), 100, 100);
        TextView textView = (TextView) this.mLlOptions.findViewById(R.id.tv_save);
        textView.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView, 10);
        TextView textView2 = (TextView) this.mLlOptions.findViewById(R.id.tv_we_chat);
        textView2.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView2, 10);
        TextView textView3 = (TextView) this.mLlOptions.findViewById(R.id.tv_browser);
        textView3.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
        ScreenAdaptationUtils.setMarginTop(this.mContext, textView3, 10);
        TextView textView4 = (TextView) this.mLlOptions.findViewById(R.id.tv_cancel);
        ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, textView4, 20);
        textView4.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
        initLlOptionsListener(linearLayout2, this.mLlWeChat, this.mLlBrowser, textView4);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws UnsupportedEncodingException {
        super.onActivityResult(i, i2, intent);
        Log.d(TAG, "onActivityResult_requestCode=>" + i + ",resultCode=>" + i2);
        if (i == 200) {
            if (i2 == 602) {
                setResult(602);
                finish();
                return;
            } else {
                this.webView.loadUrl(DATA_DETAILURL_RELEASE + "?recordstate=" + this.taskRecordState);
                return;
            }
        }
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        String uriPath = null;
        try {
            uriPath = FileUtils.getUriPath(this, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(uriPath)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            File fileCompressSize = ImageUtils.compressSize(getExternalCacheDir().getPath(), uriPath);
            if (fileCompressSize == null) {
                return;
            }
            if (this.fileMap == null) {
                this.fileMap = new TreeMap<>();
            }
            this.fileMap.put(Integer.valueOf(i), fileCompressSize);
            String strEncodeToString = Base64.encodeToString(FileUtils.readFile(fileCompressSize), 0);
            try {
                strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                this.webView.evaluateJavascript("javascript:readFileSend('" + strEncodeToString + "'," + i + ")", new ValueCallback<String>() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str) {
                        Log.d(ArbitrationActivity.TAG, str);
                    }
                });
            } else {
                this.webView.loadUrl("javascript:readFileSend('" + strEncodeToString + "')");
            }
            Log.d(TAG, "readFileSend_time==>" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void initWebView() {
        WebView webView = (WebView) this.mContentView.findViewById(R.id.webview_moku_arbitration);
        this.webView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccessFromFileURLs(true);
        MokuJsObject mokuJsObject = new MokuJsObject();
        initMokuJsLisetener();
        mokuJsObject.setOnMokuJsListener(this.mokuJsListener);
        this.webView.addJavascriptInterface(mokuJsObject, "android");
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                webView2.loadUrl(str);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23) {
                    Log.d(ArbitrationActivity.TAG, "request==>,errorCode==" + webResourceError.getErrorCode() + ",errorMsg=>" + ((Object) webResourceError.getDescription()) + i.d);
                }
            }
        });
        this.webView.loadUrl(DATA_DETAILURL_RELEASE + "?recordstate=" + this.taskRecordState);
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.ArbitrationActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 19) {
                ArbitrationActivity.this.webView.evaluateJavascript("javascript:htmlHistoryBcak()", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity$3$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        this.f$0.m403x6123ad72((String) obj);
                    }
                });
            } else {
                ArbitrationActivity.this.finish();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0014 A[Catch: all -> 0x0016, DONT_GENERATE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0014, B:8:0x000f), top: B:14:0x0003, inners: #0 }] */
        /* renamed from: lambda$onClick$0$com-fendasz-moku-planet-ui-activity-ArbitrationActivity$3, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        /* synthetic */ void m403x6123ad72(java.lang.String r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 == 0) goto L14
                boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                if (r1 == 0) goto L14
                com.fendasz.moku.planet.ui.activity.ArbitrationActivity r1 = com.fendasz.moku.planet.ui.activity.ArbitrationActivity.this     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                r1.finish()     // Catch: java.lang.Exception -> Lf java.lang.Throwable -> L16
                goto L14
            Lf:
                com.fendasz.moku.planet.ui.activity.ArbitrationActivity r1 = com.fendasz.moku.planet.ui.activity.ArbitrationActivity.this     // Catch: java.lang.Throwable -> L16
                r1.finish()     // Catch: java.lang.Throwable -> L16
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
                return
            L16:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L16
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.AnonymousClass3.m403x6123ad72(java.lang.String):void");
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new AnonymousClass3());
    }

    private void initLlOptionsListener(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView) {
        RelativeLayout relativeLayout = this.mRlOptionsContainer;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ArbitrationActivity.this.mRlOptionsContainer.setVisibility(8);
                }
            });
        }
        LinearLayout linearLayout4 = this.mLlOptions;
        if (linearLayout4 != null) {
            linearLayout4.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ArbitrationActivity.this.saveBitmap("保存成功", "保存失败");
                    if (ArbitrationActivity.this.mRlOptionsContainer != null) {
                        ArbitrationActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                }
            });
        }
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ArbitrationActivity.this.mRlOptionsContainer != null) {
                        ArbitrationActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                    ArbitrationActivity.this.showQrCodeScanTipDialog(new Action() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.7.1
                        @Override // com.fendasz.moku.planet.interf.functions.Action
                        public void run() throws Exception {
                            ArbitrationActivity.this.saveBitmap("图片已保存", "图片保存失败");
                            if (WeChatUtils.openWeChatQrCode(ArbitrationActivity.this.mContext)) {
                                return;
                            }
                            Toast.makeText(ArbitrationActivity.this.mContext, "请先安装微信", 0).show();
                        }
                    });
                }
            });
        }
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ArbitrationActivity.this.mRlOptionsContainer != null) {
                        ArbitrationActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                    ArbitrationActivity.this.showQrCodeScanTipDialog(new Action() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.8.1
                        @Override // com.fendasz.moku.planet.interf.functions.Action
                        public void run() throws Exception {
                            ArbitrationActivity.this.saveBitmap("图片已保存", "图片保存失败");
                            if (TextUtils.isEmpty(ArbitrationActivity.this.currentUrl)) {
                                return;
                            }
                            LogUtils.log(ArbitrationActivity.TAG, "开始打开浏览器，链接：" + ArbitrationActivity.this.currentUrl);
                            SystemUtils.openBrowser(ArbitrationActivity.this.mContext, ArbitrationActivity.this.currentUrl);
                        }
                    });
                }
            });
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ArbitrationActivity.this.mRlOptionsContainer != null) {
                        ArbitrationActivity.this.mRlOptionsContainer.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBitmap(String str, String str2) {
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            if (StorageUtils.saveBitmap(this.mContext, bitmap, "screenShot_" + System.currentTimeMillis() + PictureMimeType.JPG)) {
                Toast.makeText(this.mContext, str, 0).show();
            } else {
                Toast.makeText(this.mContext, str2, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQrCodeScanTipDialog(final Action action) {
        final SharedPreferencesUtils sharedPreferencesUtils = SharedPreferencesUtils.getInstance(this.mContext);
        if (sharedPreferencesUtils.getBoolean(this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), true)) {
            new CustomBuildDialog.DialogBuilder(this.mContext).setCancelable(false).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(this.mContext.getString(R.string.moku_dialog_detail_text_qr_code_scan_tip)).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.10
                @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                    sharedPreferencesUtils.putBoolean(ArbitrationActivity.this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), false);
                    customBuildDialog.dismiss();
                    try {
                        action.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).create().show();
            return;
        }
        try {
            action.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.activity.ArbitrationActivity$11, reason: invalid class name */
    class AnonymousClass11 extends MokuJsObjectListenerImpl {
        AnonymousClass11(Context context) {
            super(context);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void openPhoneAlbum(int i) {
            super.openPhoneAlbum(i);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (ArbitrationActivity.this.lastOpenAlbumTime == 0 || jCurrentTimeMillis - ArbitrationActivity.this.lastOpenAlbumTime >= 300) {
                ArbitrationActivity.this.lastOpenAlbumTime = jCurrentTimeMillis;
                Intent intent = new Intent();
                if (Build.VERSION.SDK_INT < 19) {
                    intent.setAction("android.intent.action.GET_CONTENT");
                } else {
                    intent.setAction("android.intent.action.OPEN_DOCUMENT");
                }
                intent.setType(SelectMimeType.SYSTEM_IMAGE);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.addCategory("android.intent.category.OPENABLE");
                try {
                    ((ArbitrationActivity) ArbitrationActivity.this.mContext).startActivityForResult(intent, i);
                } catch (Exception unused) {
                    Log.d(ArbitrationActivity.TAG, "no activity found");
                }
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void resubmit(int i, String str, int i2) {
            Intent intent;
            super.resubmit(i, str, i2);
            if (i2 == 1) {
                intent = new Intent(ArbitrationActivity.this, (Class<?>) GameTaskDetailActivity.class);
            } else if (i2 == 2) {
                intent = new Intent(ArbitrationActivity.this, (Class<?>) RewardTaskDetailActivity.class);
            } else {
                intent = new Intent(ArbitrationActivity.this, (Class<?>) TaskDetailActivity.class);
            }
            intent.putExtra("taskDataId", i);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("gateType", str);
            }
            intent.putExtra("operationType", 101);
            ArbitrationActivity.this.startActivityForResult(intent, 200);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public String taskDataId() {
            return String.valueOf(ArbitrationActivity.this.taskDataId);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public Integer taskSubmitRecordId() {
            return Integer.valueOf(ArbitrationActivity.this.taskRecordId);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void showArbitrationMessage(String str) {
            super.showArbitrationMessage(str);
            ArbitrationActivity.this.setResult(600);
            finish();
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void onImageClick(String str, final boolean z) {
            super.onImageClick(str, z);
            ImageUtils.getInstance().setImageView(ArbitrationActivity.this.mContext, str, new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.11.1
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(Bitmap bitmap) throws Exception {
                    new ViewImageDialog.Builder(ArbitrationActivity.this.mContext).setBitmap(bitmap).setIsMiniProgrammer(z).isReward(true).create().show();
                }
            }, null, null);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        public void onImageLongClick(String str, final boolean z) {
            super.onImageLongClick(str, z);
            ArbitrationActivity.this.mRlOptionsContainer.setVisibility(0);
            ArbitrationActivity.this.mLlWeChat.setVisibility(4);
            ArbitrationActivity.this.mLlBrowser.setVisibility(4);
            ImageUtils.getInstance().setImageView(ArbitrationActivity.this.mContext, str, new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.11.2
                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                public void accept(final Bitmap bitmap) throws Exception {
                    ArbitrationActivity.this.mRlOptionsContainer.setVisibility(0);
                    ArbitrationActivity.this.currentBitmap = bitmap;
                    if (z) {
                        LogUtils.log(ArbitrationActivity.TAG, "is mini programmer");
                        ArbitrationActivity.this.mLlWeChat.setVisibility(0);
                        ArbitrationActivity.this.mLlBrowser.setVisibility(0);
                    }
                    new Thread(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.11.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ArbitrationActivity.this.currentUrl = QrCodeUtils.parseQrCode(bitmap);
                        }
                    }).start();
                }
            }, null, null);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl, com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
        public void deleteArbitrationImage(int i) {
            super.deleteArbitrationImage(i);
            if (ArbitrationActivity.this.fileMap.containsKey(Integer.valueOf(i))) {
                ArbitrationActivity.this.fileMap.remove(Integer.valueOf(i));
            }
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void submitArbitrament(int i, String str) {
            super.submitArbitrament(i, str);
            ArrayList arrayList = new ArrayList();
            Iterator it = ArbitrationActivity.this.fileMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((File) ((Map.Entry) it.next()).getValue());
            }
            ApiDataHelper.getApiDataHelper().arbitrament(ArbitrationActivity.this.mContext, i, arrayList, str, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity.11.3
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i2, String str2) throws Exception {
                    try {
                        ArbitrationActivity.this.setResult(600);
                        ArbitrationActivity.this.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i2, String str2) throws Exception {
                    Toast.makeText(ArbitrationActivity.this.mContext, str2, 0).show();
                }
            });
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void setTitle(String str) {
            super.setTitle(str);
            ArbitrationActivity.this.mTvTitle.getCenterTextView().setText(str);
        }

        @Override // com.fendasz.moku.planet.common.MokuJsObjectListenerImpl
        protected void notifyH5Token(int i, String str) {
            super.notifyH5Token(i, str);
            if (Build.VERSION.SDK_INT >= 19) {
                ArbitrationActivity.this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback() { // from class: com.fendasz.moku.planet.ui.activity.ArbitrationActivity$11$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        Log.d(ArbitrationActivity.TAG, (String) obj);
                    }
                });
            } else {
                ArbitrationActivity.this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
            }
        }
    }

    private void initMokuJsLisetener() {
        this.mokuJsListener = new AnonymousClass11(this);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.webView.removeAllViews();
        this.webView.destroy();
        MokuJsObjectListenerImpl mokuJsObjectListenerImpl = this.mokuJsListener;
        if (mokuJsObjectListenerImpl != null) {
            mokuJsObjectListenerImpl.finish();
        }
        super.onDestroy();
    }
}
