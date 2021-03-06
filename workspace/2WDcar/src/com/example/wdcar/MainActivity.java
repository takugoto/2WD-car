package com.example.wdcar;

//import jp.ac.utsunomiyau.android.helloworld.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.util.Log;
import android.widget.TextView;



public class MainActivity extends Activity{
	private SeekBar seekBar;
	private TextView tv2;
	private SS2012FPGA fpga = new SS2012FPGA_Impl();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        seekBar = (SeekBar) findViewById(R.id.seekBar1); 
        //View changeSeekbar = this.findViewById(R.id.seekBar1);
        //changeSeekbar.setOnSeekBarListener(seekbarListener);
        
        View changeButton1 = this.findViewById(R.id.button1);   
        changeButton1.setOnClickListener(buttonListener1);   
        
        /*
        View changeButton2 = this.findViewById(R.id.button2);   
        changeButton2.setOnClickListener(buttonListener2);
        */
        
        View changeButton3 = this.findViewById(R.id.button3);   
        changeButton3.setOnClickListener(buttonListener3);
        
        /*
        View changeButton4 = this.findViewById(R.id.button4);   
        changeButton4.setOnClickListener(buttonListener4);
        */

        
        
        
        tv2 = (TextView)findViewById(R.id.textView2);//シークバーの値をtextview2に表示
        seekBar.setOnSeekBarChangeListener(
        		new OnSeekBarChangeListener(){
        			public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
        				// ツマミをドラッグしたときに呼ばれる
        				tv2.setText(""+(progress-1000));//シークバーの値をtv2にセット
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

    /****************************ボタン***************************************/
    
private View.OnClickListener buttonListener1 = new View.OnClickListener(){
    	public int f=0;
    	public int x;
    	public void onClick(View v){
    		Button thisButton = (Button) v;
    		if(f==1){
    			thisButton.setText("左アクセル");
    			x=seekBar.getProgress();//シークバーの値をxに代入
    			fpga.setTorque(0, 1000, x-1000);
    			f=0;
    		}else{
    			thisButton.setText(" 　 停止　 ");
    			fpga.setTorque(0, 1000, 0);//停止
    			f=1;
    		}
    	}
		
};
/*
private View.OnClickListener buttonListener2 = new View.OnClickListener(){
	public int f=0;
	public void onClick(View v){
		Button thisButton = (Button) v;
		if(f==0){
			thisButton.setText("停止");
			fpga.setMotorTorque(1, -50);
			f=1;
		}else{
			thisButton.setText("反転");
			fpga.setMotorTorque(0, 0);
			f=0;
		}
	}
};
    	
*/
private View.OnClickListener buttonListener3 = new View.OnClickListener(){
	public int f=0;
	public int x;
	public void onClick(View v){
		Button thisButton = (Button) v;
		if(f==1){
			thisButton.setText("右アクセル");
			x=seekBar.getProgress();//シークバーの値をxに代入
			fpga.setTorque(1, 1000, x-1000);
			f=0;
		}else{
			thisButton.setText("　 停止　 ");
			fpga.setTorque(1, 1000, 0);//停止
			f=1;
		}
	}
};
/*
private View.OnClickListener buttonListener4 = new View.OnClickListener(){
	public int f=0;
	public void onClick(View v){
		Button thisButton = (Button) v;
		if(f==0){
			thisButton.setText("停止");
			fpga.setMotorTorque(0, -50);
			f=1;
		}else{
			thisButton.setText("反転");
			fpga.setMotorTorque(0, 0);
			f=0;
		}
	}
};
*/
/**********************シークバー***************************************************************/

private SeekBar.OnSeekBarChangeListener seekbarListener = new SeekBar.OnSeekBarChangeListener(){
	
	public void onStartTrackingTouch(SeekBar seekBar) {
		Log.v("onStartTrackingTouch()",String.valueOf(seekBar.getProgress()));
		
	}
	
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
		Log.v("onProgressChanged()",String.valueOf(progress) + ", " + String.valueOf(fromTouch));
		
		
	}
	
	public void onStopTrackingTouch(SeekBar seekBar) {
		Log.v("onStopTrackingTouch()",String.valueOf(seekBar.getProgress()));
		
	}
};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	
}






	

