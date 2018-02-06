package org.usfirst.frc.team1799.robot.Drive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;

public class PlayMecanum extends MecanumDrive {

	public PlayMecanum(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void driveCartesian(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
	    Vector2d input = new Vector2d(ySpeed, xSpeed);

	    double[] wheelSpeeds = new double[4];
	    wheelSpeeds[MotorType.kFrontLeft.value] = input.x + input.y + zRotation;
	    wheelSpeeds[MotorType.kFrontRight.value] = input.x - input.y + zRotation;
	    wheelSpeeds[MotorType.kRearLeft.value] = -input.x + input.y + zRotation;
	    wheelSpeeds[MotorType.kRearRight.value] = -input.x - input.y + zRotation;
	    
	    System.out.println("x="+input.x+", y="+input.y+", zRotation="+zRotation+", gyroAngle="+gyroAngle);

//	    super.driveCartesian(xSpeed, ySpeed, zRotation, gyroAngle);
	    super.driveCartesian(xSpeed, ySpeed, zRotation, 0);
	}
}
