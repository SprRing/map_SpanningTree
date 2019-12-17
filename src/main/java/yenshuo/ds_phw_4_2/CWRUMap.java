/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yenshuo.ds_phw_4_2;

/**
 *
 * @author yenshou
 */
public class CWRUMap {
    
    public static int MinDistance(int[][] dists){
        int len = dists.length;
        boolean[] visited = new boolean[len];
        int[] shortestdistance = new int[len];
        int path = 0;
        
        //initiation
        for(int i=0; i<len; i++){
            visited[i] = false;
            shortestdistance[i] = Integer.MAX_VALUE;
        }
        
        
        int start = 0;
        int shortest = Integer.MAX_VALUE;
        int next = Integer.MAX_VALUE;
        visited[start] = true; // the first node
        int count = 1; // to count if we walk through every nodes or not
        for(int i=0; i<len; i++){
            if(start != i){
                shortestdistance[i] = dists[start][i]; // record the adjacent nodes of start
                if(shortestdistance[i]<shortest){
                    shortest = shortestdistance[i];
                    next = i;
                }
            } 
        }
        visited[next] = true; 
        count++;
        path += shortest;

        while(count < len){
            shortest = Integer.MAX_VALUE;
            start = next;
            for(int i=0; i<len; i++){
                if(start != i){
                    shortestdistance[i] = Math.min(shortestdistance[i], dists[start][i]); // to see if there's a new shorter route
                    if(shortestdistance[i]<shortest && visited[i] == false){ // find a shortest and not yet visited node
                        shortest = shortestdistance[i];
                        next = i;
                    }
                } 
            }
            visited[next] = true;
            count++;
            path += shortest;
        }
        
        
        return path;
    }
    
    public static void main(String[] args){
        int[][] dists= new int[][]{{0, 1, 2, 10},{1, 0, 3, 4},{2, 3, 0, 3},{10, 4, 3, 0}};
        System.out.println(MinDistance(dists));
    } 
}