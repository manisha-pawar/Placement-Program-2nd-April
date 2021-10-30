//https://leetcode.com/problems/bus-routes/

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>(); //bus stand vs buses
        
        for(int i=0; i < routes.length;i++) {
            for(int j=0; j < routes[i].length;j++) {
                int bus_no = i;
                int bus_stop_no = routes[i][j];
                
                if(map.containsKey(bus_stop_no) == false) {
                    ArrayList<Integer>list = new ArrayList<>();
                    list.add(bus_no);
                    map.put(bus_stop_no,list);
                }
                else {
                    ArrayList<Integer>list = map.get(bus_stop_no);
                    list.add(bus_no);
                    map.put(bus_stop_no,list);
                }
            }
        }
        
        return bfs(routes,source,target,map);
    }
    
    public static class Pair {
        int bus_stop;
        int lev;
        
        Pair() {
            
        }
        
        Pair(int bus_stop,int lev) {
            this.bus_stop = bus_stop;
            this.lev = lev;
        }
    }
    
    public static int bfs(int[][]routes,int src,int dest,HashMap<Integer,ArrayList<Integer>>map) {
        //map -> bus stand vs buses
        
        HashSet<Integer>bus_stop_vis = new HashSet<>(); //visited for bus stop
        HashSet<Integer>bus_vis = new HashSet<>(); //visited for bus
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        q.add(new Pair(src,0));
        bus_stop_vis.add(src); //marking on addition
        
        while(q.size() > 0) {
            //remove
            Pair rem = q.remove();
            
            //work
            if(rem.bus_stop == dest) {
                return rem.lev;
            }
            
            //add unvisited nbr
            ArrayList<Integer>buses = map.get(rem.bus_stop);
            
            for(int bus : buses) {
                if(bus_vis.contains(bus) == false) {
                    bus_vis.add(bus); 
                    
                    //travel all the unvisited bus_stop of this bus
                    for(int bus_stop : routes[bus]) {
                        if(bus_stop_vis.contains(bus_stop) == false) {
                            q.add(new Pair(bus_stop,rem.lev + 1));
                            bus_stop_vis.add(bus_stop);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
}