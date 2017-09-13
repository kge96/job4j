package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Test
*
*@author Gleb Kuznetsov
*@version 0.1
*@since 13.09.17
*/
public class CalculateTest {
	/**
	*Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName(){
		String input = "Java";
		String expect = "Echo, echo, echo : Java";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}