package com.duoyou.task.sdk.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.duoyou.task.pro.a.a;
import com.duoyou.task.pro.f.c;
import com.duoyou.task.pro.g.b;
import com.duoyou.task.pro.g.k;
import com.duoyou.task.pro.g.m;
import com.duoyou.task.pro.g.n;
import com.duoyou.task.sdk.PlayGameActivity;
import com.duoyou.task.sdk.R;
import com.duoyou.task.sdk.WebViewActivity;
import com.duoyou.task.sdk.entity.GameInfo;
import com.duoyou.task.sdk.utis.ShortcutReceiver;
import com.duoyou.task.sdk.view.dialog.MyAlertDialog;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.image.ImageOptions;
import com.duoyou.task.sdk.xutils.x;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class GameBottomDialog extends Dialog {
    private Activity activity;
    private View bottomLayout;
    private Drawable gameIconBitmap;
    private GameInfo gameInfo;
    private Handler handler;
    private OnGameBottomListener onGameBottomListener;
    private View parentLayout;
    private int screenOrientation;
    private WebView webView;

    public interface OnGameBottomListener {
        void onBindPhoneListener();

        void onRefreshListener();
    }

    public GameBottomDialog(Activity activity, GameInfo gameInfo, int i) {
        super(activity, R.style.dyDialogStyle);
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && GameBottomDialog.this.webView != null && GameBottomDialog.this.activity != null && !GameBottomDialog.this.activity.isFinishing() && GameBottomDialog.this.isShowing()) {
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    Object obj = message.obj;
                    n.a(GameBottomDialog.this.webView, String.format("onProgress('%s',%d,%d)", obj != null ? obj.toString() : "", Integer.valueOf(i2), Integer.valueOf(i3)));
                }
                return false;
            }
        });
        this.activity = activity;
        this.gameInfo = gameInfo;
        this.screenOrientation = i;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        initWindowParams();
        super.onCreate(bundle);
        setContentView(R.layout.dy_game_bottom_layout);
        initView();
        initBottomLayout();
        initData();
        initWebViewSettings(this.webView);
    }

    private void initView() {
        this.parentLayout = findViewById(R.id.dy_parent_layout);
        this.bottomLayout = findViewById(R.id.dy_bottom_layout);
        this.webView = (WebView) findViewById(R.id.dy_web_view);
        this.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GameBottomDialog.this.dismiss();
            }
        });
    }

    private void initWindowParams() {
        try {
            Window window = getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i = this.screenOrientation;
            if (i == 1) {
                attributes.windowAnimations = R.style.dyBottomInAndOutStyle;
                attributes.gravity = 81;
                attributes.width = b.a(getContext(), 340.0f);
                attributes.height = b.a(getContext(), 280.0f);
            } else if (i == 2) {
                attributes.windowAnimations = R.style.dyLeftInAndOutStyle;
                attributes.gravity = 3;
                attributes.width = b.a(getContext(), 340.0f);
                attributes.height = -1;
            } else {
                attributes.windowAnimations = R.style.dyBottomInAndOutStyle;
                attributes.gravity = 80;
                attributes.width = -1;
                attributes.height = b.a(getContext(), 280.0f);
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
            getWindow().setFlags(1024, 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initBottomLayout() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bottomLayout.getLayoutParams();
        int i = this.screenOrientation;
        if (i == 1) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.bottomLayout.setBackgroundResource(R.drawable.dy_coner_16_all_bg);
        } else if (i == 2) {
            layoutParams.height = -1;
            layoutParams.width = b.a(getContext(), 340.0f);
            this.bottomLayout.setBackgroundResource(R.drawable.dy_corner_16_bg);
        } else {
            layoutParams.height = b.a(getContext(), 280.0f);
            layoutParams.width = -1;
            this.bottomLayout.setBackgroundResource(R.drawable.dy_corner_16_bg);
        }
        this.bottomLayout.setLayoutParams(layoutParams);
    }

    private void initWebViewSettings(WebView webView) {
        n.a(webView);
        webView.addJavascriptInterface(new JavascriptInterfaceImpl(this.activity, this.handler), "dysdk");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
    }

    private void initData() {
        String strA = c.a("51/play.html", k.a(getContext(), "en", 1));
        String str = this.gameInfo.taskParams;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("?")) {
                strA = strA + str;
            } else {
                strA = strA + "?" + str;
            }
        }
        this.webView.loadUrl(strA);
    }

    public class JavascriptInterfaceImpl extends a {
        public JavascriptInterfaceImpl(Activity activity, Handler handler) {
            super(activity, handler);
        }

        @JavascriptInterface
        public void createShortcut() {
            ((a) this).activity.runOnUiThread(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.JavascriptInterfaceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    GameBottomDialog.this.dismiss();
                    GameBottomDialog gameBottomDialog = GameBottomDialog.this;
                    gameBottomDialog.shortcut(gameBottomDialog.gameInfo);
                }
            });
        }

        @JavascriptInterface
        public void startWebView(final String str) {
            ((a) this).activity.runOnUiThread(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.JavascriptInterfaceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    GameBottomDialog.this.dismiss();
                    WebViewActivity.a(((a) JavascriptInterfaceImpl.this).activity, str);
                }
            });
        }

        @JavascriptInterface
        public void dismiss() {
            ((a) this).activity.runOnUiThread(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.JavascriptInterfaceImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    GameBottomDialog.this.dismiss();
                }
            });
        }

        @JavascriptInterface
        public void refresh() {
            ((a) this).activity.runOnUiThread(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.JavascriptInterfaceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    GameBottomDialog.this.dismiss();
                    if (GameBottomDialog.this.onGameBottomListener != null) {
                        GameBottomDialog.this.onGameBottomListener.onRefreshListener();
                    }
                }
            });
        }

        @JavascriptInterface
        public int isSupportShortcut() {
            return GameBottomDialog.this.isRequestPinShortcutSupported();
        }

        @JavascriptInterface
        public void callBindMobileWindow() {
            GameBottomDialog.this.dismiss();
            if (GameBottomDialog.this.onGameBottomListener != null) {
                GameBottomDialog.this.onGameBottomListener.onBindPhoneListener();
            }
        }
    }

    public void shortcut(final GameInfo gameInfo) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (isRequestPinShortcutSupported() != 1) {
                m.b(getContext(), "当前手机暂不支持添加快捷方式");
                return;
            }
            if (isShortcutExists(gameInfo.gameId)) {
                m.b(getContext(), "快捷方式已存在，请返回桌面查看");
                return;
            }
            Drawable drawable = this.gameIconBitmap;
            if (drawable != null) {
                createShortcutWithBitmap(gameInfo, drawable);
            } else {
                LoadingUtils.showLoading(this.activity);
                x.image().loadDrawable(gameInfo.gameIcon, ImageOptions.DEFAULT, new Callback.CommonCallback<Drawable>() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.3
                    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
                    public void onCancelled(Callback.CancelledException cancelledException) {
                    }

                    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
                    public void onFinished() {
                    }

                    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
                    public void onSuccess(Drawable drawable2) {
                        LoadingUtils.hideLoading();
                        GameBottomDialog.this.gameIconBitmap = drawable2;
                        GameBottomDialog gameBottomDialog = GameBottomDialog.this;
                        gameBottomDialog.createShortcutWithBitmap(gameInfo, gameBottomDialog.gameIconBitmap);
                    }

                    @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
                    public void onError(Throwable th, boolean z) {
                        LoadingUtils.hideLoading();
                        m.b(GameBottomDialog.this.getContext(), com.duoyou.task.pro.f.b.b(th));
                    }
                });
            }
        }
    }

    private boolean isShortcutExists(String str) {
        List<ShortcutInfo> pinnedShortcuts;
        if (Build.VERSION.SDK_INT < 26 || (pinnedShortcuts = ((ShortcutManager) getContext().getSystemService("shortcut")).getPinnedShortcuts()) == null) {
            return false;
        }
        for (ShortcutInfo shortcutInfo : pinnedShortcuts) {
            if (!TextUtils.isEmpty(str) && str.equals(shortcutInfo.getId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int isRequestPinShortcutSupported() {
        return (Build.VERSION.SDK_INT < 26 || !((ShortcutManager) getContext().getSystemService("shortcut")).isRequestPinShortcutSupported()) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createShortcutWithBitmap(GameInfo gameInfo, Drawable drawable) {
        Intent intent = new Intent(this.activity, (Class<?>) PlayGameActivity.class);
        intent.putExtra("gameInfoString", gameInfo.jsonString);
        intent.setAction("android.intent.action.VIEW");
        ShortcutInfo shortcutInfoBuild = new ShortcutInfo.Builder(this.activity, gameInfo.gameId).setIcon(Icon.createWithBitmap(((BitmapDrawable) drawable).getBitmap())).setShortLabel(gameInfo.gameName).setIntent(intent).build();
        PlayGameActivity.B = false;
        ShortcutReceiver.a = false;
        final ShortcutManager shortcutManager = (ShortcutManager) getContext().getSystemService("shortcut");
        Intent intent2 = new Intent(getContext(), (Class<?>) ShortcutReceiver.class);
        intent2.setAction("com.duoyou.action.SHORTCUT_RECEIVER");
        shortcutManager.requestPinShortcut(shortcutInfoBuild, PendingIntent.getBroadcast(this.activity, 1, intent2, 67108864).getIntentSender());
        this.handler.postDelayed(new Runnable() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.4
            @Override // java.lang.Runnable
            public void run() {
                List<ShortcutInfo> pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                int iA = k.a(GameBottomDialog.this.getContext(), "shortcut_count", 0);
                if (pinnedShortcuts != null && pinnedShortcuts.size() > 0 && iA - pinnedShortcuts.size() <= 2) {
                    k.b(GameBottomDialog.this.getContext(), "shortcut_count", pinnedShortcuts.size());
                }
                if (!PlayGameActivity.B && pinnedShortcuts != null && pinnedShortcuts.size() > 0) {
                    k.b(GameBottomDialog.this.getContext(), "shortcut_count", pinnedShortcuts.size());
                    return;
                }
                if (ShortcutReceiver.a && pinnedShortcuts != null && pinnedShortcuts.size() > 0) {
                    k.b(GameBottomDialog.this.getContext(), "shortcut_count", pinnedShortcuts.size());
                    m.b(GameBottomDialog.this.getContext(), "快捷方式创建成功，请返回桌面查看");
                    return;
                }
                if (pinnedShortcuts != null && pinnedShortcuts.size() > iA) {
                    k.b(GameBottomDialog.this.getContext(), "shortcut_count", pinnedShortcuts.size());
                    m.b(GameBottomDialog.this.getContext(), "快捷方式创建成功，请返回桌面查看");
                    return;
                }
                MyAlertDialog.Builder builder = new MyAlertDialog.Builder(GameBottomDialog.this.activity);
                builder.setPositiveColor("#4AB3DE");
                builder.setMessage("请把桌面快捷方式设置为“允许”");
                builder.setOnPositiveListener("确定", new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.4.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.h(GameBottomDialog.this.activity, GameBottomDialog.this.activity.getPackageName());
                    }
                });
                builder.setOnNegativeListener("再玩一玩", new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.GameBottomDialog.4.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
                builder.show();
            }
        }, 500L);
    }

    public static GameBottomDialog show(Activity activity, GameInfo gameInfo, int i) {
        GameBottomDialog gameBottomDialog = new GameBottomDialog(activity, gameInfo, i);
        DialogSafeUtils.showDialogSafely(activity, gameBottomDialog);
        return gameBottomDialog;
    }

    public void setOnGameBottomListener(OnGameBottomListener onGameBottomListener) {
        this.onGameBottomListener = onGameBottomListener;
    }
}
