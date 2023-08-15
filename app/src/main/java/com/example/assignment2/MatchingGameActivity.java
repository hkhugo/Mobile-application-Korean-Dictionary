package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MatchingGameActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnDragListener {
    private Button btn_pronunciation, btn_exit, btn_restart, btn_resume, btn_start, btn_play;
    private TextView tv_score, tv_time, tv_play;
    private FloatingActionButton fab;
    private ImageView iv_wm_times_up, iv_correct, iv_wrong, iv_title;
    private RelativeLayout rl, fab_rl;

    private int screenHeight, screenWidth;

    private RelativeLayout.LayoutParams params_btn_exit;

    // Timer
    private static final String FORMAT = "%02ds";
    private CountDownTimer cdt;
    private long timeLeft = 0;
    // ---

    private int score = 0;
    private int draggedAns = 0, correctAns = 0;
    private int QuestionNum = 0;
    private int[] appearedCatNum = new int[150], appearedCatSize = new int[150];

    // Game variable
    PhraseDB database = new PhraseDB(MatchingGameActivity.this);
    private String audioFileName;
    private MediaPlayer player, player_bgMusic;
    private final static int MAX_VOLUME = 100;
    private final float lowerVolume = 0.01f;
    private final float defaultVolume = 1f;
    private TextView tv_english, tv_korean1, tv_korean2, tv_korean3, tv_answer, tv_questionNum;
    // ---

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);

        initObject();
        check_display();
    }

    // Reference: https://github.com/thegenuinegourav/Drag-Drop-Best-Example-
    @Override
    public boolean onDrag(View v, DragEvent event) {
        if (event.getAction() == DragEvent.ACTION_DROP) {
            TextView dropped = (TextView) event.getLocalState();
            TextView dropTarget = (TextView) v;
            dropped.setVisibility(View.INVISIBLE);

            String text;

            dropTarget.setText(dropped.getText());
            text = dropTarget.getText().toString();

//            Log.d("text in onDrag", text);

            if (text.equals(tv_korean1.getText().toString())) {
//                tv_korean1.setVisibility(View.VISIBLE);
                draggedAns = 1;
            } else if (text.equals(tv_korean2.getText().toString())) {
//                tv_korean2.setVisibility(View.VISIBLE);
                draggedAns = 2;
            } else if (text.equals(tv_korean3.getText().toString())) {
//                tv_korean3.setVisibility(View.VISIBLE);
                draggedAns = 3;
            }

//            Log.d("DraggedAns", String.valueOf(draggedAns));

            if (draggedAns == correctAns) {
                AnimateSlideInOut(50, iv_correct, true, 250, screenWidth);
                AnimateSlideInOut(500, iv_correct, false, 250, screenWidth);
                score += 10;
                Log.d("Correct or not", "Correct");
            } else {
                AnimateSlideInOut(50, iv_wrong, true, 250, screenWidth);
                AnimateSlideInOut(500, iv_wrong, false, 250, screenWidth);
                Log.d("Correct or not", "Wrong");
            }

            tv_score.setText(String.valueOf(score));
            tv_answer.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            startNewGame();
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        } else
            return false;
    }
    // ---


    @Override
    protected void onDestroy() {
        super.onDestroy();
        player_bgMusic.stop();
    }

    @SuppressLint("ResourceAsColor")
    private void initObject() {
        btn_pronunciation = findViewById(R.id.btn_pronunciation);
        btn_restart = findViewById(R.id.btn_restart);
        btn_resume = findViewById(R.id.btn_resume);
        btn_exit = findViewById(R.id.btn_exit);
        btn_start = findViewById(R.id.btn_start);
        btn_play = findViewById(R.id.btn_play);
        fab = findViewById(R.id.fab);

        btn_pronunciation.setOnClickListener(this);
        btn_restart.setOnClickListener(this);
        btn_resume.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_play.setOnClickListener(this);

        tv_score = findViewById(R.id.tv_score);
        tv_time = findViewById(R.id.tv_time);
        tv_play = findViewById(R.id.tv_play);

        tv_questionNum = findViewById(R.id.tv_questionNum);
        tv_english = findViewById(R.id.tv_english);
        tv_answer = findViewById(R.id.tv_answer);
        tv_korean1 = findViewById(R.id.tv_korean1);
        tv_korean2 = findViewById(R.id.tv_korean2);
        tv_korean3 = findViewById(R.id.tv_korean3);

        tv_answer.setOnDragListener(this);
        tv_korean1.setOnTouchListener(this);
        tv_korean2.setOnTouchListener(this);
        tv_korean3.setOnTouchListener(this);

        iv_wm_times_up = findViewById(R.id.iv_wm_times_up);
        iv_correct = findViewById(R.id.iv_correct);
        iv_wrong = findViewById(R.id.iv_wrong);
        iv_correct.setVisibility(View.GONE);
        iv_wrong.setVisibility(View.GONE);
        iv_title = findViewById(R.id.iv_title);

        rl = findViewById(R.id.rl);
        fab_rl = findViewById(R.id.fab_rl);

        tv_play.setVisibility(View.GONE);
        iv_wm_times_up.setVisibility(View.GONE);
        setBtnGone();
        setGameContentGone();
        btn_pronunciation.setVisibility(View.GONE);
        btn_exit.setVisibility(View.VISIBLE);
        fab_rl.setVisibility(View.GONE);

        player_bgMusic = MediaPlayer.create(this, R.raw.bg_music);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pronunciation:
                player_bgMusic.setVolume(lowerVolume, lowerVolume);

                stopPlaying();
                player = MediaPlayer.create(MatchingGameActivity.this, getResources().getIdentifier(audioFileName, "raw", getPackageName()));

                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer player) {
//                        Log.d("player finish", "finish");
                        player_bgMusic.setVolume(defaultVolume, defaultVolume);
                    }
                });

                player.start();
                break;
            case R.id.btn_restart:
                restartGame();
                break;
            case R.id.btn_resume:
                resumeGame();
                break;
            case R.id.btn_exit:
                exitGame();
                break;
            case R.id.btn_start:
                startGame();
                break;
            case R.id.btn_play:
                if (tv_play.getVisibility() != View.GONE)
                    tv_play.setVisibility(View.GONE);
                else
                    tv_play.setVisibility(View.VISIBLE);
                break;
            case R.id.fab:
                if (btn_resume.getVisibility() == View.VISIBLE)
                    resumeGame();
                else
                    pauseGame();
                break;
        }
    }

    private void stopPlaying() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    private void setBtnGone() {
        btn_resume.setVisibility(View.GONE);
        btn_restart.setVisibility(View.GONE);
        btn_exit.setVisibility(View.GONE);
    }

    private void setBtnGoneAnim() {
        AnimateSlideInOut_Btn(50, btn_resume, false, 250, screenWidth);
        AnimateSlideInOut_Btn(50, btn_restart, false, 250, screenWidth);
        AnimateSlideInOut_Btn(50, btn_exit, false, 250, screenWidth);
    }

    private void setBtnVisibleAnim() {
        AnimateSlideInOut_Btn(50, btn_resume, true, 400, screenWidth);
        AnimateSlideInOut_Btn(150, btn_exit, true, 400, screenWidth);
        AnimateSlideInOut_Btn(250, btn_restart, true, 400, screenWidth);
    }

    private void setGameContentGone() {
        tv_questionNum.setVisibility(View.GONE);
        tv_english.setVisibility(View.GONE);
        tv_answer.setVisibility(View.GONE);
        tv_korean1.setVisibility(View.GONE);
        tv_korean2.setVisibility(View.GONE);
        tv_korean3.setVisibility(View.GONE);
        iv_correct.setVisibility(View.GONE);
        iv_wrong.setVisibility(View.GONE);
    }

    private void setGameContentVisible() {
        tv_questionNum.setVisibility(View.VISIBLE);
        tv_english.setVisibility(View.VISIBLE);
        tv_answer.setVisibility(View.VISIBLE);
        tv_korean1.setVisibility(View.VISIBLE);
        tv_korean2.setVisibility(View.VISIBLE);
        tv_korean3.setVisibility(View.VISIBLE);
    }

    private void startGame() {
        btn_start.setVisibility(View.GONE);
        btn_play.setVisibility(View.GONE);
        tv_play.setVisibility(View.GONE);
        btn_exit.setVisibility(View.GONE);
        iv_title.setVisibility(View.GONE);
        fab.setOnClickListener(this);
        btn_pronunciation.setVisibility(View.VISIBLE);
        fab_rl.setVisibility(View.VISIBLE);
        setGameContentVisible();

        player_bgMusic.start();

        // Convert px to dp
        Resources r = getResources();
        int px1 = Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 40, r.getDisplayMetrics()));
        // ---

        // Change the position of btn_exit
        params_btn_exit = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params_btn_exit.setMargins(0, px1, 0, px1);
        params_btn_exit.addRule(RelativeLayout.CENTER_IN_PARENT);
        btn_exit.setLayoutParams(params_btn_exit);
        //---

        startTimer(60000);
        startNewGame();
    }

    @SuppressLint("ResourceAsColor")
    private void startNewGame() {
        // Game Interaction start
        if (QuestionNum == 150) {
            pauseTimer();
            startTimer(0);
            return;
        }
        Boolean isRepeated = true;

        tv_korean1.setVisibility(View.VISIBLE);
        tv_korean2.setVisibility(View.VISIBLE);
        tv_korean3.setVisibility(View.VISIBLE);
        tv_answer.setText("Drag Your Answer Here");
        tv_answer.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);

        QuestionNum = QuestionNum + 1;
        final int randomAnsPos = new Random().nextInt(3) + 1; // random num between 1 - 3
        correctAns = randomAnsPos;
//        Log.d("CorrectAns", String.valueOf(correctAns));
        int randNum_catSize_Ans = 0, randNum_catNum_Ans = 0;
        int randNum_catSize1 = 0, randNum_catSize2 = 0, randNum_catNum1 = 0, randNum_catNum2 = 0;

        Random r1 = new Random();
        Random r2 = new Random();
        Random rAns = new Random();
        Random rAnsForCatNum = new Random();
        Random r1_Num = new Random();
        Random r2_Num = new Random();

        randNum_catNum1 = r1_Num.nextInt(22); // generate rand num between 0-21
        randNum_catNum2 = r2_Num.nextInt(22); // generate rand num between 0-21

        randNum_catSize1 = r1.nextInt(26); // generate rand num between 0-25
        randNum_catSize2 = r2.nextInt(26); // generate rand num between 0-25

        tv_questionNum.setText("Question - " + QuestionNum);

        // while loop below prevent the catSize larger then the array size, because catSize is vary between different categories
        while (isRepeated) {
            randNum_catNum_Ans = rAnsForCatNum.nextInt(22); // generate rand num between 0-21
            randNum_catSize_Ans = rAns.nextInt(26); // generate rand num between 0-25
            try {
                tv_english.setText("English:\n" + database.database[randNum_catNum_Ans][randNum_catSize_Ans].englishText);
                audioFileName = database.database[randNum_catNum_Ans][randNum_catSize_Ans].audioFileName;
//                Log.d("RandNum ans1 before", String.valueOf(randNum_catNum_Ans));
//                Log.d("RandNum ans2 before", String.valueOf(randNum_catSize_Ans));
                // Check if there is a repeated question, more repeated after more questions answered
                for (int i = 0; i < appearedCatNum.length; i++) {
                    if (randNum_catNum_Ans != appearedCatNum[i] || randNum_catNum_Ans != appearedCatSize[i]) { // ~A + ~B
                        isRepeated = false;
                    } else { // AB
//                        Log.d("RandNum ans error", "Repeated in " + i + " run");
                        isRepeated = true;
                        break;
                    }
                }
            } catch (NullPointerException e) {
                randNum_catSize_Ans = rAns.nextInt(26); // regenerate if too large for array size and cause exception
//                Log.d("English caught", "caught exception");
            }
        }

        appearedCatNum[QuestionNum - 1] = randNum_catNum_Ans;
        appearedCatSize[QuestionNum - 1] = randNum_catSize_Ans;
//        Log.d("RandNum ans1 after", String.valueOf(randNum_catNum_Ans));
//        Log.d("RandNum ans2 after", String.valueOf(randNum_catSize_Ans));

        Log.d("MatchingGameAns", String.valueOf(randomAnsPos)); // Show answer in Log for testing


        // check if any ans are the same, although the chance are very small
        while ((randNum_catNum1 == randNum_catNum2 && randNum_catSize1 == randNum_catSize2) || (randNum_catNum1 == randNum_catNum_Ans && randNum_catSize1 == randNum_catSize_Ans) || (randNum_catNum2 == randNum_catNum_Ans && randNum_catSize2 == randNum_catSize_Ans)) {
            randNum_catSize1 = r1.nextInt(26); // generate rand num between 0-25
            randNum_catSize2 = r2.nextInt(26); // generate rand num between 0-25
            randNum_catNum1 = r1_Num.nextInt(22);
            randNum_catNum2 = r2_Num.nextInt(22);
            Log.d("Two ans the same", "Yes");
        }

        // One of the tv will set to the same catNum, catSize as tv_english, because they are the it is the ans
        switch (randomAnsPos) {
            case 1: // Ans is in tv_korean1
                while (true) {
                    try {
                        tv_korean1.setText("Korean:\n" + database.database[randNum_catNum_Ans][randNum_catSize_Ans].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize_Ans = rAns.nextInt(26); // regenerate if too large
//                        Log.d("Ans caught", "caught exception");
                    }
                }

                while (true) {
                    try {
                        tv_korean2.setText("Korean:\n" + database.database[randNum_catNum1][randNum_catSize1].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize1 = r1.nextInt(26);
//                        Log.d("Size1 caught", "caught exception");
                    }
                }

                while (true) {
                    try {
                        tv_korean3.setText("Korean:\n" + database.database[randNum_catNum2][randNum_catSize2].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize2 = r2.nextInt(26);
//                        Log.d("Size2 caught", "caught exception");
                    }
                }
                break;

            case 2: // Ans is in tv_korean2
                while (true) {
                    try {
                        tv_korean1.setText("Korean:\n" + database.database[randNum_catNum1][randNum_catSize1].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize1 = r1.nextInt(26);
//                        Log.d("Size1 caught", "caught exception");
                    }
                }

                while (true) {
                    try {
                        tv_korean2.setText("Korean:\n" + database.database[randNum_catNum_Ans][randNum_catSize_Ans].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize_Ans = rAns.nextInt(26);
//                        Log.d("Ans caught", "caught exception");
                    }
                }

                while (true) {
                    try {
                        tv_korean3.setText("Korean:\n" + database.database[randNum_catNum2][randNum_catSize2].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize2 = r2.nextInt(26);
//                        Log.d("Size2 caught", "caught exception");
                    }
                }
                break;

            case 3: // Ans is in tv_korean3
                while (true) {
                    try {
                        tv_korean1.setText("Korean:\n" + database.database[randNum_catNum1][randNum_catSize1].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize1 = r1.nextInt(26);
//                        Log.d("Size1 caught", "caught exception");
                    }
                }

                while (true) {
                    try {
                        tv_korean2.setText("Korean:\n" + database.database[randNum_catNum2][randNum_catSize2].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize2 = r2.nextInt(26);
//                        Log.d("Size2 caught", "caught exception");
                    }
                }

                while (true) {
                    try {
                        tv_korean3.setText("Korean:\n" + database.database[randNum_catNum_Ans][randNum_catSize_Ans].koreanText);
                        break;
                    } catch (NullPointerException e) {
                        randNum_catSize_Ans = rAns.nextInt(26);
//                        Log.d("Ans caught", "caught exception");
                    }
                }
                break;
        }
    }

    private void pauseGame() {
        pauseTimer();
        setBtnVisibleAnim();
        setGameContentGone();
        btn_pronunciation.setVisibility(View.GONE);
        fab_rl.setVisibility(View.GONE);
        rl.setBackgroundResource(R.drawable.border_for_game);
        stopPlaying();
        if (player_bgMusic.isPlaying()) {
            player_bgMusic.pause();
        } else {
            player_bgMusic.start();
        }
    }

    private void resumeGame() {
        resumeTimer();
        setBtnGoneAnim();
        setGameContentVisible();
        btn_pronunciation.setVisibility(View.VISIBLE);
        fab_rl.setVisibility(View.VISIBLE);
        rl.setBackgroundColor(Color.parseColor("#8FCDDC39"));
        if (player_bgMusic.isPlaying()) {
            player_bgMusic.pause();
        } else {
            player_bgMusic.start();
            player_bgMusic.setVolume(defaultVolume, defaultVolume);
        }
    }

    private void restartGame() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void exitGame() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    private void startTimer(long time) {
        cdt = new CountDownTimer(time, 1000) {

            @Override
            public void onTick(long l) {
                tv_time.setText(String.format(FORMAT, TimeUnit.MILLISECONDS.toSeconds(l)));
                timeLeft = l;
            }

            @Override
            public void onFinish() { // Event when game ended
                tv_time.setText("00s");
                fab.setOnClickListener(null);
                setBtnGone();
                setGameContentGone();
                btn_pronunciation.setVisibility(View.GONE);
                fab_rl.setVisibility(View.GONE);

                // Vibrate
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    v.vibrate(500);
                }
                // ---

                // Reset the position of btn_exit
                params_btn_exit = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params_btn_exit.addRule(RelativeLayout.CENTER_IN_PARENT);
                btn_exit.setLayoutParams(params_btn_exit);
                //---

                AnimateSlideInOut(500, iv_wm_times_up, true, 250, screenWidth);

                AnimateSlideInOut(2000, iv_wm_times_up, false, 250, screenWidth);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MatchingGameActivity.this);
                        builder.setTitle("Well Done!!!");
                        builder.setMessage("Your score is " + tv_score.getText().toString() + ". Do you want to try again?");
                        builder.setNegativeButton("Next Time.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exitGame();
                            }
                        });
                        builder.setPositiveButton("Yeah, I can do better this time.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                restartGame();
                            }
                        });
                        builder.show();
                        btn_exit.setVisibility(View.VISIBLE);
                        player_bgMusic.stop();
                    }
                }, 3000);
            }
        }.start();
    }

    private void pauseTimer() {
        cdt.cancel();
    }

    private void resumeTimer() {
        startTimer(timeLeft);
    }

    // Reference: Lecture 11 Notes
    public static void AnimateSlideInOut(final int DELAY, final ImageView ivDH,
                                         final Boolean IsIn, final int AnimDuration, final int dx) {
        if (DELAY == 0) {
            if (IsIn) {
                ivDH.setVisibility(View.VISIBLE);
            } else {
                ivDH.setVisibility(View.GONE);
            }
        } else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (IsIn) {
                        ivDH.setVisibility(View.VISIBLE);
                        Animation transAnimation = new TranslateAnimation(
                                Animation.ABSOLUTE + dx, Animation.ABSOLUTE,
                                Animation.ABSOLUTE, Animation.ABSOLUTE);
                        transAnimation.setDuration(AnimDuration);
                        AnimationSet animationSet1 = new AnimationSet(true);
                        animationSet1.addAnimation(transAnimation);
                        animationSet1.setInterpolator(new DecelerateInterpolator());
                        ivDH.startAnimation(animationSet1);
                    } else {
                        ivDH.setVisibility(View.VISIBLE);
                        Animation transAnimation = new TranslateAnimation(
                                Animation.ABSOLUTE, Animation.ABSOLUTE - dx,
                                Animation.ABSOLUTE, Animation.ABSOLUTE);
                        transAnimation.setDuration(AnimDuration);
                        AnimationSet animationSet1 = new AnimationSet(true);
                        animationSet1.addAnimation(transAnimation);
                        animationSet1.setInterpolator(new DecelerateInterpolator());
                        ivDH.startAnimation(animationSet1);
                        ivDH.setVisibility(View.GONE);
                    }

                }
            }, DELAY);
        }
    }

    public static void AnimateSlideInOut_Btn(final int DELAY, final Button ivDH,
                                             final Boolean IsIn, final int AnimDuration, final int dx) {
        if (DELAY == 0) {
            if (IsIn) {
                ivDH.setVisibility(View.VISIBLE);
            } else {
                ivDH.setVisibility(View.GONE);
            }
        } else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (IsIn) {
                        ivDH.setVisibility(View.VISIBLE);
                        Animation transAnimation = new TranslateAnimation(
                                Animation.ABSOLUTE + dx, Animation.ABSOLUTE,
                                Animation.ABSOLUTE, Animation.ABSOLUTE);
                        transAnimation.setDuration(AnimDuration);
                        AnimationSet animationSet1 = new AnimationSet(true);
                        animationSet1.addAnimation(transAnimation);
                        animationSet1.setInterpolator(new DecelerateInterpolator());
                        ivDH.startAnimation(animationSet1);
                    } else {
                        ivDH.setVisibility(View.VISIBLE);
                        Animation transAnimation = new TranslateAnimation(
                                Animation.ABSOLUTE, Animation.ABSOLUTE - dx,
                                Animation.ABSOLUTE, Animation.ABSOLUTE);
                        transAnimation.setDuration(AnimDuration);
                        AnimationSet animationSet1 = new AnimationSet(true);
                        animationSet1.addAnimation(transAnimation);
                        animationSet1.setInterpolator(new DecelerateInterpolator());
                        ivDH.startAnimation(animationSet1);
                        ivDH.setVisibility(View.GONE);
                    }
                }
            }, DELAY);
        }
    }

    public void check_display() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
    }
}