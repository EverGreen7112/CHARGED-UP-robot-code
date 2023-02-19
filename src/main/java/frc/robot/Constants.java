// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
 */
public final class Constants {
    public static class ArmValues {

        public static final double 
                FIRST_ARM_LENGTH = 0
                ,SECOND_ARM_LENGTH = 0
                ,FIRST_ARM_MIN = 0
                ,FIRST_ARM_MAX = 0
                ,SECOND_ARM_MIN = 0
                ,SECOND_ARM_MAX = 0
                ,JOYSTICK_TOLERANCE = 0.5
                ,LIMIT_TOLERANCE = 5;
    }

    public static class Values {
        public static final int TICKS_PER_REVOLUTIONS = 8196;
    }

    public static class PidValues {
        public static final double 
                FIRST_ARM_KP = 0.0000001
                ,FIRST_ARM_KI = 0
                ,FIRST_ARM_KD = 0.000001
                ,SECOND_ARM_KP = 0.00000001
                ,SECOND_ARM_KI = 0
                ,SECOND_ARM_KD = 0;
    }

    public static class MotorPorts {
        public static final int 
                FIRST_ARM_PORT = 0
                ,SECOND_ARM_PORT = 0;
    }

    public static class Motors {
    }

    public static class Functions {

        public static double angleToTicks(double angle) {
            return Constants.Values.TICKS_PER_REVOLUTIONS / ((double) 360 / angle);
        }

        public static double ticksToAngle(double ticks) {
            return (ticks * 360.0) / Constants.Values.TICKS_PER_REVOLUTIONS;
        }

        public static double closestAngle(double a, double b) {
            // get direction
            double dir = modulo(b, 360.0) - modulo(a, 360.0);

            // convert from -360 to 360 to -180 to 180
            if (Math.abs(dir) > 180.0) {
                dir = -(Math.signum(dir) * 360.0) + dir;
            }
            return dir;
        }

        public static double modulo(double a, double b) {
            return ((a % b) + b) % b;
        }
    }

}
