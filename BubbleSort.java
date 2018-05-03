public class BubbleSort {
    
    public static void Bubble(int[] arr)
    {
        int n=arr.length;
        for(int i=1;i<n;i++)
    //Feld wird von vorne durchlaufen
        {
            for(int j=n-1;j>=i;j--)
    //Feld wird von hinten durchlaufen
            {
                if(arr[j-1]>arr[j])
    //überprüfen ob variable vor arr[j] größer ist
                {
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
    //Werte werden getauscht
                    arr[j-1]=tmp;
                }
            }
        }
    }
    
    public static float runtime(int[] array)
    {
        long tStart, tEnd, lmsecsrt;
        //Start der Messung der Laufzeit
        tStart = System.currentTimeMillis();
        Bubble(array);
        //Ende der Messung
        tEnd = System.currentTimeMillis();
        lmsecsrt = (tEnd - tStart);
        float fsecsrt = (float)lmsecsrt/(float)1000;    
        return fsecsrt;
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
     
    public static void main(String[] args)
    {
        int[] testArray = makeArray(5000);
		System.out.prinln("Bei einer Feldgröße von 500 ist die Laufzeit:"); 
        System.out.printf("%.4f", runtime(testArray)); 
        
        try
        {
            if(args.length == 1)
            {
                float t = Float.parseFloat(args[0]);
                if(t<0.0)
                {
                    System.out.println("Die Zeit läuft nicht rückwärts!");   
                }    
            }
            else
            {
                System.out.println("Gib eine Laufzeit ein!");
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
                System.out.println("Größe des Feldes: " +n +" Laufzeit: " +runtime(arr2));
            } 
            int tmpN = n/2;
            while(n >= tmpN)
            {
                int middle = (n+tmpN)/2;
                int[] arr3 = makeArray(middle); 
                float rtMid = runtime(arr3);
                if(rtMid+0.1 <= b || rtMid-0.1 >= b)
                {
                    System.out.println("Größe des Feldes: " +arr3.length + " Laufzeit: " +rtMid);
                }
                if(rtMid < b)
                {
                    tmpN = middle+1;
                }
                if(rtMid > b)
                {
                    n = middle-1;
                }
            }
        }
    }
}

   
