/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final static int kFrontLeft = 10;
    public final static int kFrontRight = 14;
    public final static int kRearLeft = 12;
    public final static int kRearRight = 16;

    public final static int kSwallowerMotor = 8;

    public static final int DRIVER_XBOX_USB_PORT = 0; 
    public static final int XBOX_X_AXIS = 4;
    public static final int XBOX_Y_AXIS = 1;
    public static final int XBOX_Z_AXIS = 0;
    public static final int XBOX_SCALE_AXIS = 3;
}
