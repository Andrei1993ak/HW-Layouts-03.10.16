package com.gmail.a93ak.andrei19.vk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class IcButton extends Button {

    private OnClickListener onClickListener;
    private OnClickListener mineClickListener;
    private Drawable leftIconOnClick;
    private Drawable leftIcon;
    private Drawable topIcon;
    private Drawable bottomIcon;
    private Drawable rightIcon;


    public IcButton(final Context context) {
        super(context, null, R.attr.icButtonStyle);
    }

    public IcButton(final Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.icButtonStyle);
        init(attrs, R.attr.icButtonStyle);
    }

    public IcButton(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, R.attr.icButtonStyle);
        init(attrs, defStyleAttr);
    }

    public IcButton(final Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, R.attr.icButtonStyle);
        init(attrs, defStyleAttr);
    }

    private void init(final AttributeSet attrs, final int defStyleAttr) {

        TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.IcButtonStyle, defStyleAttr, 0);
        try {
            final AppCompatDrawableManager drawableManager = AppCompatDrawableManager.get();


            rightIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_rightIcon);
            int id = a.getResourceId(R.styleable.IcButtonStyle_rightIcon, -1);
            if (id != -1) {
                rightIcon = drawableManager.getDrawable(getContext(), id);
            }

            topIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_topIcon);
            id = a.getResourceId(R.styleable.IcButtonStyle_topIcon, -1);
            if (id != -1) {
                topIcon = drawableManager.getDrawable(getContext(), id);
            }

            leftIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_leftIcon);
            id = a.getResourceId(R.styleable.IcButtonStyle_leftIcon, -1);
            if (id != -1) {
                leftIcon = drawableManager.getDrawable(getContext(), id);
            }


            bottomIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_bottomIcon);
            id = a.getResourceId(R.styleable.IcButtonStyle_bottomIcon, -1);
            if (id != -1) {
                bottomIcon = drawableManager.getDrawable(getContext(), id);
            }

            leftIconOnClick = a.getDrawableIfKnown(R.styleable.IcButtonStyle_onClickLeftIcon);
            id = a.getResourceId(R.styleable.IcButtonStyle_onClickLeftIcon, -1);
            if (id != -1) {
                leftIconOnClick = drawableManager.getDrawable(getContext(), id);
            }

            setCompoundDrawablesWithIntrinsicBounds(leftIcon, topIcon, rightIcon, bottomIcon);

        } finally {
            a.recycle();
        }

        mineClickListener = new OnClickListener() {

            @Override
            public void onClick(final View v) {
                setCompoundDrawablesWithIntrinsicBounds(leftIconOnClick, null, null, null);
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
            }
        };
        setOnClickListener(mineClickListener);

    }

    @Override
    public void setOnClickListener(final OnClickListener l) {
        if (l.equals(mineClickListener)) {
            super.setOnClickListener(l);
        } else {
            onClickListener = l;
        }
    }

}