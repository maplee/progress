package com.wind.process.progrss.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wind.process.progrss.R;

/**
 * Created by jiagf on 2016/9/9.
 */
public class ProgressButton extends RelativeLayout {

    private RelativeLayout viewRoot;
    private TextView progressTv;
    private ProgressBar progressBar;
    private Builder builder;

    public ProgressButton(Context context) {
        super(context);
        initViews();
    }

    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();

    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    public class Builder {
        private String text;
        private int progress;
        private int progressDrawable;
        private int textSize;

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setProgress(int progress) {
            this.progress = progress;
            return this;
        }

        public Builder setProgressDrawable(int progressDrawable) {
            this.progressDrawable = progressDrawable;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder finish(){
            return finish(R.drawable.download_finished);
        }

        public Builder finish(int progressDrawable){
            this.progressDrawable = progressDrawable;
            return this;
        }

        public void invalidate() {
            if (text != null) {
                progressTv.setText(text);
            }
            if (textSize != 0) {
                progressTv.setTextSize(textSize);
            }
            if (progressDrawable != 0) {
                progressBar.setProgressDrawable(getContext().getResources().getDrawable(progressDrawable));
            }
            if (progress != 0) {
                progressBar.setProgress(progress);
                if(progressBar.getVisibility() != View.VISIBLE){
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        }

    }




    private void initViews() {
        builder = new Builder();
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.album, defStyleAttr, 0);
//        try {
//            int width = a.getLayoutDimension(R.styleable.album_android_layout_width, -1);
//            int height = a.getLayoutDimension(R.styleable.album_android_layout_height, -2);
//            Log.d(TAG, "AlbumView: " + width + " " + height);
//        } finally {
//            a.recycle();
//        }
        viewRoot = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_progress_button, null);
        addView(viewRoot, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        progressBar = (ProgressBar) viewRoot.findViewById(R.id.view_progress_button_pb);
        progressTv = (TextView) viewRoot.findViewById(R.id.view_progress_button_tv);
        progressTv.setText("下载");
    }

    public Builder getBuilder() {
        return builder;
    }

    public Builder setText(String text) {
        builder.setText(text);
        return builder;
    }

    public Builder setProgress(int progress) {
        builder.setProgress(progress);
        return builder;
    }

    public Builder setProgressDrawable(int progressDrawable) {
        builder.setProgressDrawable(progressDrawable);
        return builder;
    }

    public Builder setTextSize(int textSize) {
        builder.setTextSize(textSize);
        return builder;
    }




}
