package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] genArray;

    public ArrayUtility(T[] inArray) {
        this.genArray = inArray;
    }
    public <T> Integer getNumberOfOccurrences(T valueToEvaluate){
        int count = 0;
        for(int i = 0; i < genArray.length; i++) {
            if(genArray[i] == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

    public Integer countDuplicatesInMerge(T[] mergeArray, T valueToEvaluate){
        int count = 0;
        List<T> comboArray = new ArrayList<>(mergeArray.length + genArray.length);
        comboArray.addAll(Arrays.asList(genArray));
        for(int i = 0; i < mergeArray.length; i++) {
            comboArray.add(mergeArray[i]);
        }
        for(int i = 0; i < comboArray.size(); i++){
            if(comboArray.get(i) == valueToEvaluate) {
                count++;
            }

        }
        return count;
    }
    public T getMostCommonFromMerge(T[] mergeArray) {
        List<T> comboArray = new ArrayList<>(mergeArray.length + genArray.length);
        comboArray.addAll(Arrays.asList(genArray));
        for(int i = 0; i < mergeArray.length; i++) {
            comboArray.add(mergeArray[i]);
        }
        int high = 0;
        T mostCommon = null;
        for(int i = 0; i < comboArray.size(); i++) {
            int count = 0;
            for(int j = 0; j < comboArray.size(); j++) {
                if (comboArray.get(i) == comboArray.get(j)){
                    count++;
                }
            }
            if (count > high){
                high = count;
                mostCommon = comboArray.get(i);
            }
        }
        return mostCommon;
    }
    public T[] removeValue(T valueToRemove){
        ArrayList<T> copyList = new ArrayList<>(List.of(genArray));
        for(int i = 0; i < copyList.size(); i++){
            if(copyList.get(i) == valueToRemove){
                copyList.remove(i);
                i--;
            }
        }
        T[] result = Arrays.copyOf(genArray, copyList.size());
        for(int i = 0; i < result.length; i++) {
            result[i] = copyList.get(i);
        }
        return result;
    }
}
