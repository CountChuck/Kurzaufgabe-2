	
	public static float runtime(int[] array)
	{
		long tStart, tEnd, lmsecsrt;
		//Start der Messung der Laufzeit
		tStart = System.currentTimeMillis();
		Bubble(array);
		//Ende der Messung
		tEnd = System.currentTimeMillis();
		lmsecsrt = (tEnd - tStart);
		float msecsrt = (float)lmsecsrt/(float) 1000;
		return msecsrt;
	}
     
    public static void main(String[] args)
    {
		try
		{
			if(args.length == 1)
			{
				//Berechnung der Laufzeit eines Feldes der Eingabegröße mit BubbleSort
				int a = Integer.parseInt(args[0]);
				if(a>0)
				{
					int[]arr=makeArray(a);
					System.out.println("Laufzeit: " + runtime(arr));
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
			try{

			float b = Float.parseFloat(args[0]);
				if(b>0.0)
				{
					int n = 1000;
					int[] arr2 = makeArray(n);
					//Suche beginnt bei einer Feldgröße von 1000
					while(b > runtime(arr2))
					{
						//Feldgröße wird solange verdoppelt bis BubbleSort länger braucht als die Eingabe
						n = 2*n;
						arr2 = makeArray(n);
						System.out.println(runtime(makeArray(n)) + " " + n);
					}
					//Feldgröße bevor BubbleSort länger gebraucht hat
					int tmpN = n/2;
					//Binäre Suche startet
					while(n >= tmpN)
					{
						int middle = (n+tmpN)/2;
						//Laufzeit des Wertes in der Mitte zwischen den beiden Feldgrößen
						float rtMid = runtime(makeArray(middle));
						//Abbruch und ausgabe wenn Abweichung weniger als 0.1
						if(rtMid+0.1 >= b && rtMid-0.1 <= b)
						{
							System.out.println(runtime(makeArray(middle)) + " " + middle);
							return;
						}
						if(rtMid < b)
						{
							tmpN = middle+1;
							System.out.println(runtime(makeArray(middle)) + " " + middle);
						}
						if(rtMid > b)
						{
							n = middle-1;
							System.out.println(runtime(makeArray(middle)) + " " + middle);
						}
					}
				}
				else
				{
					System.out.println("Nur positive Zahlen!");
				}
			
			}
			catch(NumberFormatException f)
			{
					System.out.println("Bitte eine Zahl eingeben!");
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
