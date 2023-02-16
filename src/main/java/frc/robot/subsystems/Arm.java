package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

    private WPI_TalonFX m_first, m_second;
    private double m_firstMinRange, m_firstMaxRange, m_secondMinRange, m_secondMaxRange;
    private static Arm m_instance;

    public Arm(WPI_TalonFX first, WPI_TalonFX second) {
        m_first = first;
        m_firstMinRange = Constants.Values.FIRST_ARM_MIN;
        m_firstMaxRange = Constants.Values.FIRST_ARM_MAX;
        first.selectProfileSlot(0, 0);
        first.config_kP(0, Constants.Values.FIRST_ARM_KP);
        first.config_kI(0, Constants.Values.FIRST_ARM_KI);
        first.config_kD(0, Constants.Values.FIRST_ARM_KD);
        first.setSelectedSensorPosition(0);
        m_second = second;
        m_secondMinRange = Constants.Values.SECOND_ARM_MIN;
        m_secondMaxRange = Constants.Values.SECOND_ARM_MAX;
        second.selectProfileSlot(0, 0);
        second.config_kP(0, Constants.Values.SECOND_ARM_KP);
        second.config_kI(0, Constants.Values.SECOND_ARM_KI);
        second.config_kD(0, Constants.Values.SECOND_ARM_KD);
        second.setSelectedSensorPosition(0);
    }

    public static Arm getInstance(){
        if(m_instance == null){
            m_instance = new Arm(new WPI_TalonFX(Constants.MotorPorts.FIRST_ARM_PORT), new WPI_TalonFX(Constants.MotorPorts.SECOND_ARM_PORT));
        }
        return m_instance;
    }

    public void turnFirstTo(double angle) {
        double currentAngle = Constants.Functions.ticksToAngle(m_first.getSelectedSensorPosition());
        double target = 0;
        if (angle < m_firstMinRange && angle == 0)
            target = Constants.Functions.angleToTicks(currentAngle + Constants.Functions.closestAngle(m_firstMinRange, angle));
        else if (angle > m_firstMaxRange && angle == 0)
            target = Constants.Functions.angleToTicks(currentAngle + Constants.Functions.closestAngle(m_firstMaxRange, angle));
        else
            target = Constants.Functions.angleToTicks(currentAngle + Constants.Functions.closestAngle(currentAngle, angle));
        m_first.set(TalonFXControlMode.Position, target);
    }

    public void turnSecondTo(double angle) {
        double currentAngle = Constants.Functions.ticksToAngle(m_second.getSelectedSensorPosition());
        double target = 0;
        if (angle < m_secondMinRange && angle == 0)
            target = Constants.Functions.angleToTicks(currentAngle + Constants.Functions.closestAngle(m_secondMinRange, angle));
        else if (angle > m_secondMaxRange && angle == 0)
            target = Constants.Functions.angleToTicks(currentAngle + Constants.Functions.closestAngle(m_secondMaxRange, angle));
        else
            target = Constants.Functions.angleToTicks(currentAngle + Constants.Functions.closestAngle(currentAngle, angle));
        m_second.set(TalonFXControlMode.Position, target);
    }
}
