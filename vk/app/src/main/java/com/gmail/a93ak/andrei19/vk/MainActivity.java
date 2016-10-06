package com.gmail.a93ak.andrei19.vk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageViewRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Point displaySize = new Point();
        getWindowManager().getDefaultDisplay().getSize(displaySize);
        int size = displaySize.x <= displaySize.y ? displaySize.x : displaySize.y;
        ImageView imageView2 = (ImageView) findViewById(R.id.image2);
        ImageView imageView3 = (ImageView) findViewById(R.id.image3);
        imageView2.getLayoutParams().width = size;
        imageView3.getLayoutParams().width = size;

        Bitmap oldBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.foto_andrey);
        Bitmap blurredBitmap = BlurBuilder.blur(this, oldBitmap);

        FrameLayout frameViewWithphoto = (FrameLayout) findViewById(R.id.blur_layout);
        Drawable d = new BitmapDrawable(blurredBitmap);
        frameViewWithphoto.setBackgroundDrawable(d);

        imageViewRound = (ImageView) findViewById(R.id.round_image1);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ava_andrey);
        imageViewRound.setImageBitmap(icon);

    }


}
