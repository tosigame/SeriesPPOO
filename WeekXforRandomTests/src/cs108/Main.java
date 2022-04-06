package cs108;

import java.util.*;

public class Main {
    static final int LENGTH=Integer.SIZE;
    public static void main(String[] args) {

       /* String alphabet ="abcdefghijklmnopqrstuvwxyz";
        //for (int i = 0; i < alphabet.length(); i++) {
        //    System.out.println(i+": "+ alphabet.charAt(i));
        //}
        int a=10,b=20;
      //  System.out.println(a);
       // System.out.println(b);
        a^=b;
        b^=a;
        a^=b;
       // System.out.println(a);
      //  System.out.println(b);

        char c='a';
        c= (char) (c & '_');
        //System.out.println(c);
        boolean f;         // conditional flag
         int m; // the bit mask
         int w; // the word to modify:  if (f) w |= m; else w &= ~m;
         int bit= 0b11111110_10000001_00000000_11100111;

     //   System.out.println(Integer.toBinaryString(bit >>> 24 ));
     //   System.out.println(Integer.toBinaryString((bit << 24 )>>>24));
     //   System.out.println(Integer.toBinaryString((bit << 24 )>>24) + "\n");

        int flags=-1;
     //   System.out.println(Integer.toBinaryString(flags));
        int maskFlag0_3= -1<<3;
        int maskFlag4_7= 0b1001;

        int maskFlag28_31= 0b1010;

        flags=flags & maskFlag0_3;
      //  System.out.println(Integer.toBinaryString(flags));
       // flags=maskFlag4_7 & m;
        flags &= ~(0b1111 << 4) | maskFlag4_7<<4;
      // System.out.println(Integer.toBinaryString(flags));
        flags&=(~(0b1111<<28)) | maskFlag4_7<<28 ;
     //   System.out.println(Integer.toBinaryString(flags));


        maskFlag0_3=flags<<28 >>> 28;
       // System.out.println(Integer.toBinaryString(maskFlag0_3));
      //  System.out.println("extractedBits "+ Integer.toBinaryString(extractBits(flags,28,31)));
        maskFlag28_31=flags>>>28;
        //System.out.println(Integer.toBinaryString(maskFlag28_31));

        System.out.println("extractedBits "+ Integer.toBinaryString(extractBits(flags,0,7)));

        System.out.println(Integer.toBinaryString(setBits(flags,0b0,0,31)));
        System.out.println(Integer.toBinaryString(setBits(flags,-1,0,31)));





//            w ^= (-f ^ w) & m;

// OR, for superscalar CPUs:
   //     w = (w & ~m) | (-f & m);

        */
        /*
        List<Integer> ints =new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums=ints;
        double dbl=sum(nums);
        System.out.println(dbl);
        System.out.println(max(ints));
        ///nums.add(3.14);

         */
        System.out.println(BitCount2(0b111000));


    }

    public static int BitCount(int num){

        return Integer.toBinaryString(num).replace("0","").length();
    }
    public static int BitCount2(int num){
        int count=0;

        for (int i = 0; i < 32; i++) {
            if((num << i) >>> 31==1){
                count++;
            }
        }
        return count;
    }
    public static double sum(Collection<? extends Number> nums){
        double s=0.0;
        for(Number num:nums)s+=num.doubleValue();
        return s;
    }
    public static <T extends Comparable<T>> T max(Collection<T> coll){
        Iterator<T> it=coll.iterator();
        T candidate=it.next();
        while(it.hasNext()){
            T elt=it.next();
            if(candidate.compareTo(elt)<0)candidate=elt;

        }
        return candidate;

    }



































    static int extractBits(int number, int from , int toInclusive){
        int length= toInclusive-from+1;
        return number << LENGTH-toInclusive-1 >>> LENGTH-length;

    }
    static int setBits(int number , int bits,int from , int toInclusive){
        //step 0 find the int for the 1s bit
        int length= toInclusive-from+1;
        int toClear=-1;
       toClear=toClear>>>LENGTH-length;
       // System.out.println(String.format("%16s", Integer.toBinaryString(toClear>>>LENGTH-length)).replace(' ', '0'));
        //step 1 clear the necessary bits
       // System.out.println(String.format("%16s", Integer.toBinaryString((~((-1>>>toInclusive-from+1) << from)))));
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toBinaryString(number & (~((toClear) << from))));
        number&= ~((toClear) << from);
        number |= bits<<LENGTH-length;
        System.out.println(String.format("%16s", Integer.toBinaryString(bits<<LENGTH-length)).replace(' ', '0'));
        return number;
    }
}
