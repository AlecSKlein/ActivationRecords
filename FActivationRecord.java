public class FActivationRecord extends ActivationStacks{
	int x, y, a;
	//A constructor for the F activation record
	public FActivationRecord(int x, int y, int a)
	{
		this.x = x;
		this.y = y;
		this.a = a;
	}
	
	public int getX()
	{return x;}
	
	public int getY()
	{return y;}
	
	public int getA()
	{return a;}
}
