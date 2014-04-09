package org.teasdale.api;

import java.util.Collection;

/**
 * Represents a single serial connection to an Arduino,
 * provides methods for utilizing that connection.
 */
public interface ArduinoSerialConnection {

    /**
     * @return a collection of available port names (e.g. "COM3", "/dev/ttyS0", "/dev/ttyUSB0", etc.)
     */
    public Collection<String> ports();

    /**
     * Open a serial connection to the Arduino.  This method includes
     * a two second delay to allow the Arduino to reset itself.
     */
    public void open();

    /**
     * Write a series of bytes to the Arduino.  This method sends the byte
     * array verbatim - it does no processing, appends no terminators, etc.
     * <br><br>
     * The {@link #open} method must be called once before attempting to
     * call this method.
     *
     * @param bytes An array of bytes to write to the Arduino
     */
    public void writeBytes(byte[] bytes);

    /**
     * Update the value of a previously registered command.  Once updated,
     * the command and value will be sent on the next transmission cycle.
     * <br><br>
     * The command being updated must have been previously registerd via the
     * {@link ArduinoSerialConfig#registerCommand(String, int)} method.
     *
     * @param commandName The name of the command to update
     * @param value The updated command value
     */
    public void updateCommand(String commandName, int value);

    /**
     * Close the serial connection.
     */
    public void close();
}
