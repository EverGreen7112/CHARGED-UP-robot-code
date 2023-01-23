package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class EncoderPositionPID extends CommandBase {
    
    private TalonSRX m_talon;
    private double m_kp;
    private double m_ki;
    private double m_kd;
    private double m_target;
    private double m_tolerance;
    /**
     * 
     * @param talon - TalonSRX must be configured with encoder correctly
     * @param kp - proportional value of pid
     * @param ki - integral value of pid
     * @param kd - derivative value of pid
     * @param target - target of pid
     * @param tolerance - the allowed tolerance in ticks.
     */
    public EncoderPositionPID(TalonSRX talon, double kp, double ki, double kd, double target, double tolerance){
      m_talon = talon;
      m_kp = kp;
      m_ki = ki;
      m_kd = kd;
      m_target = target;
      m_tolerance = tolerance;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()  {
      m_talon.selectProfileSlot(0, 0);
      m_talon.config_kP(0, m_kp);
      m_talon.config_kI(0, m_ki);
      m_talon.config_kD(0, m_kd);
      m_talon.setSelectedSensorPosition(0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      m_talon.setSensorPhase(true);
      m_talon.set(TalonSRXControlMode.Position, m_target);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return m_talon.getSelectedSensorPosition() < (m_target + m_tolerance) && m_talon.getSelectedSensorPosition() > (m_target - m_tolerance);
    }

}