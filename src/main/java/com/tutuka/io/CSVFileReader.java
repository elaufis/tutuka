/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutuka.io;

import com.tutuka.entity.TransactionRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Laurence
 */
public class CSVFileReader {

    String fileLocation;
    Part tutukaFile;
    Boolean handlePart;

    public CSVFileReader(Part tutukaFile) {
        this.tutukaFile = tutukaFile;
        handlePart = true;
    }

    public CSVFileReader(String fileLocation) {
        this.fileLocation = fileLocation;
        handlePart = false;
    }

    public List<TransactionRecord> loadFileIntoList() throws IOException {
        Reader in;
        if(handlePart){
            in = new InputStreamReader(tutukaFile.getInputStream());
        }
        else {
            in = new FileReader(fileLocation);
        }

        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

        List<TransactionRecord> trecList;
        trecList = new ArrayList<>();
        for (CSVRecord rec : records) {
            TransactionRecord trec = new TransactionRecord();
            trec.setTransactionID(rec.get("TransactionID"));
            trecList.add(trec);
        }
        return trecList;
    }
}
