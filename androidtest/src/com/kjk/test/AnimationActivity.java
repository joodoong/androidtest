package com.kjk.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class AnimationActivity extends Activity {

	FrameLayout layoutAni;
	ImageView imgAniRing;
	
	int currentSubAniNum;
	ImageView imgSub1;
	ImageView imgSub2;
	ImageView imgSub3;
	AnimationSet aniSub1;
	AnimationSet aniSub2;
	AlphaAnimation aniSub3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation);
		
		layoutAni = (FrameLayout) findViewById(R.id.layoutAni);
		imgAniRing = (ImageView) findViewById(R.id.imgAniRing);
		
		currentSubAniNum = 2;
		
		imgSub1 = null;
		imgSub2 = null;
		imgSub3 = null;
		
		ScaleAnimation scaleAniSub1 = new ScaleAnimation(0.3f, 1, 0.3f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAniSub1.setDuration(3000);
		AlphaAnimation alphaAniSub1 = new AlphaAnimation(1, 0);
		alphaAniSub1.setDuration(3000);
		aniSub1 = new AnimationSet(true);
		aniSub1.addAnimation(scaleAniSub1);
		aniSub1.addAnimation(alphaAniSub1);
		aniSub1.setFillAfter(true);
		
		ScaleAnimation scaleAniSub2 = new ScaleAnimation(0.3f, 1, 0.3f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAniSub2.setDuration(3000);
		AlphaAnimation alphaAniSub2 = new AlphaAnimation(1, 0);
		alphaAniSub2.setDuration(3000);
		aniSub2 = new AnimationSet(true);
		aniSub2.addAnimation(scaleAniSub2);
		aniSub2.addAnimation(alphaAniSub2);
		aniSub2.setFillAfter(true);
		
		aniSub3 = new AlphaAnimation(0, 0);
		aniSub3.setDuration(1500);
		aniSub3.setFillAfter(true);
		aniSub3.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
			}
			@Override
			public void onAnimationRepeat(Animation arg0) {
			}
			@Override
			public void onAnimationEnd(Animation arg0) {
				if (currentSubAniNum == 1) {
					currentSubAniNum = 2;
					if (imgSub2 == null) {
						imgSub2 = new ImageView(AnimationActivity.this);
						imgSub2.setLayoutParams(imgAniRing.getLayoutParams());
						imgSub2.setImageResource(R.drawable.img_ring);
						layoutAni.addView(imgSub2);
					}
					imgSub2.startAnimation(aniSub2);
				} else {
					currentSubAniNum = 1;
					if (imgSub1 == null) {
						imgSub1 = new ImageView(AnimationActivity.this);
						imgSub1.setLayoutParams(imgAniRing.getLayoutParams());
						imgSub1.setImageResource(R.drawable.img_ring);
						layoutAni.addView(imgSub1);
					}
					imgSub1.startAnimation(aniSub1);
				}
			}
		});
		
		ScaleAnimation scaleAni = new ScaleAnimation(0.3f, 1, 0.3f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAni.setDuration(3000);
		scaleAni.setRepeatCount(-1);
		AlphaAnimation alphaAni = new AlphaAnimation(1, 0);
		alphaAni.setDuration(3000);
		alphaAni.setRepeatCount(-1);
		AnimationSet aniSet = new AnimationSet(true);
		aniSet.addAnimation(scaleAni);
		aniSet.addAnimation(alphaAni);
		scaleAni.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				imgSub3 = new ImageView(AnimationActivity.this);
				imgSub3.setLayoutParams(imgAniRing.getLayoutParams());
				imgSub3.setImageResource(R.drawable.img_ring);
				layoutAni.addView(imgSub3);
				imgSub3.startAnimation(aniSub3);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				imgSub3.startAnimation(aniSub3);
			}
			@Override
			public void onAnimationEnd(Animation animation) {
			}
		});
		imgAniRing.setAnimation(aniSet);
		
		
	}
}
