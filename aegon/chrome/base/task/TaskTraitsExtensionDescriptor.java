package aegon.chrome.base.task;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface TaskTraitsExtensionDescriptor<Extension> {
    Extension fromSerializedData(byte[] bArr);

    int getId();

    byte[] toSerializedData(Extension extension);
}
