package frc.robot.controllers.Basic;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class VirtualJoystickButton extends Button {
    GenericHID joystick;
    int axisNumber;
    double threshold;
    boolean invert;

    public VirtualJoystickButton(GenericHID _joystick, int _axisNumber, double _threshold, boolean _invert) {
        joystick = _joystick;
        axisNumber = _axisNumber;
        threshold = _threshold;
        invert = _invert;
    }
    public VirtualJoystickButton(GenericHID _joystick, int _axisNumber, double _threshold) {
        this(_joystick,_axisNumber,_threshold,false);
    }

    @Override
    public boolean get() {
        if (invert) {
            return joystick.getRawAxis(axisNumber) > threshold;
        } else {
            return joystick.getRawAxis(axisNumber) < threshold;
        }
    }
}