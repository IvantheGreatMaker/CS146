package hw11;

import java.util.LinkedList;
import java.util.Queue;

public class Filler {
	    public int[][] floodFill(int[][] image, int  sr, int  sc,int color){
	        if(image[sr][sc] == color) {
	        	return image;
	        }
	        int m = image.length;
	        int n = image[0].length;
	        int old_color = image[sr][sc];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{sr, sc});

	        while (!queue.isEmpty()) {
	            int[] curr = queue.poll();
	            int a = curr[0];
	            int b = curr[1];
	            if (image[a][b] != old_color) {
	                continue;
	            }
	            image[a][b] = color;
	            if (0 <= a + 1 && a + 1 < m) {
	                queue.add(new int[]{a + 1, b});
	            }
	            if (0 <= a - 1 && a - 1 < m) {
	                queue.add(new int[]{a - 1, b});
	            }
	            if (0 <= b + 1 && b + 1 < n) {
	                queue.add(new int[]{a, b + 1});
	            }
	            if (0 <= b - 1 && b - 1 < n) {
	                queue.add(new int[]{a, b - 1});
	            }
	        }

	        return image;
	    
	    }
	    public static void main(String[] args) {
	    	Filler bob = new Filler();
	    	int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
	    	int sr = 1;
	    	int sc = 1;
	    	int color = 2;
	    	int[][] output = bob.floodFill(image, sr, sc, color);
	    	for(int i =0;i<image.length;i++) {
	    		for(int j = 0;j<image[0].length;j++) {
	    			System.out.print(output[i][j]+",");
	    		}
	    		System.out.println("");
	    	}
	    	
	    	System.out.println("\n \n ");
	    	
	    	Filler jim = new Filler();
	    	int[][] new_image = {{0,0,0},{0,0,0}};
	    	int nr = 0;
	    	int nc = 0;
	    	int new_color = 0;
	    	int[][] new_output = jim.floodFill(new_image, nr, nc, new_color);
	    	for(int i =0;i<new_image.length;i++) {
	    		for(int j = 0;j<new_image[0].length;j++) {
	    			System.out.print(new_output[i][j]+",");
	    		}
	    		System.out.println("");
	    	}
	    	
	    	System.out.println("\n \n ");
	    	
	    	
	    }
}
