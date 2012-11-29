package com.example.wdcar;

public class SS2012FPGA_Impl implements SS2012FPGA {

	@Override
	public void setMotorTorque(int id, int torque) {
		System.out.println("setMotorTorque called: id="+id+" torque="+torque);
	}


}
