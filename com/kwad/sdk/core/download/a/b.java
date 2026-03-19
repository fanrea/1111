package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {

    public interface a {
        void onError(Throwable th);

        void onPreStart();

        void onStart();

        void onSuccess();

        void qd();

        boolean qe();
    }

    /* renamed from: com.kwad.sdk.core.download.a.b$b, reason: collision with other inner class name */
    public static class C0583b implements a {
        @Override // com.kwad.sdk.core.download.a.b.a
        public void onError(Throwable th) {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onSuccess() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void qd() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final boolean qe() {
            return false;
        }
    }

    public static int Q(Context context, String str) {
        return a(context, str, new C0583b());
    }

    public static int a(Context context, String str, a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            aVar.onPreStart();
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri uri = Uri.parse(str);
            h hVar = (h) ServiceProvider.get(h.class);
            int iDy = hVar != null ? hVar.dy(uri.getScheme()) : -1;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            com.kwad.sdk.core.d.c.d("DeepLinkUtil", "handleDeepLink: configFlags: " + iDy);
            if (iDy > 0) {
                intent.setFlags(iDy);
            } else {
                intent.setFlags(268435456);
            }
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                aVar.onStart();
                context.startActivity(intent);
                aVar.onSuccess();
                return 1;
            }
            aVar.qd();
            if (!aVar.qe()) {
                return 0;
            }
            aVar.onStart();
            context.startActivity(intent);
            aVar.onSuccess();
            return 1;
        } catch (Throwable th) {
            aVar.onError(th);
            return -1;
        }
    }
}
