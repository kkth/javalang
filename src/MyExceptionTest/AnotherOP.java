package MyExceptionTest;

public class AnotherOP {

	MyOp op = new MyOp();
	public void another()
	{
		try {
			op.op();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("catch exception");
		}
		finally
		{
			System.out.println("this is finally");
		}
	}
}
