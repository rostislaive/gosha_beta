package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Controlv06")
public class Controlv06 extends LinearOpMode {

  private DcMotor LFMotor;
  private DcMotor RBMotor;
  private DcMotor LBMotor;
  private DcMotor RFMotor;
  private DcMotor ARMotor;
  private DcMotor LRMotor;
  private DcMotor BRMotor;
  private Servo Servo1;
   @Override
  public void runOpMode() {

    LFMotor = hardwareMap.get(DcMotor.class, "LFMotor");
    RBMotor = hardwareMap.get(DcMotor.class, "RBMotor");
    LBMotor = hardwareMap.get(DcMotor.class, "LBMotor");
    RFMotor = hardwareMap.get(DcMotor.class, "RFMotor");
    ARMotor = hardwareMap.get(DcMotor.class, "ARMotor");
    LRMotor = hardwareMap.get(DcMotor.class, "LRMotor");
    Servo1 = hardwareMap.get(Servo.class, "Servo1");
    BRMotor = hardwareMap.get(DcMotor.class, "BRMotor");
    LBMotor.setDirection(DcMotor.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
		
        float valLX = (gamepad1.left_stick_x);
        float valLY = (gamepad1.left_stick_y);
        float valRX = (gamepad1.right_stick_x);
        float valRY = (gamepad1.right_stick_y);
        float valAR = (gamepad2.right_stick_y);
        float valLR = (gamepad2.left_stick_y);
        float dirFR = (valLY + valLX) + (valRY - valRX);
        float dirFL = (valLY - valLX) + (valRY + valRX);
        float dirBR = (valLY - valLX) + (valRY - valRX);
        float dirBL = (valLY + valLX) + (valRY + valRX);
        LBMotor.setPower(dirBL);
        RBMotor.setPower(dirBR);
        LFMotor.setPower(dirFL);
        RFMotor.setPower(dirFR);
        ARMotor.setPower(valAR);
	LRMotor.setPower(valLR);
	BRMotor.setPower(valLR);
        telemetry.update();
        if ((gamepad2.a == true)){
			  Servo1.setPosition(0.66);
		    }
	if ((gamepad2.b == true)){
			Servo1.setPosition(0);

		    }
      }
    }
  }
}
