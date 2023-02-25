// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 * </p>
 * Conventions:
 * <ul>
 * <li>Distance in meters</li>
 * <li>Angles in degrees</li>
 * </ul>
 */
public final class Constants {
    public final class Ports {
        public static final int LEFT_FRONT_PORT = 0,
                LEFT_MIDDLE_PORT = 0,
                LEFT_BACK_PORT = 0,
                RIGHT_FRONT_PORT = 0,
                RIGHT_MIDDLE_PORT = 0,
                RIGHT_BACK_PORT = 0;
    }

    public final static class Speeds {
        public final static double constantSpeed = 0.4;
        public final static double constantPropConst = 0.07;
        public final static Supplier<Double> driveMax = () -> {
            return SmartDashboard.getNumber("robot speed", 0.8);
        };
        // use only in TurnUntilWithInRange

    }

    public final static class PIDS {
    public final static double driveKp = 0.05;
    public final static double driveKi = 0.007;
    public final static double driveKd = 0.007;
    public final static double drivePTolerance =0.02;
    public final static double driveVTolerance =1;
    
    public final static double rotateKp = 0.05/75;
    public final static double rotateKi = 0.007/75;
    public final static double rotateKd = 0.007/75;
    public final static double rotatePTolerance =2;
    public final static double rotateVTolerance =10;

    public final static double velKp = 0.05/75;
    public final static double velKi = 0.007/75;
    public final static double velKd = 0.007/75;
    public final static double velPTolerance =2;
    public final static double velVTolerance =10;
    }
}
