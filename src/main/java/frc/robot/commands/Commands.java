package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class Commands {
    /**
     *  <p>Commands that go from one point to the other using simple drive and pid sequntally, assuming that turns at the endpoint are not desirebale</p>
     *  Symbols:
     * <ul>
     *  <li> l1 stright line at the angle of the robot that goes through the robot</li>
     *  <li>l2:  stright line at the angle of the endpoint that goes through the endpoint</li>
     * <li> R will represent the robot position, and E the endpoint</li>
     * </ul>
     * 
     * Steps:
     * <ol>
     * <li>(if necessery) The robot will turn until the intresection between l1 and l2 is  within miLineDist and maxLineDist(in the opsite direction of the bot) (this will not be done with pid, but rather turn and when in range stop, for time saving (the speed will be b+m*(diffrence_between_angles)))</li>
     * <li> The robot will drive stright to this intresection point</li>
     * <li>the robot will turn until l1 will overlap with l2</li>
     * <li> the robot will turn until p overlap with E</li>
     * </ol>
     * @param curX current x cordinite of robot
     * @param curY current y cordinite of robot
     * @param curAng current angle of robot
     * @param endX desired x cordinite of robot
     * @param endY desired y cordinite of robot
     * @param endAng desired angle of robot
     * @param minLineDist the minimum line distance (see first step)
     * @param maxLineDist the maximum line distance (see first step)
     * @return the command
     */
    public static CommandBase getDriveToLocationCommand(Vector2d curP,double curAng,Vector2d endP,double endAng,double minLineDist, double maxLineDist){
        Vector2d endDir = new Vector2d(Math.cos(endAng),Math.sin(endAng));
        Vector2d minP = 

    }
}
