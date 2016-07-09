package MyExceptionTest;

public class MyOp {

	public void op() throws MyException
	{
		System.out.println("op");
		throw new MyException();
	}
}
