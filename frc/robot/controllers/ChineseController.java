package frc.robot.controllers;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This is a preset for the chinese knock-off playstation controller, and all of
 * its buttons.
 * 
 */
public class ChineseController extends DummyDriverController {

    public ChineseController(int port) {
        super(port);
    }

    public double getLeftX() {
        return controller.getRawAxis(0);
    }

    public double getLeftY() {
        return controller.getRawAxis(1);
    }

    public double getRightY() {
        return controller.getRawAxis(-4);
    }

    public double getRightX() {
        return controller.getRawAxis(4);
    }

    @Override
    public JoystickButton getA() {
        return new JoystickButton(controller, 0);
    }

    @Override
    // TODO: find values for the buttons once the wiki is up
    public JoystickButton getB() {
        return new JoystickButton(controller, 1);
    }

    @Override
    public JoystickButton getX() {
        return new JoystickButton(controller, 3);
    }

    @Override
    public JoystickButton getY() {
        return new JoystickButton(controller, 1);
    }

    @Override
    public double rightTrigger() {
        return 0;
    }

    @Override
    public double leftTrigger() {
        return 0;
    }

    @Override
    public JoystickButton rightBumper() {
        return new JoystickButton(controller, 5);
    }

    @Override
    public JoystickButton leftBumper() {
        return new JoystickButton(controller, 6);
    }

    public int getDPAD() {
        return controller.getPOV(0);
    }

    @Override
    public JoystickButton cameraSwitch() {
        return new JoystickButton(controller, 3);
    }
    

}