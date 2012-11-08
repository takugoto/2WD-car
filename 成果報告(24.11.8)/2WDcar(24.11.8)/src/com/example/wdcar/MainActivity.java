package com.example.wdcar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;

public interface SS2012FPGA{
	public void setMotorTorque(int id, int torque);
}

	
}

public class MainActivity extends Activity {
	private SeekBar seekBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        seekBar = (SeekBar) findViewById(R.id.seekBar1); 
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
