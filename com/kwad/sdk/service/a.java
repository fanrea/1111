package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.kwad.sdk.m.a {
    private com.kwad.sdk.c ckH;
    private Service ckJ;
    private final Map<String, Integer> ckI = new ConcurrentHashMap();
    private final HandlerC0632a ckK = new HandlerC0632a(this);

    private void h(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest serializableExtra = intent.getSerializableExtra("download_service_args_tag");
            Integer num = TextUtils.isEmpty(stringExtra) ? null : this.ckI.get(stringExtra);
            int iIntValue = num != null ? num.intValue() : 0;
            if (intExtra == 1) {
                this.ckI.put(stringExtra, Integer.valueOf(this.ckH.a(serializableExtra, (com.kwad.sdk.a) null)));
                return;
            }
            if (intExtra == 2) {
                this.ckH.pause(iIntValue);
                return;
            }
            if (intExtra == 3) {
                this.ckH.resume(iIntValue);
                return;
            }
            if (intExtra != 4) {
                return;
            }
            if (iIntValue != 0) {
                this.ckH.cancel(iIntValue);
                return;
            }
            String stringExtra2 = intent.getStringExtra("download_service_path");
            if (stringExtra2 != null) {
                com.kwad.sdk.c.dt(stringExtra2);
            }
        } catch (Exception unused) {
        }
    }

    public static void register() {
        c.g(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.ckJ = service;
        this.ckH = com.kwad.sdk.c.SL();
        this.ckK.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        h(intent);
        return super.onStartCommand(service, intent, i, i2);
    }

    /* renamed from: com.kwad.sdk.service.a$a, reason: collision with other inner class name */
    static class HandlerC0632a extends Handler {
        final WeakReference<a> ckL;

        public HandlerC0632a(a aVar) {
            this.ckL = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.ckL.get();
            if (aVar != null && message.what == 1) {
                if (aVar.ckH != null && aVar.ckH.SR()) {
                    aVar.ckJ.stopSelf();
                } else {
                    sendEmptyMessageDelayed(1, 30000L);
                }
            }
        }
    }
}
