package com.bytedance.android.openliveplugin.stub.activity;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformProxyActivity;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.api.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class StubActivity {

    public static class Activity_Portrait extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.hc
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    public static class Activity_Portrait2 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.hc
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    public static class Activity_Portrait3 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.hc
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    public static class Activity_Portrait4 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.hc
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    public static class Activity_Portrait5 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.hc
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    static class SuperActivity extends ZeusPlatformProxyActivity {
        Handler handler;

        SuperActivity() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void execAsyncCheckReport() {
            LivePluginHelper.sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                    if (liveRoomService == null || SuperActivity.this.mTargetActivity == null) {
                        return;
                    }
                    try {
                        liveRoomService.callExpandMethod("report_window_focus_change", JavaCallsUtils.getField(SuperActivity.this, "mToken"), SuperActivity.this.mTargetActivity.getClass().getCanonicalName());
                    } catch (Throwable th) {
                        an.d(th);
                    }
                }
            });
        }

        @Override // com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.hc
        public String getPluginPkgName() {
            return LivePluginHelper.LIVE_PLUGIN_PACKAGE_NAME;
        }

        @Override // com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z) {
                return;
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.handler.post(new Runnable() { // from class: com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    SuperActivity.this.execAsyncCheckReport();
                }
            });
        }
    }
}
