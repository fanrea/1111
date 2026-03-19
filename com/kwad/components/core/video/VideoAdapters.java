package com.kwad.components.core.video;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class VideoAdapters {

    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    public static abstract class a implements com.kwad.components.core.video.d {
        protected abstract void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2);

        @Override // com.kwad.components.core.video.d
        public final void a(final View view, View view2, int i, int i2) {
            AdaptType adaptType;
            if (!b(view, view2, i, i2)) {
                com.kwad.sdk.core.d.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i, i2);
            boolean z = dVar2.getRatio() >= 1.0f;
            boolean z2 = dVar.getRatio() >= 1.0f;
            if (z2 && z) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z2) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else if (z) {
                adaptType = AdaptType.LANDSCAPE_VERTICAL;
            } else {
                adaptType = AdaptType.LANDSCAPE_HORIZONTAL;
            }
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            if (C(view)) {
                view.post(new Runnable() { // from class: com.kwad.components.core.video.VideoAdapters.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setLayoutParams(layoutParams);
                    }
                });
            } else {
                view.setLayoutParams(layoutParams);
            }
        }

        private static boolean C(View view) {
            if (Build.VERSION.SDK_INT >= 18) {
                return view.isInLayout() || view.isLayoutRequested();
            }
            return false;
        }

        private static boolean b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float fUy;
            float fUz;
            float fUA = dVar.uA();
            float fUA2 = dVar2.uA();
            int i = AnonymousClass1.acP[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (fUA >= fUA2) {
                    fUz = dVar.uz();
                    fUy = fUz * fUA2;
                } else {
                    fUy = dVar.uy();
                    fUz = fUy / fUA2;
                }
            } else if (i == 3 || i == 4) {
                fUy = dVar.uz();
                fUz = fUy / fUA2;
            } else {
                fUy = 0.0f;
                fUz = -2.1474836E9f;
            }
            if (fUz == -2.1474836E9f || fUy == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) fUz;
                layoutParams.height = (int) fUy;
            } else {
                layoutParams.height = (int) fUz;
                layoutParams.width = (int) fUy;
            }
        }
    }

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] acP;

        static {
            int[] iArr = new int[AdaptType.values().length];
            acP = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                acP[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                acP[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                acP[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class b extends a {
        private float acS = 0.8f;
        private float acT = 0.9375f;
        private float acU = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float fUz;
            float f;
            float fUA = dVar.uA();
            float fUA2 = dVar2.uA();
            float fUz2 = dVar.uz();
            float fUy = dVar.uy();
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + fUy + ", " + fUz2);
            int i = AnonymousClass1.acP[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (fUA > fUA2) {
                    float fUy2 = dVar.uy();
                    float f2 = fUy2 / fUA2;
                    float f3 = fUz2 / f2;
                    float f4 = this.acS;
                    if (f3 >= f4) {
                        f = fUy2;
                        fUz = f2;
                    } else {
                        fUz = fUz2 / f4;
                        f = fUz * fUA2;
                    }
                } else {
                    fUz = dVar.uz();
                    f = fUA2 * fUz;
                    float f5 = fUy / f;
                    float f6 = this.acT;
                    if (f5 < f6) {
                        f = fUy / f6;
                        fUz = f / fUA2;
                    }
                }
            } else if (i == 3 || i == 4) {
                f = fUz2 * this.acU;
                fUz = f / fUA2;
            } else {
                fUz = -2.1474836E9f;
                f = -2.1474836E9f;
            }
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + fUz);
            if (f == -2.1474836E9f || fUz == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) fUz;
                layoutParams.height = (int) f;
            } else {
                layoutParams.height = (int) fUz;
                layoutParams.width = (int) f;
            }
        }
    }

    static class d {
        float acV;
        float height;
        float width;

        public d(float f, float f2) {
            this.acV = -1.0f;
            this.width = f;
            this.height = f2;
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.acV = f2 / f;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.acV;
        }

        public final float uy() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float uz() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float uA() {
            if (!isValid()) {
                return -1.0f;
            }
            float f = this.height;
            float f2 = this.width;
            return f > f2 ? f / f2 : f2 / f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.acV + '}';
        }
    }
}
