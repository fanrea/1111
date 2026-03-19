package com.fc.tjcpl.sdk.n;

import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public class a extends Thread {
        public final /* synthetic */ CallBackFunction a;

        /* renamed from: com.fc.tjcpl.sdk.n.e$a$a, reason: collision with other inner class name */
        public class RunnableC0363a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0363a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onCallBack(this.a);
            }
        }

        public a(CallBackFunction callBackFunction) {
            this.a = callBackFunction;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String string;
            CustomViewContent customViewContent;
            super.run();
            try {
                string = new JSONObject(com.fc.tjcpl.sdk.b.a.a(e.this.a.a.a().getApplicationContext())).toString();
                customViewContent = e.this.a;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (customViewContent.j) {
                return;
            }
            customViewContent.b.post(new RunnableC0363a(string));
            e.this.a.k = false;
        }
    }

    public e(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        CustomViewContent customViewContent = this.a;
        if (customViewContent.k) {
            return;
        }
        customViewContent.k = true;
        new a(callBackFunction).start();
    }
}
