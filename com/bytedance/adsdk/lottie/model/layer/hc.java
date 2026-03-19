package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.component.video.api.d;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.jh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends h {
    private final Runnable e;
    private float gb;
    private final Handler k;
    private volatile boolean mk;
    private TextureView mq;
    private com.bykv.vk.openvk.component.video.d.c.c tc;
    private float tt;
    private LottieAnimationView uo;

    public hc(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, final Context context) {
        super(gbVar, gbVar2);
        this.gb = -1.0f;
        this.tt = -1.0f;
        this.k = new Handler(Looper.getMainLooper());
        this.e = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.hc.4
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.uo != null) {
                    hc.this.uo.invalidate();
                }
                hc.this.k.postDelayed(hc.this.e, 40L);
            }
        };
        if (this.h == null || gbVar == null || context == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewHc = gbVar.hc();
        this.uo = lottieAnimationViewHc;
        if (lottieAnimationViewHc == null) {
            return;
        }
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        this.gb = (int) (this.h.d() * fD);
        this.tt = (int) (this.h.hc() * fD);
        JSONObject jSONObject = null;
        jh jhVarYi = gbVar.yi();
        if (jhVarYi != null) {
            String strD = jhVarYi.d(this.h.mq());
            if (!TextUtils.isEmpty(strD)) {
                try {
                    jSONObject = new JSONObject(strD);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
        }
        if (jSONObject != null) {
            final String strOptString = jSONObject.optString("file_hash");
            final String strOptString2 = jSONObject.optString("video_url");
            jSONObject.optString("video_duration");
            jSONObject.optString("resolution");
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            TextureView textureView = new TextureView(context);
            this.mq = textureView;
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.bytedance.adsdk.lottie.model.layer.hc.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    hc.this.d(strOptString2, strOptString, context, surfaceTexture);
                    hc.this.w();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    hc.this.k();
                    surfaceTexture.release();
                    hc.this.cb();
                    return true;
                }
            });
            this.uo.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.hc.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (hc.this.uo == view) {
                        if (hc.this.hc()) {
                            hc.this.uo.removeOnAttachStateChangeListener(this);
                        } else {
                            hc.this.d(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.hc.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    hc.this.e();
                                }
                            });
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (hc.this.uo == view) {
                        hc.this.d(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.hc.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent parent = hc.this.mq.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).removeView(hc.this.mq);
                                }
                            }
                        });
                    }
                }
            });
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        k();
        com.bykv.vk.openvk.component.video.d.c.c cVar = new com.bykv.vk.openvk.component.video.d.c.c("uttie");
        this.tc = cVar;
        cVar.d(surfaceTexture);
        this.tc.d(new d.InterfaceC0158d() { // from class: com.bytedance.adsdk.lottie.model.layer.hc.3
            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void b(com.bykv.vk.openvk.component.video.api.d dVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, int i, int i2, int i3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void hc(com.bykv.vk.openvk.component.video.api.d dVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void hc(com.bykv.vk.openvk.component.video.api.d dVar) {
                hc.this.mk = true;
                dVar.b(true);
            }

            @Override // com.bykv.vk.openvk.component.video.api.d.InterfaceC0158d
            public void d(com.bykv.vk.openvk.component.video.api.d dVar, com.bykv.vk.openvk.component.video.api.b.hc hcVar) {
                com.bytedance.sdk.component.utils.mq.c("uttie-video", hcVar.d() + ":" + hcVar.hc() + ":" + hcVar.b());
            }
        });
        com.bykv.vk.openvk.component.video.api.b.b bVar = new com.bykv.vk.openvk.component.video.api.b.b();
        bVar.b(str);
        bVar.u(str2);
        this.tc.d(new com.bykv.vk.openvk.component.video.api.b.c(com.bytedance.adsdk.lottie.u.hc.hc(context), bVar, null, 0, 0));
        this.tc.d(true);
        this.tc.d(true, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.tc != null) {
            if (this.mk) {
                this.tc.c();
            }
            this.tc.u();
            this.tc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewParent parent = this.mq.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mq);
        }
        ViewParent parent2 = this.uo.getParent();
        if (parent2 instanceof ViewGroup) {
            this.mq.setTranslationX(2.1474836E9f);
            ((ViewGroup) parent2).addView(this.mq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        this.k.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        cb();
        if (this.uo != null) {
            this.k.postDelayed(this.e, 40L);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.h, com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        if (this.gb <= 0.0f || this.mq == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        d(i);
        float fGb = gb();
        d(this.mq, (int) this.gb, (int) this.tt);
        this.mq.setAlpha(fGb);
        this.mq.draw(canvas);
        canvas.restore();
    }

    private static void d(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
