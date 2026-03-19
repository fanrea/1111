package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AdWebViewActivityProxy extends f {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    private static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.s.b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private boolean mHasShowShowConfirmDialog;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.a.a mLandPageViewListener = new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.a.a
        public final void rc() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void rd() {
            if (AdWebViewActivityProxy.this.mLandingPageView == null || !AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                if (!AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                    if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
                        return;
                    }
                    if (!AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                        if (!com.kwad.sdk.core.response.b.a.aS(e.eP(AdWebViewActivityProxy.this.mAdTemplate)) || com.kwad.components.core.s.a.sX().sY() != 1 || !com.kwad.components.core.s.a.sX().td() || com.kwad.components.core.s.a.sX().ta()) {
                            if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                                AdWebViewActivityProxy.this.showDialog();
                                return;
                            } else {
                                AdWebViewActivityProxy.this.finish();
                                return;
                            }
                        }
                        if (com.kwad.components.core.s.a.sX().sZ() || !com.kwad.sdk.core.config.e.Yc()) {
                            AdWebViewActivityProxy.this.finish();
                            return;
                        }
                        AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                        adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                        com.kwad.components.core.s.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                        return;
                    }
                    AdWebViewActivityProxy.this.finish();
                    return;
                }
                AdWebViewActivityProxy.this.finish();
                return;
            }
            AdWebViewActivityProxy.this.mLandingPageView.rm();
        }
    };
    private com.kwad.components.core.webview.tachikoma.f.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.f.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void G(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hn() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void he() {
            com.kwad.components.core.s.a.sX().aQ(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hm() {
            com.kwad.components.core.s.a.sX().aQ(false);
        }
    };

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    public static void register() {
        com.kwad.sdk.service.c.g(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.UY)) {
            return;
        }
        try {
            com.kwad.sdk.commercial.g.a.j(aVar.getAdTemplate(), aVar.rg(), aVar.rf());
            com.kwad.sdk.service.c.g(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(KEY_PAGE_TITLE, aVar.UX);
            intent.putExtra(KEY_LANDING_PAGE_TYPE, aVar.Vc);
            intent.putExtra(KEY_PAGE_URL, aVar.UY);
            intent.putExtra(KEY_IS_AUTO_SHOW, aVar.Vb);
            intent.putExtra(KEY_SHOW_PERMISSION, aVar.Va);
            intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, aVar.ri());
            AdResultData adResultDataEv = aVar.UZ;
            if (adResultDataEv == null) {
                adResultDataEv = com.kwad.sdk.core.response.b.c.ev(aVar.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ot().l(adResultDataEv));
            context.startActivity(intent);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            com.kwad.sdk.commercial.g.a.a(aVar.getAdTemplate(), aVar.rg(), aVar.rf(), bx.A(th));
            if (l.UL().TQ()) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
            throw th;
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0479a().aF(com.kwad.sdk.core.response.b.b.dk(adTemplate)).aE(adTemplate).rk());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.g.a.k(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        AdResultData adResultDataD = com.kwad.components.core.c.f.ot().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = adResultDataD;
        if (adResultDataD == null) {
            return false;
        }
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultDataD);
        this.mAdTemplate = adTemplateS;
        return adTemplateS != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
    }

    private void initContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        c cVarA = c.a(this.mContext, new a.C0479a().aE(this.mPageTitle).aF(this.mPageUrl).aE(this.mAdTemplate).aG(this.mShowPermission).aH(this.mAutoShow).aU(this.mLandingPageType).aI(this.mDisableShowConfirmDialog).rk());
        this.mLandingPageView = cVarA;
        cVarA.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        viewGroup.addView(this.mLandingPageView);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            com.kwad.components.core.s.b bVar = this.mDialogFragment;
            if (bVar != null) {
                bVar.dismiss();
                this.mDialogFragment = null;
            }
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            Dialog dialog2 = this.mKsExitInterceptDialogV2;
            if (dialog2 != null && dialog2.isShowing()) {
                this.mKsExitInterceptDialogV2.dismiss();
            }
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                adTemplate.interactLandingPageShowing = false;
                this.mAdTemplate.mIsForceJumpLandingPage = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.rm();
            return;
        }
        if (this.mDisableShowConfirmDialog) {
            finish();
            return;
        }
        if (handleMiddlePageDialog()) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || adTemplate.mIsForceJumpLandingPage) {
            super.onBackPressed();
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aS(e.eP(this.mAdTemplate)) && com.kwad.components.core.s.a.sX().sY() == 1 && com.kwad.components.core.s.a.sX().td() && !com.kwad.components.core.s.a.sX().ta()) {
            if (com.kwad.components.core.s.a.sX().sZ() || !com.kwad.sdk.core.config.e.Yc()) {
                super.onBackPressed();
                return;
            }
            com.kwad.components.core.s.b tkDialogFragment = getTkDialogFragment();
            this.mDialogFragment = tkDialogFragment;
            com.kwad.components.core.s.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
            return;
        }
        if (isFormAdExitInterceptEnable()) {
            try {
                if (this.mKsExitInterceptDialogV2 == null) {
                    this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0483a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
                        public final void a(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.r(AdWebViewActivityProxy.this.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
                        public final void b(DialogInterface dialogInterface) {
                            if (!AdWebViewActivityProxy.this.destroyed) {
                                try {
                                    AdWebViewActivityProxy.super.onBackPressed();
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.c.printStackTrace(th);
                                }
                            }
                            com.kwad.sdk.core.adlog.c.r(AdWebViewActivityProxy.this.mAdTemplate, 105);
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
                        public final void c(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.r(AdWebViewActivityProxy.this.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    });
                }
                com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
                this.mKsExitInterceptDialogV2.show();
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z = false;
        if (this.mAdTemplate == null || !com.kwad.sdk.core.config.e.Yc()) {
            return false;
        }
        if (!bq.isNullString(com.kwad.sdk.core.response.b.a.cD(this.mAdTemplate)) && com.kwad.sdk.core.response.b.a.cC(this.mAdTemplate)) {
            z = true;
            if (this.mHasShowShowConfirmDialog) {
                try {
                    super.onBackPressed();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            } else {
                com.kwad.components.core.s.b tkDialogFragment = getTkDialogFragment();
                this.mDialogFragment = tkDialogFragment;
                com.kwad.components.core.s.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                this.mHasShowShowConfirmDialog = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || e.P(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.e.Yk() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.e.Yl() && !this.mAdTemplate.mIsFromContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.s.b getTkDialogFragment() {
        e.b bVar = new e.b();
        bVar.a(this.mAdResultData);
        bVar.bo(com.kwad.sdk.core.response.b.b.ep(this.mAdTemplate));
        bVar.bf(false);
        bVar.bg(true);
        return com.kwad.components.core.s.b.a(bVar);
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0483a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.r(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.adlog.c.r(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.r(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    public static class a {
        private String UX;
        private String UY;
        private AdResultData UZ;
        private boolean Va;
        private boolean Vb;
        private int Vc;
        private boolean Vd;
        private AdTemplate adTemplate;

        /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adResultData, z, z2, z3, i);
        }

        /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adTemplate, z, z2, z3, i);
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adTemplate = adTemplate;
        }

        private a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.UZ = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
        }

        private a(String str, String str2, boolean z, boolean z2, boolean z3, int i) {
            this.UX = str;
            this.UY = str2;
            this.Va = z;
            this.Vb = z2;
            this.Vd = z3;
            this.Vc = i;
        }

        public final String re() {
            return this.UX;
        }

        public final String rf() {
            return this.UY;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final int rg() {
            return this.Vc;
        }

        public final boolean rh() {
            return this.Va;
        }

        public final boolean ri() {
            return this.Vd;
        }

        public final boolean rj() {
            return this.Vb;
        }

        /* renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a, reason: collision with other inner class name */
        public static class C0479a {
            private String UX;
            private String UY;
            private AdResultData UZ;
            private boolean Vb;
            private int Vc = 0;
            private boolean Vd;
            private boolean Ve;
            private AdTemplate adTemplate;

            public final C0479a aG(boolean z) {
                this.Ve = z;
                return this;
            }

            public final C0479a aU(int i) {
                this.Vc = i;
                return this;
            }

            public final C0479a aE(String str) {
                this.UX = str;
                return this;
            }

            public final C0479a aF(String str) {
                this.UY = str;
                return this;
            }

            public final C0479a q(AdResultData adResultData) {
                this.UZ = adResultData;
                return this;
            }

            public final C0479a aE(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }

            public final C0479a aH(boolean z) {
                this.Vb = z;
                return this;
            }

            public final C0479a aI(boolean z) {
                this.Vd = z;
                return this;
            }

            public final a rk() {
                if (this.UZ != null) {
                    return new a(this.UX, this.UY, this.UZ, this.Ve, this.Vb, this.Vd, this.Vc, (byte) 0);
                }
                return new a(this.UX, this.UY, this.adTemplate, this.Ve, this.Vb, this.Vd, this.Vc, (byte) 0);
            }
        }
    }
}
