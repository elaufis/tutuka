/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutuka.tutukafilecomparator;

import com.tutuka.entity.TransactionRecord;
import com.tutuka.io.CSVFileReader;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Laurence
 */
@Named(value = "fileComparatorController")
@RequestScoped
public class FileComparatorController {

    private Part tutukaMarkoffFile;
    private Part clientMarkoffFile;
    private List<TransactionRecord> tutukaTransactionList;

    @Inject
    private CSVFileReader csvFileReader;
    
    public FileComparatorController(){
        
    }

    public void compare() {
        try{
             tutukaTransactionList = csvFileReader.loadFileIntoList();
        }
        catch(IOException e){
            e.printStackTrace();
        }
       
    }

    public Part getTutukaMarkoffFile() {
        return tutukaMarkoffFile;
    }

    public void setTutukaMarkoffFile(Part tutukaMarkoffFile) {
        this.tutukaMarkoffFile = tutukaMarkoffFile;
    }

    public Part getClientMarkoffFile() {
        return clientMarkoffFile;
    }

    public void setClientMarkoffFile(Part clientMarkoffFile) {
        this.clientMarkoffFile = clientMarkoffFile;
    }

    public List<TransactionRecord> getTutukaTransactionList() {
        return tutukaTransactionList;
    }

    public void setTutukaTransactionList(
            List<TransactionRecord> tutukaTransactionList) {
        this.tutukaTransactionList = tutukaTransactionList;
    }

}
