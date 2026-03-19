package com.alliance.ssp.ad.api;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.a.a;
import com.alliance.ssp.ad.a.b;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.o0.s;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.x.c;
import com.alliance.ssp.ad.x.e;
import com.alliance.ssp.ad.x.g;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceNativeFeedAdData {
    private static final String TAG = "SAAllianceNativeFeedAdData: ";
    public SAAllianceAdData mAdData;
    public Material mMaterial;
    public c mNMNativeFeedAdImpl;
    public ImageView myImageView;
    public NMPlayerView playerView;
    private VideoController videoController;
    public boolean videoReady = false;
    public boolean firstMuteReport = false;
    public boolean firstPlayReport = false;
    public boolean videoPlayLoop = true;
    public boolean isVideoStop = false;

    public SAAllianceNativeFeedAdData(SAAllianceAdData sAAllianceAdData, c cVar) {
        this.mAdData = sAAllianceAdData;
        this.mNMNativeFeedAdImpl = cVar;
        this.mMaterial = sAAllianceAdData.getMaterial();
    }

    private void releaseVideo() {
        VideoController videoController = this.videoController;
        if (videoController != null) {
            videoController.g();
        }
    }

    public void destroy() {
        ImageView imageView = this.myImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.myImageView = null;
        }
        c cVar = this.mNMNativeFeedAdImpl;
        if (cVar != null) {
            cVar.p();
        }
        releaseVideo();
        this.mAdData = null;
        this.mNMNativeFeedAdImpl = null;
        this.mMaterial = null;
    }

    public String getApkName() {
        return this.mMaterial.getApkname();
    }

    public String getAppIntro() {
        return this.mMaterial.getAppIntro();
    }

    public String getAppPublisher() {
        return this.mMaterial.getAppPublisher();
    }

    public String getDesc() {
        return this.mMaterial.getDesc();
    }

    public String getECPM() {
        return this.mAdData.getPrice();
    }

    public String getIconUrl() {
        return this.mMaterial.getIconurl();
    }

    public List<String> getImgUrl() {
        return this.mMaterial.getImgurl();
    }

    public int getLdpType() {
        return this.mMaterial.getLdptype();
    }

    public Bitmap getLogoBitmap(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.nmadssp_logo_ad);
    }

    public Bitmap getLogoBitmapNoText(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.nmadssp_logo_gray);
    }

    public String getMainImageHeight() {
        return this.mMaterial.getH();
    }

    public String getMainImageWidth() {
        return this.mMaterial.getW();
    }

    public Material getMaterial() {
        return this.mMaterial;
    }

    public NMPlayerView getNmApAdVideo(Context context) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            this.mNMNativeFeedAdImpl.t();
            VideoController videoController = this.mNMNativeFeedAdImpl.R0;
            this.videoController = videoController;
            if (videoController == null) {
                int i = l.a;
                return null;
            }
            NMPlayerView nMPlayerView = new NMPlayerView(context, this.mNMNativeFeedAdImpl, this.mAdData, this.videoController);
            this.playerView = nMPlayerView;
            if (nMPlayerView.mListener != null) {
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m303x9d30ed24();
                    }
                });
            }
            this.videoController.b(0.0f);
            View view = this.mNMNativeFeedAdImpl.S0;
            if (view != null) {
                this.playerView.setVideoView(view);
            }
            return this.playerView;
        } catch (Exception e) {
            new f().a(0, 0, "004", a.a(e, b.a("SAAllianceNativeFeedAdData 001: ")), e);
            return null;
        }
    }

    public String getPermissionUrl() {
        return this.mMaterial.getPermissionUrl();
    }

    public String getPrivacyUrl() {
        return this.mMaterial.getPrivacyUrl();
    }

    public String getTitle() {
        return this.mMaterial.getTitle();
    }

    public String getVersionName() {
        return this.mMaterial.getVersionName();
    }

    public String getVideoUrl() {
        return this.mMaterial.getVideourl();
    }

    /* renamed from: lambda$getNmApAdVideo$0$com-alliance-ssp-ad-api-SAAllianceNativeFeedAdData, reason: not valid java name */
    /* synthetic */ void m303x9d30ed24() {
        this.playerView.mListener.onVideoLoading();
    }

    public void registerPACAViews(Activity activity, View view, ArrayList<View> arrayList, NMNativeADEventListener nMNativeADEventListener) throws JSONException, PackageManager.NameNotFoundException, IOException {
        c cVar = this.mNMNativeFeedAdImpl;
        cVar.getClass();
        int i = l.a;
        if (activity != null) {
            cVar.f = new WeakReference<>(activity);
        }
        if (cVar.E0) {
            cVar.v();
        }
        cVar.h.getMaterial();
        cVar.F0 = view;
        cVar.G0 = nMNativeADEventListener;
        if (arrayList != null && !arrayList.isEmpty()) {
            cVar.a1 = true;
        }
        if (Build.VERSION.SDK_INT >= 19 && view.isAttachedToWindow()) {
            cVar.a(view);
        }
        view.addOnAttachStateChangeListener(new e(cVar));
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next != null) {
                next.setOnTouchListener(new com.alliance.ssp.ad.x.f(cVar, new GestureDetector(new s(cVar))));
                next.setOnClickListener(new g(cVar));
                next.toString();
                int i2 = l.a;
            }
        }
    }
}
