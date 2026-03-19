package com.sigmob.sdk.base.common;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.an;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.windad.WindAds;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class am {
    private static final b a = new b() { // from class: com.sigmob.sdk.base.common.am.1
        @Override // com.sigmob.sdk.base.common.am.b
        public void a(String url, al urlAction) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void b(String url, al lastFailedUrlAction) {
        }
    };
    private static final c b = new c() { // from class: com.sigmob.sdk.base.common.am.2
        @Override // com.sigmob.sdk.base.common.am.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.c
        public void b() {
        }

        @Override // com.sigmob.sdk.base.common.am.c
        public void c() {
        }
    };
    private final EnumSet<al> c;
    private final b d;
    private final b e;
    private final c f;
    private final BaseAdUnit g;
    private final boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    /* renamed from: com.sigmob.sdk.base.common.am$3, reason: invalid class name */
    class AnonymousClass3 implements an.a {
        final /* synthetic */ al a;
        final /* synthetic */ Context b;
        final /* synthetic */ am c;
        final /* synthetic */ Uri d;
        final /* synthetic */ String e;

        AnonymousClass3(final al val$followDeepLink, final Context val$context, final am val$finalUrlHandler, final Uri val$deeplinkUri, final String val$finalHandleUrL) {
            this.a = val$followDeepLink;
            this.b = val$context;
            this.c = val$finalUrlHandler;
            this.d = val$deeplinkUri;
            this.e = val$finalHandleUrL;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, al alVar) {
            try {
                am.this.d.b(str, alVar);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, al alVar) {
            try {
                am.this.d.a(str, alVar);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, al alVar) {
            try {
                am.this.d.b(str, alVar);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, al alVar) {
            try {
                am.this.d.a(str, alVar);
            } catch (Throwable unused) {
            }
        }

        @Override // com.sigmob.sdk.base.common.an.a
        public void a(final String resolvedUrl) {
            final al alVar = this.a;
            if (!resolvedUrl.toLowerCase().startsWith(com.alipay.sdk.m.l.a.r)) {
                alVar = al.FOLLOW_DEEP_LINK;
            }
            try {
                alVar.a(this.b, Uri.parse(resolvedUrl), this.c, am.this.g);
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.am$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(resolvedUrl, alVar);
                    }
                });
            } catch (Exception unused) {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.am$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(resolvedUrl, alVar);
                    }
                });
            }
        }

        @Override // com.sigmob.sdk.base.common.an.a
        public void a(String message, Throwable throwable) {
            try {
                this.a.a(this.b, this.d, this.c, am.this.g);
                Handler handler = WindAds.sharedAds().getHandler();
                final String str = this.e;
                final al alVar = this.a;
                handler.post(new Runnable() { // from class: com.sigmob.sdk.base.common.am$3$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(str, alVar);
                    }
                });
            } catch (Exception unused) {
                Handler handler2 = WindAds.sharedAds().getHandler();
                final String str2 = this.e;
                final al alVar2 = this.a;
                handler2.post(new Runnable() { // from class: com.sigmob.sdk.base.common.am$3$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(str2, alVar2);
                    }
                });
            }
        }
    }

    public static class a {
        private EnumSet<al> a = EnumSet.of(al.NOOP);
        private b b = am.a;
        private b c = am.a;
        private c d = am.b;
        private boolean e = false;
        private boolean f = false;
        private BaseAdUnit g;

        public a a(final al first, final al... others) {
            this.a = EnumSet.of(first, others);
            return this;
        }

        public a a(final b resultActions) {
            this.b = resultActions;
            return this;
        }

        public a a(final c sigmobSchemeListener) {
            this.d = sigmobSchemeListener;
            return this;
        }

        public a a(final BaseAdUnit adunit) {
            this.g = adunit;
            return this;
        }

        public a a(boolean skip) {
            this.e = skip;
            return this;
        }

        public am a() {
            return new am(this.a, this.b, this.c, this.d, this.e, this.g, this.f);
        }

        public a b(final b resultActions) {
            this.c = resultActions;
            return this;
        }

        public a b(boolean enable) {
            this.f = enable;
            return this;
        }
    }

    public interface b {
        void a(final String url, final al urlAction);

        void b(final String url, final al lastFailedUrlAction);
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    private am(final EnumSet<al> supportedUrlActions, final b resultActions, final b deepLinkResultActions, final c sigmobSchemeListener, final boolean skipShowSigmobBrowser, final BaseAdUnit adUnit, final boolean withoOutresolvedUrl) {
        this.c = EnumSet.copyOf((EnumSet) supportedUrlActions);
        this.d = resultActions;
        this.e = deepLinkResultActions;
        this.f = sigmobSchemeListener;
        this.h = skipShowSigmobBrowser;
        this.g = adUnit;
        this.i = false;
        this.j = false;
        this.k = withoOutresolvedUrl;
    }

    private void a(String url, al urlAction, String message, Throwable throwable) {
        Preconditions.NoThrow.checkNotNull(message);
        if (urlAction == null) {
            urlAction = al.NOOP;
        }
        SigmobLog.d(message, throwable);
        this.d.b(url, urlAction);
    }

    private boolean b(final Context context, String url) {
        al alVar = al.NOOP;
        Iterator it = this.c.iterator();
        final String strMacroProcess = null;
        while (it.hasNext()) {
            final al alVar2 = (al) it.next();
            String strA = alVar2.a(this.g);
            if (!TextUtils.isEmpty(url) && this.g.getInteractionType() != 7) {
                strA = url;
            }
            if (!TextUtils.isEmpty(strA)) {
                strMacroProcess = this.g.getMacroCommon().macroProcess(strA);
                try {
                    Uri uri = Uri.parse(strMacroProcess);
                    AndroidMarket androidMarket = this.g.getAndroidMarket();
                    if (alVar2 != al.FOLLOW_DEEP_LINK || !uri.getScheme().equalsIgnoreCase("market") || androidMarket == null || TextUtils.isEmpty(androidMarket.market_url)) {
                        if (alVar2.a(uri, this.g.getInteractionType())) {
                            if (!this.k && al.OPEN_WITH_BROWSER == alVar2) {
                                an.a(strMacroProcess, new AnonymousClass3(alVar2, context, this, uri, strMacroProcess));
                                return true;
                            }
                            alVar2.a(context, uri, this, this.g);
                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.am.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    am.this.d.a(strMacroProcess, alVar2);
                                }
                            });
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                    this.d.b(strMacroProcess, alVar2);
                }
            }
        }
        try {
            a(strMacroProcess, alVar, "Link ignored. Unable to handle url: ", null);
            return false;
        } catch (Throwable th) {
            SigmobLog.e("handleResolvedUrl eroor", th);
            return false;
        }
    }

    c a() {
        return this.f;
    }

    public void a(final Context context, String url) {
        Preconditions.NoThrow.checkNotNull(context);
        b(context, url);
    }

    boolean b() {
        return this.h;
    }
}
