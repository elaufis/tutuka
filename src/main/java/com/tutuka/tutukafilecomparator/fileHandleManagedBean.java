/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutuka.tutukafilecomparator;

import com.tutuka.entity.TransactionRecord;
import com.tutuka.io.CSVFileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.servlet.http.Part;

/**
 *
 * @author Laurence
 */
@ManagedBean(name = "fileHandleManagedBean")
@SessionScoped
public class fileHandleManagedBean implements Serializable {

    private Part tutukaMarkoffFile;
    private Part clientMarkoffFile;
    private List<TransactionRecord> tutukaTransactionList;

    @Inject
    private CSVFileReader csvFileReader;

    public void compare() {
        CSVFileReader tutukaFileReader = new CSVFileReader(tutukaMarkoffFile);
        try {
            tutukaTransactionList = tutukaFileReader.loadFileIntoList();

            for (TransactionRecord tr : tutukaTransactionList) {
                System.out.println(tr.getTransactionID());
            }
        } catch (IOException e) {
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

    /**
     * Creates a new instance of fileHandleManagedBean
     */
    public fileHandleManagedBean() {
    }

    @PostConstruct
    public void init() {

    }

}
