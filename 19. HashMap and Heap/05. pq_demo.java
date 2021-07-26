import java.util.*;

public class Main {
    public static class Student implements Comparable<Student>{
        String name;
        int marks;
        
        Student() {
            
        }
        
        Student(String name,int marks) {
            this.name = name;
            this.marks = marks;
        }
        
        //+ve -> this > other
        //-ve ->  this < other
        //0 -> this == other
        
        public int compareTo(Student o) {
            if(this.marks != o.marks) {
                return this.marks - o.marks;
            }
            else {
                return -(this.name.compareTo(o.name));
            }
        }
    }
    
    public static void main(String[]args) {
        // //1. min PQ
        // PriorityQueue<Integer>pq = new PriorityQueue<>(); //smaller value has higher priority
        
        // pq.add(19);
        // pq.add(27);
        // pq.add(13);
        // pq.add(9);
        // pq.add(20);
        
        // while(pq.size() > 0) {
        //     int top = pq.peek();
        //     pq.remove();
            
        //     System.out.print(top + " ");
        // }
        
        // //2. max PQ
        // PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder()); //larger value has higher priority
        
        // pq.add(19);
        // pq.add(27);
        // pq.add(13);
        // pq.add(9);
        // pq.add(20);
        
        // while(pq.size() > 0) {
        //     int top = pq.peek();
        //     pq.remove();
            
        //     System.out.print(top + " ");
        // }
        
        // //3. when PQ has your class objects
        // PriorityQueue<Student>pq = new PriorityQueue<>(); //smaller value has higher priority
        
        // pq.add(new Student("A",75));
        // pq.add(new Student("D",94));
        // pq.add(new Student("C",70));
        // pq.add(new Student("B",94));
        // pq.add(new Student("E",75));
        // pq.add(new Student("D",75));
        
        
        // while(pq.size() > 0) {
        //     Student st = pq.remove();
        //     System.out.println(st.name +" -> " + st.marks);
        // }
        
        
        PriorityQueue<Student>pq = new PriorityQueue<>(Collections.reverseOrder()); //larger value has higher priority
        
        pq.add(new Student("A",75));
        pq.add(new Student("D",94));
        pq.add(new Student("C",70));
        pq.add(new Student("B",94));
        pq.add(new Student("E",75));
        
        
        while(pq.size() > 0) {
            Student st = pq.remove();
            System.out.println(st.name +" -> " + st.marks);
        }
        
        
    }
    

}