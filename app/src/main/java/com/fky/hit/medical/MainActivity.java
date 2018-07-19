package com.fky.hit.medical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mldn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          this.mldn = super.findViewById(R.id.mldn);
//        mldn.setOnClickListener(new OnClickListenerfade());
        mldn.setOnClickListener(new OnClickListenerSpeed());
    }

    private class OnClickListenerSpeed implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            AnimationSet set = new AnimationSet(true);
            TranslateAnimation tran = new TranslateAnimation(Animation.RELATIVE_TO_SELF
            ,0.0f,Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0.0f,
                    Animation.RELATIVE_TO_SELF,1.5f);
            ScaleAnimation scale = new ScaleAnimation(1,0.0f,
                    1,0.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0.5f);
            scale.setRepeatCount(3);
            set.setInterpolator(new AccelerateInterpolator());
            set.addAnimation(tran);
            set.addAnimation(scale);
            set.setDuration(2000);
            MainActivity.this.mldn.startAnimation(set);
        }
    }
    private class OnClickListenerfade implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            AnimationSet set = new AnimationSet(true);
            AlphaAnimation alpha = new AlphaAnimation(1,0);
            alpha.setDuration(300);
            set.addAnimation(alpha);
            MainActivity.this.mldn.startAnimation(set);
        }
    }
}
