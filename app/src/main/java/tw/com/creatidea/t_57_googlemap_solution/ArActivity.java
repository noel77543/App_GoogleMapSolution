package tw.com.creatidea.t_57_googlemap_solution;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by noel on 2017/12/12.
 */

public class ArActivity extends AppCompatActivity{
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        ButterKnife.bind(this);
    }

}
