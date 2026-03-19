package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.view.video.OutputFileOptions;
import com.alipay.sdk.m.u.i;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class AutoValue_OutputFileOptions extends OutputFileOptions {
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final File file;
    private final ParcelFileDescriptor fileDescriptor;
    private final Metadata metadata;
    private final Uri saveCollection;

    private AutoValue_OutputFileOptions(File file, ParcelFileDescriptor parcelFileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, Metadata metadata) {
        this.file = file;
        this.fileDescriptor = parcelFileDescriptor;
        this.contentResolver = contentResolver;
        this.saveCollection = uri;
        this.contentValues = contentValues;
        this.metadata = metadata;
    }

    @Override // androidx.camera.view.video.OutputFileOptions
    File getFile() {
        return this.file;
    }

    @Override // androidx.camera.view.video.OutputFileOptions
    ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    @Override // androidx.camera.view.video.OutputFileOptions
    ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    @Override // androidx.camera.view.video.OutputFileOptions
    Uri getSaveCollection() {
        return this.saveCollection;
    }

    @Override // androidx.camera.view.video.OutputFileOptions
    ContentValues getContentValues() {
        return this.contentValues;
    }

    @Override // androidx.camera.view.video.OutputFileOptions
    public Metadata getMetadata() {
        return this.metadata;
    }

    public String toString() {
        return "OutputFileOptions{file=" + this.file + ", fileDescriptor=" + this.fileDescriptor + ", contentResolver=" + this.contentResolver + ", saveCollection=" + this.saveCollection + ", contentValues=" + this.contentValues + ", metadata=" + this.metadata + i.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OutputFileOptions)) {
            return false;
        }
        OutputFileOptions outputFileOptions = (OutputFileOptions) obj;
        File file = this.file;
        if (file != null ? file.equals(outputFileOptions.getFile()) : outputFileOptions.getFile() == null) {
            ParcelFileDescriptor parcelFileDescriptor = this.fileDescriptor;
            if (parcelFileDescriptor != null ? parcelFileDescriptor.equals(outputFileOptions.getFileDescriptor()) : outputFileOptions.getFileDescriptor() == null) {
                ContentResolver contentResolver = this.contentResolver;
                if (contentResolver != null ? contentResolver.equals(outputFileOptions.getContentResolver()) : outputFileOptions.getContentResolver() == null) {
                    Uri uri = this.saveCollection;
                    if (uri != null ? uri.equals(outputFileOptions.getSaveCollection()) : outputFileOptions.getSaveCollection() == null) {
                        ContentValues contentValues = this.contentValues;
                        if (contentValues != null ? contentValues.equals(outputFileOptions.getContentValues()) : outputFileOptions.getContentValues() == null) {
                            if (this.metadata.equals(outputFileOptions.getMetadata())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        File file = this.file;
        int iHashCode = ((file == null ? 0 : file.hashCode()) ^ 1000003) * 1000003;
        ParcelFileDescriptor parcelFileDescriptor = this.fileDescriptor;
        int iHashCode2 = (iHashCode ^ (parcelFileDescriptor == null ? 0 : parcelFileDescriptor.hashCode())) * 1000003;
        ContentResolver contentResolver = this.contentResolver;
        int iHashCode3 = (iHashCode2 ^ (contentResolver == null ? 0 : contentResolver.hashCode())) * 1000003;
        Uri uri = this.saveCollection;
        int iHashCode4 = (iHashCode3 ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        ContentValues contentValues = this.contentValues;
        return ((iHashCode4 ^ (contentValues != null ? contentValues.hashCode() : 0)) * 1000003) ^ this.metadata.hashCode();
    }

    static final class Builder extends OutputFileOptions.Builder {
        private ContentResolver contentResolver;
        private ContentValues contentValues;
        private File file;
        private ParcelFileDescriptor fileDescriptor;
        private Metadata metadata;
        private Uri saveCollection;

        Builder() {
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        OutputFileOptions.Builder setFile(File file) {
            this.file = file;
            return this;
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        OutputFileOptions.Builder setFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
            this.fileDescriptor = parcelFileDescriptor;
            return this;
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        OutputFileOptions.Builder setContentResolver(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
            return this;
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        OutputFileOptions.Builder setSaveCollection(Uri uri) {
            this.saveCollection = uri;
            return this;
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        OutputFileOptions.Builder setContentValues(ContentValues contentValues) {
            this.contentValues = contentValues;
            return this;
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        public OutputFileOptions.Builder setMetadata(Metadata metadata) {
            if (metadata == null) {
                throw new NullPointerException("Null metadata");
            }
            this.metadata = metadata;
            return this;
        }

        @Override // androidx.camera.view.video.OutputFileOptions.Builder
        public OutputFileOptions build() {
            String str = this.metadata == null ? " metadata" : "";
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_OutputFileOptions(this.file, this.fileDescriptor, this.contentResolver, this.saveCollection, this.contentValues, this.metadata);
        }
    }
}
