// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    public final class Ports{
        public static final int 
        LEFT_FRONT_PORT = 0,
        LEFT_MIDDLE_PORT = 0,
        LEFT_BACK_PORT = 0,
        RIGHT_FRONT_PORT = 0,
        RIGHT_MIDDLE_PORT = 0,
        RIGHT_BACK_PORT = 0
        ;
    }
    
    public final static  class Speeds{
        public final static Supplier<Double> driveMax = () -> {
           return SmartDashboard.getNumber("robot speed", 0.8);            
        };
    }

    }
    

    public static class Conversions {
        
        public static double angleToTicks(double angle){
            return Constants.Values.TICKS_PER_REVOLUTIONS / ((double) 360 / angle);
        }

        public static double ticksToAngle(double ticks){
            return (ticks * 360.0)/ Constants.Values.TICKS_PER_REVOLUTIONS;
        }
    }
    public static class MotorPorts{
        public static final int
            FLY_WHEEL_PORT = 0; 
    }
    
    public static class Motors {
        public static final WPI_TalonSRX
            FLY_WHEEL = new WPI_TalonSRX(MotorPorts.FLY_WHEEL_PORT);
    }

}
