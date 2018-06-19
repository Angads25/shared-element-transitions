package com.mikescamell.sharedelementtransitions.flash_fix.xml_activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mikescamell.sharedelementtransitions.GlideApp;
import com.mikescamell.sharedelementtransitions.R;

public class FlashFixXmlActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_fix_b);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        supportPostponeEnterTransition();

        TextView detailTextView = findViewById(R.id.flash_fix_activity_b_text);
        detailTextView.setText(getString(R.string.pig_blurb));

        ImageView imageView = findViewById(R.id.flash_fix_activity_b_imageView);

        GlideApp.with(this)
                .load(FlashFixXmlActivityA.PIG_PIC_URL)
                .centerCrop()
                .dontAnimate()
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .into(imageView);
    }
}