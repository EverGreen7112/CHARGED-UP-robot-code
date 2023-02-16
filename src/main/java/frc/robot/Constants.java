// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class Values{
        public static final int
                TICKS_PER_REVOLUTIONS = 8196;
                
                
        public static final double
                WHEEL_POSITION_PID_TOLERANCE = 0.5
                ,WHEEL_POSITION_PID_KP = 0.01 * 9
                ,WHEEL_POSITION_PID_KI = 0.00000
                ,WHEEL_POSITION_PID_KD = 0.000001
                ,TURN_SWERVE_WHEEL_PID_KP = 0.02
                ,TURN_SWERVE_WHEEL_PID_KI = 0
                ,TURN_SWERVE_WHEEL_PID_KD = 0
                ,DRIVE_SWERVE_WHEEL_PID_KP = 0.02
                ,DRIVE_SWERVE_WHEEL_PID_KI = 0
                ,DRIVE_SWERVE_WHEEL_PID_KD = 0
                ,SWERVE_WHEEL_RADIUS = 0
                ,SWERVE_LENGTH = 0
                ,SWERVE_WIDTH = 0
                
                ;
    }
    
    public static class Conversions {
        
        public static double angleToTicks(double angle){
            return Constants.Values.TICKS_PER_REVOLUTIONS / ((double) 360 / angle);
        }

        public static double ticksToAngle(double ticks){
            return (ticks * 360.0)/ Constants.Values.TICKS_PER_REVOLUTIONS;
        }

                /**
         * Get the closest angle between the given angles.
         */
        public static double closestAngle(double a, double b)
        {
                // get direction
                double dir = modulo(b, 360.0) - modulo(a, 360.0);

                // convert from -360 to 360 to -180 to 180
                if (Math.abs(dir) > 180.0)
                {
                        dir = -(Math.signum(dir) * 360.0) + dir;
                }
                return dir;
        }
                
        public static double modulo(double a, double b) {
            return ((a % b)+ b )% b;
        }

        public static double rpm2ms(double rpm){
            double rps = rpm / 60;
            return Constants.Values.SWERVE_WHEEL_RADIUS * 2 * Math.PI * rps;
        }

        public static double ms2rpm(double ms){
           double rps = ms / Constants.Values.SWERVE_WHEEL_RADIUS / 2 / Math.PI;
            return 60 * rps;
        }
        

    }
    public static class MotorPorts{
        public static final int
            FLY_WHEEL_PORT = 0,
            RIGHT_UP_DRIVE_MOTOR_PORT = 0,
            RIGHT_UP_TURN_MOTOR_PORT = 0,
            LEFT_UP_DRIVE_MOTOR_PORT = 0,
            LEFT_UP_TURN_MOTOR_PORT = 0,
            RIGHT_DOWN_DRIVE_MOTOR_PORT = 0,
            RIGHT_DOWN_TURN_MOTOR_PORT = 0,
            LEFT_DOWN_DRIVE_MOTOR_PORT = 0,
            LEFT_DOWN_TURN_MOTOR_PORT = 0;
        
    }
    public static class ControllerPorts{
        public static final int
            RIGHT_JOYSTICK_PORT = 0,
            LEFT_JOYSTICK_PORT = 0; 
    }
    
    public static class Motors {
        public static final WPI_TalonSRX
            FLY_WHEEL = new WPI_TalonSRX(MotorPorts.FLY_WHEEL_PORT);
    }

}
