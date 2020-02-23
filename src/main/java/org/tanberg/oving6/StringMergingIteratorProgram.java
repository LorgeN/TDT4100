package org.tanberg.oving6;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class StringMergingIteratorProgram {

    public static void main(String[] args) throws Exception {
        Iterator<String> one = Lists.newArrayList("a", "b").iterator();
        Iterator<String> two = Lists.newArrayList("c", "d", "e").iterator();

        StringMergingIterator mergeIterator = new StringMergingIterator(one, two);

        List<String> values = Lists.newArrayList();

        while (mergeIterator.hasNext()) {
            values.add(mergeIterator.next());
        }

        List<String> expectedOutput = Lists.newArrayList("a", "c", "b", "d", "e");

        if (values.size() != expectedOutput.size()) {
            throw new Exception("The merged output did not contain the expected number of values. Try using the Eclipse debugger to see the difference between the lists.");
        }

        for (int i = 0; i < expectedOutput.size(); i++) {
            if (!values.get(i).equals(expectedOutput.get(i))) {
                throw new Exception("The iterator did not correctly merge the output. Try using the Eclipse debugger to see the difference between the lists.");
            }
        }

        System.out.println("Success! StringMergingIterator correctly merged the output of the two lists.");
    }
}
