package com.example.android.tourguide;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InformationAboutPlace extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech tts;
    final boolean[] isClicked = {true};
    @BindView(R.id.place_info_name)
    TextView textname;
    //TextView textname = (TextView) findViewById(R.id.place_info_name);

    @BindView(R.id.place_info_address)
    TextView addresstext;
    // TextView addresstext = (TextView) findViewById(R.id.place_info_address);

    @BindView(R.id.description)
    TextView info;
    //  TextView info = (TextView) findViewById(R.id.description);

    @BindView(R.id.info_image)
    ImageView imageView;
    //ImageView imageView = (ImageView) findViewById(R.id.info_image);
    @BindView(R.id.info_image1)
    ImageView imageView1;
    // ImageView imageView1 = (ImageView) findViewById(R.id.info_image1);
    @BindView(R.id.info_image2)
    ImageView imageView2;
    // ImageView imageView2 = (ImageView) findViewById(R.id.info_image2);

    @BindView(R.id.textToSpeech)
    Button b;
    //  Button b = (Button) findViewById(R.id.textToSpeech);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_about_place);
        ButterKnife.bind(this);
        tts = new TextToSpeech(this, this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String name = getIntent().getStringExtra("placename");

        textname.setText(name + "");

        String address = getIntent().getStringExtra("Address");
        addresstext.setText(address + "");

        switch (getIntent().getIntExtra("id", 0)) {
            case 1: {
                imageView.setImageResource(R.drawable.alexanabaskhironp);
                imageView1.setImageResource(R.drawable.alexanabaskhironpa);
                imageView2.setImageResource(R.drawable.alexanabaskhironpalace);
                info.setText(R.string.alexa_palace_Info);
            }
            break;
            case 2: {
                imageView.setImageResource(R.drawable.mirpla);
                imageView1.setImageResource(R.drawable.mirpl);
                imageView2.setImageResource(R.drawable.mirth);
                info.setText(R.string.Mir_place_Info);
            }
            break;
            case 3: {
                imageView.setImageResource(R.drawable.da);
                imageView1.setImageResource(R.drawable.dayer);
                imageView2.setImageResource(R.drawable.dayr);
                info.setText(R.string.Mary_menostry_Info);
            }
            break;
            case 4: {
                imageView.setImageResource(R.drawable.institue);
                imageView1.setImageResource(R.drawable.fouad);
                imageView2.setImageResource(R.drawable.fouadinstitue);
                info.setText(R.string.fouad_instatue);
            }
            break;
        }
        //by using ButterKnife library this code equivalent to b.setOnClickListener method

//        @OnClick(R.id.textToSpeech)
//        public void onTextToSpeech (View view){
//            Bundle t = new Bundle();
//            String utteranceId = this.hashCode() + "";
//            t.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
//            if (isClicked[0]) {
//                tts.speak(info.getText().toString(), TextToSpeech.QUEUE_FLUSH, t, utteranceId);
//                isClicked[0] = false;
//                b.setText(getString(R.string.Stop));
//            } else {
//                tts.stop();
//                isClicked[0] = true;
//                b.setText(getString(R.string.Speak));
//            }
//        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle t = new Bundle();
                String utteranceId = this.hashCode() + "";
                t.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                if (isClicked[0]) {
                    tts.speak(info.getText().toString(), TextToSpeech.QUEUE_FLUSH, t, utteranceId);
                    isClicked[0] = false;
                    b.setText(getString(R.string.Stop));
                } else {
                    tts.stop();
                    isClicked[0] = true;
                    b.setText(getString(R.string.Speak));
                }
            }
        });
    }

    @Override
    public void onDestroy() {

        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub

        if (tts != null) {

            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.ENGLISH);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "this language is not supported");
            }
        } else {
            Log.e("TTS", "initialization failed");
        }
    }
}
