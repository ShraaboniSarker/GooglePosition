package com.email.shraabonisarker06.googlepossition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.wangyuwei.particleview.ParticleView;

public class SplashActivity extends AppCompatActivity {

ParticleView mParticleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mParticleView =(ParticleView) findViewById(R.id.mparticle);
        mParticleView.startAnim();
        mParticleView.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(SplashActivity.this, MainActivity .class);
                startActivity(intent);
            }
        });
    }
}
