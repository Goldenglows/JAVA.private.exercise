public class Quick {

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi <= lo)
            return;
        //对数组进行切分
        int j = partition(a, lo, hi);
        //process the left half of the array first
        sort(a,lo,j-1);
        //process the right half of the array
        sort(a,j+1,hi);
    }

    //function used for partition
    private static int partition(Comparable[] a, int lo, int hi)
    {
        //左右指针，用作扫描用
        int i = lo, j = hi+1;
        //切分用的元素
        Comparable v = a[lo];
        while(true)
        {
            //if the current pointer i to the value smaller than the marked element v
            //the pointer will be moved to the right
            while(less(a[++i], v))
                //stop loop when two pointers meet
                if(i == hi)
                    break;
            //if the current pointer j to the value bigger than v
            //the pointer will be moved to the left
            while(less(v,a[--j]))
                if(j == lo)
                    break;
            exch(a, lo, j);
        }
        //put v into the right position
        exch(a, lo, j);
        return j;
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
