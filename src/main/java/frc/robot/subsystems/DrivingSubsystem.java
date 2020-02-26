/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class DrivingSubsystem extends SubsystemBase {
  
  static WPI_TalonFX frontLeftMotor = new WPI_TalonFX(Constants.kFrontLeft);
  static WPI_TalonFX rearLeftMotor = new WPI_TalonFX(Constants.kRearLeft);
  static WPI_TalonFX frontRightMotor = new WPI_TalonFX(Constants.kFrontRight);
  static WPI_TalonFX rearRightMotor = new WPI_TalonFX(Constants.kRearRight);


  public static MecanumDrive drive; 

  //private final float MIN_MOTOR_SPEED = 0.15f;
  // private final float MIN_CONTROLLER_SPEED = 0.20f;
  // private final float SMALLEST_RADIO = 0.1f;
  



  /**
   * Creates a new DriveTrain.
   */
  public DrivingSubsystem() {
    super();


    drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run


  }

  public void setDrive (double x, double y, double z) {
    drive.driveCartesian(x, y, z);
  }
}
