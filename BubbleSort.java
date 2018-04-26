public class BubbleSort
{
    public static void Bubble(int[]arr)
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
		double tStart, tEnd, msecs;
		//Modus 0 = Laufzeit von InsertionSort soll gemessen werden
		
		
			//Start der Messung der Laufzeit
			tStart = System.currentTimeMillis();
			Bubble(array);
			//Ende der Messung
			tEnd = System.currentTimeMillis();
			System.out.println("Laufzeit: " + (msecs = (tEnd - tStart)/1000));
    

     }
     
    public static void main(String[] args)
    {
        if(args.length==1)
        {
            int a = Integer.parseInt(args[0]);
            if(a>0)
            {
            int[]arr=makeArray(a);
            measure(arr);
        }
        
        else
        {
            System.out.println("Nur positive Zahlen");
            
        }
        
            
        }
        else
        {
            System.out.println("Genau eine Eingabe bitte");
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
