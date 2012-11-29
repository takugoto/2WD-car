package com.example.wdcar;

//import jp.ac.utsunomiyau.android.helloworld.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;




public class MainActivity extends Activity{
	private SeekBar seekBar;
	private SS2012FPGA fpga = new SS2012FPGA_Impl();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        seekBar = (SeekBar) findViewById(R.id.seekBar1); 
        
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
    }

    /*******************************************************************/
    
private View.OnClickListener buttonListener1 = new View.OnClickListener(){
    	public int f=0;
    	public void onClick(View v){
    		Button thisButton = (Button) v;
    		if(f==0){
    			thisButton.setText("��~");
    			fpga.setMotorTorque(0, 50);
    			f=1;
    		}else{
    			thisButton.setText("�A�N�Z��");
    			fpga.setMotorTorque(0,0);
    			f=0;
    		}
    	}
		
};
/*
private View.OnClickListener buttonListener2 = new View.OnClickListener(){
	public int f=0;
	public void onClick(View v){
		Button thisButton = (Button) v;
		if(f==0){
			thisButton.setText("��~");
			fpga.setMotorTorque(1, -50);
			f=1;
		}else{
			thisButton.setText("���]");
			fpga.setMotorTorque(0, 0);
			f=0;
		}
	}
};
    	
*/
private View.OnClickListener buttonListener3 = new View.OnClickListener(){
	public int f=0;
	public void onClick(View v){
		Button thisButton = (Button) v;
		if(f==0){
			thisButton.setText("��~");
			fpga.setMotorTorque(1, 50);
			f=1;
		}else{
			thisButton.setText("�A�N�Z��");
			fpga.setMotorTorque(1, 0);
			f=0;
		}
	}
};
/*
private View.OnClickListener buttonListener4 = new View.OnClickListener(){
	public int f=0;
	public void onClick(View v){
		Button thisButton = (Button) v;
		if(f==0){
			thisButton.setText("��~");
			fpga.setMotorTorque(0, -50);
			f=1;
		}else{
			thisButton.setText("���]");
			fpga.setMotorTorque(0, 0);
			f=0;
		}
	}
};
*/
/*************************************************************************************/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	
}






	

