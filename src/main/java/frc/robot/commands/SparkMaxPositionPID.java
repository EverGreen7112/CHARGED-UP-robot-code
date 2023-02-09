package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SparkMaxPositionPID extends CommandBase{
    private CANSparkMax m_motor;
    private SparkMaxPIDController m_pidController;
    private RelativeEncoder m_encoder;
    private double m_target;

    public SparkMaxPositionPID(int motorId, double kp, double ki, double kd, double target){
        m_motor = new CANSparkMax(motorId, MotorType.kBrushless);
        m_pidController = m_motor.getPIDController();
        m_encoder = m_motor.getEncoder();
        m_pidController.setP(kp);
        m_pidController.setI(ki);
        m_pidController.setD(kd);
        m_target = target;
    }
    @Override
    public void execute() {
        m_pidController.setReference(m_target, ControlType.kPosition);
    
    }
}