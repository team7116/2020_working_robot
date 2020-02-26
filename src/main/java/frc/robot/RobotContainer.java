/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.SwallowCommand;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.SwallowerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivingSubsystem m_robotDrive = new DrivingSubsystem();
  public final XboxController m_driverInput = new XboxController(Constants.DRIVER_XBOX_USB_PORT);
  private final DriveCommand m_driveCommand = new DriveCommand(m_robotDrive, this);
  public final SwallowerSubsystem m_swallower = new SwallowerSubsystem();

  private JoystickButton button_b;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_robotDrive.setDefaultCommand(m_driveCommand);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    button_b = new JoystickButton(m_driverInput, XboxController.Button.kB.value);

    button_b.whileActiveContinuous(new SwallowCommand(m_swallower, 0.5));
    button_b.whenReleased(new SwallowCommand(m_swallower, 0));
    System.out.println("Button should be configured now");
    //button_a.whenInactive(new SwallowCommand(m_swallower, 0));

  }

  public double getRawAxis(final int axis) {
    return m_driverInput.getRawAxis(axis);
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

}
