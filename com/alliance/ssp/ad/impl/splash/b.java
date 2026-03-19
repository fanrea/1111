package com.alliance.ssp.ad.impl.splash;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.l.d;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMSplashAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends Handler {
    public final /* synthetic */ NMSplashAdImpl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(NMSplashAdImpl nMSplashAdImpl, Looper looper) {
        super(looper);
        this.a = nMSplashAdImpl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        NMSplashAdImpl nMSplashAdImpl = this.a;
        if (!nMSplashAdImpl.j) {
            int i = nMSplashAdImpl.a1 + 100;
            nMSplashAdImpl.a1 = i;
            if (i < 3000) {
                nMSplashAdImpl.k1.sendEmptyMessageDelayed(0, 100L);
                return;
            }
            if (nMSplashAdImpl.e1) {
                nMSplashAdImpl.q("", "", nMSplashAdImpl.h);
            }
            this.a.u();
            this.a.a("素材加载超时", 100006, "1", "加载超时导致素材不可用");
            this.a.x1 = NMSplashAdImpl.SPLASH_STATE.ERROR;
            return;
        }
        ViewGroup viewGroup = nMSplashAdImpl.F0;
        int i2 = l.a;
        nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.RENDERING;
        View view = null;
        if (nMSplashAdImpl.h == null || viewGroup == null) {
            nMSplashAdImpl.a("Show failure", 100006, "2", "container is null");
            nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.ERROR;
        } else {
            Context contextA = com.alliance.ssp.ad.o0.b.a(nMSplashAdImpl.f);
            if (contextA == null) {
                nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.ERROR;
            } else {
                View viewInflate = LayoutInflater.from(contextA).inflate(R.layout.layout_nmssp_ad_splash, (ViewGroup) null, false);
                if (viewInflate == null) {
                    viewInflate = null;
                } else {
                    nMSplashAdImpl.M0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_splash_image_view);
                    nMSplashAdImpl.K0 = (FrameLayout) viewInflate.findViewById(R.id.fl_nm_splash_video_view);
                    nMSplashAdImpl.P0 = (TextView) viewInflate.findViewById(R.id.tv_nm_splash_count_down);
                    nMSplashAdImpl.N0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_splash_logo);
                    nMSplashAdImpl.O0 = (FrameLayout) viewInflate.findViewById(R.id.iv_nm_splash_audio_switch);
                    nMSplashAdImpl.H0 = (FrameLayout) viewInflate.findViewById(R.id.xml_splash_fl_shake_container);
                    nMSplashAdImpl.I0 = (FrameLayout) viewInflate.findViewById(R.id.fl_nm_splash_swipe_container);
                    nMSplashAdImpl.J0 = (FrameLayout) viewInflate.findViewById(R.id.xml_splash_six_element_container);
                    nMSplashAdImpl.G0 = (FrameLayout) viewInflate.findViewById(R.id.xml_splash_fl_download);
                    nMSplashAdImpl.Q0 = (TextView) viewInflate.findViewById(R.id.xml_splash_tv_shake_download_tittle);
                }
                if (viewInflate == null) {
                    nMSplashAdImpl.a("Show failure", 100006, "2", "layout view is null");
                    nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.ERROR;
                } else {
                    viewInflate.addOnAttachStateChangeListener(new a(nMSplashAdImpl));
                    nMSplashAdImpl.a(contextA);
                    nMSplashAdImpl.a(viewInflate);
                    try {
                        if (nMSplashAdImpl.Y0 == 1) {
                            d.b bVarA = new d.b().a(nMSplashAdImpl.J0, 1, false, 31);
                            Material material = nMSplashAdImpl.T0;
                            d dVar = bVarA.a;
                            dVar.c = contextA;
                            dVar.d = material;
                            dVar.e = new com.alliance.ssp.ad.z.d(nMSplashAdImpl);
                            bVarA.a();
                        } else {
                            nMSplashAdImpl.J0.setVisibility(8);
                            ImageView imageView = nMSplashAdImpl.N0;
                            if (imageView != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                                marginLayoutParams.bottomMargin = 16;
                                nMSplashAdImpl.N0.setLayoutParams(marginLayoutParams);
                            }
                        }
                    } catch (Exception e) {
                        e.getMessage();
                        int i3 = l.a;
                    }
                    if (nMSplashAdImpl.s1 != 2) {
                        nMSplashAdImpl.G0.getViewTreeObserver().addOnGlobalLayoutListener(new com.alliance.ssp.ad.z.b(nMSplashAdImpl, contextA));
                    }
                    TextView textView = nMSplashAdImpl.Q0;
                    if (textView != null && nMSplashAdImpl.Y0 == 1) {
                        textView.setText("点击下载 App 或跳转至第三方应用");
                    }
                    try {
                        if (nMSplashAdImpl.f1) {
                            nMSplashAdImpl.a(viewInflate, viewGroup);
                            nMSplashAdImpl.M0.setVisibility(0);
                            nMSplashAdImpl.O0.setVisibility(8);
                            nMSplashAdImpl.K0.setVisibility(8);
                        } else if (nMSplashAdImpl.e1) {
                            nMSplashAdImpl.b(viewInflate, viewGroup);
                            nMSplashAdImpl.M0.setVisibility(8);
                            nMSplashAdImpl.K0.setVisibility(0);
                            nMSplashAdImpl.O0.setVisibility(0);
                        }
                        nMSplashAdImpl.P0.setVisibility(0);
                        nMSplashAdImpl.a(nMSplashAdImpl.P0, 16);
                    } catch (Exception e2) {
                        new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 005: ")), (Exception) null);
                        nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.ERROR;
                    }
                    view = viewInflate;
                }
            }
        }
        if (view != null) {
            this.a.g(view);
        }
    }
}
