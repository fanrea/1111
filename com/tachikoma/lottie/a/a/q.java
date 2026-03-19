package com.tachikoma.lottie.a.a;

import android.graphics.Path;
import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class q implements m, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final boolean IO;
    private boolean IW;
    private final com.tachikoma.lottie.a.b.a<?, Path> Jy;
    private final String name;
    private final Path Iz = new Path();
    private b IV = new b();

    public q(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.IO = kVar.isHidden();
        this.Gt = gVar;
        this.Jy = kVar.lt().kB();
        aVar.a(this.Jy);
        this.Jy.b(this);
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        invalidate();
    }

    private void invalidate() {
        this.IW = false;
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.jX() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.IV.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        if (this.IW) {
            return this.Iz;
        }
        this.Iz.reset();
        if (this.IO) {
            this.IW = true;
            return this.Iz;
        }
        this.Iz.set(this.Jy.getValue());
        this.Iz.setFillType(Path.FillType.EVEN_ODD);
        this.IV.a(this.Iz);
        this.IW = true;
        return this.Iz;
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }
}
