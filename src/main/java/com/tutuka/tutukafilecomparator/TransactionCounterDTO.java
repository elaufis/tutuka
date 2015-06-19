/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutuka.tutukafilecomparator;

import com.tutuka.entity.TransactionRecord;
import java.util.List;

/**
 *
 * @author Laurence
 */
public class TransactionCounterDTO {
    
    private int matchedRecCounter;
    private int unmatchedRecCounter;
    private List<TransactionRecord> matchedRecordList;

  
    private List<TransactionRecord> unmatchedRecordList;
    
    public TransactionCounterDTO(){
        matchedRecCounter = 0;
        unmatchedRecCounter = 0;
    }
    
    public void incrementMatchedRecCounter(){
        matchedRecCounter++;
    }
    
    public void incrementUnmatchedRecCounter() {
        unmatchedRecCounter++;
    }
    
        public int getMatchedRecCounter() {
        return matchedRecCounter;
    }

    public void setMatchedRecCounter(int matchedRecCounter) {
        this.matchedRecCounter = matchedRecCounter;
    }

    public int getUnmatchedRecCounter() {
        return unmatchedRecCounter;
    }

    public void setUnmatchedRecCounter(int unmatchedRecCounter) {
        this.unmatchedRecCounter = unmatchedRecCounter;
    }
    
      public List<TransactionRecord> getMatchedRecordList() {
        return matchedRecordList;
    }

    public void setMatchedRecordList(List<TransactionRecord> matchedRecordList) {
        this.matchedRecordList = matchedRecordList;
    }

    public List<TransactionRecord> getUnmatchedRecordList() {
        return unmatchedRecordList;
    }

    public void setUnmatchedRecordList(List<TransactionRecord> unmatchedRecordList) {
        this.unmatchedRecordList = unmatchedRecordList;
    }
    
}
