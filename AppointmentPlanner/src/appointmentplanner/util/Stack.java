/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentplanner.util;

import appointmentplanner.Appointment;

/**
 *
 * @author sriem
 */
public class Stack {

    private int itemPos;
    private int lastPos;
    private int stackSize = 200;
    private boolean firstItem = true;
    private Appointment[] appointmentArray;
    
    
    
    public Stack() {
        appointmentArray = new Appointment[stackSize];
        lastPos = 0;
        itemPos = 0;

    }
    /**
     * This Method is creating a Queue of all Appointments
     *
     * @return the Size of the Stack
     */
    public int size() {
        return itemPos;
    }
    
    /**
     * This Method checks if the Stack is empty
     *
     * @return true if the Stack is empty, false otherwise
     */
    public boolean isEmpty() {
        if (lastPos == 0) {
            return true;
        }

        return false;
    }
    
    /**
     * This Method puts a Appointment in to the Stack
     *
     * @param item The Appointment
     */
    public void push(Appointment item) {
        if (lastPos == 0 && itemPos == 0) {
            appointmentArray[itemPos] = item;
            lastPos++;
        }

        if (lastPos != 0) {
            appointmentArray[lastPos] = item;
            itemPos++;
            lastPos++;

        }

    }
    
    
    /**
     * This Method removes the last added Appointment of the Stack
     *
     * @return the last added object of the Stack
     */
    public Appointment pop() {
        Appointment result = appointmentArray[itemPos];
        //Regular expresion
        if (lastPos != 0) {
            itemPos--;
            lastPos--;
        }
        //Last Item in Stack
        if (itemPos == 0) {
            lastPos--;
        }
        // no Further Pops possible Stack is empty
        if(itemPos ==  0 && lastPos == 0){
            appointmentArray[itemPos] = null;
            return result;
        }
        
        return result;
    }
}
