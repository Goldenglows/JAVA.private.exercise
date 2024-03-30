public class Quickway {
    //其他内容在Quick内
    //
    private static void sort(Comparable[] a, int lo, int hi)
    {
        //The public method that calls this method is in Quick
        if( hi <= lo )
            return;
        //three pointers are used to divide three regions
        //lt represents the identification of elements that are smaller than the value of v
        //gt opposite
        int lt = lo, i = lo+1, gt = hi;
        //set identification
        Comparable v = a[lo];
        while(i <= gt)
        {
            int cmp = a[1].compareTo(v);
            if(cmp < 0)
                //if a[i] less than v
                //exchange between a[lt] and a[i]
                exch(a, lt++, i++);
            else if(cmp > 0)
                //if a[i] more than v
                //exchange between a[gt] and a[i]
                exch(a, i, gt--);
            else
                i++;
        }
        //splitting completed
        sort(a, lo, lt-1);
        sort(a, gt + 1, hi);
    }


}
