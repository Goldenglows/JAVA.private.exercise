public class Selection {
    public static void sort(Comparable[] a)
    {
        //数组长度
        int n=a.length;
        for (int i=0;i<n;i++)
        {
            //记录最小元素的索引
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                //判断i后面的所有元素哪个最小，并且将角标赋值给min
                if(less(a[j],a[min]))
                    min=j;
            }
            exch(a,i,min);
        }
    }

    private static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j)
    {
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static void show(Comparable[] a)
    {
        for(int i=0;i<a.length;i++)
            StdOut.print(a[i]+"");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }



}
