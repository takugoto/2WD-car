package com.example.wdcar;

//import jp.ac.utsunomiyau.android.helloworld.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

/*
public interface SS2012FPGA{
	public void setMotorTorque(int id, int torque);
}
*/


public class MainActivity extends Activity implements OnClickListener{
	private SeekBar seekBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        seekBar = (SeekBar) findViewById(R.id.seekBar1); 
        
        View changeButton1 = this.findViewById(R.id.button1);   
        changeButton1.setOnClickListener(this);   
        
        View changeButton2 = this.findViewById(R.id.button2);   
        changeButton2.setOnClickListener(this);
        
        View changeButton3 = this.findViewById(R.id.button3);   
        changeButton3.setOnClickListener(this);
        
        View changeButton4 = this.findViewById(R.id.button4);   
        changeButton4.setOnClickListener(this);
        
    }
        /*
        Button button = (Button) findViewById(R.id.button1);
        //OnClickListener buttonListener;
        button.setOnClickListener(buttonListener);
    	}
    	*/
    /*******************************************************************/
    
    //�����[�^�̐��]�E��~����
    /*
    public int f=0;	
    public void onClick1(View v){
    	if(v.getId() == R.id.button1){
    		if(f==0){
    			((Button)v).setText("��~");
    			f=1;
    		}else{
    			f=0;
    			((Button)v).setText("���]");
    			}
    		}
    	}
    
    //�����[�^�̔��]�E��~����
    public int g=0;	
    public void onClick2(View v){
    	if(v.getId() == R.id.button2){
    		if(g==0){
    			((Button)v).setText("��~");
    			g=1;
    		}else{
    			g=0;
    			((Button)v).setText("���]");
    			}
    		}
    	}
    
    //�E���[�^�̐��]�E��~����
    public int h=0;	
    public void onClick3(View v){
    	if(v.getId() == R.id.button3){
    		if(h==0){
    			((Button)v).setText("��~");
    			h=1;
    		}else{
    			h=0;
    			((Button)v).setText("���]");
    			}
    		}
    	}
    
    //�E���[�^�̔��]�E��~����
    public int i=0;	
    public void onClick4(View v){
    	if(v.getId() == R.id.button4){
    		if(i==0){
    			((Button)v).setText("��~");
    			i=1;
    		}else{
    			i=0;
    			((Button)v).setText("���]");
    			}
    		}
    	}
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
	//@Override
	public int f=0;
	public void onClick(View v) {
		if(v.getId() == R.id.button1){
    		if(f==0){
    			((Button)v).setText("��~");
    			f=1;
    		}else{
    			f=0;
    			((Button)v).setText("���]");
    			}
    		}
   
	}
	
	public int g=0;	
    public void onClick2(View v){
    	if(v.getId() == R.id.button2){
    		if(g==0){
    			((Button)v).setText("��~");
    			g=1;
    		}else{
    			g=0;
    			((Button)v).setText("���]");
    			}
    		}
    	}
	}

	

