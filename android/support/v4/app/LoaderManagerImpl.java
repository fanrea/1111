package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.c;
import android.support.v4.content.b;
import android.support.v4.d.d;
import android.support.v4.d.l;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class LoaderManagerImpl extends c {
    static boolean DEBUG = false;
    private final LifecycleOwner A;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class a<D> extends MutableLiveData<D> implements b.a<D> {
        private LifecycleOwner A;
        private final android.support.v4.content.b<D> B;
        private b<D> C;
        private android.support.v4.content.b<D> D;
        private final int mId;

        @Override // android.arch.lifecycle.LiveData
        public final void onActive() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.B.startLoading();
        }

        @Override // android.arch.lifecycle.LiveData
        public final void onInactive() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.B.stopLoading();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        public final void removeObserver(Observer<? super D> observer) {
            super.removeObserver(observer);
            this.A = null;
            this.C = null;
        }

        final android.support.v4.content.b<D> f(boolean z) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.B.abandon();
            b<D> bVar = this.C;
            if (bVar != null) {
                removeObserver(bVar);
                bVar.reset();
            }
            this.B.a(this);
            this.B.reset();
            return this.D;
        }

        @Override // android.arch.lifecycle.MutableLiveData, android.arch.lifecycle.LiveData
        public final void setValue(D d) {
            super.setValue(d);
            android.support.v4.content.b<D> bVar = this.D;
            if (bVar != null) {
                bVar.reset();
                this.D = null;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            d.a(this.B, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b<D> implements Observer<D> {
        private final android.support.v4.content.b<D> B;
        private final c.a<D> E;
        private boolean F;

        @Override // android.arch.lifecycle.Observer
        public final void onChanged(D d) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.B + ": " + android.support.v4.content.b.dataToString(d));
            }
            this.F = true;
        }

        final void reset() {
            if (this.F && LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Resetting: " + this.B);
            }
        }

        public final String toString() {
            return this.E.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory G = new ViewModelProvider.Factory() { // from class: android.support.v4.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // android.arch.lifecycle.ViewModelProvider.Factory
            public final <T extends ViewModel> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private l<a> H = new l<>();
        private boolean I = false;

        LoaderViewModel() {
        }

        @Override // android.arch.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.H.size();
            for (int i = 0; i < size; i++) {
                this.H.valueAt(i).f(true);
            }
            this.H.clear();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a(this.A, sb);
        sb.append("}}");
        return sb.toString();
    }
}
