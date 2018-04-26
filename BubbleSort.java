public class BubbleSort
{
    public static void Bubble(int[] arr)
    {
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            for(int j=n-1;j>=i;j--)
            {
                if(arr[j-1]>arr[j])
                {
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }
            }
        }
    }

    public static void measure(int[] array)
	{
		long tStart, tEnd, lmsecs;
		//Start der Messung der Laufzeit
		tStart = System.currentTimeMillis();
		Bubble(array);
		//Ende der Messung
		tEnd = System.currentTimeMillis();
		//Umrechnung der Millisekunden in Sekunden und anschließende Ausgabe
		lmsecs = (tEnd - tStart)/1000;
		float msecs = lmsecs;
		System.out.println("Laufzeit: " + msecs);
    }
	
	public static float runtime(int[] array)
	{
		long tStart, tEnd, lmsecsrt;
		//Start der Messung der Laufzeit
		tStart = System.currentTimeMillis();
		Bubble(array);
		//Ende der Messung
		tEnd = System.currentTimeMillis();
		lmsecsrt = (tEnd - tStart)/1000;
		float msecsrt = lmsecsrt;
		return msecsrt;
	}
     
    public static void main(String[] args)
    {
		try
		{
			if(args.length == 1)
			{
				int a = Integer.parseInt(args[0]);
				if(a>0)
				{
					int[]arr=makeArray(a);
					measure(arr);
				}
				else
				{
					System.out.println("Nur positive Zahlen!");   
				}	 
			}
			else
			{
				System.out.println("Genau eine Eingabe bitte!");
			}
		}
		catch(NumberFormatException e)
		{
			float b = Float.parseFloat(args[0]);
			int n = 1000;
			int[] arr2 = makeArray(n);
			while(b > runtime(arr2))
			{
				n = 2*n;
				arr2 = makeArray(n);
			}
			int tmpN = n/2;
			while(n >= tmpN)
			{
				int middle = (n+tmpN)/2;
				float rtMid = runtime(makeArray(middle));
				if(rtMid+0.1 <= b || rtMid-0.1 >= b)
				{
					System.out.println(runtime(makeArray(middle)));
				}
				if(middle < b)
				{
					tmpN = middle+1;
				}
				if(middle > b)
				{
					n = middle-1;
				}
			}
		}
    }
    
    public static int[] makeArray(int a)
    {
        int[]arr=new int[a];
        //füllen einen Array mit absteigend sortierten Zahlen
        for(int j = 0; j < arr.length; j++)
        {
            //Werte von hinten nach vorne einfügen
            arr[j] = a;
            a--;
        }
        return arr;
    }
}