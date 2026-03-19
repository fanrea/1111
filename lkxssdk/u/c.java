package lkxssdk.u;

import com.googlecode.mp4parser.util.Matrix;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c {
    public Matrix a = Matrix.ROTATE_0;
    public ArrayList<g> b = new ArrayList<>();
    public File c;

    public void a(int i) {
        Matrix matrix;
        if (i == 0) {
            matrix = Matrix.ROTATE_0;
        } else if (i == 90) {
            matrix = Matrix.ROTATE_90;
        } else if (i == 180) {
            matrix = Matrix.ROTATE_180;
        } else if (i != 270) {
            return;
        } else {
            matrix = Matrix.ROTATE_270;
        }
        this.a = matrix;
    }

    public void a(File file) {
        this.c = file;
    }
}
