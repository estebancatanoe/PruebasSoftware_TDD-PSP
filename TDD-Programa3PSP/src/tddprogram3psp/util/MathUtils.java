/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tddprogram3psp.util;

import tddprogram3psp.util.exception.EmptyListException;
import tddprogram3psp.model.LinkedList;
import tddprogram3psp.model.Node;

/**
 *
 * @author Mateo Noreña
 * @author Joan Morales
 * @author Esteban Cataño
 */
public class MathUtils {

    public static double calculateMean(LinkedList list) throws EmptyListException {
        if (list.getHead() == null) {
            throw new EmptyListException();
        } else {
            double sum, mean, n;
            sum = 0;
            n = 0;
            Node p = list.getHead();
            while (p != null) {
                sum += p.getData();
                n++;
                p = p.getNext();
            }
            mean = sum / n;
            return mean;
        }
    }

    public static double calculateVariance(LinkedList list) throws EmptyListException {
        if (list.getHead() == null) {
            throw new EmptyListException();
        } 
        if (list.getHead().getNext() == null) {
            throw new ArithmeticException("No se puede obtener la varianza de un solo dato");
        }else {
            double variance, sum, n, mean;
            sum = 0;
            n = 0;
            mean = calculateMean(list);
            Node p = list.getHead();
            while (p != null) {
                n++;
                sum += Math.pow(p.getData() - mean, 2);
                p = p.getNext();
            }
            variance = sum / (n - 1);
            return variance;
        }
    }

    public static double calculateStdDev(double variance) {
        return Math.sqrt(variance);
    }
}
