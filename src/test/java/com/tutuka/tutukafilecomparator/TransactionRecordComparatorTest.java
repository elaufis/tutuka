/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutuka.tutukafilecomparator;

import com.tutuka.entity.TransactionRecord;
import com.tutuka.io.CSVFileReader;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laurence
 */
public class TransactionRecordComparatorTest {
    private TransactionRecordComparator comparator;
    
    private static final String CLIENT_FILE_LOCATION = "c:\\temp\\ClientMarkoffFile20140113.csv";
    private static final String TUTUKA_FILE_LOCATION = "c:\\temp\\TutukaMarkoffFile20140113.csv";
    
    public TransactionRecordComparatorTest() {
    }
    
    @Before
    public void setUp() {
        comparator = new TransactionRecordComparator();
    }
    
       /**
     * Test of compareAllTransactions method, of class TransactionRecordComparator.
     */
    @Test
    public void testCompareAllTransactions() throws Exception{
        CSVFileReader clientReader = new CSVFileReader(CLIENT_FILE_LOCATION);
        CSVFileReader tutukaReader = new CSVFileReader(TUTUKA_FILE_LOCATION);
        
        List<TransactionRecord> clientList = clientReader.loadFileIntoList();
        List<TransactionRecord> tutukaList = tutukaReader.loadFileIntoList();

        TransactionCounterDTO dto = comparator.compareAllTransactions(clientList, tutukaList);
        
        System.out.println(dto.getMatchedRecCounter());
        System.out.println(dto.getUnmatchedRecCounter());
        
        for(TransactionRecord tr: dto.getUnmatchedRecordList()){
            System.out.println(tr.getTransactionID());
        }
        
        TransactionCounterDTO dto2 = comparator.compareAllTransactions(tutukaList, clientList);
        
        System.out.println(dto2.getMatchedRecCounter());
        System.out.println(dto2.getUnmatchedRecCounter());
        
         for(TransactionRecord tr: dto2.getUnmatchedRecordList()){
            System.out.println(tr.getTransactionID());
        }
    }
    
    @After
    public void tearDown() {
        comparator = null;
    }
}
