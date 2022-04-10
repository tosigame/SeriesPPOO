package cs108;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.*;


class MainTest {

    @Test
    void setBits() {
        String str="w00t";
      //  str.chars().forEach(System.out::println);
      //  str.chars().forEach(IterateString::printChar);
        str.chars()
           .mapToObj(ch-> (char) ch).forEach(System.out::println);

        str.chars()
           .filter(Character::isDigit)
           .forEach(IterateString::printChar);
    }

    @Test
    void Polynomial(){
        Map<Integer, Integer> input = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            input.put(i, (int) (Math.pow(-1,i)*i));
        }


        Polynomial polynomial=new Polynomial(input);
        System.out.println(polynomial.valueAt(2));
        System.out.println(polynomial);
      //  System.out.println(polynomial);

        Map<Integer, Integer> newPol = new HashMap<>();
        newPol.put(1,1);
        newPol.put(12,22);
        newPol.put(2,52);
        newPol.put(5,2);
        newPol.put(50,3);
        Polynomial newPolynomial=new Polynomial(newPol);
     //   System.out.println(newPolynomial);

       // System.out.println(polynomial.add(newPolynomial));

    }


    public class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(Node l, Node r, int v) {
            left = l;
            right = r;
            value = v;
        }
    }
    class Kata {
        public static List<Integer> treeByLevels(Node node)
        {

            if(node!=null){
                List<List<Integer>> lists=new ArrayList<>();

                treeByDepthLevel(node,0,lists);

                List<Integer> sol=new ArrayList<>();
                for (var list: lists ) {
                    sol.addAll(list);
                }

            return sol;

            }else{
                return new ArrayList<Integer>();
            }
        }

        public static void treeByDepthLevel(Node node, int depth,List<List<Integer>> lists){

            if(lists.size()<=depth){
                lists.add(new ArrayList<>());
            }
            if(node!=null) {
                lists.get(depth).add(node.value);
                depth++;
                treeByDepthLevel(node.left, depth, lists);
                treeByDepthLevel(node.right, depth, lists);
            }



        }
    }

    @Test
    public void basicTest() {
        assertEquals(Arrays.asList(1,2,3,4,5,6), Kata.treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
    }



}