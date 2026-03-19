package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.hc;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, hc {
    private static final ArrayList<b> b = new ArrayList<>();
    private hc.d c;
    private WeakReference<d> d;
    private b hc;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hc
    public View getView() {
        return this;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hc
    public void d(d dVar) {
        this.d = new WeakReference<>(dVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<b> it = b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.d() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.hc);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hc
    public void d(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<d> weakReference = this.d;
        if (weakReference != null && weakReference.get() != null) {
            this.d.get().d(surfaceHolder);
        }
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<d> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().d(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<d> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().hc(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(hc.d dVar) {
        this.c = dVar;
    }
}
