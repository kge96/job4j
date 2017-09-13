package ru.job4j;
/**
*Class класс для вывода сообщения "Hello world" в консоль.
*
*@author gkuznetsov.
*@since 13.09.17.
*@version 0.1.
*/
class Calculate {
	/**
	*Начало выполнения программы. Вывод сообщения "Hello world" в консоль.
	*@param args - массив аргументов args.
	*/
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	Method echo.
	*@param name Your name.
	*@return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}