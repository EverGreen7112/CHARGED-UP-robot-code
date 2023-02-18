package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Swerve;

public class DriveByJoystick extends CommandBase{
    private Swerve m_swerve;
    public DriveByJoystick(){
        addRequirements(Swerve.swerve);
        m_swerve = Swerve.swerve;
    }
    @Override
    public void execute() {
        m_swerve.drive(RobotContainer.leftJoystick.getX(), RobotContainer.leftJoystick.getY(), RobotContainer.rightJoystick.getX());
    }
    
}
