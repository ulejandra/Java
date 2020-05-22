package com.ini.foreach;

import static com.ini.foreach.Foreach.FOR_TYPE.STREAM;

import org.junit.Test;

import com.ini.foreach.Foreach.FOR_TYPE;

public class ForeachTest {

	@Test
	public void printFor() {
		Foreach.printList(10, FOR_TYPE.FOREACH.CLASSIC); // Accediendo directo FOR_TYPE.FOREACH.CLASSIC
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
