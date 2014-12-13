
public class MainFunction extends ActivationStacks{
	static ActivationStacks stacks = new ActivationStacks();
	public static int f(int x, int y)
	{
		int a = x + 1;
		stacks.pushF(x, y, a); //add the fresh value to the record
		if(x == 0)
		{
			int temp = g(stacks.peekFy()); //store the value
			stacks.popF(); //remove the record
			return temp; //return the value
		}
		else
		{
			int temp = a + g(f((x-1), y)); //same principle as above
			stacks.popF();
			return temp;
		}
	}
	
	public static int g(int n)
	{
		int a = stacks.peekFx() + stacks.peekFy();
		stacks.pushG(n, a); //add the fresh value to the record
		if(n == 0)
		{
			return 0;
		}
        else
        {
            int temp = h(n-1); //store the value 
            stacks.popG(); //remove the record
            return temp; //return the value
        }
	}
	
	public static int h(int k)
	{
		stacks.pushH(k); //stores the k value into the record
		if(k == 0)       //it will never actually be used, however
		{
			stacks.popH();
			return 0;
		}
		else
		{
			return stacks.peekGa() + stacks.peekGn() + g((stacks.peekGn()-1));
		}
	}
		public static void main(String args[])
    {
        for(int x = 0; x <= 3; x++)
        {
            for(int y = 0; y <= 30; y++)
            {
                try{
                    //Prints out the x and y values, along with their output using f()
                    System.out.println("x:" + x + ", y " + y + ", Out: " + f(x,y));
                }catch(StackOverflowError e){
                    //Catches any overflow errors and prints the indices of that error
                    System.out.println("f("+x+", "+y+") is out of bounds");
                }
            }
        }
    }
	
}