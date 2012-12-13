package com.example.wdcar;

public class SS2012FPGA_Impl implements SS2012FPGA {

	@Override
	public void setTorque(int motor, int active) {
		System.out.println("setTorque called: motor="+motor+" active="+active);
	}


}
