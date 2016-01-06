/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Emil
 */
public class InputArgs {
    
    private String rowNumber ;
    private String columnNumber ;
    private String screenView ;
    private String filePath ;
    private int seconds;

    public InputArgs(String [] args) {
        this.rowNumber = args[0];
        this.columnNumber = args[1];
        this.screenView = args[2];
        this.filePath = args[3];
        this.seconds = Integer.parseInt(args[4]);
    }
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(String columnNumber) {
        this.columnNumber = columnNumber;
    }

    public String getScreenView() {
        return screenView;
    }

    public void setScreenView(String screenView) {
        this.screenView = screenView;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
}
