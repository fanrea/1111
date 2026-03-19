package aegon.chrome.base;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class ObservableSupplierImpl$$Lambda$1 implements Runnable {
    private final ObservableSupplierImpl arg$1;
    private final Object arg$2;
    private final Callback arg$3;

    private ObservableSupplierImpl$$Lambda$1(ObservableSupplierImpl observableSupplierImpl, Object obj, Callback callback) {
        this.arg$1 = observableSupplierImpl;
        this.arg$2 = obj;
        this.arg$3 = callback;
    }

    public static Runnable lambdaFactory$(ObservableSupplierImpl observableSupplierImpl, Object obj, Callback callback) {
        return new ObservableSupplierImpl$$Lambda$1(observableSupplierImpl, obj, callback);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObservableSupplierImpl.lambda$addObserver$0(this.arg$1, this.arg$2, this.arg$3);
    }
}
