package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * @author nehalborole
 * Input:
 * 1. Algo to use: BFS, UCS, A*
 * 2. size of X*Y*Z
 * 3. Entrance (x,y,z)
 * 4. Exit (x,y,z)
 * 5. N -> no. of grids in the maze where there are actions available.
 * 6. x y z [actions]
 *
 * Output:
 * 1. Total cost, if no solution return "FAIL"
 * 2. <Total steps in solution> <Cost>
 *
 * X+(1) X-(2) Y+(3) Y-(4) Z+(5) Z-(6) X+Y+(7) X+Y-(8) X-Y+(9) X-Y-(10) X+Z+(11) X+Z-(12) X-Z+(13) X-Z-(14) Y+Z+(15)
 * Y+Z-(16) Y-Z+(17) Y-Z-(18)
 *
 */

class Point{
    int x,y,z;
    int dist;
    int costAndH;
    int distFromOrigin;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(int x, int y, int z, int dist) {
        this.x = x;
        this.y = y;
        this.z = z;
        /** dist is the cost **/
        this.dist = dist;
    }

    public Point(int x, int y, int z, int dist, int distFromOrigin) {
        this.x = x;
        this.y = y;
        this.z = z;
        /** dist is the cost **/
        this.dist = dist;
        this.distFromOrigin = distFromOrigin;
    }

    public Point(int x, int y, int z, int dist, int distFromOrigin, int costAndH) {
        this.x = x;
        this.y = y;
        this.z = z;
        /** dist is the cost **/
        this.dist = dist;
        this.distFromOrigin = distFromOrigin;
        this.costAndH = costAndH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return x + " " + y + " " + z + " " + dist + "\n";
    }
}

public class homework {

    static Scanner sc;

    static class Cave{
        int x,y,z;
        int start_x, start_y, start_z;
        int end_x, end_y, end_z;
        int n;
        HashMap<Point, List<Integer>> grid = new HashMap();
    }

    static int move_x[] = {1, -1, 0, 0, 0, 0, 1, 1, -1, -1, 1, 1, -1, -1, 0, 0, 0, 0};
    static int move_y[] = {0, 0, 1, -1, 0, 0, 1, -1, 1, -1, 0, 0, 0, 0, 1, 1, -1, -1};
    static int move_z[] = {0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 1, -1, 1, -1, 1, -1, 1, -1};

    static boolean isInside(int nx, int ny, int nz, Cave c){
        if (nx >= 0 && nx < c.x && ny >= 0 && ny < c.y && nz >= 0 && nz < c.z){
            return true;
        }
        return false;
    }

    static int calculateHeuristics( int x, int y, int z, int g_x, int g_y, int g_z){
        //return (int)Math.sqrt((x-g_x)*(x-g_x) + (y-g_y)*(y-g_y) + (z-g_z)*(z-g_z));
        return Math.abs(x-g_x) + Math.abs(y-g_y) + Math.abs(z-g_z);
    }

    static void parseInput(Cave c){
        c.x = sc.nextInt();
        c.y = sc.nextInt();
        c.z = sc.nextInt();
        c.start_x = sc.nextInt();
        c.start_y = sc.nextInt();
        c.start_z = sc.nextInt();
        c.end_x = sc.nextInt();
        c.end_y = sc.nextInt();
        c.end_z = sc.nextInt();
        c.n = sc.nextInt();
        for(int i=0; i <= c.n; i++){
            String line = sc.nextLine();
            Scanner lineScanner = new Scanner(line);
            if(lineScanner.hasNext()){
                String[] arr = line.split("\\s");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                int z = Integer.parseInt(arr[2]);
                List<Integer> actions = new ArrayList<>();
                for(int j = 3; j < arr.length; j++){
                    actions.add(Integer.parseInt(arr[j]));
                }
                c.grid.put(new Point(x,y,z), actions);
            }
        }
    }

    static void bfs(Cave c){
        int nx, ny, nz;
        Queue<List<Point>> q = new LinkedList<>();
        boolean visited[][][] = new boolean[c.x][c.y][c.z];
        List<Point> temp = new ArrayList<>();
        temp.add(new Point(c.start_x, c.start_y, c.start_z, 0));
        q.add(temp);
        Point pt;
        visited[c.start_x][c.start_y][c.start_z] = true;
        List<Point> pathList;
        while(!q.isEmpty()){
            pathList = q.poll();
            //get the recently inserted node
            pt = pathList.get(pathList.size()-1);
            //check if goal reached
            if(pt.x == c.end_x && pt.y == c.end_y && pt.z == c.end_z){
                int totalCost = 0;
                for(int i=0; i<pathList.size(); i++){
                    totalCost += pathList.get(i).dist;
                }
                System.out.println(totalCost);
                System.out.println(pathList.size());
                for(Point p : pathList){
                    System.out.println(p.x + " " + p.y + " " + p.z + " " + p.dist);
                }
                return;
            }
            //visit neighbors
            for(int i = 0; i < c.grid.get(pt).size(); i++){
                int action = c.grid.get(pt).get(i)-1;
                nx = pt.x + move_x[action];
                ny = pt.y + move_y[action];
                nz = pt.z + move_z[action];

                if(isInside(nx,ny,nz, c) && !visited[nx][ny][nz]){  //and not visited
                    visited[nx][ny][nz] = true;
                    Point p = new Point(nx, ny, nz , 1);
                    List<Point> tempPathList = new ArrayList<>(pathList);
                    tempPathList.add(p);
                    q.add(tempPathList);
                }
            }
        }
        System.out.println("FAIL");
    }

    static void uniformCostSearch(Cave c){
        int nx, ny, nz;
        PriorityQueue<List<Point>> q = new PriorityQueue<>((l1, l2) -> l1.get(l1.size() -1).distFromOrigin - l2.get(l2.size()-1).distFromOrigin);
        boolean visited[][][] = new boolean[c.x][c.y][c.z];
        List<Point> temp = new ArrayList<>();
        temp.add(new Point(c.start_x, c.start_y, c.start_z, 0, 0));
        q.add(temp);
        Point pt;
        visited[c.start_x][c.start_y][c.start_z] = true;
        List<Point> pathList;

        while(!q.isEmpty()){
            pathList = q.poll();
            //get the recently inserted node
            pt = pathList.get(pathList.size()-1);
            int pt_x = pt.x, pt_y = pt.y, pt_z = pt.z;
            visited[pt_x][pt_y][pt_z] = true;
            //check if goal reached
            if(pt.x == c.end_x && pt.y == c.end_y && pt.z == c.end_z){
                int totalCost = 0;
                for(int i=0; i<pathList.size(); i++){
                    totalCost += pathList.get(i).dist;
                }
                System.out.println(totalCost);
                System.out.println(pathList.size());
                for(Point p : pathList){
                    System.out.println(p.x + " " + p.y + " " + p.z + " " + p.dist);
                }
                return;
            }

            //visit neighbors
            for(int i = 0; i < c.grid.get(pt).size(); i++){
                int action = c.grid.get(pt).get(i)-1;
                nx = pt.x + move_x[action];
                ny = pt.y + move_y[action];
                nz = pt.z + move_z[action];

                int costOfAction = (action > 5) ? 14 : 10;  //if diagonal cost:14 else cost:10

                if(isInside(nx,ny,nz, c) && !visited[nx][ny][nz]){  //and not visited
                    /*visited[nx][ny][nz] = true;*/
                    Point p = new Point(nx, ny, nz , costOfAction, pt.distFromOrigin + costOfAction);
                    List<Point> tempPathList = new ArrayList<>(pathList);
                    tempPathList.add(p);
                    q.add(tempPathList);
                }
            }
        }
        System.out.println("FAIL");
    }

    static void aStarSearch(Cave c){
        int nx, ny, nz;
        PriorityQueue<List<Point>> q = new PriorityQueue<>((l1, l2) -> (l1.get(l1.size() -1).costAndH - l2.get(l2.size()-1).costAndH));
        boolean visited[][][] = new boolean[c.x][c.y][c.z];
        List<Point> temp = new ArrayList<>();
        temp.add(new Point(c.start_x, c.start_y, c.start_z, 0, 0));
        q.add(temp);
        Point pt;
        visited[c.start_x][c.start_y][c.start_z] = true;
        List<Point> pathList;

        while(!q.isEmpty()){
            pathList = q.poll();
            //get the recently inserted node
            pt = pathList.get(pathList.size()-1);
            int pt_x = pt.x, pt_y = pt.y, pt_z = pt.z;
            visited[pt_x][pt_y][pt_z] = true;
            //check if goal reached
            if(pt.x == c.end_x && pt.y == c.end_y && pt.z == c.end_z){
                int totalCost = 0;
                for(int i=0; i<pathList.size(); i++){
                    totalCost += pathList.get(i).dist;
                }
                System.out.println(totalCost);
                System.out.println(pathList.size());
                for(Point p : pathList){
                    System.out.println(p.x + " " + p.y + " " + p.z + " " + p.dist);
                }
                return;
            }

            //visit neighbors
            for(int i = 0; i < c.grid.get(pt).size(); i++){
                int action = c.grid.get(pt).get(i)-1;
                nx = pt.x + move_x[action];
                ny = pt.y + move_y[action];
                nz = pt.z + move_z[action];

                int costOfAction =  (action > 5) ? 14 : 10;  //if diagonal cost:14 else cost:10
                int distFromOrigin = pt.distFromOrigin + costOfAction;
                if(isInside(nx,ny,nz, c) && !visited[nx][ny][nz]){  //and not visited
                    /*visited[nx][ny][nz] = true;*/
                    Point p = new Point(nx, ny, nz , costOfAction, distFromOrigin, distFromOrigin + calculateHeuristics(nx,ny,nz, c.end_x ,c.end_y,c.end_z));
                    List<Point> tempPathList = new ArrayList<>(pathList);
                    tempPathList.add(p);
                    q.add(tempPathList);
                }
            }
        }
        System.out.println("FAIL");
    }

    public static void main(String[] args) throws FileNotFoundException {
        final String BASE_PATH = "/Users/nehalborole/USC/USC-coursework/AI/input";
        File input = new File(BASE_PATH + "/input.txt");
        sc = new Scanner(input);
        File output = new File(BASE_PATH + "/output.txt");
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        String type = sc.next(); //input type of algorithm
        Cave c = new Cave();
        parseInput(c);
        switch(type){
            case "BFS":
                bfs(c);
                break;
            case "UCS":
                uniformCostSearch(c);
                break;
            case "A*":
                aStarSearch(c);
        }
    }
}
