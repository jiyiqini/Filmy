package tech.salroid.filmy.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.BindView;
import tech.salroid.filmy.R;
import tech.salroid.filmy.customs.BreathingProgress;

/*
 * Filmy Application for Android
 * Copyright (c) 2016 Sajal Gupta (http://github.com/salroid).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


public class FullScreenImage extends AppCompatActivity {

    @BindView(R.id.cen_img)
    ImageView centreimg;
    @BindView(R.id.breathingProgress)
    BreathingProgress breathingProgress;

    private String image_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        breathingProgress.setVisibility(View.VISIBLE);


        Intent intent = getIntent();
        if (intent != null) {
            image_url = intent.getStringExtra("img_url");
        }

        Glide.with(this)
                .load(image_url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        centreimg.setImageBitmap(resource);
                        breathingProgress.setVisibility(View.INVISIBLE);
                    }
                });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}