/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutuka.tutukafilecomparator;

import com.tutuka.entity.TransactionRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;

/**
 *
 * @author Laurence
 */
public class TransactionRecordComparator {
    private Javers javers;
    
    public TransactionRecordComparator(){
        javers = JaversBuilder.javers().build();
    }
    
    public TransactionCounterDTO compareAllTransactions(List<TransactionRecord> t1List, List<TransactionRecord> t2List ){
        Map<String, TransactionRecord> t2Map = convertListToMap(t2List);
        TransactionCounterDTO counter = new TransactionCounterDTO();
        
        List<TransactionRecord> matchedRecordList = new ArrayList<TransactionRecord>();
        List<TransactionRecord> unmatchedRecordList = new ArrayList<TransactionRecord>();
        
        for(TransactionRecord tr: t1List){
            if(t2Map.containsKey(tr.getTransactionID())){
                if(getTransactionRecordDiff(tr, t2Map.get(tr.getTransactionID()))){
                    unmatchedRecordList.add(tr);
                    counter.incrementUnmatchedRecCounter();
                }
                else{
                    matchedRecordList.add(tr);
                    counter.incrementMatchedRecCounter();
                }
            }
            else {
                unmatchedRecordList.add(tr);
                counter.incrementUnmatchedRecCounter();
            }
        }
        counter.setMatchedRecordList(matchedRecordList);
        counter.setUnmatchedRecordList(unmatchedRecordList);
        return counter;
    }
    
    public Boolean getTransactionRecordDiff(TransactionRecord t1, TransactionRecord t2){
        Diff diff = javers.compare(t1, t2);
        
        return diff.hasChanges();
    }
    
    private Map<String, TransactionRecord> convertListToMap(List<TransactionRecord> transactionRecordList){
        Map<String, TransactionRecord> transactionRecordMap = new HashMap<>();
        
        for(TransactionRecord tr : transactionRecordList){
            transactionRecordMap.put(tr.getTransactionID(), tr);
        }
        
        return transactionRecordMap;
    }
    
    
    
}
