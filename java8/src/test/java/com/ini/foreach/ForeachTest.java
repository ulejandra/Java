package com.ini.foreach;

import static com.ini.foreach.Foreach.FOR_TYPE.STREAM;

import org.junit.Test;

import com.ini.foreach.Foreach.FOR_TYPE;

/**
 * Explicar que se pueden hacer diferentes tipos de imports al enum.
 * Explicar que esto no es util porque no es testeable, no hay nada que comprobar hasta el momento.
 * 
 * @author alejandra.ramirez
 *
 */
public class ForeachTest {

	@Test
	public void printFor() {
		Foreach.printList(10, FOR_TYPE.CLASSIC);
	}

	@Test
	public void printForeach() {
		Foreach.printList(10, FOR_TYPE.FOREACH); // importando el tipo FOR_TYPE.FOREACH
	}

	@Test
	public void printForStream() {
		Foreach.printList(10, STREAM); // static import "static com.ini.foreach.Foreach.FOR_TYPE.STREAM"
	}

}
