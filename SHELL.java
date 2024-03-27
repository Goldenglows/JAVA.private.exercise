public class SHELL {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        //h 是一个增量序列（用作后面插入排序的间隔），初始值根据N/3计算最大的h值
        while (h < N/3)
            h=h*3 + 1;
        //当h为0，就排列成功了
        while (h >= 1)
        {
            //接下来就是间隔为h的插入排序（只是普通的插入只需要间隔1，这个要间隔h
            for(int i=h;i<N;i++)
            {
                for(int j = i;j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
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
