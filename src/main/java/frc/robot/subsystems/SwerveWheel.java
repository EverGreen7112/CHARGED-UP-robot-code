package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Conversions;
import frc.robot.commands.SparkMaxPositionPID;

public class SwerveWheel extends SubsystemBase{

    private CANSparkMax m_driveMotor;
    private RelativeEncoder m_driveEncoder;
    private CANSparkMax m_turnMotor;  
    private RelativeEncoder m_turnEncoder;
    private SparkMaxPIDController m_turnPositionPIDController;
    private SparkMaxPIDController m_drivePVelocityPIDController;

    public SwerveWheel(int driveMotorId, int turnMotorId){
        m_driveMotor = new CANSparkMax(driveMotorId, MotorType.kBrushless);
        m_driveEncoder = m_driveMotor.getEncoder();
        m_turnMotor = new CANSparkMax(driveMotorId, MotorType.kBrushless);
        m_turnEncoder = m_turnMotor.getEncoder();

        m_turnPositionPIDController = m_turnMotor.getPIDController();
        m_turnPositionPIDController.setP(Constants.Values.TURN_SWERVE_WHEEL_PID_KP);
        m_turnPositionPIDController.setI(Constants.Values.TURN_SWERVE_WHEEL_PID_KI);
        m_turnPositionPIDController.setD(Constants.Values.TURN_SWERVE_WHEEL_PID_KD);
        
        m_drivePVelocityPIDController = m_driveMotor.getPIDController();
        m_turnPositionPIDController.setP(Constants.Values.DRIVE_SWERVE_WHEEL_PID_KP);
        m_turnPositionPIDController.setI(Constants.Values.DRIVE_SWERVE_WHEEL_PID_KI);
        m_turnPositionPIDController.setD(Constants.Values.DRIVE_SWERVE_WHEEL_PID_KD);

    }

    /**
     * 
     * @param angle - turn SwerveWheel to angle (in degrees)  
     */
    public void turnTo(double angle){    
        double targetDegrees = getCurrentAngle() + Constants.Conversions.closestAngle(getCurrentAngle(), angle); // get the target angle in degrees
        double targetRotations = targetDegrees / 360; //convert the target degrees to rotations 
        
        m_turnPositionPIDController.setReference(targetRotations, ControlType.kPosition); //when pid is set on position mode it get rotations as target value        
    }
    
    public double getCurrentAngle(){
        return Constants.Conversions.modulo(m_turnEncoder.getPosition() * 360, 360); //convert rotations to degrees
    }
    /**
     * 
     * @param speed - m/s
     */
    public void setSpeed(double speed){
        m_drivePVelocityPIDController.setReference(Constants.Conversions.ms2rpm(speed) , ControlType.kVelocity);
    }
    
}
