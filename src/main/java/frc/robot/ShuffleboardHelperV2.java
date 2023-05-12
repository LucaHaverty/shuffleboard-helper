package frc.robot;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleboardHelperV2 {
    // private static final boolean debugEnabled = true;

    // public static ShuffleboardTab exampleTab = Shuffleboard.getTab("Example Tab");
    // private static ArrayList<Runnable> persistentOutputs = new ArrayList<Runnable>();
    // private static ArrayList<Runnable> debugOutputs = new ArrayList<Runnable>();


    // private static void addOutputCall(Runnable runnable, boolean isDebug) {
    //     if (isDebug) 
    //         debugOutputs.add(runnable);
    //     else persistentOutputs.add(runnable);
    // }

    // public static void addDoubleOutput(String name, Supplier<Double> supplier, ShuffleboardTab tab, int xPos, int yPos, boolean isDebug) {
    //     GenericEntry entry = tab.add(name, supplier.get()).withPosition(xPos, yPos).getEntry();
    //     addOutputCall(() -> entry.setDouble(supplier.get()), isDebug);
    // }
    // public static void addDoubleOutput(String name, Supplier<Double> supplier, ShuffleboardTab tab, int xPos, int yPos) {
    //     addDoubleOutput(name, supplier, tab, xPos, yPos, false);
    // }
    // public static void addDoubleOutput(String name, Supplier<Double> supplier, ShuffleboardTab tab, boolean isDebug) {
    //     GenericEntry entry = tab.add(name, 0).getEntry();
    //     addOutputCall(() -> entry.setDouble(supplier.get()), isDebug);
    // }
    // public static void addDoubleOutput(String name, Supplier<Double> supplier, ShuffleboardTab tab) {
    //     addDoubleOutput(name, supplier, tab, false);
    // }

    // public static void addDialOutput(String name, Supplier<Double> supplier, ShuffleboardTab tab, int xPos, int yPos, float min, float max, boolean isDebug) {
    //     GenericEntry entry = tab.add(name, supplier.get()).withPosition(xPos, yPos).withWidget(BuiltInWidgets.kDial).withProperties(Map.of("min", min, "max", max)).getEntry();
    //     addOutputCall(() -> entry.setDouble(supplier.get()), isDebug);
    // }

    // public static void Update() {
    //     for(Runnable runnable : persistentOutputs)
    //         runnable.run();

    //     if (debugEnabled)
    //         for(Runnable runnable : debugOutputs)
    //             runnable.run();
    // }
}
