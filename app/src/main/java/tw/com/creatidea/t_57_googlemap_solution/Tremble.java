package tw.com.creatidea.t_57_googlemap_solution;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by noel on 2017/8/16.
 */

public class Tremble extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();

        matrix.setTranslate((float) Math.sin(interpolatedTime * 80) * 12,
                (float) Math.sin(interpolatedTime * 80) * 12);
        // 第一個數值 ＝ 頻率，第二個數值 ＝ 振幅
        super.applyTransformation(interpolatedTime, t);

    }
}
