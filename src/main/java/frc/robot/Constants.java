// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class Ports{
        //tank drive chassis
        public static final int 
        LEFT_FRONT_PORT = 2,
        LEFT_MIDDLE_PORT = 14,
        LEFT_BACK_PORT = 10,
        RIGHT_FRONT_PORT = 15,
        RIGHT_MIDDLE_PORT = 12,
        RIGHT_BACK_PORT = 11
        ;
    }
    public final static class Values{
        public static double 
            TANKDRIVE_WHEEL_RADIUS = 0.76,
            DISTANCE_BETWEEN_LEFT_TO_RIGHT = 0.5; //in meters;
    }
    public final static class Speeds{
        public final static Supplier<Double> driveMax = () -> {
           return SmartDashboard.getNumber("robot speed", 0.8);            
        };
        public static double rpm2ms(double wheelRadius, double rpm){
            double rps = rpm / 60;
            return wheelRadius * 2 * Math.PI * rps;
        }

    }
    public final static class JoystickPorts{
        public static final int
        RIGHT_JOYSTICK = 0,
        LEFT_JOYSTICK = 1;
    } 
}