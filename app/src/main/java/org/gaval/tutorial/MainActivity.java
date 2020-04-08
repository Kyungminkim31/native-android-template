package org.gaval.tutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);
        System.loadLibrary("native-lib");
    }

    public void doNative(View view){
        Log.i(LOG_TAG, "do native!!");
        TextView statusTextView = (TextView) findViewById( R.id.statusTextView );
        String userName = "John Doe";
        statusTextView.setText( getStringFromCpp(userName) );
        statusTextView.setTextSize( 24 );

    }

    static {
        System.loadLibrary( "native-lib" );
    }

    public native String getStringFromCpp(String input);
}
