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
        m_firstMinRange = Constants.ArmValues.FIRST_ARM_MIN;
        m_firstMaxRange = Constants.ArmValues.FIRST_ARM_MAX;
        first.selectProfileSlot(0, 0);
        first.config_kP(0, Constants.PidValues.FIRST_ARM_KP);
        first.config_kI(0, Constants.PidValues.FIRST_ARM_KI);
        first.config_kD(0, Constants.PidValues.FIRST_ARM_KD);
        first.setSelectedSensorPosition(0);
        m_second = second;
        m_secondMinRange = Constants.ArmValues.SECOND_ARM_MIN;
        m_secondMaxRange = Constants.ArmValues.SECOND_ARM_MAX;
        second.selectProfileSlot(0, 0);
        second.config_kP(0, Constants.PidValues.SECOND_ARM_KP);
        second.config_kI(0, Constants.PidValues.SECOND_ARM_KI);
        second.config_kD(0, Constants.PidValues.SECOND_ARM_KD);
        second.setSelectedSensorPosition(0);
    }

    public static Arm getInstance(){
        if(m_instance == null){
            m_instance = new Arm(new WPI_TalonFX(Constants.MotorPorts.FIRST_ARM_PORT), new WPI_TalonFX(Constants.MotorPorts.SECOND_ARM_PORT));
        }
        return m_instance;
    }

    public void turnFirstTo(double angle) {
        if (Math.abs(Controls.m_rightJoystick.getX()) < Constants.ArmValues.JOYSTICK_TOLERANCE && Math.abs(Controls.m_rightJoystick.getY()) < Constants.ArmValues.JOYSTICK_TOLERANCE) {
            return;
          }
          double m_JoystickAngle = Math.toDegrees(Math.atan2(Controls.m_rightJoystick.getX(), Controls.m_rightJoystick.getY()));
          if(m_JoystickAngle <= 0)
           m_JoystickAngle += 360;
          double m_firstAngle = Constants.Functions.ticksToAngle(m_first.getSelectedSensorPosition());
          double m_firstTarget = Constants.Functions.angleToTicks(m_firstAngle + Constants.Functions.closestAngle(m_firstAngle, m_JoystickAngle));
          if (m_JoystickAngle <= m_firstMaxRange && m_JoystickAngle >= m_firstMinRange){
            if (Math.abs(m_JoystickAngle - Math.abs(Constants.Functions.modulo(Constants.Functions.ticksToAngle(m_firstTarget), 360))) > m_firstMaxRange + Constants.ArmValues.LIMIT_TOLERANCE || Math.abs(m_JoystickAngle - Math.abs(Constants.Functions.modulo(Constants.Functions.ticksToAngle(m_firstTarget), 360))) < m_firstMinRange - Constants.ArmValues.LIMIT_TOLERANCE){
              m_first.set(TalonFXControlMode.Position, m_firstTarget);
            }
            else {
              m_first.set(TalonFXControlMode.Position, Constants.Functions.angleToTicks(m_JoystickAngle));
            }
          }
    }

    public void turnSecondTo(double angle) {
        if (Math.abs(Controls.m_rightJoystick.getX()) < Constants.ArmValues.JOYSTICK_TOLERANCE && Math.abs(Controls.m_rightJoystick.getY()) < Constants.ArmValues.JOYSTICK_TOLERANCE) {
            return;
          }
          double m_JoystickAngle = Math.toDegrees(Math.atan2(Controls.m_rightJoystick.getX(), Controls.m_rightJoystick.getY()));
          if(m_JoystickAngle <= 0)
           m_JoystickAngle += 360;
          double m_secondAngle = Constants.Functions.ticksToAngle(m_second.getSelectedSensorPosition());
          double m_secondTarget = Constants.Functions.angleToTicks(m_secondAngle + Constants.Functions.closestAngle(m_secondAngle, m_JoystickAngle));
          if (m_JoystickAngle <= m_secondMaxRange && m_JoystickAngle >= m_secondMinRange){
            if (Math.abs(m_JoystickAngle - Math.abs(Constants.Functions.modulo(Constants.Functions.ticksToAngle(m_secondTarget), 360))) > m_secondMaxRange + Constants.ArmValues.LIMIT_TOLERANCE || Math.abs(m_JoystickAngle - Math.abs(Constants.Functions.modulo(Constants.Functions.ticksToAngle(m_secondTarget), 360))) < m_secondMinRange - Constants.ArmValues.LIMIT_TOLERANCE){
              m_second.set(TalonFXControlMode.Position, m_secondTarget);
            }
            else {
              m_second.set(TalonFXControlMode.Position, Constants.Functions.angleToTicks(m_JoystickAngle));
            }
          }
    }
}
