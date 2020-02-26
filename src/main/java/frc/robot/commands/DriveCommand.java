/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivingSubsystem;


public class DriveCommand extends CommandBase {
  private DrivingSubsystem driveSubsystem;
  private RobotContainer robotContainer;
  
  /**
   * Creates a new DriveCommand.
   */
  public DriveCommand (DrivingSubsystem drivingSubsystem, RobotContainer container) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem = drivingSubsystem;
    this.robotContainer = container;

    addRequirements(this.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = robotContainer.getRawAxis(Constants.XBOX_X_AXIS);
    double y = robotContainer.getRawAxis(Constants.XBOX_Y_AXIS);
    double z = robotContainer.getRawAxis(Constants.XBOX_Z_AXIS);
    double scale = robotContainer.getRawAxis(Constants.XBOX_SCALE_AXIS);

    //y is flipped in driverstation, this fixes that
    y = y*-1;
    //Formula for scale (1-x)/2
    scale = (1-scale)/2;
    //squares inputs
    x = squareInput(x)*scale;
    y = squareInput(y)*scale;
    //Sqaures z, the scale, then applies to z
    z = squareInput(z) * squareInput(scale);

    driveSubsystem.setDrive(x, y, z);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public double squareInput(double input){
    return Math.pow(input, 2) * Math.signum(input);
  }
}
