import java.util.EmptyStackException;
import java.util.Stack;

public class ActivationStacks {
	//Internal stacks for each method's activation records
	Stack<FActivationRecord> f = new Stack<FActivationRecord>();
	Stack<GActivationRecord> g = new Stack<GActivationRecord>();
	Stack<HActivationRecord> h = new Stack<HActivationRecord>();
	
	//Getters for each stack of records
	public Stack<FActivationRecord> getF() 
	{
		return f;
	}	
	public Stack<GActivationRecord> getG()
	{
		return g;
	}	
	public Stack<HActivationRecord> getH()
	{
		return h;
	}

	//Push a new f record, look at the x/y/a value in the current f record,
	//or remove the current f record
	public boolean pushF(int x, int y, int a)
	{
		try
		{
			f.push(new FActivationRecord(x, y, a));
			return true;
		}
		catch(StackOverflowError e)
		{
			return false;
		}
	}
	public int peekFx()
	{
		return f.peek().getX();
	}
	public int peekFy()
	{
		return f.peek().getY();
	}
	public int peekFa()
	{
		return f.peek().getA();
	}
	public FActivationRecord popF()
	{
		try
		{
			return f.pop();
		}
		catch(EmptyStackException e)
		{
			return null;
		}
	}
	
	//Push a new g record, look at the n/a value in the current g record,
	//or remove the current g record
	public boolean pushG(int n, int a)
	{
		try
		{
			g.push(new GActivationRecord(n, a));
			return true;
		}
		catch(StackOverflowError e)
		{
			return false;
		}
	}
	public int peekGn()
	{
		return g.peek().getN();
	}
	public int peekGa()
	{
		return g.peek().getA();
	}	
	public GActivationRecord popG()
	{
		try
		{
			return g.pop();
		}
		catch(EmptyStackException e)
		{
			return null;
		}
	}
	
	//Push a new h record, look at the k value in the current h record,
	//or remove the current h record
	public boolean pushH(int k)
	{
		try
		{
			h.push(new HActivationRecord(k));
			return true;
		}
		catch(StackOverflowError e)
		{
			return false;
		}
	}
	public int peekHk()
	{
		return h.peek().getK();
	}
	public HActivationRecord popH()
	{
		try
		{
			return h.pop();
		}
		catch(EmptyStackException e)
		{
			return null;
		}
	}
}
