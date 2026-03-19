package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Presenter {
    private Object cgq;
    private View mRootView;
    private final List<Presenter> cgp = new CopyOnWriteArrayList();
    private PresenterState cgr = PresenterState.INIT;

    protected void ay() {
    }

    protected void onCreate() {
    }

    protected void onDestroy() {
    }

    protected void onUnbind() {
    }

    public final void ak(View view) {
        try {
            this.cgr = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.cgr.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void K(Object obj) {
        try {
            if (this.cgr != PresenterState.INIT) {
                PresenterState presenterState = PresenterState.DESTROY;
            }
            if (this.cgr == PresenterState.BIND) {
                nC();
            }
            this.cgr = PresenterState.BIND;
            this.cgq = obj;
            ay();
            this.cgr.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void nC() {
        try {
            this.cgr = PresenterState.UNBIND;
            onUnbind();
            this.cgr.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void destroy() {
        try {
            if (this.cgr == PresenterState.BIND) {
                nC();
            }
            this.cgr = PresenterState.DESTROY;
            onDestroy();
            this.cgr.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void d(Presenter presenter) {
        this.cgp.add(presenter);
        if (!amd() || presenter.amd()) {
            return;
        }
        ak(this.mRootView);
    }

    public final void a(Presenter presenter, boolean z) {
        this.cgp.add(presenter);
        try {
            e(presenter);
        } catch (Throwable th) {
            d.gatherException(th);
            c.printStackTrace(th);
        }
    }

    private void e(Presenter presenter) {
        Object obj;
        View view;
        if (this.cgr.index() >= PresenterState.UNBIND.index() || presenter.cgr.index() >= PresenterState.UNBIND.index()) {
            return;
        }
        if (amd() && !presenter.amd() && (view = this.mRootView) != null) {
            presenter.ak(view);
        }
        if (!isBound() || !presenter.amd() || presenter.isBound() || (obj = this.cgq) == null) {
            return;
        }
        presenter.K(obj);
    }

    private boolean amd() {
        return this.cgr.index() >= PresenterState.CREATE.index();
    }

    private boolean isBound() {
        return this.cgr == PresenterState.BIND;
    }

    public final View getRootView() {
        return this.mRootView;
    }

    public final List<Presenter> ame() {
        return this.cgp;
    }

    public final Activity getActivity() {
        return m.fb(getContext());
    }

    public final Object amf() {
        return this.cgq;
    }

    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final <T extends View> T findViewById(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INIT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static abstract class PresenterState {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        abstract void performCallState(Presenter presenter);

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        static {
            int i = 0;
            PresenterState presenterState = new PresenterState("INIT", i, i) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = presenterState;
            int i2 = 1;
            PresenterState presenterState2 = new PresenterState("CREATE", i2, i2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.cgp.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).ak(presenter.mRootView);
                        } catch (Exception e) {
                            d.gatherException(e);
                            c.printStackTrace(e);
                        }
                    }
                }
            };
            CREATE = presenterState2;
            int i3 = 2;
            PresenterState presenterState3 = new PresenterState("BIND", i3, i3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.cgp.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).K(presenter.cgq);
                        } catch (Throwable th) {
                            d.gatherException(th);
                            c.printStackTrace(th);
                        }
                    }
                }
            };
            BIND = presenterState3;
            int i4 = 3;
            PresenterState presenterState4 = new PresenterState("UNBIND", i4, i4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.cgp.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).nC();
                        } catch (Exception e) {
                            d.gatherException(e);
                            c.printStackTrace(e);
                        }
                    }
                }
            };
            UNBIND = presenterState4;
            int i5 = 4;
            PresenterState presenterState5 = new PresenterState("DESTROY", i5, i5) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.cgp.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e) {
                            d.gatherException(e);
                            c.printStackTrace(e);
                        }
                    }
                }
            };
            DESTROY = presenterState5;
            $VALUES = new PresenterState[]{presenterState, presenterState2, presenterState3, presenterState4, presenterState5};
        }

        private PresenterState(String str, int i, int i2) {
            this.mIndex = i2;
        }

        public int index() {
            return this.mIndex;
        }
    }
}
