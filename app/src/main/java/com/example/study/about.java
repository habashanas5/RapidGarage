package com.example.study;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class about extends AppCompatActivity {
    ViewPager slideViewPager;
    LinearLayout dotIndicator;
    Button backButton, nextButton;
    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            setDotIndicator(position);
            if (position > 0) {
                backButton.setVisibility(View.VISIBLE);
            } else {
                backButton.setVisibility(View.INVISIBLE);
            }
            if (position == 6) {
                nextButton.setVisibility(View.INVISIBLE);
            } else {
                nextButton.setVisibility(View.VISIBLE);
                nextButton.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("About App");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#365096"));
        bar.setBackgroundDrawable(colorDrawable);
        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0) > 0) {
                    slideViewPager.setCurrentItem(getItem(-1), true);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0) < 6)
                    slideViewPager.setCurrentItem(getItem(1), true);
                else {
                    ReturnToMain();
                }
            }
        });

        slideViewPager = findViewById(R.id.slideViewPager);
        dotIndicator = findViewById(R.id.dotIndicator);

        viewPagerAdapter = new ViewPagerAdapter(this);
        slideViewPager.setAdapter(viewPagerAdapter);

        setDotIndicator(0);
        slideViewPager.addOnPageChangeListener(viewPagerListener);
    }

    public void ReturnToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


    public void setDotIndicator(int position) {
        dots = new TextView[7];
        dotIndicator.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(HtmlCompat.fromHtml("&#8226", HtmlCompat.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.grey, getApplicationContext().getTheme()));
            dotIndicator.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.myBlue, getApplicationContext().getTheme()));
    }

    private int getItem(int i) {
        return slideViewPager.getCurrentItem() + i;
    }

    private class ViewPagerAdapter extends PagerAdapter {
        Context context;
        int sliderAllImages[] = {
                R.drawable.iconforabout1,
                R.drawable.iconforabout2,
                R.drawable.iconforabout4,
                R.drawable.iconforabout5,
                R.drawable.iconforabout3,
                R.drawable.iconforabout6,
                R.drawable.iconforabout7,

        };
        int sliderAllTitle[] = {
                R.string.screen1,
                R.string.screen2,
                R.string.screen2,
                R.string.screen2,
                R.string.screen2,
                R.string.screen2,
                R.string.screen2,

        };
        int sliderAllDesc[] = {
                R.string.screen1desc,
                R.string.screen2desc,
                R.string.screen3desc,
                R.string.screen4desc,
                R.string.screen5desc,
                R.string.screen6desc,
                R.string.screen7desc,
        };

        public ViewPagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return sliderAllTitle.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.activity_slider_screen, container, false);

            ImageView sliderImage = view.findViewById(R.id.sliderImage);
            TextView sliderTitle = view.findViewById(R.id.sliderTitle);
            TextView sliderDesc = view.findViewById(R.id.sliderDesc);

            sliderImage.setImageResource(sliderAllImages[position]);
            sliderTitle.setText(sliderAllTitle[position]);
            sliderDesc.setText(sliderAllDesc[position]);

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
