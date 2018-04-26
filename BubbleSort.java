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
        show(arr);
    }
    
    public static void show(int[]arr)
    {
        for(int a : arr)
        {
            System.out.print(a+" ");
        }
    }
    


}
