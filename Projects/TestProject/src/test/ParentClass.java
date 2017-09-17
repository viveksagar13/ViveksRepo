package test;

public class ParentClass {
	
	public void parentMethod()
	{
		System.out.println("This is getting called frm parent");
		System.out.println("this:"+this.getClass().getSimpleName());
	}

}
