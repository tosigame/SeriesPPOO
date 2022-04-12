package cs108;

import java.util.*;

public class Main {
    static final int LENGTH=Integer.SIZE;
   // public static void main(String[] args) {

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
       // System.out.println(BitCount2(0b111000));


    //}
    public static void main(String[] args) {


        sort(List.of(27, 71, 17, 1, 77, 11, 24,9999,111,2));

        int flag0_3=0b1010;


        int flag28_31=0b1000;
        int num =-1;
        int clearBits=0b1111;
        num&= ~(0b1111 & num);
        num|=flag0_3;

        num&=~(clearBits<<28);
        num|=flag28_31<<28;
       // System.out.println(Integer.toBinaryString(num));

        //String str=String.format("%tH%n minutes:",59,2,2);
       // System.out.print(str);
        Comparator<Integer> it= Comparator.comparingInt(Integer::intValue);
        Comparator<ArrayList<Integer>> c=(o1,o2)-> o1.get(0)-o2.get(0);

        List<Integer > list= new ArrayList<>(List.of(27, 71, 17, 1, 77, 11, 24, 9999, 111, 2,Integer.MAX_VALUE,Integer.MIN_VALUE));
        list.sort(it);

        String str="lol Heard9NewsOn~tb";
        System.out.println(Arrays.toString(str.split("[a-z1-9A-Z]")));
        //System.out.println(sort(List.of(27, 71, 17, 1, 77, 11, 24,9999,111,2));
        //};

       // setBits(-1,1,2,5);

      //  for (var i :new ArrayList<>(list)) {}
        list.sort(Comparator.naturalOrder());
        StringBuilder stringBuilder=new StringBuilder();
        new HashMap<>().containsKey()
        /*



        HashMaps<>

        hm.entrySet().iterator() returns an iterator that acts as a cursor and points at the first element of the set and moves on till the end.
        to iterate over the keys use keySet()
        to iterate over the values only use map.values()
        to get both values and keys use map.entrySet() is used to retrieve all the key-value pairs called Map.Entries and stores internally into a set.
        for (var i :new ArrayList<>(list)) {} foreach loop takes a variable i from the given list var i : list
        if need to remove elements during iteration use Iterator =entries=map.entrySet().iterator();

        Iterators:
        values.sort(comparator);
        Comparator.naturalOrder()

        Collections
        static <T> List<T>	nCopies(int n, T o) Returns an immutable list consisting of n copies of the specified object.
        static <T> Comparator<T>	reverseOrder()
        static <T> void	fill(List<? super T> list, T obj)  Replaces all of the elements of the specified list with the specified element.




        List<E> subList(int fromIndex,int toIndex) create a sub list view of certain elements



        System.out.println(String.format("%32s", Integer.toBinaryString(ourBits)).replace(' ', '0'));
        Collections.sort(rs);

        StringBuilder newString= new StringBuilder();
        then StringAppend to add elements, finally toString to get the final String

        String:
        charAt(int index)	Returns the char value at the specified index.
        static String	format(String format, Object... args)
        int	indexOf(String str)
        int	indexOf(int ch)	Returns the index within this string of the first occurrence of the specified character.
        String	replace(char oldChar, char newChar)
        Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.
        String[] split(String regex)	Splits this string around matches of the given regular expression.
        String	substring​(int beginIndex)
        Returns a string that is a substring of this string.
        String	toLowerCase()
        Converts all of the characters in this String to lower case using the rules of the default locale.



        Sets
        boolean add(E e)
        boolean addAll(Collection<? extends E> c)
        void clear
        boolean contains(Object o)
        boolean containsAll(Collection<?> c)
        boolean	retainAll(Collection<?> c) Retains only the elements in this set that are contained in the specified collection (optional operation).
        boolean remove(Object o)
        Object[] toArray()

        static String	toBinaryString(int i)


        Comparator<ArrayList<Integer>> c=(o1,o2)-> o1.get(0)-o2.get(0);
        compartor.reversed() to get inverse order


        for (Iterator<Integer> it = ints. iterator(); it.hasNext(); ) {
        int n = it.next();
        s += n;
        }

        List<Integer> ints = Arrays.asList(1,2,3);
        Substitution Principle: a variable of a given type may be assigned a value of any subtype
        of that type, and a method with a parameter of a given type may be invoked with an
        argument of any subtype of that type.

        The Get and Put Principle: use an extends wildcard when you only get values out of a
        structure, use a super wildcard when you only put values into a structure, and don’t use
        a wildcard when you both get and put.

         */







    }
    static public void sort(List<Integer> ints){
        List<Integer> sortedList=ints;
        for (int i = 0; i < 7; i++) {
            sortedList=oneIteration(sortedList,i);
        }
       // System.out.println(sortedList);
    }

    static public ArrayList<Integer> oneIteration(List<Integer> ints,int depth){
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i:ints) {
            lists.get((int) (i /Math.pow(10,depth))%10).add(i);
        }
        ArrayList<Integer> newList=new ArrayList<>();
        for (var l : lists) {
            newList.addAll(l);
        }
        //System.out.println(newList);
        return newList;

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
        int length= toInclusive-from+1;  // length of wished extracted bits
        return number << LENGTH-toInclusive-1 >>> LENGTH-length;   // move bits to right then to left putting in 0s so >>>
    }
    static int setBits(int number , int bits,int from , int toInclusive){
        int length= toInclusive-from+1;//step 0 find the int for the 1s bit
        int toClear=-1;
       toClear=toClear>>>LENGTH-length; // find bits to clear
        number&= ~((toClear) << from); //clear those bits
        number |= bits<<LENGTH-length; // change those bits
        System.out.println(String.format("%32s", Integer.toBinaryString(bits<<LENGTH-length)).replace(' ', '0'));
        return number;
    }
}
