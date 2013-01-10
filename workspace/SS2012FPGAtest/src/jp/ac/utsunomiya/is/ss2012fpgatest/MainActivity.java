package jp.ac.utsunomiya.is.ss2012fpgatest;


import jp.ac.utsunomiya.is.FPGAController;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends Activity {
	private FPGAController fc;
	private EditText editTextIPaddress;
	private Activity thisActivity;
	private CheckBox checkBoxAlarmSwitchState;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = this;
        setContentView(R.layout.activity_main);
        this.init();
		Button buttonExit = (Button) findViewById(R.id.buttonExit);
		buttonExit.setOnClickListener(exitButtonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void init(){
    	setContentView(R.layout.activity_main);
               
        fc = new FPGAController();
		fc.initialize(new String[]{});

		//Button buttonConnect = (Button) findViewById(R.id.buttonConnect);
		//buttonConnect.setOnClickListener(connectButtonListener);
		

    }

	private int currentChannel;
	private int maxTorque = 1000;
    private void setupTorqueBar(int id, int channel) {
    	currentChannel = channel;
        SeekBar tuningBar = (SeekBar)findViewById(id);
        tuningBar.setMax(maxTorque*2);
        tuningBar.setProgress(maxTorque);
        
        SeekBar.OnSeekBarChangeListener tuningBarListener = new SeekBar.OnSeekBarChangeListener() {
        	private int ch;
        	private int max;
        	
        	{
        		ch = currentChannel;
        	}

    		public void onProgressChanged(SeekBar seekBar, final int progress,
    				boolean fromUser) {
    			if(connected) {
    				fc.setMotorTorque(ch, maxTorque, progress-maxTorque);				
    			}
    		}

    		public void onStartTrackingTouch(SeekBar seekBar) {
    			//fc.setMotorTorque(ch, maxTorque, progress-maxTorque);
    		}

    		public void onStopTrackingTouch(SeekBar seekBar) {
    			//fc.setMotorTorque(ch, maxTorque, progress-maxTorque);
    		}
        };
    		
        tuningBar.setOnSeekBarChangeListener(tuningBarListener);
    }

	private boolean connected = false;
    private View.OnClickListener connectButtonListener = new View.OnClickListener() {
		public void onClick(View v) {
			if(connected) return;
			if(editTextIPaddress.getText().toString().equals("")) return;
			connected=true;
			
			Button thisButton = (Button) v;
			thisButton.setText("Connected");
			
			try {
				fc.connect(editTextIPaddress.getText().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    };
       
	private View.OnClickListener exitButtonListener = new View.OnClickListener() {
		public void onClick(View v) {
			thisActivity.finish();
		}
    };
    
    private View.OnClickListener alarmButtonListener = new View.OnClickListener() {
		public void onClick(View v) {
			if(!connected) return;
			
			try {
				fc.playAlarmSound();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    };
    
    private View.OnClickListener getAlarmSwitchStateButtonListener = new View.OnClickListener() {
 		public void onClick(View v) {
 			if(!connected) return;
 			Button thisButton = (Button) v;
 			
 			try {
 				int state = fc.getAlarmSwitchState();
 				checkBoxAlarmSwitchState.setChecked(state==1);
 				//checkBoxAlarmSwitchState.invalidate();

 				//thisButton.setText("State="+state);
 				
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
     };
  
}
