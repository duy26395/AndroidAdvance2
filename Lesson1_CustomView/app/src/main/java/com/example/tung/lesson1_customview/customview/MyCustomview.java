package com.example.tung.lesson1_customview.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tung.lesson1_customview.R;

/**
 * Created by tung on 5/19/17.
 */

public class MyCustomview extends LinearLayout implements View.OnClickListener {

    private Button btnPrevious, btnNext;
    private TextView tv_value;

    private CharSequence[] mSpinnerValues = null;
    private int mSelectedIndex = -1;

    public MyCustomview(Context context) {
        super(context);
        initView(context);
    }

    public MyCustomview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyCustomview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.my_custom_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPrevious = (Button) findViewById(R.id.btn_previous);
        tv_value = (TextView) findViewById(R.id.tv_value);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        setSelectedIndex(0);
    }

    public CharSequence getSelectedValue(int index) {
        if (mSpinnerValues == null || mSpinnerValues.length == 0)
            return "";
        if (mSelectedIndex < 0 || mSelectedIndex >= mSpinnerValues.length)
            return "";

        return mSpinnerValues[mSelectedIndex];
    }

    public void setValues(CharSequence[] value) {
        this.mSpinnerValues = value;
        setSelectedIndex(0);
    }

    public int getSelectedIndex() {
        return mSelectedIndex;
    }

    public void setSelectedIndex(int index) {
        if (mSpinnerValues == null || mSpinnerValues.length == 0)
            return;
        if (index < 0 || index >= mSpinnerValues.length)
            return;

        mSelectedIndex = index;
        tv_value.setText(mSpinnerValues[index]);

        if (mSelectedIndex == 0)
            btnPrevious.setVisibility(INVISIBLE);
        else
            btnPrevious.setVisibility(VISIBLE);

        if (mSelectedIndex == mSpinnerValues.length - 1)
            btnNext.setVisibility(INVISIBLE);
        else
            btnNext.setVisibility(VISIBLE);
        mSelectedIndex = index;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (mSpinnerValues != null && mSelectedIndex < mSpinnerValues.length - 1) {
                    int newSelectedIndex = mSelectedIndex + 1;
                    setSelectedIndex(newSelectedIndex);
                }
                break;
            case R.id.btn_previous:
                if (mSelectedIndex > 0) {
                    int newSelectedIndex = mSelectedIndex - 1;
                    setSelectedIndex(newSelectedIndex);
                }
        }
    }
}
