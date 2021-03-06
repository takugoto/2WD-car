package jp.ac.utsunomiya.is.ss2012fpgatest;


//import com.example.wdcar.R;

import jp.ac.utsunomiya.is.FPGAController;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private FPGAController fc;
	private EditText editTextIPaddress;
	private Activity thisActivity;
	//private CheckBox checkBoxAlarmSwitchState;
	private SeekBar seekBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = this;
        setContentView(R.layout.activity_main);
        this.init();
		Button buttonExit = (Button) findViewById(R.id.buttonExit);
		buttonExit.setOnClickListener(exitButtonListener);
		
		View changeButton1 = this.findViewById(R.id.button1);   
	    changeButton1.setOnClickListener(buttonListener1);
	    
	    View changeButton2 = this.findViewById(R.id.button2);   
	    changeButton2.setOnClickListener(buttonListener2);
		
	    View changeButton3 = this.findViewById(R.id.button3);   
	    changeButton3.setOnClickListener(buttonListener3);
	    
		seekBar = (SeekBar) findViewById(R.id.seekBar1); 
		
		seekBar.setOnSeekBarChangeListener(
        		new OnSeekBarChangeListener(){
        			public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
        				// ツマミをドラッグしたときに呼ばれる
        				//tv2.setText(""+(progress-1000));//シークバーの値をtv2にセット
        				}
        			public void onStartTrackingTouch(SeekBar seekBar){
        				// ツマミに触れたときに呼ばれる
        				}
        			public void onStopTrackingTouch(SeekBar seekBar){
        				// ツマミを離したときに呼ばれる
        				}
        			}
        		);
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

		Button buttonConnect = (Button) findViewById(R.id.buttonConnect);
		buttonConnect.setOnClickListener(connectButtonListener);
		editTextIPaddress = (EditText)findViewById(R.id.editTextIPaddress);
		
		//setupTorqueBar(R.id.seekBarLeft, 1);
		//setupTorqueBar(R.id.seekBarRight, 0);
		
		//Button buttonAlarmSound = (Button) findViewById(R.id.buttonAlarmSound);
		//buttonAlarmSound.setOnClickListener(alarmButtonListener);

		//Button buttonGetAlarmSwitchState = (Button) findViewById(R.id.buttonGetAlarmSwitchState);
		//buttonGetAlarmSwitchState.setOnClickListener(getAlarmSwitchStateButtonListener);
		
		//checkBoxAlarmSwitchState = (CheckBox) findViewById(R.id.checkBoxAlarmSwitchState);

    }
/*
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
    			//if(connected) {
    				//fc.setMotorTorque(ch, maxTorque, progress-maxTorque);				
    			//}
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

    */
    private View.OnClickListener buttonListener1 = new View.OnClickListener(){
    	public int f=0;
    	public int x;
    	public void onClick(View v){
    		Button thisButton = (Button) v;
    		if(f==1){
    			thisButton.setText("　停止　");
    			x=seekBar.getProgress();
    			if(connected){
    			fc.setMotorTorque(0, 1000, x-1000);
    			}
    			f=0;
    		}else{
    			thisButton.setText("　右折　");
    			if(connected){
    			fc.setMotorTorque(0, 1000, 0);//停止
    			}
    			f=1;
    		}
    	}
		
    };

	private View.OnClickListener buttonListener2 = new View.OnClickListener(){
		public int f=0;
		public int x;
		public void onClick(View v){
			Button thisButton = (Button) v;
			if(f==1){
				thisButton.setText("　停止　");
				x=seekBar.getProgress();
				if(connected){
					fc.setMotorTorque(1, 1000, x-1000);
				}
				f=0;
			}else{
				thisButton.setText(" 左折　");
				if(connected){
					fc.setMotorTorque(1, 1000, 0);//停止
				}
				f=1;
			}
		}
	
	};
	
	private View.OnClickListener buttonListener3 = new View.OnClickListener(){
		public int f=0;
		public int x;
		public void onClick(View v){
			Button thisButton = (Button) v;
			if(f==1){
				thisButton.setText("　停止　");
				x=seekBar.getProgress();
				if(connected){
					fc.setMotorTorque(1, 1000, x-1000);
					fc.setMotorTorque(0, 1000, x-1000);
					
				}
				f=0;
			}else{
				thisButton.setText("アクセル");
				if(connected){
					fc.setMotorTorque(1, 1000, 0);//停止
					fc.setMotorTorque(0, 1000, 0);
				}
				f=1;
			}
		}
	
	};
	
	

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
    /*
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
     */
  
}
