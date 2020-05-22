package com.ini.foreach;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Explicar los cambios del FOR. Primer acercamiento a los lambdas</br>
 * Recordar el uso de los enums.</br>
 * Explicar el acceso a un constructor privado.</br>
 * 
 * @author alejandra.ramirez
 *
 */
public class Foreach {

	enum FOR_TYPE {
		CLASSIC, FOREACH, STREAM
	} // Puede ir sin ";" <- Hacerlo notar en la clase

	private static final Logger LOG = LoggerFactory.getLogger(Foreach.class);

	private List<Integer> ints; // Preguntar si podemos tener listas de tipo primitivo (int)

	private Foreach(int size) {
		ints = new ArrayList<>(size);
		for (Integer i = 0; i < size; i++) {
			ints.add(i);
		}
	}

	public static void printList(int size, FOR_TYPE type) {
		switch (type) {
		case CLASSIC:
			new Foreach(size).printFor();
			break;
		case FOREACH:
			new Foreach(size).printForeach();
			break;
		case STREAM:
			new Foreach(size).printForStream();
			break;
		}
	}

	private void printFor() {
		for (int i = 0; i < ints.size(); i++) {
			LOG.info("Arr [{}] = {}", i, ints.get(i));
		}
	}

	private void printForeach() {
		for (Integer integer : ints) {
			LOG.info("Arr = {} ", integer);

		}
	}

	private void printForStream() {
		ints.forEach(integer -> LOG.info("Arr = {} ", integer));
	}

}
