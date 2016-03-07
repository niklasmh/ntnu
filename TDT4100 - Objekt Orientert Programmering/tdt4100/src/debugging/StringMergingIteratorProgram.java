package debugging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

public class StringMergingIteratorProgram {

	public static void main(String[] args) throws Exception {

		Iterator<String> one = CollectionLiterals.<String>newArrayList("a", "b").iterator();
		Iterator<String> two = CollectionLiterals.<String>newArrayList("c", "d", "e").iterator();
		 
		StringMergingIterator mergeIterator = new StringMergingIterator(one, two); 
		
		List<String> values = new ArrayList<String>();
		
		while(mergeIterator.hasNext()){
			values.add(mergeIterator.next());
		}
		
		List<String> expectedOutput = CollectionLiterals.<String>newArrayList("a", "c", "b", "d", "e");
		
		if(values.size() != expectedOutput.size()){
			throw new Exception("The merged output did not contain the expected number of values. Try using the Eclipse debugger to see the difference between the lists.");
		}
		
		for(int i = 0; i < expectedOutput.size(); i++){
			if(! values.get(i).equals(expectedOutput.get(i))){
				throw new Exception("The iterator did not correctly merge the output. Try using the Eclipse debugger to see the difference between the lists.");
			}
		}
		
		System.out.println("Success! StringMergingIterator correctly merged the output of the two lists.");
		
	}

}
