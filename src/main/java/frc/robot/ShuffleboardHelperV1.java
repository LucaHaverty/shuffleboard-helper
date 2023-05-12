package frc.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class ShuffleboardHelperV1 {
    // public static class ShuffleboardOutput {
    //     private NetworkTableEntry entry;
    //     private Supplier<Object> supplier;
    //     private UpdateFrequency updateFrequency;

    //     public ShuffleboardOutput(String name, String tabName, Supplier<Object> supplier, UpdateFrequency updateFrequency) {
    //         this.entry = Shuffleboard.getTab(tabName).add(name, supplier.get()).getEntry();;
    //         this.supplier = supplier;
    //     }

    //     private int periodicCallsSinceUpdate = 0;
    //     public void update() {
    //         periodicCallsSinceUpdate++;
    //         //if (periodicCallsSinceUpdate >= updateFrequency.getFrequency())
    //             entry.setValue(supplier.get());
    //     }
    // }
    // public static List<ShuffleboardOutput> outputs = new ArrayList<ShuffleboardOutput>();

    // public static class ShuffleboardInput {
    //     private NetworkTableEntry entry;
    //     private Consumer<Object> consumer;
    //     private UpdateFrequency updateFrequency;

    //     public ShuffleboardInput(String name, String tabName, Consumer<Object> consumer, UpdateFrequency updateFrequency) {
    //         this.entry = Shuffleboard.getTab(tabName).add(name, 0).getEntry();;
    //         this.consumer = consumer;
    //     }

    //     private int periodicCallsSinceUpdate = 0;
    //     public void update() {
    //         periodicCallsSinceUpdate++;
    //         if (periodicCallsSinceUpdate >= updateFrequency.getFrequency())
    //             consumer.accept(entry.getDouble(0));
    //     }
    // }
    // public static List<ShuffleboardInput> inputs = new ArrayList<ShuffleboardInput>();

    // public static void AddOutput(String name, String tabName, Supplier<Object> supplier, UpdateFrequency updateFrequency) {
    //     outputs.add(new ShuffleboardOutput(name, tabName, supplier, updateFrequency));
    // }

    // public static void AddInput(String name, String tabName, Consumer<Object> consumer, UpdateFrequency updateFrequency) {
    //     inputs.add(new ShuffleboardInput(name, tabName, consumer, updateFrequency));
    // }

    // /** Called in robot.java */
    // public static void periodic() {
    //     outputs.forEach((output) -> output.update());
    //     inputs.forEach((input) -> input.update());
    // }

    // public enum UpdateFrequency {
    //     Fast(1),
    //     Medium(5),
    //     Slow(10);
        
    //     private int frequency;
    
    //     UpdateFrequency(int frequency) {
    //         this.frequency = frequency;
    //     }
    
    //     public int getFrequency() {
    //         return frequency;
    //     }
    // }
}
